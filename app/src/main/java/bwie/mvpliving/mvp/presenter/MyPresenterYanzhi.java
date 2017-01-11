package bwie.mvpliving.mvp.presenter;

import com.pick.library.mvp.BasePresenter;

import bwie.mvpliving.bean.YanZhiBean;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.ibase.MyCallBack;
import bwie.mvpliving.mvp.model.MyModelYanzhi;
import bwie.mvpliving.mvp.view.fragment.YanzhiFragment;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/7.
 */

public class MyPresenterYanzhi extends BasePresenter<MyModelYanzhi, YanzhiFragment> implements Contract.IMyBasePresenterOne {

    public MyPresenterYanzhi(YanzhiFragment yanzhiFragment) {
        super(yanzhiFragment);
    }

    @Override
    public void getData() {
        getModel().getData(new MyCallBack<YanZhiBean>() {
            @Override
            public void success(YanZhiBean yanZhiBean) {
                getView().getDataSuccess(yanZhiBean);
            }

            @Override
            public void failed(String errormsg) {
                getView().getDataFailed(errormsg);
            }
        });
    }

    @Override
    protected MyModelYanzhi createModel() {
        return new MyModelYanzhi();
    }
}
