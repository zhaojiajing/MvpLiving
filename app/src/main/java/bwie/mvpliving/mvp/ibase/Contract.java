package bwie.mvpliving.mvp.ibase;

import com.pick.library.mvp.ibase.IBasePresenter;
import com.pick.library.mvp.ibase.IBaseView;
import com.pick.library.net.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/3.
 */

public class Contract {
    public interface IMyBasePresenter extends IBasePresenter {
        void getInitData();

        void getRefreshData();

        void getLoadMoreData();
    }

    public interface IMyBaseView<T> extends IBaseView {
        void getInitData(T t);

        void getInitDataFailed(String errormsg);

        void getRefreshDataSuccess(T t);

        void getRefreshDataFailed(String errMsg);

        void getLoadMoreDataSuccess(T t);

        void getLoadMoreDataFailed(String errMsg);
    }


    public interface IMyColumnTwoPresenter extends IBasePresenter {
        void getColumnTwoData(int id);
    }
    public interface IMyStringPresenter extends IBasePresenter {
        void getTvafterData(String type);
    }
    public interface IMyBasePresenterOne extends IBasePresenter {
        void getData();
    }

    public interface IMyBaseViewList<T extends ResponseBean> extends IBaseView {
        void getDataListSuccess(List<T> list);
        void getDataListFailed(String errMsg);
    }


    public interface IMyBaseViewOne<T> extends IBaseView {
        void getDataSuccess(T t);

        void getDataFailed(String errMsg);
    }
}
