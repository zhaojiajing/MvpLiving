package bwie.mvpliving.mvp.view.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pick.library.log.MyLog;
import com.pick.library.mvp.MvpFragment;
import com.pick.library.mvp.ibase.IBaseView;

import java.util.List;

import butterknife.Bind;
import bwie.mvpliving.R;
import bwie.mvpliving.bean.YanZhiBean;
import bwie.mvpliving.mvp.adapter.YanzhiAdapter;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.presenter.MyPresenterYanzhi;

/**
 * A simple {@link Fragment} subclass.
 */
public class YanzhiFragment extends MvpFragment<MyPresenterYanzhi> implements Contract.IMyBaseViewOne<YanZhiBean> {


    @Bind(R.id.yanzhiRecyclerView)
    RecyclerView mYanzhiRecyclerView;

    @Override
    public void getDataSuccess(YanZhiBean yanZhiBean) {
        /**
         * 最大的recyclerView,一个banner,一个recyclerView
         */
        List<YanZhiBean.RoomBean> room = yanZhiBean.room;
     YanzhiAdapter adapter=new YanzhiAdapter(getActivity(),room);
        mYanzhiRecyclerView.setAdapter(adapter);
        mYanzhiRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void getDataFailed(String errMsg) {
        new MyLog().e("请求失败"+errMsg);
    }

    @Override
    protected MyPresenterYanzhi createPresenter(IBaseView view) {
        return new MyPresenterYanzhi(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_yanzhi;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void loadData() {
        getPresenter().getData();

    }

}
