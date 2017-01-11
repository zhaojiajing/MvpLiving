package bwie.mvpliving.mvp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.pick.library.imageloader.ImageLoaderManager;
import com.pick.library.log.MyLog;
import com.pick.library.mvp.MvpFragment;
import com.pick.library.mvp.ibase.IBaseView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import java.util.List;
import butterknife.Bind;
import bwie.mvpliving.R;
import bwie.mvpliving.bean.ColumnBean;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.presenter.MyPresenterColumn;
import bwie.mvpliving.mvp.view.activity.ColumnActivityTwo;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColumnFragment extends MvpFragment<MyPresenterColumn> implements Contract.IMyBaseView {
    @Bind(R.id.columnRecyclerView)
    RecyclerView mColumnRecyclerView;
    private CommonAdapter mAdapter;

    @Override
    public void getInitData(Object db) {
        ColumnBean cb = (ColumnBean) db;
        final List<ColumnBean.DataBean> data = cb.data;
        //找到imageView,参数为资源ID
        mAdapter = new CommonAdapter<ColumnBean.DataBean>(getActivity(), R.layout.item_column, data) {

            @Override
            protected void convert(ViewHolder holder, ColumnBean.DataBean dataBean, int position) {
                ImageView img_column = holder.getView(R.id.img_column);//找到imageView,参数为资源ID
                ImageLoaderManager.getinstance().getImageloader(ImageLoaderManager.Type.GLIDE).display(dataBean.thumbnail, img_column);
                holder.setText(R.id.tv1_column, dataBean.description);
                holder.setText(R.id.tv2_column, dataBean.name);
            }
        };
        mColumnRecyclerView.setAdapter(mAdapter);
        mColumnRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Intent intent=new Intent(getActivity(), ColumnActivityTwo.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",data.get(position).id);
                bundle.putString("name",data.get(position).name);
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    @Override
    public void getInitDataFailed(String errormsg) {
        new MyLog().e("Column请求出错" + errormsg);
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
    protected MyPresenterColumn createPresenter(IBaseView view) {
        return new MyPresenterColumn(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_column;
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


}
