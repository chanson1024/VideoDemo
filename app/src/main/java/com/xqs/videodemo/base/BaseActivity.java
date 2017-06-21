package com.xqs.videodemo.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hwangjr.rxbus.RxBus;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    public ProgressDialog dialog;

    protected P mPresenter;

    protected abstract void initialize();

    protected abstract int getContentViewLayoutId();

    protected abstract P providerPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayoutId());
        mPresenter = providerPresenter();
        initialize();
        RxBus.get().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.unsubscribe();
        }
        RxBus.get().unregister(this);
    }

    @Override
    public void showLoading() {
        // TODO: 07/06/2017  
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissLoading() {
        if (null != dialog && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
