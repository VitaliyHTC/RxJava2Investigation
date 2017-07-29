package com.vitaliyhtc.rxjava2investigation.domain;

import com.vitaliyhtc.rxjava2investigation.domain.model.Product;

import java.util.List;

import io.reactivex.Observable;

public interface ProductRepository extends Repository {
    Observable<List<Product>> getProductsObservable(int page, int storeId);
}
