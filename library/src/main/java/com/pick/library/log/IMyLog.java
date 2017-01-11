package com.pick.library.log;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2016/12/28.
 */

public interface IMyLog {
    void e(Object obj);
    void i(Object obj);
    void d(Object obj);
    void json(String msg);
    void v(Object obj);
}
