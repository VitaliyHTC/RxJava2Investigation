package com.vitaliyhtc.rxjava2investigation.data;

import android.util.Log;

import com.vitaliyhtc.rxjava2investigation.BuildConfig;
import com.vitaliyhtc.rxjava2investigation.Config;
import com.vitaliyhtc.rxjava2investigation.data.model.ConvertUtils;
import com.vitaliyhtc.rxjava2investigation.data.model.response.Product;
import com.vitaliyhtc.rxjava2investigation.data.model.response.ProductsByStoreResult;
import com.vitaliyhtc.rxjava2investigation.data.rest.ApiInterface;
import com.vitaliyhtc.rxjava2investigation.data.rest.RetrofitApiClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDataManagerImpl implements ProductDataManager {
    private static final String LOG_TAG = ProductDataManagerImpl.class.getSimpleName();

    private List<Product> mProductsResult = new ArrayList<>();

    @Override
    public void initResources() {
    }

    @Override
    public void releaseResources() {
    }

    @Override
    public Observable<com.vitaliyhtc.rxjava2investigation.domain.model.Product> getProductsObservable(final int storeId) {
        return Observable.create(e -> getProductsPageByStoreFromNetwork(1, e, storeId));
    }

    // TODO: 26/07/17 use rx, work with data stream
    // TODO: 26/07/17 you don't know here how many pages you need to load, you just make a request, consume the reponse and return the data stream
    private void getProductsPageByStoreFromNetwork(
            final int offset,
            final ObservableEmitter<com.vitaliyhtc.rxjava2investigation.domain.model.Product> emitter,
            final int storeId
    ) {
        mProductsResult.clear();
        ApiInterface apiService = RetrofitApiClient.getClient().create(ApiInterface.class);

        Call<ProductsByStoreResult> call = apiService.getProductsByStore(storeId, offset,
                Config.PRODUCTS_PER_PAGE, Config.PRODUCTS_WHERE_NOT, BuildConfig.LCBO_API_ACCESS_KEY);
        call.enqueue(new Callback<ProductsByStoreResult>() {
            @Override
            public void onResponse(Call<ProductsByStoreResult> call, Response<ProductsByStoreResult> response) {
                if (response.isSuccessful()) {
                    ProductsByStoreResult productsResult = response.body();
                    mProductsResult = productsResult.getResult();

                    if (!mProductsResult.isEmpty()) {
                        for (Product product : mProductsResult) {
                            //TODO: use mapper
                            emitter.onNext(ConvertUtils.convertProductModel(product));
                        }
                        // mProductsResult.forEach(emitter::onNext);
                        if (!emitter.isDisposed())
                            getProductsPageByStoreFromNetwork(offset + 1, emitter, storeId);
                    } else {
                        emitter.onComplete();
                    }
                } else {
                    Log.e(LOG_TAG, "getProductsPageByStoreFromNetwork() - response problem.");
                    emitter.onError(new IOException("getProductsPageByStoreFromNetwork() - response problem."));
                }
            }

            @Override
            public void onFailure(Call<ProductsByStoreResult> call, Throwable t) {
                Log.e(LOG_TAG, t.toString());
                if (!emitter.isDisposed())
                    emitter.onError(t);
            }
        });
    }
}
