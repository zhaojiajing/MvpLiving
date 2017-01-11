package bwie.mvpliving.mvp.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.pick.library.mvp.MvpFragment;
import com.pick.library.mvp.ibase.IBaseView;
import com.socks.library.KLog;
import butterknife.Bind;
import butterknife.ButterKnife;
import bwie.mvpliving.R;
import bwie.mvpliving.bean.DailyBean;
import bwie.mvpliving.mvp.adapter.DailyAdapter;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.presenter.MyPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyFragment extends MvpFragment<MyPresenter> implements Contract.IMyBaseView {



    @Bind(R.id.dailyRecyclerView)
    RecyclerView mDailyRecyclerView;

    @Override
    public int bindLayout() {
        return R.layout.fragment_daily;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void loadData() {
        getPresenter().getInitData();
    }


    @Override
    protected MyPresenter createPresenter(IBaseView view) {
        return new MyPresenter(this);
    }

    @Override
    public void getInitData(Object db) {

        mDailyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DailyAdapter adapter=new DailyAdapter(getActivity(),(DailyBean) db);
        mDailyRecyclerView.setAdapter(adapter);
    }

    @Override
    public void getInitDataFailed(String errormsg) {
        KLog.e("请求出错"+errormsg);
    }

    @Override
    public void getRefreshDataSuccess(Object db) {

    }

    @Override
    public void getRefreshDataFailed(String errMsg) {

    }

    @Override
    public void getLoadMoreDataSuccess(Object db) {

    }

    @Override
    public void getLoadMoreDataFailed(String errMsg) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
