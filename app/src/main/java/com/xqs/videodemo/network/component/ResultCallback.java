package com.xqs.videodemo.network.component;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;


public abstract class ResultCallback<T> extends Subscriber<T> {
    private static final int ERROR_CODE_JSON_PARSE = 400;
    private static final int ERROR_CODE_IO = 403;
    private static final int ERROR_CODE_UNKNOWN = 500;

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        JDException exception;
        if (e instanceof HttpException) {
            exception = new JDException(((HttpException) e).code(), "网络加载错误");
        } else if (e instanceof JDException) {
            exception = (JDException) e;
        } else if (e instanceof JsonParseException || e instanceof JSONException) {
            exception = new JDException(ERROR_CODE_JSON_PARSE, "解析服务器数据失败");
        } else if (e instanceof IOException) {
            exception = new JDException(ERROR_CODE_IO, "网络连接失败");
        } else {
            exception = new JDException(ERROR_CODE_UNKNOWN, "服务器发生未知错误");
        }
        showErrorToast(exception.message);
        onFailure(exception);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onCompleted() {

    }

    protected abstract void onFailure(JDException e);

    protected abstract void onSuccess(T t);


    protected void showErrorToast(final String msg) {
//        new Handler(Looper.getMainLooper()).post(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(App.getContext(), msg, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

}