package com.pick.library.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * 类描述：
 * 创建人：zhaojingjing
 * 创建时间：2016/7/6 11:29
 */
public interface OnItemClickListener<T> {
    void onItemClick(ViewGroup parent, View view, T t, int position);
    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}