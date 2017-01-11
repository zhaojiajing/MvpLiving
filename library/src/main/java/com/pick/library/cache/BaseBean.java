package com.pick.library.cache;

import com.google.gson.Gson;

/**
 * 类描述：缓存数据bean基类
 * 创建人：zhaojingjing
 * 创建时间：2016/7/6 10:54
 */
public class BaseBean {
    /**
     * 默认有效期限是1小时： 60 * 60 * 1000
     */
    private static final long EXPIRE_LIMIT = 60 * 60 * 1000;
    private long mCreateTime;

    public BaseBean(){
        mCreateTime = System.currentTimeMillis();
    }

    /**
     * 在{@link #EXPIRE_LIMIT}时间之内有效，过期作废
     *
     * @return true 表示过期
     */
    public boolean isExpire() {

        //当前时间-保存时间如果超过1天，则认为过期
        return System.currentTimeMillis() - mCreateTime > EXPIRE_LIMIT;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}