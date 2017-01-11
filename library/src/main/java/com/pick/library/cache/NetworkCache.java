package com.pick.library.cache;

import rx.Observable;

/**
 * 类描述：网络请求
 * 创建人：zhaojingjing
 * 创建时间：2016/7/6 11:04
 */
public abstract class NetworkCache<T extends BaseBean> {

    public abstract Observable<T> get(String key, final Class<T> cls);
}