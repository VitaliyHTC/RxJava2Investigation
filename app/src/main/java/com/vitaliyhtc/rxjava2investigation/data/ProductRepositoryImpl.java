package com.vitaliyhtc.rxjava2investigation.data;

import com.vitaliyhtc.rxjava2investigation.domain.ProductRepository;
import com.vitaliyhtc.rxjava2investigation.model.Product;

import io.reactivex.Observable;

public class ProductRepositoryImpl implements ProductRepository {

    private ProductDataManager mProductDataManager;

    public ProductRepositoryImpl() {
    }

    @Override
    public void initResources() {
        mProductDataManager = new ProductDataManagerImpl();
        mProductDataManager.initResources();
    }

    @Override
    public void releaseResources() {
        mProductDataManager.releaseResources();
        mProductDataManager = null;
    }

    @Override
    public Observable<Product> getProductsObservable(int storeId) {
        return mProductDataManager.getProductsObservable(storeId);
    }

}
