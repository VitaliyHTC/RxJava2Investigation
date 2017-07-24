package com.vitaliyhtc.rxjava2investigation.data;

import com.vitaliyhtc.rxjava2investigation.domain.ProductRepository;
import com.vitaliyhtc.rxjava2investigation.domain.model.Product;
import com.vitaliyhtc.rxjava2investigation.presenter.MainPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ProductRepositoryImpl implements ProductRepository {

    private MainPresenter mMainPresenter;
    private ProductDataManager mProductDataManager;

    private Disposable mDisposableProducts;
    private int mCountProducts;

    // TODO: 24/07/17 wrong repository definitely don't know anything about presenter they are on different levels
    public ProductRepositoryImpl(MainPresenter mainPresenter) {
        mMainPresenter = mainPresenter;
    }

    @Override
    public void initResources() {
        mProductDataManager = new ProductDataManagerImpl();
        mProductDataManager.initResources();
    }

    @Override
    public void releaseResources() {
        RxUtils.dispose(mDisposableProducts);
        mProductDataManager.releaseResources();
        mProductDataManager = null;
    }

    @Override
    public void loadProducts(int storeId, int count, RxFilter<Product> filter) {
        if(mProductDataManager != null) {
            mCountProducts = 0;
            mDisposableProducts = mProductDataManager.getProductsObservable(storeId)
                    .subscribeOn(Schedulers.io())
                    .map(product -> new com.vitaliyhtc.rxjava2investigation.domain.model.Product(product.getId(), product.getName()))
                    .filter(filter::isMeetsCondition)
                    .take(count)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            product -> {
                                mMainPresenter.addProductToResult(storeId, product);
                                mCountProducts++;
                                if (mCountProducts >= count)
                                    RxUtils.dispose(mDisposableProducts);
                            },
                            throwable -> mMainPresenter.onError(throwable)
                    );
        }
    }

}
