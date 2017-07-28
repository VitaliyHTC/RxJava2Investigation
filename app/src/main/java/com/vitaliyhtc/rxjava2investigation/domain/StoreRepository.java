package com.vitaliyhtc.rxjava2investigation.domain;

import com.vitaliyhtc.rxjava2investigation.domain.model.Store;

import io.reactivex.Observable;

public interface StoreRepository extends Repository {
    Observable<Store> getStoresObservable();
    // TODO: 26/07/17 you can return entire list of items that represent one page or parametrize the request
//    Observable<List<Store>> getStoresObservable(int page, <Condition>);
}
