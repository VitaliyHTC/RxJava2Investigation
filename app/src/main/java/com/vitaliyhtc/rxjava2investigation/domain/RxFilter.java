package com.vitaliyhtc.rxjava2investigation.domain;

public interface RxFilter<T> {
    boolean isMeetsCondition(T t);
}
