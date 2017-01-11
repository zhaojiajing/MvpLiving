package bwie.mvpliving.mvp.ibase;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/3.
 */

public interface MyCallBack<T> {
    void success (T t);
    void failed(String errormsg);
}
