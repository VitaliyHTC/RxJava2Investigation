package com.vitaliyhtc.rxjava2investigation.data;

import com.vitaliyhtc.rxjava2investigation.BuildConfig;
import com.vitaliyhtc.rxjava2investigation.Config;
import com.vitaliyhtc.rxjava2investigation.data.model.ProductMapper;
import com.vitaliyhtc.rxjava2investigation.data.model.response.ProductsByStoreResult;
import com.vitaliyhtc.rxjava2investigation.data.rest.ApiInterface;
import com.vitaliyhtc.rxjava2investigation.data.rest.RetrofitApiClient;
import com.vitaliyhtc.rxjava2investigation.domain.ProductRepository;
import com.vitaliyhtc.rxjava2investigation.domain.model.Product;

import java.util.List;

import io.reactivex.Observable;

public class ProductRepositoryImpl implements ProductRepository {

    public ProductRepositoryImpl() {
    }

    @Override
    public void initResources() {
    }

    @Override
    public void releaseResources() {
    }

    @Override
    public Observable<List<Product>> getProductsObservable(int page, int storeId) {
        ApiInterface apiService = RetrofitApiClient.getClient().create(ApiInterface.class);
        return apiService
                .getProductsByStore(
                        storeId,
                        page,
                        Config.PRODUCTS_PER_PAGE,
                        Config.PRODUCTS_WHERE_NOT,
                        BuildConfig.LCBO_API_ACCESS_KEY
                )
                .toObservable()
                .map(ProductsByStoreResult::getResult)
                .flatMap(Observable::fromIterable)
                .map(new ProductMapper())
                .toList()
                .toObservable();
    }
}
