package com.pick.library.mynet;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2016/12/28.
 */

public class RetrofitHelper {
    public static Retrofit getRetrofit(String baseurl){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseurl)
                .client(OkhttpHelper.getinstance().getOkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit;
    }
public <T>T getservice(String baseurl,Class<T> cls){
    return getRetrofit(baseurl).create(cls);
}

}
