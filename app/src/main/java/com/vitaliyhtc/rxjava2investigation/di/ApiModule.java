package com.vitaliyhtc.rxjava2investigation.di;

import android.support.annotation.NonNull;

import com.vitaliyhtc.rxjava2investigation.data.rest.ApiInterface;
import com.vitaliyhtc.rxjava2investigation.data.rest.RetrofitApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    @NonNull
    @Singleton
    public ApiInterface provideApiInterface() {
        return RetrofitApiClient.getClient().create(ApiInterface.class);
    }
}
