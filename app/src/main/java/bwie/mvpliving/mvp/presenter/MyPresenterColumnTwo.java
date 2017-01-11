package bwie.mvpliving.mvp.presenter;

import com.pick.library.mvp.BasePresenter;

import bwie.mvpliving.bean.ColumTwo;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.ibase.MyCallBack;
import bwie.mvpliving.mvp.model.MyModelColumnTwo;
import bwie.mvpliving.mvp.view.activity.ColumnActivityTwo;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/5.
 */

public class MyPresenterColumnTwo extends BasePresenter<MyModelColumnTwo, ColumnActivityTwo> implements Contract.IMyColumnTwoPresenter {
    public MyPresenterColumnTwo(ColumnActivityTwo columnActivityTwo) {
        super(columnActivityTwo);
    }


    @Override
    protected MyModelColumnTwo createModel() {
        return new MyModelColumnTwo();
    }

    @Override
    public void getColumnTwoData(int id) {
        getModel().getColumTwoData(id, new MyCallBack<ColumTwo>() {
            @Override
            public void success(ColumTwo columTwo) {
                getView().getInitData(columTwo);
            }

            @Override
            public void failed(String errormsg) {
                getView().getInitDataFailed(errormsg);
            }
        });
    }
}
