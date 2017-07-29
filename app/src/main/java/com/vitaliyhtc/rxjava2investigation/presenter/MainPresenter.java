package com.vitaliyhtc.rxjava2investigation.presenter;

// TODO: 26/07/17 no need for this interface
// Why? How we will use Presenter from View?
public interface MainPresenter<T> extends BasePresenter<T> {
    void loadData();
}
