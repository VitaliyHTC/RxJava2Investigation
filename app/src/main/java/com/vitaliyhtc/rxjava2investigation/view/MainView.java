package com.vitaliyhtc.rxjava2investigation.view;

import com.vitaliyhtc.rxjava2investigation.presenter.model.Product;
import com.vitaliyhtc.rxjava2investigation.presenter.model.Store;

public interface MainView extends BaseView {
    void addStoreToResult(Store store);
    void addProductToResult(int storeId, Product product);
    void loadStoresError(Throwable t);
    void loadProductsError(Throwable t);
}
