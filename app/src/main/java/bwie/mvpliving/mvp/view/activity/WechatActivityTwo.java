package bwie.mvpliving.mvp.view.activity;

import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.pick.library.mvp.BaseActivity;

import butterknife.Bind;
import bwie.mvpliving.R;

public class WechatActivityTwo extends BaseActivity {
    @Bind(R.id.webViewWeChat)
    WebView mWebViewWeChat;
    @Bind(R.id.commontoolbar)
    Toolbar mCommontoolbar;
    private String mUrl;
    private String mTitle;

    @Override
    public int bindLayout() {
        return R.layout.activity_wechat_two;
    }

    @Override
    public void initVariables() {
        mUrl = getIntent().getStringExtra("url");
        mTitle = getIntent().getStringExtra("title");
    }


    @Override
    public void initViews() {
        initWebseting();
       setToolbar(mCommontoolbar, mTitle);

    }

    @Override
    public void loadData() {
        mWebViewWeChat.loadUrl(mUrl);
    }
    // 设置webView
    private void initWebseting() {
        // 设置网页不跳到其他位置
        mWebViewWeChat.setWebViewClient(new WebViewClient());
        WebSettings settings = mWebViewWeChat.getSettings();
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
