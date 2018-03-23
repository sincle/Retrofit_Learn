package com.haieros.retrofit_learn.api;

import com.google.gson.Gson;
import com.haieros.cjp.bean.LoginBean;
import com.haieros.cjp.utils.JsonUtils;
import com.haieros.cjp.utils.Logger;
import com.haieros.cjp.utils.MD5Util;

import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Kang on 2018/3/23.
 */

public class LoginService {

    public void login(String sendPhone, String pwd, final IRequestCallBack<LoginBean> requestCallBack){
        String sendPwd = MD5Util.MD5(pwd); //md5 加密
        //生成post 参数
        HashMap<Object, Object> map = new HashMap<>();
//        String deviceId = PhoneUtils.getDeviceId(this);
//        map.put("openId", deviceId);
        map.put("loginType", 1);
        map.put("phone", sendPhone);
        map.put("password", sendPwd);
        String json = JsonUtils.newJson(map);
        RequestBody body =RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),json);
        Logger.e(TAG, "LoginActivity--->login--->:" + json);
        Call<LoginBean> login = RetrofitClient.getInstance().configRetrofit(new Gson()).login(body);
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
}
