package com.vitaliyhtc.rxjava2investigation.presenter;

import com.vitaliyhtc.rxjava2investigation.view.BaseView;

public interface BasePresenter {
    // TODO: 24/07/17 modify with generics so don't need to cast
    void onAttachView(BaseView baseView);
    void onDetachView();
}
