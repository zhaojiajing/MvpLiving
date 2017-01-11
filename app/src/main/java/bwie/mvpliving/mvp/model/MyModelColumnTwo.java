package bwie.mvpliving.mvp.model;

import com.pick.library.net.ICallback;

import bwie.mvpliving.bean.ColumTwo;
import bwie.mvpliving.mvp.ibase.IMyIdModel;
import bwie.mvpliving.mvp.ibase.MyCallBack;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/5.
 */

public class MyModelColumnTwo extends MyBaseModel implements IMyIdModel<ColumTwo> {

    @Override
    public void getColumTwoData(int id, final MyCallBack<ColumTwo> myCallBack) {
        deploy(getApi().getColumnTwoData(id), new ICallback<ColumTwo>() {

            @Override
            public void onCompleted(ColumTwo columTwo) {
                myCallBack.success(columTwo);
            }

            @Override
            public void onFailed(String errMsg) {
                myCallBack.failed(errMsg);
            }
        });
    }
}
