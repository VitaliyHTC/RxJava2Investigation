package com.vitaliyhtc.rxjava2investigation.presenter.model.mapper;

import com.vitaliyhtc.rxjava2investigation.presenter.model.Product;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class ProductMapper implements Function<com.vitaliyhtc.rxjava2investigation.domain.model.Product, Product> {

    @Override
    public Product apply(@NonNull com.vitaliyhtc.rxjava2investigation.domain.model.Product product) {
        return new Product(product.getId(), product.getName());
    }
}
