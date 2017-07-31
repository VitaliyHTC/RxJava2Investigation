package com.vitaliyhtc.rxjava2investigation.presenter.model.mapper;

import com.vitaliyhtc.rxjava2investigation.presenter.model.Store;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class StoreMapper implements Function<com.vitaliyhtc.rxjava2investigation.domain.model.Store, Store> {

    @Override
    public Store apply(@NonNull com.vitaliyhtc.rxjava2investigation.domain.model.Store store) throws Exception {
        return new Store(store.getId(), store.getName());
    }
}
