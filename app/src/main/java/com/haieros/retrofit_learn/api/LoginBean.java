package com.haieros.retrofit_learn.api;

/**
 * Created by Kang on 2017/8/24.
 */

public class LoginBean{

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        private String errorCode;
        private String errorDesc;
        private String token;

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorDesc() {
            return errorDesc;
        }

        public void setErrorDesc(String errorDesc) {
            this.errorDesc = errorDesc;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "errorCode='" + errorCode + '\'' +
                    ", errorDesc='" + errorDesc + '\'' +
                    ", token='" + token + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "msg='" + msg + '\'' +
                ", result='" + result + '\'' +
                ", data=" + data +
                ", version='" + version + '\'' +
                '}';
    }
}
