package com.vitaliyhtc.rxjava2investigation.data;

import com.vitaliyhtc.rxjava2investigation.data.model.Product;

import io.reactivex.Observable;

public interface ProductDataManager extends DataStorage {
    Observable<Product> getProductsObservable(int storeId);
}
