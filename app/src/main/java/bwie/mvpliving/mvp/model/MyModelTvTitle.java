package bwie.mvpliving.mvp.model;

import com.pick.library.net.ICallback;

import java.util.List;

import bwie.mvpliving.bean.TvBean;
import bwie.mvpliving.mvp.ibase.IMyBaseModelList;
import bwie.mvpliving.mvp.ibase.MyCallBackList;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/6.
 */

public class MyModelTvTitle extends MyBaseQuanmingModel implements IMyBaseModelList<TvBean> {

    @Override
    public void getData(final MyCallBackList myCallBacklist) {
        //请求数据
        deploylist(getApi().getTvData(), new ICallback<List<TvBean>>() {


            @Override
            public void onCompleted(List<TvBean> tvBeen) {
                myCallBacklist.success(tvBeen);
            }

            @Override
            public void onFailed(String errMsg) {
                myCallBacklist.failed(errMsg);
            }
        });
    }
}
