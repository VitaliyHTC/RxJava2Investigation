package com.vitaliyhtc.rxjava2investigation.presenter;

import com.vitaliyhtc.rxjava2investigation.view.BaseView;

public interface BasePresenter<T extends BaseView> {
    void onAttachView(T view);
    void onDetachView();
}
