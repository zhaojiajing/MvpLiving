package bwie.mvpliving.mvp.view.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.pick.library.imageloader.ImageLoaderManager;
import com.pick.library.log.MyLog;
import com.pick.library.mvp.MvpFragment;
import com.pick.library.mvp.ibase.IBaseView;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import bwie.mvpliving.R;
import bwie.mvpliving.bean.WechatBean;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.presenter.MyPresenterWeChat;
import bwie.mvpliving.mvp.view.activity.WechatActivityTwo;

/**
 * A simple {@link Fragment} subclass.
 */
public class WechatFragment extends MvpFragment<MyPresenterWeChat> implements Contract.IMyBaseView {
    @Bind(R.id.weChatRecyclerView)
    PullLoadMoreRecyclerView mWeChatRecyclerView;
    /**
     * 此处是自己的集合myNewslist,用于请求到数据后添加数据,用 myNewslist.addAll(wb.newslist);
     * addAll();而不是=,使用=会报错
     */
    private List<WechatBean.NewslistBean> myNewslist=new ArrayList<>();
    private CommonAdapter mAdapter;

    @Override
    public void getInitData(Object db) {
        WechatBean wb = (WechatBean) db;
       myNewslist.addAll(wb.newslist);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void getInitDataFailed(String errormsg) {
        new MyLog().e("请求微信数据错误" + errormsg);
    }

    @Override
    public void getRefreshDataSuccess(Object db) {
        WechatBean wb = (WechatBean) db;
        myNewslist.addAll(wb.newslist);
        mAdapter.notifyDataSetChanged();
        mWeChatRecyclerView.setPullLoadMoreCompleted();
    }

    @Override
    public void getRefreshDataFailed(String errMsg) {
        new MyLog().e("刷新微信数据错误" + errMsg);
    }

    @Override
    public void getLoadMoreDataSuccess(Object db) {

        WechatBean wb = (WechatBean) db;
        myNewslist.addAll(wb.newslist);
        mAdapter.notifyDataSetChanged();
        mWeChatRecyclerView.setPullLoadMoreCompleted();
    }

    @Override
    public void getLoadMoreDataFailed(String errMsg) {
        new MyLog().e("加载微信数据错误" + errMsg);
    }

    @Override
    protected MyPresenterWeChat createPresenter(IBaseView view) {
        return new MyPresenterWeChat(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_wechat;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews() {
        //注意泛型是类里的集合里的泛型
        mAdapter = new CommonAdapter<WechatBean.NewslistBean>(getActivity(), R.layout.item_wechat, myNewslist) {

            @Override
            protected void convert(ViewHolder holder, WechatBean.NewslistBean newslistBean, int position) {
                holder.setText(R.id.tv1_wechat, newslistBean.title);
                holder.setText(R.id.tv2_wechat, newslistBean.description);
                holder.setText(R.id.tv3_wechat, newslistBean.ctime);
                ImageLoaderManager.getinstance().getImageloader(ImageLoaderManager.Type.GLIDE).display(newslistBean.picUrl, (ImageView) holder.getView(R.id.img_wechat));
            }
        };
        mWeChatRecyclerView.setAdapter(mAdapter);
        mWeChatRecyclerView.setLinearLayout();
        mWeChatRecyclerView.setPullRefreshEnable(true);

        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Intent intent = new Intent(getActivity(), WechatActivityTwo.class);
                intent.putExtra("url",myNewslist.get(position).url);
                intent.putExtra("title",myNewslist.get(position).title);
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        //设置监听上拉下拉
        mWeChatRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                getPresenter().getRefreshData();
            }

            @Override
            public void onLoadMore() {
                getPresenter().getLoadMoreData();
            }
        });
    }

    @Override
    public void loadData() {
        getPresenter().getInitData();
    }


}
