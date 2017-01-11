package bwie.mvpliving.mvp.ibase;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/9.
 */

public interface IMyBaseModelString<T> {
    void getData(String type ,MyCallBack<T> myCallBack);
}
