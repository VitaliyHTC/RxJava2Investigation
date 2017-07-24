package com.vitaliyhtc.rxjava2investigation.presenter;

import com.vitaliyhtc.rxjava2investigation.domain.model.Product;

public interface ResultProductsCallback {
    void addProductToResult(int storeId, Product product);
    void loadProductsError(Throwable t);
}
