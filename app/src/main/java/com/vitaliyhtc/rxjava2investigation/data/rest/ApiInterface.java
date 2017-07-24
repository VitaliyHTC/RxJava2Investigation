package com.vitaliyhtc.rxjava2investigation.data.rest;

import com.vitaliyhtc.rxjava2investigation.data.model.response.ProductResult;
import com.vitaliyhtc.rxjava2investigation.data.model.response.ProductsByStoreResult;
import com.vitaliyhtc.rxjava2investigation.data.model.response.ProductsResult;
import com.vitaliyhtc.rxjava2investigation.data.model.response.StoreResult;
import com.vitaliyhtc.rxjava2investigation.data.model.response.StoresResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("stores")
    Call<StoresResult> getStoresResult(
            @Query("page") int page,
            @Query("per_page") int perPage,
            @Query("access_key") String accessKey
    );

    @GET("stores/{store_id}")
    Call<StoreResult> getOneStore(
            @Path("store_id") int storeId,
            @Query("access_key") String accessKey
    );

    @GET("products")
    Call<ProductsResult> getProductsResult(
            @Query("page") int page,
            @Query("per_page") int perPage,
            @Query("where_not") String whereNot,
            @Query("access_key") String accessKey
    );

    @GET("products")
    Call<ProductsByStoreResult> getProductsByStore(
            @Query("store_id") int storeId,
            @Query("page") int page,
            @Query("per_page") int perPage,
            @Query("where_not") String whereNot,
            @Query("access_key") String accessKey
    );

    @GET("products")
    Call<ProductsResult> getProductsSearchWithWResult(
            @Query("page") int page,
            @Query("per_page") int perPage,
            @Query("where_not") String whereNot,
            @Query("where") String where,
            @Query("access_key") String accessKey
    );

    @GET("products")
    Call<ProductsResult> getProductsSearchWithQResult(
            @Query("page") int page,
            @Query("per_page") int perPage,
            @Query("where_not") String whereNot,
            @Query("q") String query,
            @Query("access_key") String accessKey
    );

    @GET("products")
    Call<ProductsResult> getProductsSearchWithQWResult(
            @Query("page") int page,
            @Query("per_page") int perPage,
            @Query("where_not") String whereNot,
            @Query("q") String query,
            @Query("where") String where,
            @Query("access_key") String accessKey
    );

    @GET("products/{product_id}")
    Call<ProductResult> getOneProduct(
            @Path("product_id") int productId,
            @Query("access_key") String accessKey
    );

}
