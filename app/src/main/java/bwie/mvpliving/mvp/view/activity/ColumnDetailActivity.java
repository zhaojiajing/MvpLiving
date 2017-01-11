package bwie.mvpliving.mvp.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.pick.library.imageloader.ImageLoaderManager;
import com.pick.library.log.MyLog;
import com.pick.library.mvp.MvpActivity;
import com.pick.library.mvp.ibase.IBaseView;

import butterknife.Bind;
import bwie.mvpliving.R;
import bwie.mvpliving.bean.ColumnDetail;
import bwie.mvpliving.mvp.ibase.Contract;
import bwie.mvpliving.mvp.presenter.MypresenterColumnDetail;

public class ColumnDetailActivity extends MvpActivity<MypresenterColumnDetail> implements Contract.IMyBaseViewOne<ColumnDetail> {


    @Bind(R.id.detail_bar_image)
    ImageView mDetailBarImage;
    @Bind(R.id.detail_bar_copyright)
    TextView mDetailBarCopyright;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.app_bar)
    AppBarLayout mAppBar;
    @Bind(R.id.fab)
    FloatingActionButton mFab;
    @Bind(R.id.wv_detail_content)
    WebView mWvDetailContent;
    @Bind(R.id.nsv_scroller)
    NestedScrollView mNsvScroller;
    private int mId;

    @Override
    public void getDataSuccess(ColumnDetail columnDetail) {
        ImageLoaderManager.getinstance().getImageloader(ImageLoaderManager.Type.GLIDE).display(columnDetail.image, mDetailBarImage);
        mToolbar.setTitleTextColor(Color.WHITE);
        setToolbar(mToolbar, columnDetail.title);
        mWvDetailContent.loadUrl(columnDetail.share_url);
    }

    @Override
    public void getDataFailed(String errMsg) {
        new MyLog().e(errMsg);
    }

    @Override
    protected MypresenterColumnDetail createPresenter(IBaseView view) {
        return new MypresenterColumnDetail(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_column_detail;
    }

    @Override
    public void initVariables() {
        Intent intent = getIntent();
        mId = intent.getIntExtra("id", 0);

    }

    @Override
    public void loadData() {
        getPresenter().getColumnTwoData(mId);
    }
    // 设置webView
    private void initWebseting() {
        // 设置网页不跳到其他位置
        mWvDetailContent.setWebViewClient(new WebViewClient());
        WebSettings settings = mWvDetailContent.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 设置识别jsp
        settings.setJavaScriptEnabled(true);
        // 默认加载缓存，如果缓存过期，就加载网络
        // LOAD_CACHE_ELSE_NETWORK 设置默认缓冲 即便是缓冲过期 也使用缓冲，只有缓冲消失 使用网络
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        // 是否显示缩放按钮
        settings.setBuiltInZoomControls(true);
        // 设置默认缩放比列
        settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
    }
}
