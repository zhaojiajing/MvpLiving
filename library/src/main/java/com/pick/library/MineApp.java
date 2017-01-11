package com.pick.library;


import android.app.Application;
import android.content.Context;

import com.pick.library.mynet.InterceptorManager;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 1.类的用途:在程序的入库初始化okhttp并添加日志拦截器
 * 2.@author:zhaojingjing
 * 3.2016/12/28.
 * 1.final 不允许有set()方法
 */

public class MineApp extends Application {
    private String baseurl = "http://news-at.zhihu.com/api/4/";
    private String baseurlwechat = "http://api.tianapi.com/";

    public String getBaseurlquanmin() {
        return baseurlquanmin;
    }

    private String baseurlquanmin = "http://www.quanmin.tv/";
    private static MineApp mMineApp;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttp();
        mMineApp = this;
        mContext = this;

    }

    private void initOkHttp() {
        HttpLoggingInterceptor mHttpLoggingInterceptor = new HttpLoggingInterceptor();
        mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        InterceptorManager.add(mHttpLoggingInterceptor);
    }

    public String getBaseurl() {
        return baseurl;
    }

    public String getBaseurlwechat() {
        return baseurlwechat;
    }

    public static MineApp getmMineApp() {
        return mMineApp;
    }

    public static Context getmContext() {
        return mContext;
    }

}
