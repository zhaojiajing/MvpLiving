package bwie.mvpliving.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.pick.library.imageloader.ImageLoaderManager;
import com.pick.library.log.MyLog;
import com.pick.library.mvp.MvpActivity;
import com.pick.library.mvp.ibase.IBaseView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import butterknife.Bind;
import bwie.mvpliving.R;
import bwie.mvpliving.bean.ColumTwo;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.presenter.MyPresenterColumnTwo;

public class ColumnActivityTwo extends MvpActivity<MyPresenterColumnTwo> implements Contract.IMyBaseView {

    @Bind(R.id.twocolumnRecyclerView)
    RecyclerView mTwocolumnRecyclerView;
    @Bind(R.id.commontoolbar)
    Toolbar mCommontoolbar;
    private String mName;
    private int mId;
    private CommonAdapter mAdapter;


    @Override
    public void getInitData(Object db) {
        ColumTwo ct = (ColumTwo) db;
        final List<ColumTwo.StoriesBean> stories = ct.stories;
        mAdapter = new CommonAdapter<ColumTwo.StoriesBean>(this, R.layout.item_daily, stories) {
            @Override
            protected void convert(ViewHolder holder, ColumTwo.StoriesBean storiesBean, int position) {
                holder.setText(R.id.item_daily_tv, stories.get(position).title);
                ImageLoaderManager.getinstance().getImageloader(ImageLoaderManager.Type.GLIDE).display(stories.get(position).images.get(0), (ImageView) holder.getView(R.id.item_daily_img));
            }
        };
        mTwocolumnRecyclerView.setAdapter(mAdapter);
        mTwocolumnRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
               Intent in= new Intent(ColumnActivityTwo.this, ColumnDetailActivity.class);
                in.putExtra("id", stories.get(position).id);
                startActivity(in);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    @Override
    public void getInitDataFailed(String errormsg) {
        new MyLog().e("请求出错View" + errormsg);
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
    protected MyPresenterColumnTwo createPresenter(IBaseView view) {
        return new MyPresenterColumnTwo(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_column_two;
    }

    @Override
    public void initVariables() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mName = bundle.getString("name");
        mId = bundle.getInt("id");
        new MyLog().e("mName" + mName);
        new MyLog().e("mId" + mId);
    }

    @Override
    public void loadData() {
        setToolbar(mCommontoolbar, mName);
        getPresenter().getColumnTwoData(mId);
    }

}
