package com.haieros.retrofit_learn.api;

import com.google.gson.Gson;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kang on 2018/3/23.
 */

public class ApiServiceImpl {

    private static ApiServiceImpl apiServiceImpl;
    private final Gson gson;
    private final ApiService apiService;

    private ApiServiceImpl(){
        gson = new Gson();
        apiService = RetrofitClient.getInstance().configRetrofit(gson);
    }

    public static ApiServiceImpl getInstance(){

        if(apiServiceImpl == null) {
            synchronized (ApiServiceImpl.class){
                if(apiServiceImpl == null) {
                    apiServiceImpl = new ApiServiceImpl();
                }
            }
        }
        return apiServiceImpl;
    }

    public void login(HashMap map, final IRequestCallBack<LoginBean> requestCallBack){

        Call<LoginBean> login =apiService.login(createRequestBody(map));
        login.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                requestCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                requestCallBack.onFailure(t);
            }
        });
    }

    /**
     * 创建请求体
     * @param map
     * @return
     */
    public RequestBody createRequestBody(HashMap map){
        String content = gson.toJson(map);
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), content);
    }
}
