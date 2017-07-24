package com.vitaliyhtc.rxjava2investigation.presenter;

public interface BasePresenter<T> {
    void onAttachView(T view);
    void onDetachView();
}
