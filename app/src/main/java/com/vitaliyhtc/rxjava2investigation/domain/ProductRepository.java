package com.vitaliyhtc.rxjava2investigation.domain;

import com.vitaliyhtc.rxjava2investigation.data.RxFilter;
import com.vitaliyhtc.rxjava2investigation.domain.model.Product;

public interface ProductRepository extends Repository {
    // TODO: 24/07/17 in the perfect world data and domain are separated modules and domain don't know anything about data [RxFilter<Product>]
    void loadProducts(int storeId, int count, RxFilter<Product> productFilter);
}
