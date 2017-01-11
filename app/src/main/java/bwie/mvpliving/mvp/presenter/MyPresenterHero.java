package bwie.mvpliving.mvp.presenter;

import com.pick.library.mvp.BasePresenter;

import bwie.mvpliving.bean.HeroBean;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.ibase.MyCallBack;
import bwie.mvpliving.mvp.model.MyModelTvHero;
import bwie.mvpliving.mvp.view.fragment.TvAfterFragment;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/8.
 */

public class MyPresenterHero extends BasePresenter<MyModelTvHero, TvAfterFragment> implements Contract.IMyStringPresenter {
    public MyPresenterHero(TvAfterFragment tvAfterFragment) {
        super(tvAfterFragment);
    }



    @Override
    protected MyModelTvHero createModel() {
        return new MyModelTvHero();
    }

    @Override
    public void getTvafterData(String type) {
        getModel().getData(type,new MyCallBack<HeroBean>() {
            @Override
            public void success(HeroBean heroBean) {
                getView().getDataSuccess(heroBean);
            }

            @Override
            public void failed(String errormsg) {
                getView().getDataFailed(errormsg);
            }
        });
    }
}
