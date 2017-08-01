package com.vitaliyhtc.rxjava2investigation.data;

import com.vitaliyhtc.rxjava2investigation.Config;
import com.vitaliyhtc.rxjava2investigation.data.model.mapper.ProductMapper;
import com.vitaliyhtc.rxjava2investigation.data.model.response.ProductsByStoreResult;
import com.vitaliyhtc.rxjava2investigation.data.rest.ApiInterface;
import com.vitaliyhtc.rxjava2investigation.domain.ProductRepository;
import com.vitaliyhtc.rxjava2investigation.domain.model.Product;

import java.util.List;

import io.reactivex.Observable;

import static com.vitaliyhtc.rxjava2investigation.data.rest.ApiInterface.LCBO_API_ACCESS_KEY;

public class ProductRepositoryImpl implements ProductRepository {

    private ApiInterface mApiService;
    private final ProductMapper mProductMapper;

    public ProductRepositoryImpl(ApiInterface apiService) {
        mApiService = apiService;
        mProductMapper = new ProductMapper();
    }

    @Override
    public Observable<List<Product>> getProductsObservable(int page, int storeId) {
        return mApiService
                .getProductsByStore(
                        storeId,
                        page,
                        Config.PRODUCTS_PER_PAGE,
                        Config.PRODUCTS_WHERE_NOT,
                        LCBO_API_ACCESS_KEY
                )
                .toObservable()
                .map(ProductsByStoreResult::getResult)
                .flatMap(Observable::fromIterable)
                .map(mProductMapper)
                .toList()
                .toObservable();
    }
}
