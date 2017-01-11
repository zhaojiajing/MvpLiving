package bwie.mvpliving.mvp.model;

import com.pick.library.net.ICallback;

import bwie.mvpliving.bean.ColumnDetail;
import bwie.mvpliving.mvp.ibase.IMyIdModel;
import bwie.mvpliving.mvp.ibase.MyCallBack;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/5.
 */

public class MyModelColummDetail extends MyBaseModel implements IMyIdModel<ColumnDetail> {
    @Override
    public void getColumTwoData(int id, final MyCallBack<ColumnDetail> myCallBack) {
        deploy(getApi().getColumnDetailData(id), new ICallback<ColumnDetail>() {

            @Override
            public void onCompleted(ColumnDetail columnDetail) {
                myCallBack.success(columnDetail);
            }

            @Override
            public void onFailed(String errMsg) {
                myCallBack.failed(errMsg);
            }
        });
    }
}
