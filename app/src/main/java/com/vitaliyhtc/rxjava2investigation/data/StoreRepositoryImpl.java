package com.vitaliyhtc.rxjava2investigation.data;

import com.vitaliyhtc.rxjava2investigation.domain.StoreRepository;
import com.vitaliyhtc.rxjava2investigation.domain.model.Store;
import com.vitaliyhtc.rxjava2investigation.presenter.MainPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class StoreRepositoryImpl implements StoreRepository {

    private MainPresenter mMainPresenter;
    private StoreDataManager mStoreDataManager;

    private Disposable mDisposableStores;
    private int mCountStores;

    public StoreRepositoryImpl(MainPresenter mainPresenter) {
        mMainPresenter = mainPresenter;
    }

    @Override
    public void initResources() {
        mStoreDataManager = new StoreDataManagerImpl();
        mStoreDataManager.initResources();
    }

    @Override
    public void releaseResources() {
        RxUtils.dispose(mDisposableStores);
        mStoreDataManager.releaseResources();
        mStoreDataManager = null;
    }

    @Override
    public void loadStores(int count, RxFilter<Store> filter) {
        if (mStoreDataManager != null) {
            mCountStores = 0;
            mDisposableStores = mStoreDataManager.getStoresObservable()
                    .subscribeOn(Schedulers.io())
                    .map(store -> new Store(store.getId(), store.getName()))
                    .filter(filter::isMeetsCondition)
                    .take(count)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            store -> {
                                mMainPresenter.addStoreToResult(store);
                                mCountStores++;
                                if (mCountStores >= count)
                                    RxUtils.dispose(mDisposableStores);
                            },
                            throwable -> mMainPresenter.onError(throwable)
                    );
        }
    }

}
