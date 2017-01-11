package com.pick.library.cache;

import android.util.Log;

import com.pick.library.utils.MD5Utils;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 类描述：缓存管理器
 * 创建人：zhaojingjing
 * 创建时间：2016/7/6 11:04
 */
public class CacheManager {
    private ICache mMemoryCache, mDiskCache;
    private CacheManager() {
        mMemoryCache = new MemoryCache();
        mDiskCache = new DiskCache();
    }

    public static final CacheManager getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static final class LazyHolder {
        public static final CacheManager INSTANCE = new CacheManager();
    }

    public <T extends BaseBean> Observable<T> load(final String key, Class<T> cls, NetworkCache<T> networkCache) {
        String md5Key = MD5Utils.md5(key);

        Observable observable = Observable.concat(
                loadFromMemory(md5Key, cls),
                loadFromDisk(md5Key, cls),
                loadFromNetwork(key, md5Key, cls, networkCache))
                .first(new Func1<T, Boolean>() {
                    @Override
                    public Boolean call(T t) {
                        String result = t == null ? key + " not exist" :
                                t.isExpire() ? key + " exist but expired" : key + " exist and not expired";
                        Log.v("cache", "result: " + result);
                        return t != null && !t.isExpire();
                    }
                });
        return observable;
    }

    private <T extends BaseBean> Observable<T> loadFromMemory(String key, Class<T> cls) {

        Observable.Transformer<T, T> transformer = log("load from memory: " + key);

        return mMemoryCache
                .get(key, cls)
                .compose(transformer);
    }

    private <T extends BaseBean> Observable<T> loadFromDisk(final String key, Class<T> cls) {

        Observable.Transformer<T, T> transformer = log("load from disk: " + key);

        return mDiskCache.get(key, cls)
                .compose(transformer)
                .doOnNext(new Action1<T>() {
                    @Override
                    public void call(T t) {

                        if (null != t) {

                            mMemoryCache.put(key, t);
                        }
                    }
                });
    }

    private <T extends BaseBean> Observable<T> loadFromNetwork(final String key, final String md5Key, Class<T> cls
            , NetworkCache<T> networkCache) {

        Observable.Transformer<T, T> transformer = log("load from network: " + key);

        return networkCache.get(key, cls)
                .compose(transformer)
                .doOnNext(new Action1<T>() {
                    @Override
                    public void call(T t) {

                        if (null != t) {
                            mDiskCache.put(md5Key, t);
                            mMemoryCache.put(md5Key, t);
                        }
                    }
                });
    }

    private <T extends BaseBean> Observable.Transformer<T, T> log(final String msg) {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.doOnNext(new Action1<T>() {
                    @Override
                    public void call(T t) {

                        //MemoryCache、DiskCache中已经打印过log了，这里只是为了演示transformer、和compose的使用
                        Log.v("cache", msg);
                    }
                });
            }
        };
    }
}