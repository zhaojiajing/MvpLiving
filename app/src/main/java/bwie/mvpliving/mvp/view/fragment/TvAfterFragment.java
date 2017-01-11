package bwie.mvpliving.mvp.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.pick.library.imageloader.ImageLoaderManager;
import com.pick.library.log.MyLog;
import com.pick.library.mvp.MvpFragment;
import com.pick.library.mvp.ibase.IBaseView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import butterknife.Bind;
import bwie.mvpliving.R;
import bwie.mvpliving.bean.HeroBean;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.presenter.MyPresenterHero;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvAfterFragment extends MvpFragment<MyPresenterHero> implements Contract.IMyBaseViewOne<HeroBean> {
    @Bind(R.id.tvafterrecycler)
    RecyclerView mTvafterrecycler;
    private String mType;


    @Override
    public void getDataSuccess(HeroBean heroBean) {
        // new MyLog().e("TvAfterFragment请求成功" + heroBean);
        List<HeroBean.DataBean> data = heroBean.data;
        mTvafterrecycler.setAdapter(new CommonAdapter<HeroBean.DataBean>(getActivity(), R.layout.zb_item, data) {
            @Override
            protected void convert(ViewHolder holder, HeroBean.DataBean dataBean, int position) {
                //可以直接用dataBean,也可以使用data.get(position);
                holder.setText(R.id.zb_nick, dataBean.nick);
                holder.setText(R.id.zb_title, dataBean.title);
                ImageLoaderManager.getinstance().getImageloader(ImageLoaderManager.Type.GLIDE).display(dataBean.thumb, (ImageView) holder.getView(R.id.zb_large_image));
                ImageLoaderManager.getinstance().getImageloader(ImageLoaderManager.Type.GLIDE).display(dataBean.avatar, (ImageView) holder.getView(R.id.zb_round_image));
            }
        });
        mTvafterrecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }

    @Override
    public void getDataFailed(String errMsg) {
        new MyLog().e("TvAfterFragment请求失败" + errMsg);
    }

    @Override
    protected MyPresenterHero createPresenter(IBaseView view) {
        return new MyPresenterHero(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_tv_after;
    }

    @Override
    public void initVariables() {
        //获取传过来的type(网址内的类型)
        Bundle bundle = getArguments();
        mType = bundle.getString("type");
    }

    @Override
    public void initViews() {

    }

    @Override
    public void loadData() {
        getPresenter().getTvafterData(mType);
    }

}
