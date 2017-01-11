package bwie.mvpliving.mvp.ibase;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/6.
 */

public interface MyCallBackList<T> {
    void success (List<T> list);
    void failed(String errMsg);
}
