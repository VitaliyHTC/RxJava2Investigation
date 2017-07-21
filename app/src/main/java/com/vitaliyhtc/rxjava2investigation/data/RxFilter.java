package com.vitaliyhtc.rxjava2investigation.data;

public interface RxFilter<T> {
    boolean isMeetsCondition(T t);
}
