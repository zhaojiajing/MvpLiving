package com.pick.library.log;

import com.socks.library.KLog;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2016/12/28.
 */

public class MyLog implements IMyLog {
    @Override
    public void e(Object obj) {
        KLog.e(obj);
    }

    @Override
    public void i(Object obj) {
        KLog.i(obj);
    }

    @Override
    public void d(Object obj) {
        KLog.d(obj);
    }

    @Override
    public void json(String msg) {
        KLog.json(msg);
    }

    @Override
    public void v(Object obj) {
        KLog.v(obj);
    }
}
