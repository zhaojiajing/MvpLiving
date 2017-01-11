package bwie.mvpliving.mvp.ibase;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/5.
 */

public interface IMyIdModel<T> {
 void getColumTwoData(int id, MyCallBack<T> myCallBack);
}
