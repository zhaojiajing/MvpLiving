package com.pick.library.mvp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.pick.library.mvp.ibase.IActivity;
import com.pick.library.mvp.ibase.IBaseView;
import com.pick.library.utils.AppManager;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.socks.library.KLog;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

import static com.pick.library.utils.AppManager.getAppManager;

/**
 * 类描述：所有子Activity的基类
 * 创建人：zhaojingjing
 * 创建时间：2016/7/6 10:13
 */
public abstract class BaseActivity extends AutoLayoutActivity
        implements IActivity, IBaseView {

    private Dialog mLoadingDialog;
    private Toolbar toolbar;
    private View mContentView;
    private static PermissionListener mListener;

    //由于有些跳转无需参数,所以这里无需抽象方法
    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加activity
        getAppManager().addActivity(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
       // beforeContentView();

        //处理Intent(主要用来获取其中携带的参数)
        if (getIntent() != null) {
            handleIntent(getIntent());
        }

        if (bindLayout() != 0) {
            mContentView = View.inflate(this, bindLayout(), null);
            setContentView(mContentView);

       /*    //使用第三方:设置沉浸式状态栏,位置在setContentView(mContentView)之后,否则报nullPointerException
           if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                StatusBarUtil.setColor(this, Color.parseColor("#35464e"), 0);//夜间模式设为黑色
            }else{
               //其他模式设为绿色,刚开始默认模式为-1,MODE_NIGHT_FOLLOW_SYSTEM,即默认模式和白天模式设为绿色
                StatusBarUtil.setColor(this, Color.parseColor("#43c117"), 0);
            }*/

                ButterKnife.bind(this);
            initVariables();
            initViews();
            mLoadingDialog = getLoadingDialog();
            setDisplayShowTitleEnabled(true);
            loadData();
        } else {
            KLog.e(this + "--->bindLayout() return 0");
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * @param flag 给左上角图标的左边加上一个返回的图标 。对应ActionBar.DISPLAY_HOME_AS_UP
     */
    protected void setDisplayHomeAsUpEnabled(boolean flag) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(flag);
            //actionBar.setHomeAsUpIndicator(R.drawable.back);
        }
    }

    /**
     * 设置是否可以显示title的内容(ActionBar.ToolBar)
     *
     * @param flag
     */
    protected void setDisplayShowTitleEnabled(boolean flag) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(flag);
        }
    }

    protected Dialog getLoadingDialog() {
        return null;
    }

    @Override
    public void showLoading() {
        if (mLoadingDialog != null && !mLoadingDialog.isShowing())
            mLoadingDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing())
            mLoadingDialog.dismiss();
    }

    @Override
    public void beforeContentView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
    //设置透明状态栏,状态栏颜色(给状态栏着色)
    public  static void setStatusColor(Activity activity,int id){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(activity, true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
        // 使用颜色资源
        tintManager.setStatusBarTintResource(id);
    }

    private static void setTranslucentStatus(Activity activity, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    /**
     * 重构findViewById
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T findView(int viewId) {
        return (T) findViewById(viewId);
    }

    /**
     * 如果需要添加fragment 需重写此方法提供FrameLayout的ID
     *
     * @return
     */
    protected int getFragmentContainerId() {
        return 0;
    }

    /**
     * 往activity中添加fragment
     * (我觉得替换)
     *
     * @param fragment
     */
    public void pushFragment(BaseFragment fragment) {
        if (fragment != null && getFragmentContainerId() != 0) {
            getSupportFragmentManager().beginTransaction()
                    .replace(getFragmentContainerId(), fragment)
                    //.addToBackStack(fragment.toString())
                    .commitAllowingStateLoss();
        }
    }

    /**
     * 从回退栈中抛出fragment**************
     */
    public void popFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    /**
     * 针对返回写的
     *
     * @param toolbar
     * @param title
     */
    protected void setToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左上角设置返回图标
        getSupportActionBar().setDisplayShowHomeEnabled(true);//左上角设置图标显示
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void ShowSnackBar(@NonNull View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }

    public void ShowToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 监测按键(返回键)
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        this.toolbar = toolbar;
        super.setSupportActionBar(toolbar);

    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public View getContentView() {
        return mContentView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
        // 返回false允许正常的菜单处理资源，若返回true，则直接在此毁灭它
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public static void requestRuntimePermission(String[] permissions, PermissionListener listener) {
        Activity topActivity = AppManager.getAppManager().currentActivity();
        if (topActivity == null) {
            return;
        }
        mListener = listener;
        List<String> permissionList = new ArrayList<>();
        //遍历需要添加的权限,如果没有同意,就添加到permissionList
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(topActivity, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission);
            }
        }
        if (!permissionList.isEmpty()) {
            //有没同意的
            ActivityCompat.requestPermissions(topActivity, permissionList.toArray(new String[permissionList.size()]), 1);
        } else {
            mListener.onGranted();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                //返回的结果的长度>0
                if (grantResults.length > 0) {
                    List<String> deniedPermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];//权限是否同意的结果
                        String permission = permissions[i];//对应的权限
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
                            deniedPermissions.add(permission);
                        }
                    }
                    if (deniedPermissions.isEmpty()) {
                        mListener.onGranted();
                    } else {
                        mListener.onDenied(deniedPermissions);
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * 不带值跳转
     *
     * @param cls 要跳转的activity
     */
    public void startAct(Class<? extends BaseActivity> cls) {
        startActivity(new Intent(this, cls));
    }

    /**
     * 带值跳转
     *
     * @param cls 要跳转的activity
     */
    public void startAct(Class<? extends BaseActivity> cls, Bundle bundle) {
        startActivity(new Intent(this, cls).putExtras(bundle));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideLoading();
        ButterKnife.unbind(this);
        mContentView = null;
        //写了日夜间模式切换:调recreate()方法,走onDestroy(),所以在此不能将activity finish掉
        // getAppManager().finishActivity(this);
    }
}
