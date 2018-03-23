package com.haieros.retrofit_learn.api;

/**
 * Created by Kang on 2016/12/27.
 *
 * 网络请求回调接口
 */
public interface IRequestCallBack<T>{

    /**
     * 成功回调
     * @param response
     */
    void onSuccess(T response);

    /**
     * 失败回调
     * @param throwable 异常信息
     * 自己主动取消的错误的 java.net.SocketException: Socket closed
     * 超时的错误是 java.net.SocketTimeoutException
     * 网络出错的错误是java.net.ConnectException: Failed to connect to xxxxx
     * 已经连接 Canceled
     */
    void onFailure(Throwable throwable);
}
