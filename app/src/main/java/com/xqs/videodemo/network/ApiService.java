package com.xqs.videodemo.network;


import com.xqs.videodemo.base.BaseData;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;


public interface ApiService {


    @FormUrlEncoded
    @POST("discovery/findInfo.ajax")
    Observable<BaseData> getExploreDetail(@Field("account") String account,
                                          @Field("activityId") String activityId);

}
