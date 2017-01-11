package com.pick.library.cache;

import rx.Observable;

/**
 * 类描述：请求缓存接口
 * 创建人：zhaojingjing
 * 创建时间：2016/7/6 10:53
 */
public interface ICache {
    <T extends BaseBean> Observable<T> get(String key, Class<T> cls);

    <T extends BaseBean> void put(String key, T t);
}
