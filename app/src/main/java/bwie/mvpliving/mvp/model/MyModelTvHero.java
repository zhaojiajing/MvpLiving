package bwie.mvpliving.mvp.model;

import com.pick.library.net.ICallback;

import bwie.mvpliving.bean.HeroBean;
import bwie.mvpliving.mvp.ibase.IMyBaseModelString;
import bwie.mvpliving.mvp.ibase.MyCallBack;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/8.
 */

public class MyModelTvHero extends MyBaseQuanmingModel implements IMyBaseModelString<HeroBean> {

    @Override
    public void getData(String type, final MyCallBack<HeroBean> myCallBack) {
        deploy(getApi().getHeroData(type), new ICallback<HeroBean>() {
            @Override
            public void onCompleted(HeroBean heroBean) {
                myCallBack.success(heroBean);
            }

            @Override
            public void onFailed(String errMsg) {
                myCallBack.failed(errMsg);
            }
        });
    }
}
