package bwie.mvpliving.mvp.model;

import com.pick.library.MineApp;
import com.pick.library.mvp.BaseModel;
import com.pick.library.net.Retrofit2Helper;

import bwie.mvpliving.mvp.ServiceApi.ServiceApi;
import retrofit2.Retrofit;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/3.
 */

public class MyBaseModel extends BaseModel<ServiceApi> {


    /**
     * 写个构造方法
     * 需要写一个Application继承类库的application,重写oncreate()调用父类的方法(即surper())
     */
    public MyBaseModel() {
        if(getApi()==null){
          Retrofit retrofit = Retrofit2Helper.getInstance().getRetrofit(MineApp.getmMineApp().getBaseurl());
            ServiceApi apiDaily = retrofit.create(ServiceApi.class);
            setApi(apiDaily);
        }
    }




}
