package bwie.mvpliving.mvp.presenter;

import com.pick.library.mvp.BasePresenter;

import java.util.List;

import bwie.mvpliving.bean.TvBean;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.ibase.MyCallBackList;
import bwie.mvpliving.mvp.model.MyModelTvTitle;
import bwie.mvpliving.mvp.view.activity.TvActivity;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/6.
 */

public class MyPresenterTvTitle extends BasePresenter<MyModelTvTitle,TvActivity>implements Contract.IMyBasePresenterOne {
    public MyPresenterTvTitle(TvActivity tvActivity) {
        super(tvActivity);
    }

    @Override
    public void getData() {
        getModel().getData(new MyCallBackList<TvBean>() {
            @Override
            public void success(List<TvBean> list) {
                getView().getDataListSuccess(list);
            }

            @Override
            public void failed(String errMsg) {
getView().getDataListFailed(errMsg);
            }
        });
    }

    @Override
    protected MyModelTvTitle createModel() {
        return new MyModelTvTitle();
    }
}
