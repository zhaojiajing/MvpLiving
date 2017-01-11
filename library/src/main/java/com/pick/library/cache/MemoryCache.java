package com.pick.library.cache;

import android.text.TextUtils;
import android.util.LruCache;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

import rx.Observable;
import rx.Subscriber;

/**
 * 类描述：内存缓存
 * 创建人：zhaojingjing
 * 创建时间：2016/7/6 11:02
 */
public class  MemoryCache implements ICache{
    private LruCache<String, String> mCache;

    public MemoryCache() {
        //获取系统分配给每个应用程序的最大内存，每个应用系统分配32M
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int mCacheSize = maxMemory / 8;
        //给LruCache分配1/8 4M
        mCache = new LruCache<String, String>(mCacheSize) {
            @Override
            protected int sizeOf(String key, String value) {
                try {
                    return value.getBytes("UTF-8").length;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return value.getBytes().length;
                }
            }
        };
    }

    @Override
    public <T extends BaseBean> Observable<T> get(final String key, final Class<T> cls) {

        Observable.OnSubscribe<T> f = new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                String result = mCache.get(key);
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                if (TextUtils.isEmpty(result)) {
                    subscriber.onNext(null);
                } else {
                    T t = new Gson().fromJson(result, cls);
                    subscriber.onNext(t);
                }
                subscriber.onCompleted();
            }
        };

        return Observable.create(f);
    }

    @Override
    public <T extends BaseBean> void put(String key, T t) {
        if (null != t) {
            mCache.put(key, t.toString());
        }
    }
}
