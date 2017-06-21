package com.xqs.videodemo.network.component;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;


final class ResponseConverter<T> implements Converter<ResponseBody, T> {

    private static final String TAG = "OkHttp";
    private final Gson gson;
    private final Type type;
    private static final String KEY_CODE = "code";
    private static final String KEY_MSG = "msg";

    public ResponseConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        int code = 0;
        String msg = "";
        try {
            Log.i(TAG, "convert: okhttp "+"post response="+response);
            JSONObject jsonObject = new JSONObject(response);
            code = jsonObject.getInt(KEY_CODE);
            if(jsonObject.has(KEY_MSG)) {
                msg = jsonObject.getString(KEY_MSG);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        if (code == 0) {
            return convert2Body(response);
        } else {
            throw new JDException(code, msg);
        }
    }

    public T convert2Body(String response) {
        TypeToken typeToken = TypeToken.get(type);
        if (typeToken.getRawType() == String.class || TextUtils.isEmpty(response)) {
            return (T) response;
        } else {
            return gson.fromJson(response, type);
        }
    }

}
