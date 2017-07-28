package com.vitaliyhtc.rxjava2investigation.data;

import com.vitaliyhtc.rxjava2investigation.domain.model.Store;

import io.reactivex.Observable;

public interface StoreDataManager extends DataStorage {
    Observable<Store> getStoresObservable();
}
