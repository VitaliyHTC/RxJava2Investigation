package com.vitaliyhtc.rxjava2investigation.data;

import android.util.Log;

import com.vitaliyhtc.rxjava2investigation.BuildConfig;
import com.vitaliyhtc.rxjava2investigation.Config;
import com.vitaliyhtc.rxjava2investigation.data.model.Store;
import com.vitaliyhtc.rxjava2investigation.data.model.response.StoresResult;
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

public class StoreDataManagerImpl implements StoreDataManager {
    private static final String LOG_TAG = StoreDataManagerImpl.class.getSimpleName();

    private List<Store> mStoresResult = new ArrayList<>();

    private Observable<Store> mStoreObservable;

    @Override
    public void initResources() {
    }

    @Override
    public void releaseResources() {
    }

    public synchronized Observable<Store> getStoresObservable() {
        if (mStoreObservable != null) {
            return mStoreObservable;
        } else {
            mStoreObservable = Observable.create(e -> getStoresPageFromNetwork(1, e));
            return mStoreObservable;
        }
    }

    private void getStoresPageFromNetwork(final int offset, final ObservableEmitter<Store> emitter) {
        mStoresResult.clear();
        ApiInterface apiService = RetrofitApiClient.getClient().create(ApiInterface.class);

        Call<StoresResult> call = apiService.getStoresResult(offset, Config.STORES_PER_PAGE, BuildConfig.LCBO_API_ACCESS_KEY);
        call.enqueue(new Callback<StoresResult>() {
            @Override
            public void onResponse(Call<StoresResult> call, Response<StoresResult> response) {
                if (response.isSuccessful()) {
                    StoresResult storesResult = response.body();
                    mStoresResult = storesResult.getResult();

                    if (!mStoresResult.isEmpty()) {
                        for (Store store : mStoresResult) {
                            emitter.onNext(store);
                        }
                        //mStoresResult.forEach(emitter::onNext);
                        if (!emitter.isDisposed())
                            getStoresPageFromNetwork(offset + 1, emitter);
                    } else {
                        emitter.onComplete();
                    }
                } else {
                    Log.e(LOG_TAG, "getStoresPageFromNetwork() - response problem.");
                    emitter.onError(new IOException("getStoresPageFromNetwork() - response problem."));
                }
            }

            @Override
            public void onFailure(Call<StoresResult> call, Throwable t) {
                Log.e(LOG_TAG, t.toString());
                if (!emitter.isDisposed())
                    emitter.onError(t);
            }
        });
    }
}
