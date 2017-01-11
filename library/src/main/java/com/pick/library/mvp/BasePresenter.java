package com.pick.library.mvp;


import com.pick.library.mvp.ibase.IBaseModel;
import com.pick.library.mvp.ibase.IBasePresenter;
import com.pick.library.mvp.ibase.IBaseView;

/**
 * 类描述：Presenter模块的基类，持有对应的View模块对象
 * 创建人：zhaojingjing
 * 创建时间：2016/7/6 10:21
 */
public abstract class BasePresenter<M extends IBaseModel, V extends IBaseView>
        implements IBasePresenter {

    private V mView;

    private M mModel;



    public BasePresenter(V v) {
        mView = v;
        mModel = createModel();
    }

    protected abstract M createModel();

    @Override
    public void onDestroy() {
        if(mModel!=null)
            mModel.onDestroy();
    }

    public V getView() {
        return mView;
    }

    public M getModel() {
        return mModel;
    }
}
