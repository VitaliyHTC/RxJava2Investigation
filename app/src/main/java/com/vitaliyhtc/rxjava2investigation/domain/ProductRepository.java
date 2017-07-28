package com.vitaliyhtc.rxjava2investigation.domain;


import com.vitaliyhtc.rxjava2investigation.domain.model.Product;

import io.reactivex.Observable;

public interface ProductRepository extends Repository {
    Observable<Product> getProductsObservable(int storeId);
}
