package com.vitaliyhtc.rxjava2investigation.presenter;

import com.vitaliyhtc.rxjava2investigation.domain.model.Product;
import com.vitaliyhtc.rxjava2investigation.domain.model.Store;

public interface MainPresenter extends BasePresenter {
    void loadData();
    void addStoreToResult(Store store);
    void addProductToResult(int storeId, Product product);
    void onError(Throwable t);
}
