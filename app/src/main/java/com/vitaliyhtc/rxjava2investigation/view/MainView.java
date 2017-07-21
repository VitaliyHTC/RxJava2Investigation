package com.vitaliyhtc.rxjava2investigation.view;

import com.vitaliyhtc.rxjava2investigation.domain.model.Product;
import com.vitaliyhtc.rxjava2investigation.domain.model.Store;

public interface MainView extends BaseView {
    void addStoreToResult(Store store);
    void addProductToResult(int storeId, Product product);
    void onError(Throwable t);
}
