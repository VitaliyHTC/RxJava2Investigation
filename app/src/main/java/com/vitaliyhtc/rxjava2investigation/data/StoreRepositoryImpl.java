package com.vitaliyhtc.rxjava2investigation.data;

import com.vitaliyhtc.rxjava2investigation.Config;
import com.vitaliyhtc.rxjava2investigation.data.model.mapper.StoreMapper;
import com.vitaliyhtc.rxjava2investigation.data.model.response.StoresResult;
import com.vitaliyhtc.rxjava2investigation.data.rest.ApiInterface;
import com.vitaliyhtc.rxjava2investigation.domain.StoreRepository;
import com.vitaliyhtc.rxjava2investigation.domain.model.Store;

import java.util.List;

import io.reactivex.Observable;

import static com.vitaliyhtc.rxjava2investigation.data.rest.ApiInterface.LCBO_API_ACCESS_KEY;

public class StoreRepositoryImpl implements StoreRepository {

    private ApiInterface mApiService;
    private final StoreMapper mStoreMapper;

    public StoreRepositoryImpl(ApiInterface apiService) {
        mApiService = apiService;
        mStoreMapper = new StoreMapper();
    }

    @Override
    public Observable<List<Store>> getStoresObservable(int page) {
        return mApiService
                .getStoresResult(
                        page,
                        Config.STORES_PER_PAGE,
                        LCBO_API_ACCESS_KEY
                )
                .toObservable()
                .map(StoresResult::getResult)
                .flatMap(Observable::fromIterable)
                .map(mStoreMapper)
                .toList()
                .toObservable();
    }
}
