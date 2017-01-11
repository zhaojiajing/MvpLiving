package com.pick.library.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zjj on 2016/11/15.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder{
//public static  final String PREPICURL="http://image1.suning.cn";
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    //写抽象方法----必须是抽象类
    public abstract void setData(Context context, T t);
}
