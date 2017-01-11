package bwie.mvpliving.mvp.model;

import com.pick.library.MineApp;
import com.pick.library.mvp.BaseModel;
import com.pick.library.net.Retrofit2Helper;

import bwie.mvpliving.mvp.ServiceApi.ServiceApi;
import retrofit2.Retrofit;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/7.
 */

public class MyBaseQuanmingModel extends BaseModel<ServiceApi> {
    public MyBaseQuanmingModel() {
        if (getApi() == null) {
            Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(MineApp.getmMineApp().getBaseurlquanmin());
            ServiceApi apiDaily = retrofit.create(ServiceApi.class);
            setApi(apiDaily);
        }
    }
}
