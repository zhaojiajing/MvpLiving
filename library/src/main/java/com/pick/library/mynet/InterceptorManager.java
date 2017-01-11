package com.pick.library.mynet;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;

/**
 * 1.类的用途:拦截器管理类
 * 2.@author:zhaojingjing
 * 3.2016/12/28.
 */

public class InterceptorManager {
//私有化
   private static List<Interceptor> mInterceptorList=new ArrayList<>();
    public static void add(Interceptor interceptor){
        mInterceptorList.add(interceptor);
    }

    public static List<Interceptor> getmInterceptorList() {
        return mInterceptorList;
    }
}
