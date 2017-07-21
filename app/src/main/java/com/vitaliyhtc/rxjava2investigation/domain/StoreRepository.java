package com.vitaliyhtc.rxjava2investigation.domain;

import com.vitaliyhtc.rxjava2investigation.data.RxFilter;
import com.vitaliyhtc.rxjava2investigation.domain.model.Store;

public interface StoreRepository extends Repository {
    void loadStores(int count, RxFilter<Store> storeFilter);
}
