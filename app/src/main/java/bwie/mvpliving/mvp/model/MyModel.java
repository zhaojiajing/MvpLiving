package bwie.mvpliving.mvp.model;

import com.pick.library.net.ICallback;

import bwie.mvpliving.bean.DailyBean;
import bwie.mvpliving.mvp.ibase.IMyBaseModel;
import bwie.mvpliving.mvp.ibase.MyCallBack;
import rx.Observable;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/3.
 */

public class MyModel extends MyBaseModel implements IMyBaseModel {
    @Override
    public void getinitData(final MyCallBack myCallBack) {
        //调deploy()方法第一个参数  Observable<> 通过getApi().getDailyData()得到
        Observable<DailyBean> dailyData = getApi().getDailyData();
        deploy(dailyData, new ICallback<DailyBean>() {


            @Override
            public void onCompleted(DailyBean dailyBean) {
                myCallBack.success(dailyBean);
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
