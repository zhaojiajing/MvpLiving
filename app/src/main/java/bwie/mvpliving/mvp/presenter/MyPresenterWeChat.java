package bwie.mvpliving.mvp.presenter;

import com.pick.library.mvp.BasePresenter;

import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.ibase.MyCallBack;
import bwie.mvpliving.mvp.model.MyModelWeChat;
import bwie.mvpliving.mvp.view.fragment.WechatFragment;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/4.
 */

public class MyPresenterWeChat extends BasePresenter<MyModelWeChat, WechatFragment> implements Contract.IMyBasePresenter {
    public MyPresenterWeChat(WechatFragment wechatFragment) {
        super(wechatFragment);
    }

    @Override
    public void getInitData() {
        new MyModelWeChat().getinitData(new MyCallBack() {

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
        new MyModelWeChat().getRefreshData(new MyCallBack() {
            @Override
            public void success(Object db) {
                getView().getRefreshDataSuccess(db);
            }

            @Override
            public void failed(String errormsg) {
                getView().getRefreshDataFailed(errormsg);
            }
        });
    }

    @Override
    public void getLoadMoreData() {
        new MyModelWeChat().getLoadMoreData(new MyCallBack() {
            @Override
            public void success(Object db) {
                getView().getLoadMoreDataSuccess(db);
            }

            @Override
            public void failed(String errormsg) {
                getView().getLoadMoreDataFailed(errormsg);
            }
        });
    }

    @Override
    protected MyModelWeChat createModel() {
        return new MyModelWeChat();
    }
}
