package bwie.mvpliving.mvp.view.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.pick.library.mvp.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import bwie.mvpliving.R;
import bwie.mvpliving.mvp.view.fragment.ColumnFragment;
import bwie.mvpliving.mvp.view.fragment.DailyFragment;
import bwie.mvpliving.mvp.view.fragment.HotFragment;
import bwie.mvpliving.mvp.view.fragment.WechatFragment;
import static bwie.mvpliving.R.id.fab;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.nav_view)
    NavigationView mNavView;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.tabs)
    TabLayout mTabs;
    @Bind(fab)
    FloatingActionButton mFab;
    @Bind(R.id.viewpager)
    ViewPager mViewpager;
    @Bind(R.id.appbarlayout)
    AppBarLayout mAppbarlayout;
    private String[] tabs;
    private List<Fragment> fs;

    @Override
    public int bindLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initVariables() {

        tabs = new String[]{"日报", "专栏", "微信", "热门"};
        fs = new ArrayList<>();
        fs.add(new DailyFragment());
        fs.add(new ColumnFragment());
        fs.add(new WechatFragment());
        fs.add(new HotFragment());

    }

    @Override
    public void initViews() {
        //设置沉浸式状态栏,并给状态栏着色
        setStatusColor(this, R.color.colorPrimaryDark);

        //mToolbar
        setToolbar(mToolbar, "首页");
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.day:
                        //一直是白天
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
                        recreate();
                        break;
                    case R.id.night:
                        //一直是夜间
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
                        recreate();
                        break;
                    default:
                        break;
                }

                return true;
            }
        });


        //Navigation
        mNavView.setNavigationItemSelectedListener(this);

        //DrawerLayout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        mDrawerLayout.addDrawerListener(toggle);

        //tablayout
        for (int i = 0; i < tabs.length; i++) {
            mTabs.addTab(mTabs.newTab().setText(tabs[i]));
        }

        //是tablelayout与ViewPager联系起来
        mTabs.setupWithViewPager(mViewpager);
        //Viewpager
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
                return tabs[position];
            }
        });

    }

    // mToolbar.inflateMenu(R.menu.fragment_main_menu);
//  与方法效果一样,bubu 不写下面的方法就不出来
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fragment_main_menu, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_tv:
                startAct(TvActivity.class);
                break;
        }
        item.setChecked(true);//点击了把它设为选中状态
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void loadData() {

    }

}
