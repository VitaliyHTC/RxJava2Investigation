package com.vitaliyhtc.rxjava2investigation.domain;

import com.vitaliyhtc.rxjava2investigation.data.RxFilter;
import com.vitaliyhtc.rxjava2investigation.domain.model.Store;

public interface StoreRepository extends Repository {
    // TODO: 24/07/17 in the perfect world data and domain are separated modules and domain don't know anything about data [RxFilter<Store>]
    void loadStores(int count, RxFilter<Store> storeFilter);
}
