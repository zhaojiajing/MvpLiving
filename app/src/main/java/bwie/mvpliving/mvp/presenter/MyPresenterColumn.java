package bwie.mvpliving.mvp.presenter;

import com.pick.library.mvp.BasePresenter;

import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.ibase.MyCallBack;
import bwie.mvpliving.mvp.model.MyModelColumn;
import bwie.mvpliving.mvp.view.fragment.ColumnFragment;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/4.
 */

public class MyPresenterColumn extends BasePresenter<MyModelColumn, ColumnFragment> implements Contract.IMyBasePresenter {
    /**
     * 默认父类有参构造
     *
     * @param columnFragment
     */
    public MyPresenterColumn(ColumnFragment columnFragment) {
        super(columnFragment);
    }

    @Override
    public void getInitData() {
        getModel().getinitData(new MyCallBack() {
            @Override
            public void success(Object db) {
                getView().getInitData(db);
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
    protected MyModelColumn createModel() {
        return new MyModelColumn();
    }
}
