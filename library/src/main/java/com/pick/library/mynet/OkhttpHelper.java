package com.pick.library.mynet;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * 1.类的用途:通过OkhttpHelper获取getOkHttpClient
 * 2.@author:zhaojingjing
 * 3.2016/12/28.
 */

public class OkhttpHelper {
    /**
     * 单例模式
     */
    private static OkhttpHelper mOkhttpHelper;

    private OkhttpHelper() {
    }

    public static OkhttpHelper getinstance() {
        if (mOkhttpHelper == null) {
            synchronized (OkhttpHelper.class) {
                if (mOkhttpHelper == null) {
                    mOkhttpHelper = OkhttpHolder.instance;//静态内部类的静态属性
                }
            }
        }
        return mOkhttpHelper;
    }

    //静态内部类
    static class OkhttpHolder {
        static OkhttpHelper instance = new OkhttpHelper();
    }
//非静态的
    public OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(3000, TimeUnit.MILLISECONDS)
                .writeTimeout(3000, TimeUnit.MILLISECONDS)
                .connectTimeout(3000, TimeUnit.MILLISECONDS);

        List<Interceptor> mList = InterceptorManager.getmInterceptorList();
        /**
         * 判空操作
         */
        if(!mList.isEmpty()){
            for (Interceptor interceptor : mList) {
                builder.addInterceptor(interceptor);
            }
        }

        return builder.build();


    }


}
