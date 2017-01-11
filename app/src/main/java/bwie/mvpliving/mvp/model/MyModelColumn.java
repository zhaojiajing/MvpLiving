package bwie.mvpliving.mvp.model;

import com.pick.library.net.ICallback;

import bwie.mvpliving.bean.ColumnBean;
import bwie.mvpliving.mvp.ibase.IMyBaseModel;
import bwie.mvpliving.mvp.ibase.MyCallBack;

/**
 * 1.类的用途:请求数据(专栏)
 * 2.@author:zhaojingjing
 * 3.2017/1/4.
 */

public class MyModelColumn extends MyBaseModel implements IMyBaseModel {

    @Override
    public void getinitData(final MyCallBack myCallBack) {
        deploy(getApi().getColumnData(), new ICallback<ColumnBean>() {


            @Override
            public void onCompleted(ColumnBean columnBean) {
                myCallBack.success(columnBean);
            }

            @Override
            public void onFailed(String errMsg) {
                myCallBack.failed(errMsg);
            }
        });
    }

    @Override
    public void getRefreshData(MyCallBack myCallBack) {

    }

    @Override
    public void getLoadMoreData(MyCallBack myCallBack) {

    }
}
