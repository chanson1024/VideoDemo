package com.xqs.videodemo.network.interceptor;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;


public class NetworkInterceptor implements Interceptor {
    private static final String TAG = "OkHttp";
    private static final String L = "l";
    private static final String SIGN = "sign";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        return chain.proceed(request);
    }

    public static String bodyToString(RequestBody requestBody) {
        String paramString;
        try {
            Buffer buffer = new Buffer();
            if (requestBody != null) {
                requestBody.writeTo(buffer);
            } else {
                return "";
            }
            paramString = buffer.readUtf8();
        } catch (IOException e) {
            return "";
        }

        Map<String, Object> paramMap = new HashMap<>();
        String[] params = paramString.split("&");
        for (String param : params) {
            String[] p = param.split("=");
            if (p.length == 2) {
                paramMap.put(p[0], p[1]);
            }
        }
        return new JSONObject(paramMap).toString();
    }
}
