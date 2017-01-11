package bwie.mvpliving.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pick.library.adapter.BaseViewHolder;
import com.pick.library.imageloader.ImageLoaderManager;

import bwie.mvpliving.R;
import bwie.mvpliving.bean.YanZhiBean;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/7.
 */
public class ZHiboAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final int FTEXT = 0;
    private static final int FRVITEM = 1;
    private final Context mContext;
    private final YanZhiBean.RoomBean mRoomBean;

    public ZHiboAdapter(Context context, YanZhiBean.RoomBean roomBean) {
        mContext = context;
        mRoomBean = roomBean;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return FTEXT;
        } else {
            return FRVITEM;
        }

    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == FTEXT) {
            // 记住new
            return new ZHiBoHeaderViewHolder(LayoutInflater.from(mContext).inflate(R.layout.zb_header, parent, false));
        } else if (viewType == FRVITEM) {
            return new ZhiBoRvViewHolder(LayoutInflater.from(mContext).inflate(R.layout.zb_item, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (position == 0)
            holder.setData(mContext, mRoomBean);
        else
            holder.setData(mContext, mRoomBean.list.get(position - 1));//因为position是从1开始的
    }


    @Override
    public int getItemCount() {
        return mRoomBean.list.size() + 1;
    }
}

class ZHiBoHeaderViewHolder extends BaseViewHolder<YanZhiBean.RoomBean> {

    private final TextView mCategory_name;

    public ZHiBoHeaderViewHolder(View itemView) {
        super(itemView);
        mCategory_name = (TextView) itemView.findViewById(R.id.category_name);

    }

    @Override
    public void setData(Context context, YanZhiBean.RoomBean roomBean) {
        mCategory_name.setText(roomBean.name);

    }
}

class ZhiBoRvViewHolder extends BaseViewHolder<YanZhiBean.RoomBean.ListBean> {
    private final ImageView mZb_large_image;
    private final TextView mZb_nick;
    private final TextView mZb_title;
    private final ImageView mZb_round_image;

    public ZhiBoRvViewHolder(View itemView) {
        super(itemView);
        mZb_large_image = (ImageView) itemView.findViewById(R.id.zb_large_image);
        mZb_nick = (TextView) itemView.findViewById(R.id.zb_nick);
        mZb_title = (TextView) itemView.findViewById(R.id.zb_title);
        mZb_round_image = (ImageView) itemView.findViewById(R.id.zb_round_image);
    }

    @Override
    public void setData(Context context, YanZhiBean.RoomBean.ListBean listBean) {
        mZb_nick.setText(listBean.nick);
        mZb_title.setText(listBean.title);
        ImageLoaderManager.getinstance().getImageloader(ImageLoaderManager.Type.GLIDE).display(listBean.thumb, mZb_large_image);
        ImageLoaderManager.getinstance().getImageloader(ImageLoaderManager.Type.GLIDE).display(listBean.avatar, mZb_round_image);
    }

}
