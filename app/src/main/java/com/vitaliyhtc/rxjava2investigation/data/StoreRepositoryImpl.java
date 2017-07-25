package com.vitaliyhtc.rxjava2investigation.data;

import com.vitaliyhtc.rxjava2investigation.domain.StoreRepository;
import com.vitaliyhtc.rxjava2investigation.model.Store;

import io.reactivex.Observable;

public class StoreRepositoryImpl implements StoreRepository {

    private StoreDataManager mStoreDataManager;

    public StoreRepositoryImpl() {
    }

    @Override
    public void initResources() {
        mStoreDataManager = new StoreDataManagerImpl();
        mStoreDataManager.initResources();
    }

    @Override
    public void releaseResources() {
        mStoreDataManager.releaseResources();
        mStoreDataManager = null;
    }

    @Override
    public Observable<Store> getStoresObservable() {
        return mStoreDataManager.getStoresObservable();
    }

}
