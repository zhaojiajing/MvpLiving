package bwie.mvpliving.mvp.ServiceApi;

import java.util.List;

import bwie.mvpliving.bean.ColumTwo;
import bwie.mvpliving.bean.ColumnBean;
import bwie.mvpliving.bean.ColumnDetail;
import bwie.mvpliving.bean.DailyBean;
import bwie.mvpliving.bean.HeroBean;
import bwie.mvpliving.bean.TvBean;
import bwie.mvpliving.bean.WechatBean;
import bwie.mvpliving.bean.YanZhiBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/3.
 */

public interface ServiceApi {
    /**
     * 最新日报
     */
    @GET("news/latest")
    Observable<DailyBean> getDailyData();

    /**
     * 专栏
     */
    @GET("sections")
    Observable<ColumnBean> getColumnData();

    /**
     * 微信精选列表
     * http://api.tianapi.com/wxnew/?key=09691a96d0c41d30215a888632e1b96e&num=10&page=1
     */
    @GET("wxnew")
    Observable<WechatBean> getWChatData(@Query("key") String key, @Query("num") int num, @Query("page") int page);

    /**
     * 专栏详情1
     * http://news-at.zhihu.com/api/4/section/2   专栏详情id2
     */
    @GET("section/{id}")
    Observable<ColumTwo> getColumnTwoData(@Path("id") int id);

    /**
     * 专栏详情2
     * http://news-at.zhihu.com/api/4/news/9122609   专栏详情id9122609
     */
    @GET("news/{id}")
    Observable<ColumnDetail> getColumnDetailData(@Path("id") int id);
    /**
     * 全民TV的tableLayout
     * http://www.quanmin.tv/json/app/index/category/info-android.json?v=2.2.4&os=1&ver=4
     */
    @GET("json/app/index/category/info-android.json?v=2.2.4&os=1&ver=4")
    Observable<List<TvBean>> getTvData();
    /**
     *  颜值
     * http://www.quanmin.tv/json/app/index/recommend/list-android.json?11241742&v=2.2.4&os=1&ver=4
     */
    @GET("json/app/index/recommend/list-android.json?11241742&v=2.2.4&os=1&ver=4")
    Observable<YanZhiBean> getYanZhiData();
    /**
     * 英雄联盟
     * http://www.quanmin.tv/json%2Fcategories%2  Fbeauty %2Flist.json?11211639&os=1&v=2.2.4&os=1&ver=4
     */
    @GET("json%2Fcategories%2{type}%2Flist.json?11211639&os=1&v=2.2.4&os=1&ver=4")
    Observable<HeroBean> getHeroData(@Path("type") String type);
}
