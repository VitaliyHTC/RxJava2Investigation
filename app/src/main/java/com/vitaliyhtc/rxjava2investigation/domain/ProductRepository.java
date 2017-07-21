package com.vitaliyhtc.rxjava2investigation.domain;

import com.vitaliyhtc.rxjava2investigation.data.RxFilter;
import com.vitaliyhtc.rxjava2investigation.domain.model.Product;

public interface ProductRepository extends Repository {
    void loadProducts(int storeId, int count, RxFilter<Product> productFilter);
}
