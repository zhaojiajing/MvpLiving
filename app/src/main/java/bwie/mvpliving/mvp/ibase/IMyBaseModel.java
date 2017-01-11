package bwie.mvpliving.mvp.ibase;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/3.
 */

public interface IMyBaseModel {
    void getinitData(MyCallBack myCallBack);
    void getRefreshData(MyCallBack myCallBack);
    void getLoadMoreData(MyCallBack myCallBack);

}
