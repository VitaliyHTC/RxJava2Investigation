package com.vitaliyhtc.rxjava2investigation.app;

import android.app.Application;

import com.vitaliyhtc.rxjava2investigation.di.ApiModule;
import com.vitaliyhtc.rxjava2investigation.di.AppComponent;
import com.vitaliyhtc.rxjava2investigation.di.DaggerAppComponent;
import com.vitaliyhtc.rxjava2investigation.di.RepositoryModule;

public class App extends Application {

    private static AppComponent sComponent;

    public static AppComponent getComponent() {
        return sComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sComponent = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .repositoryModule(new RepositoryModule())
                .build();
    }
}
