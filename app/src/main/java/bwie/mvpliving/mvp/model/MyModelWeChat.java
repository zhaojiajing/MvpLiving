package bwie.mvpliving.mvp.model;

import com.pick.library.net.ICallback;

import bwie.mvpliving.bean.WechatBean;
import bwie.mvpliving.mvp.ibase.IMyBaseModel;
import bwie.mvpliving.mvp.ibase.MyCallBack;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/4.
 */

public class MyModelWeChat extends MyBaseWeChatModel implements IMyBaseModel {


    private int page ;

    @Override
    public void getinitData(final MyCallBack myCallBack) {
       page = 1;
        requestData(myCallBack);
    }

    private void requestData(final MyCallBack myCallBack) {
        deploy(getApi().getWChatData("09691a96d0c41d30215a888632e1b96e", 10, page), new ICallback<WechatBean>() {


            @Override
            public void onCompleted(WechatBean wechatBean) {
                myCallBack.success(wechatBean);
            }

            @Override
            public void onFailed(String errMsg) {
                myCallBack.failed(errMsg);
            }
        });
    }

    @Override
    public void getRefreshData(MyCallBack myCallBack) {
        page = 1;
        requestData(myCallBack);
    }

    @Override
    public void getLoadMoreData(MyCallBack myCallBack) {
        page++;
        requestData(myCallBack);
    }
}
