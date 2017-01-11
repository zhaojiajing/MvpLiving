package bwie.mvpliving.mvp.model;

import com.pick.library.net.ICallback;

import bwie.mvpliving.bean.YanZhiBean;
import bwie.mvpliving.mvp.ibase.IMyBaseModelOne;
import bwie.mvpliving.mvp.ibase.MyCallBack;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/7.
 */

public class MyModelYanzhi extends MyBaseQuanmingModel implements IMyBaseModelOne<YanZhiBean> {
    @Override
    public void getData(final MyCallBack<YanZhiBean> myCallBack) {
        deploy(getApi().getYanZhiData(), new ICallback<YanZhiBean>() {
            @Override
            public void onCompleted(YanZhiBean yanZhiBean) {
                myCallBack.success(yanZhiBean);
            }

            @Override
            public void onFailed(String errMsg) {
                myCallBack.failed(errMsg);
            }
        });
    }
}
