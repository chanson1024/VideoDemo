package com.xqs.videodemo.base;

import rx.subscriptions.CompositeSubscription;


public class BasePresenter {
    protected CompositeSubscription mCompositeSubscription;

    public BasePresenter() {
        mCompositeSubscription = new CompositeSubscription();
    }

    protected void unsubscribe() {
        mCompositeSubscription.unsubscribe();
    }
}
