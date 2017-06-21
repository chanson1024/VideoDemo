package com.xqs.videodemo.network;


import com.xqs.videodemo.network.component.JDConverterFactory;
import com.xqs.videodemo.network.interceptor.NetworkInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;


public class RestClient {
    private static final String TAG = "RestClient";
    private static ApiService sAPIService;

    public static ApiService getApiService() {
        if (null == sAPIService) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            OkHttpClient okhttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new NetworkInterceptor())
                    .addInterceptor(logging)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();
            sAPIService = createRetrofit(APIConfig.API_BASE_URL, okhttpClient).create(ApiService.class);
        }
        return sAPIService;
    }


    private static Retrofit createRetrofit(String baseUrl, OkHttpClient client) {
        return  new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JDConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }
}
