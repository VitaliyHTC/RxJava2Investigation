package com.vitaliyhtc.rxjava2investigation.presenter;

import com.vitaliyhtc.rxjava2investigation.domain.model.Store;

public interface ResultStoresCallback {
    void addStoreToResult(Store store);
    void loadStoresError(Throwable t);
}
