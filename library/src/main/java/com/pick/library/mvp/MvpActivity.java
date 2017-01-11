package com.pick.library.mvp;

import com.pick.library.mvp.ibase.IBasePresenter;
import com.pick.library.mvp.ibase.IBaseView;


/**
 * 类描述：MVP架构下的Activity基类
 * 创建人：zhaojingjing
 * 创建时间：2016/7/6 10:27
 */
public abstract class MvpActivity<P extends IBasePresenter> extends BaseActivity implements IBaseView {
    private P mPresenter;

    protected abstract P createPresenter(IBaseView view);
//在MvpActivity中重写了initViews()初始化控件的方法,
    //所以在MainActivity中在重写即是又覆盖了,所以不走createPresenter(this)方法,mPresenter就没有实例化,就报NullPoint
    @Override
    public void initViews() {
        mPresenter = createPresenter(this);
        if(mPresenter==null){
            throw new RuntimeException("presenter must be in createPresenter");
        }
    }

    @Override
    protected void onDestroy() {
        //避免Presenter持有该对象，先销毁Presenter
        if (null != mPresenter) {
            mPresenter.onDestroy();
        }
        mPresenter=null;
        super.onDestroy();
    }

    public P getPresenter() {
        return mPresenter;
    }

}