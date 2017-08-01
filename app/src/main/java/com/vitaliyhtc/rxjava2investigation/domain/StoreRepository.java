package com.vitaliyhtc.rxjava2investigation.domain;

import com.vitaliyhtc.rxjava2investigation.domain.model.Store;

import java.util.List;

import io.reactivex.Observable;

public interface StoreRepository {
    Observable<List<Store>> getStoresObservable(int page);
}
