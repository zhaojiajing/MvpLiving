package bwie.mvpliving.mvp.presenter;

import com.pick.library.mvp.BasePresenter;

import bwie.mvpliving.bean.DailyBean;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.ibase.MyCallBack;
import bwie.mvpliving.mvp.model.MyModel;
import bwie.mvpliving.mvp.view.fragment.DailyFragment;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/3.
 */

public class MyPresenter extends BasePresenter<MyModel, DailyFragment> implements Contract.IMyBasePresenter {
    //父类的有参构造
    public MyPresenter(DailyFragment dailyFragment) {
        super(dailyFragment);
    }

    @Override
    public void getInitData() {
        getModel().getinitData(new MyCallBack() {
            @Override
            public void success(Object db) {
                getView().getInitData((DailyBean)db);
            }

            @Override
            public void failed(String errormsg) {
                getView().getInitDataFailed(errormsg);
            }
        });
    }

    @Override
    public void getRefreshData() {

    }

    @Override
    public void getLoadMoreData() {

    }

    @Override
    protected MyModel createModel() {
        return new MyModel();
    }
}
