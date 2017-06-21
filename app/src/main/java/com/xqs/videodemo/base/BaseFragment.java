package com.xqs.videodemo.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hwangjr.rxbus.RxBus;

import butterknife.ButterKnife;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    public ProgressDialog dialog;

    protected P mPresenter;

    protected abstract int getContentViewLayoutId();

    protected abstract void initialize();

    protected abstract P providerPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.get().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getContentViewLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        mPresenter = providerPresenter();
        initialize();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.unsubscribe();
        }
        RxBus.get().unregister(this);
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissLoading() {
        if (null != dialog && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
