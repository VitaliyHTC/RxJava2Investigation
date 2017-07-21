package com.vitaliyhtc.rxjava2investigation.presenter;

import com.vitaliyhtc.rxjava2investigation.view.BaseView;

public interface BasePresenter {
    void onAttachView(BaseView baseView);
    void onDetachView();
}
