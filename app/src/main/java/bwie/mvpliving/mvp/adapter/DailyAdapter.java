package bwie.mvpliving.mvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pick.library.imageloader.ImageLoaderManager;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;

import bwie.mvpliving.R;
import bwie.mvpliving.bean.DailyBean;
import bwie.mvpliving.mvp.view.activity.ColumnDetailActivity;
import bwie.mvpliving.utils.GlideImageLoader;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/3.
 */
public class DailyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private final DailyBean mDb;
    private final int VP = 0;
    private final int TV = 1;

    public DailyAdapter(Context context, DailyBean db) {
        mContext = context;
        mDb = db;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VP) {
            return new MyViewHolder1(LayoutInflater.from(mContext).inflate(R.layout.item_daily0, parent, false));
        } else if (viewType == TV) {
            return new MyViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.item_daily1, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ArrayList<String> imglist = new ArrayList<>();
        ArrayList<String> titlelist = new ArrayList<>();
        if (holder instanceof MyViewHolder1) {
            for (int i = 0; i < mDb.top_stories.size(); i++) {
                imglist.add(mDb.top_stories.get(i).image);
                titlelist.add(mDb.top_stories.get(i).title);
            }
            ((MyViewHolder1) holder).mMContentBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            ((MyViewHolder1) holder).mMContentBanner.setBannerTitles(titlelist);
            ((MyViewHolder1) holder).mMContentBanner.setBannerAnimation(Transformer.ForegroundToBackground);
            ((MyViewHolder1) holder).mMContentBanner.setImages(imglist).setImageLoader(new GlideImageLoader()).start();

            ((MyViewHolder1) holder).mMContentBanner.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    mContext.startActivity(new Intent(mContext, ColumnDetailActivity.class).putExtra("id", mDb.top_stories.get(position-1).id));

                }
            });
        } else if (holder instanceof MyViewHolder2) {

            CommonAdapter<DailyBean.StoriesBean> adapter = new CommonAdapter<DailyBean.StoriesBean>(mContext, R.layout.item_daily, mDb.stories) {
                @Override
                protected void convert(ViewHolder holder, DailyBean.StoriesBean storiesBean, int position) {
                    holder.setText(R.id.item_daily_tv, storiesBean.title);
                    ImageView img = holder.getView(R.id.item_daily_img);
                    ImageLoaderManager.getinstance().getImageloader().display(storiesBean.images.get(0), img);
                }
            };

            ((MyViewHolder2) holder).mItem_daily_recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            ((MyViewHolder2) holder).mItem_daily_recyclerView.setAdapter(adapter);
            adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                    mContext.startActivity(new Intent(mContext, ColumnDetailActivity.class).putExtra("id", mDb.stories.get(position).id));

                }

                @Override
                public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VP;
        } else {
            return TV;
        }

    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {

        private final Banner mMContentBanner;

        public MyViewHolder1(View itemView) {
            super(itemView);
            mMContentBanner = (Banner) itemView.findViewById(R.id.banner);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {
        private final RecyclerView mItem_daily_recyclerView;

        public MyViewHolder2(View itemView) {
            super(itemView);
            mItem_daily_recyclerView = (RecyclerView) itemView.findViewById(R.id.item_daily_recyclerView);
        }
    }

}
