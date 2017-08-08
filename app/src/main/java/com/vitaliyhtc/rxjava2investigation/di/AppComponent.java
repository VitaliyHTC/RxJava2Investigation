package com.vitaliyhtc.rxjava2investigation.di;

import com.vitaliyhtc.rxjava2investigation.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ApiModule.class, RepositoryModule.class})
@Singleton
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
