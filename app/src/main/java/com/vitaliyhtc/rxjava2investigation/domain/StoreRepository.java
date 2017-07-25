package com.vitaliyhtc.rxjava2investigation.domain;

import com.vitaliyhtc.rxjava2investigation.model.Store;

import io.reactivex.Observable;

public interface StoreRepository extends Repository {
    Observable<Store> getStoresObservable();
}
