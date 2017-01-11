package bwie.mvpliving.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pick.library.adapter.BaseViewHolder;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import bwie.mvpliving.R;
import bwie.mvpliving.bean.YanZhiBean;
import bwie.mvpliving.utils.GlideImageLoader;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/7.
 */
public class YanzhiAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final int BANNER = 0;
    private static final int RECYCLERVIEW = 1;
    private final Context mContext;
    private final List<YanZhiBean.RoomBean> mRoom;
    private final List<YanZhiBean.RoomBean> mRoomList=new ArrayList<>();

    public YanzhiAdapter(Context context, List<YanZhiBean.RoomBean> room) {
        mContext = context;
        mRoom = room;//整个的集合
        mRoomList.addAll(room);//除去banner的集合(也就是下面的整个recyclerView)
        mRoomList.remove(0);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER;
        }
        else {
            return RECYCLERVIEW;
        }


    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_daily0, parent, false));
        } else if (viewType == RECYCLERVIEW) {
            //wrap_content
            return new MyViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.zb_recyclerview, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        /*if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).setData(mContext, mRoom.get(position));
        } else if (holder instanceof MyViewHolder2) {
            //((MyViewHolder2) holder).setData(mContext, mRoom.get(position));这样写只有第二条
            for (int i = 1; i < mRoom.size(); i++) {
                YanZhiBean.RoomBean roomBean = mRoom.get(i);
                 ((MyViewHolder2) holder).setData(mContext, roomBean);//这样写只有最后一条
            }
        }*/
           // holder.setData(mContext,mRoomList.get(position));
            holder.setData(mContext,mRoom.get(position));
    }

    @Override
    public int getItemCount() {
        return mRoom.size();
    }//22条

    class MyViewHolder extends BaseViewHolder<YanZhiBean.RoomBean> {

        private final Banner mBanner;

        public MyViewHolder(View itemView) {
            super(itemView);
            mBanner = (Banner) itemView.findViewById(R.id.banner);
        }


        @Override
        public void setData(Context context, YanZhiBean.RoomBean roomBean) {
            List<String> titles = new ArrayList<>();
            List<String> imags = new ArrayList<>();
            List<YanZhiBean.RoomBean.ListBean> nrlist = roomBean.list;
            for (YanZhiBean.RoomBean.ListBean listBean : nrlist) {
                titles.add(listBean.title);
                imags.add(listBean.thumb);
            }
            mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
            mBanner.setBannerTitles(titles);//设置title
            mBanner.setImages(imags).setImageLoader(new GlideImageLoader()).start();//设置图片//自己写的专门对banner的GlideImageLoader
        }
    }

    private class MyViewHolder2 extends BaseViewHolder<YanZhiBean.RoomBean> {

        private final RecyclerView mYanzhidarv;

        public MyViewHolder2(View itemView) {
            super(itemView);
            //(gridView)多条目,内包含:header和item即textView和imageview
        mYanzhidarv = (RecyclerView) itemView.findViewById(R.id.zb_recycler);

        }


        @Override
        public void setData(Context context, final YanZhiBean.RoomBean roomBean) {
            GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,2);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return position==0?2:1;//判断类型
                }
            });
            ZHiboAdapter adapter = new ZHiboAdapter(mContext,roomBean);
            mYanzhidarv.setLayoutManager(gridLayoutManager);
            mYanzhidarv.setAdapter(adapter);

        }
    }


}
