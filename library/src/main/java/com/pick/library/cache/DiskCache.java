package com.pick.library.cache;

import rx.Observable;

/**
 * 类描述：硬盘缓存
 * 创建人：zhaojingjing
 * 创建时间：2016/7/6 10:55
 */
public class DiskCache implements ICache {
    @Override
    public <T extends BaseBean> Observable<T> get(String key, Class<T> cls) {
        return null;
    }

    @Override
    public <T extends BaseBean> void put(String key, T t) {

    }
//
//    private String CACHE_PATH;
//
//    public DiskCache() {
//        CACHE_PATH = FileUtils.getExternalFileDir("api");
//        KLog.e(CACHE_PATH);
//    }
//
//    @Override
//    public <T extends BaseBean> Observable<T> get(final String key, final Class<T> cls) {
//        Observable.OnSubscribe<T> f =new Observable.OnSubscribe<T>() {
//            @Override
//            public void call(Subscriber<? super T> subscriber) {
//
//                String filename = CACHE_PATH + key;
//                String result = FileUtils.readTextFromSDcard(filename);
//                if (subscriber.isUnsubscribed()) {
//                    return;
//                }
//                if (TextUtils.isEmpty(result)) {
//                    subscriber.onNext(null);
//                } else {
//                    T t = new Gson().fromJson(result, cls);
//                    subscriber.onNext(t);
//                }
//                subscriber.onCompleted();
//            }
//        };
//
//        return Observable.create(f)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }
//
//
//
//    @Override
//    public <T extends BaseBean> void put(final String key, final T t) {
//        Observable.OnSubscribe<T> f = new Observable.OnSubscribe<T>() {
//            @Override
//            public void call(Subscriber<? super T> subscriber) {
//                String filename = CACHE_PATH + key;
//                String result = t.toString();
//                FileUtils.saveText2Sdcard(filename, result);
//                if (!subscriber.isUnsubscribed()) {
//                    subscriber.onNext(t);
//                    subscriber.onCompleted();
//                }
//            }
//        };
//        Observable.create(f)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe();
//    }
//

}
