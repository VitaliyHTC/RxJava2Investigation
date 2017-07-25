package com.vitaliyhtc.rxjava2investigation.domain;

import io.reactivex.disposables.Disposable;

public abstract class RxUtils {

    public RxUtils() {
        throw new AssertionError();
    }

    public static void dispose(Disposable disposable) {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }
}
