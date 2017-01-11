package com.pick.library.utils;

import android.widget.EditText;

/**
 * 类描述：View控件辅助类
 * 创建人：zhaojingjing
 * 创建时间：2016/8/16 10:00
 */
public class ViewHandler {

    public static void setText(EditText et, CharSequence msg){
        et.setText(msg);
        setSelection(et);
    }

    public static void setSelection(EditText et){
        et.setSelection(et.getText().length());
        et.requestFocus();
    }

}
