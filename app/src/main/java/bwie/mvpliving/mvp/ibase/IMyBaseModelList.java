package bwie.mvpliving.mvp.ibase;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/6.
 */

public interface IMyBaseModelList<T> {
    void getData(MyCallBackList myCallBacklist);
    //void getData(MyCallBack<T> myCallBack);
}
