package bwie.mvpliving.mvp.presenter;

import com.pick.library.mvp.BasePresenter;

import bwie.mvpliving.bean.ColumnDetail;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.ibase.MyCallBack;
import bwie.mvpliving.mvp.model.MyModelColummDetail;
import bwie.mvpliving.mvp.view.activity.ColumnDetailActivity;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/5.
 */

public class MypresenterColumnDetail extends BasePresenter<MyModelColummDetail, ColumnDetailActivity> implements Contract.IMyColumnTwoPresenter {
    public MypresenterColumnDetail(ColumnDetailActivity columnDetailActivity) {
        super(columnDetailActivity);
    }


    @Override
    protected MyModelColummDetail createModel() {
        return new MyModelColummDetail();
    }

    @Override
    public void getColumnTwoData(int id) {
        getModel().getColumTwoData(id, new MyCallBack<ColumnDetail>() {
            @Override
            public void success(ColumnDetail columnDetail) {
                getView().getDataSuccess(columnDetail);
            }

            @Override
            public void failed(String errormsg) {
                getView().getDataFailed(errormsg);
            }
        });
    }
}
