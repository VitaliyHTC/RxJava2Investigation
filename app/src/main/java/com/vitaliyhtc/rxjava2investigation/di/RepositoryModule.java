package com.vitaliyhtc.rxjava2investigation.di;

import android.support.annotation.NonNull;

import com.vitaliyhtc.rxjava2investigation.data.ProductRepositoryImpl;
import com.vitaliyhtc.rxjava2investigation.data.StoreRepositoryImpl;
import com.vitaliyhtc.rxjava2investigation.data.rest.ApiInterface;
import com.vitaliyhtc.rxjava2investigation.domain.ProductRepository;
import com.vitaliyhtc.rxjava2investigation.domain.StoreRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @NonNull
    @Singleton
    public StoreRepository provideStoreRepository(ApiInterface apiInterface) {
        return new StoreRepositoryImpl(apiInterface);
    }
    
    @Provides
    @NonNull
    @Singleton
    public ProductRepository provideProductRepository(ApiInterface apiInterface) {
        return new ProductRepositoryImpl(apiInterface);
    }
}
