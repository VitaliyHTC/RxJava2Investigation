package com.vitaliyhtc.rxjava2investigation.data;

import com.vitaliyhtc.rxjava2investigation.domain.model.Product;

import io.reactivex.Observable;

public interface ProductDataManager extends DataStorage {
    Observable<Product> getProductsObservable(int storeId);
}
