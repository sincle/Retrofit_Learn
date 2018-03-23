package com.haieros.retrofit_learn.api;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Kang on 2018/3/23.
 */

public interface ApiService {
    String HOST = "http://120.55.88.22:18080/";

   // @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("pureRun/user/login")
    Call<LoginBean> login(@Body RequestBody json);
}
