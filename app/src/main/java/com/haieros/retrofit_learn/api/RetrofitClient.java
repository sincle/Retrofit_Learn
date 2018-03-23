package com.haieros.retrofit_learn.api;

import com.google.gson.Gson;
import com.haieros.cjp.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kang on 2018/3/23.
 */

public class RetrofitClient {

    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;
    private ApiService apiService;
    private RetrofitClient(){

    }
    public static RetrofitClient getInstance(){

        if(retrofitClient == null) {
            synchronized (RetrofitClient.class){
                if(retrofitClient == null) {
                    retrofitClient = new RetrofitClient();
                }
            }
        }
        return retrofitClient;
    }

    public ApiService configRetrofit(Gson gson){
        if (apiService == null) {
            synchronized (RetrofitClient.class) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(ApiService.HOST)
                        .client(configClient())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                apiService = retrofit.create(ApiService.class);
            }
        }
        return apiService;
    }

    private OkHttpClient configClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        builder.connectTimeout(15, TimeUnit.SECONDS);
        return builder.build();
    }
}
