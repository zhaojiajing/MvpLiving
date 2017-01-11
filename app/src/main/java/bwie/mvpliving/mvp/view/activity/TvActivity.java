package bwie.mvpliving.mvp.view.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.pick.library.log.MyLog;
import com.pick.library.mvp.MvpActivity;
import com.pick.library.mvp.ibase.IBaseView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import bwie.mvpliving.R;
import bwie.mvpliving.bean.TvBean;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.presenter.MyPresenterTvTitle;
import bwie.mvpliving.mvp.view.fragment.TvAfterFragment;
import bwie.mvpliving.mvp.view.fragment.YanzhiFragment;

public class TvActivity extends MvpActivity<MyPresenterTvTitle> implements Contract.IMyBaseViewList<TvBean> {
    @Bind(R.id.tvtoolbar)
    Toolbar mTvtoolbar;
    @Bind(R.id.tvtabs)
    TabLayout mTvtabs;
    @Bind(R.id.tvappbarlayout)
    AppBarLayout mTvappbarlayout;
    @Bind(R.id.viewpager)
    ViewPager mViewpager;
    List<String> titils = new ArrayList<>();
    List<Fragment> fs = new ArrayList<>();
    private String[] mTypes;

    @Override
    public void getDataListSuccess(List<TvBean> list) {
        for (TvBean tvBean : list) {
            titils.add(tvBean.name);
        }
        //设置tab的title
        for (String titil : titils) {
            mTvtabs.addTab(mTvtabs.newTab().setText(titil));
        }
        //添加fragment并传值,URL中的类型
        for (int i = 0; i < titils.size()-1; i++) {
            TvAfterFragment tvAfterFragment = new TvAfterFragment();
            Bundle bundle=new Bundle();
            bundle.putString("type",mTypes[i]);
            tvAfterFragment.setArguments(bundle);
            fs.add(tvAfterFragment);
        }
        mViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fs.get(position);
            }

            @Override
            public int getCount() {
                return fs.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titils.get(position);
            }
        });
    }

    @Override
    public void getDataListFailed(String errMsg) {
        new MyLog().e("TvActivity请求出错" + errMsg);
    }

    @Override
    protected MyPresenterTvTitle createPresenter(IBaseView view) {
        return new MyPresenterTvTitle(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_tv;
    }

    @Override
    public void initVariables() {
        setStatusColor(this,R.color.colorPrimaryDark);
        mTvtoolbar.setTitle("全民TV");
        mTypes = new String[]{"Flol", "Fbeauty", "Foverwatch", "Fhuwai", "Fheartstone", "Fmobilegame", "Fwebgame", "Ftvgame", "Fwangzhe", "F", "Fdota2", "Fcfpc", "Fdnf", "Fqqfeiche", "Fwar34", "Fnba2k", "Fminecraft", "Ffifa", "Fblizzard", "Fqiuqiu", "Ferciyuan",
                "Fcfpc", "Fjianling", "Fqqfeiche", "Flimingshaji", "Fnba2k", "Fmsg", "Ffifa", "Ffs", "Fwar3", "Fzhuangjiafengbao", "Fwangzhe", "Fstreet"};
        //设置tablelayout的Mode:滑动
        mTvtabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTvtabs.setupWithViewPager(mViewpager);
        fs.add(new YanzhiFragment());


    }

    @Override
    public void loadData() {
        getPresenter().getData();

    }


}
