package com.vitaliyhtc.rxjava2investigation.data;

import com.vitaliyhtc.rxjava2investigation.BuildConfig;
import com.vitaliyhtc.rxjava2investigation.Config;
import com.vitaliyhtc.rxjava2investigation.data.model.mapper.StoreMapper;
import com.vitaliyhtc.rxjava2investigation.data.model.response.StoresResult;
import com.vitaliyhtc.rxjava2investigation.data.rest.ApiInterface;
import com.vitaliyhtc.rxjava2investigation.data.rest.RetrofitApiClient;
import com.vitaliyhtc.rxjava2investigation.domain.StoreRepository;
import com.vitaliyhtc.rxjava2investigation.domain.model.Store;

import java.util.List;

import io.reactivex.Observable;

public class StoreRepositoryImpl implements StoreRepository {

    private final StoreMapper mStoreMapper;

    // TODO: 01/08/17  send ApiInterface into constuctor and use it from here
    public StoreRepositoryImpl() {
        mStoreMapper = new StoreMapper();
    }

    @Override
    public void initResources() {
    }

    @Override
    public void releaseResources() {
    }

    @Override
    public Observable<List<Store>> getStoresObservable(int page) {
        ApiInterface apiService = RetrofitApiClient.getClient().create(ApiInterface.class);
        return apiService
                .getStoresResult(
                        page,
                        Config.STORES_PER_PAGE,
                        // TODO: 01/08/17 api key is static for whole project, can be used as constant in ApiInterface
                        BuildConfig.LCBO_API_ACCESS_KEY
                )
                .toObservable()
                .map(StoresResult::getResult)
                .flatMap(Observable::fromIterable)
                .map(mStoreMapper)
                .toList()
                .toObservable();
    }
}
