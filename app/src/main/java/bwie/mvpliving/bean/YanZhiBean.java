package bwie.mvpliving.bean;

import com.pick.library.net.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/7.
 */

public class YanZhiBean extends ResponseBean{
    public List<RoomBean> room;
    public List<?> ad;

    public static class RoomBean {
        /**
         * id : 0
         * name : 精彩推荐
         * is_default : 1
         * icon :
         * slug :
         * category_more :
         * type : 1
         * screen : 0
         * list : [{"beauty_cover":"","no":2252160,"first_play_at":"1970-01-01 08:00:00","category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/2252160-1483749623-600.jpg?imageView2/2/w/390/","last_play_at":"1970-01-01 08:00:00","screen":0,"video":"http://thumb.quanmin.tv/2252160.mp4?t=1483749600","title":"最强盲僧个人秀 让你目瞪口呆 受益匪浅","recommend_image":"http://image.quanmin.tv/1019ebf1d0b17ed6c11f06f5e2a6be5ejpg","is_shield":false,"nick":"驯良Zz","uid":2252160,"view":"117021","category_id":1,"slug":"xunliang","love_cover":"","level":0,"like":0,"weight":0,"starlight":0,"check":true,"avatar":"http://image.quanmin.tv/avatar/d287fdda97154434b76d62774fff2f2bpng?imageView2/2/w/300/","follow":34945,"play_count":0,"play_true":0,"fans":0,"max_view":0,"default_image":"","last_end_at":"1970-01-01 08:00:00","position":"","app_shuffling_image":"http://image.quanmin.tv/b61bd53b497a8412674de9a9851e3711jpg","create_at":"2017-01-07 08:05:36","last_thumb":"2252160-1483517132-501.jpg","landscape":1,"category_slug":"lol","play_status":true,"anniversary":0,"status":2,"coin":0,"link":"http://www.quanmin.tv/v/xunliang","stream":"","icontext":""},{"beauty_cover":"","no":7353184,"first_play_at":"1970-01-01 08:00:00","category_name":"全民星秀","thumb":"http://snap.quanmin.tv/7353184-1483749652-474.jpg?imageView2/2/w/390/","last_play_at":"1970-01-01 08:00:00","screen":0,"video":"http://thumb.quanmin.tv/7353184.mp4?t=1483749600","title":"好像天又快快凉了\u2026\u2026","recommend_image":"","is_shield":false,"nick":"TV丶晶莹","uid":7353184,"view":"3122","category_id":4,"slug":"","love_cover":"","level":0,"like":0,"weight":0,"starlight":0,"check":true,"avatar":"http://image.quanmin.tv/avatar/85dbffa4137bdd594d5dfa53e0e9810djpg?imageView2/2/w/300/","follow":3179,"play_count":0,"play_true":0,"fans":0,"max_view":0,"default_image":"","last_end_at":"1970-01-01 08:00:00","position":"","create_at":"2017-01-07 06:26:04","last_thumb":"7353184-1483546001-465.jpg","landscape":1,"category_slug":"beauty","play_status":true,"anniversary":0,"status":2,"coin":0,"link":"http://www.quanmin.tv/v/7353184","stream":"","icontext":""},{"beauty_cover":"","no":7695987,"first_play_at":"1970-01-01 08:00:00","category_name":"王者荣耀","thumb":"http://snap.quanmin.tv/7695987-1483749602-795.jpg?imageView2/2/w/390/","last_play_at":"1970-01-01 08:00:00","screen":0,"video":"http://thumb.quanmin.tv/7695987.mp4?t=1483749600","title":"鳗鱼：中午抽奖送限时皮肤.福利鱼","recommend_image":"","is_shield":false,"nick":"暖暖的鳗鱼宝宝","uid":7695987,"view":"9149","category_id":17,"slug":"","love_cover":"","level":0,"like":0,"weight":0,"starlight":0,"check":true,"avatar":"http://image.quanmin.tv/avatar/94fcfb43a7d2dacbbe1bda8650cdf9dd?imageView2/2/w/300/","follow":1522,"play_count":0,"play_true":0,"fans":0,"max_view":0,"default_image":"","last_end_at":"1970-01-01 08:00:00","position":"","create_at":"2017-01-07 07:31:15","last_thumb":"7695987-1483547103-627.jpg","landscape":1,"category_slug":"wangzhe","play_status":true,"anniversary":0,"status":2,"coin":0,"link":"http://www.quanmin.tv/v/7695987","stream":"","icontext":""},{"beauty_cover":"","no":3093842,"first_play_at":"1970-01-01 08:00:00","category_name":"炉石传说","thumb":"http://snap.quanmin.tv/3093842-1483749602-52.jpg?imageView2/2/w/390/","last_play_at":"1970-01-01 08:00:00","screen":0,"video":"http://thumb.quanmin.tv/3093842.mp4?t=1483749600","title":"认真严肃的清水 搞笑我是认真的","recommend_image":"","is_shield":false,"nick":"全民TV丶清水","uid":3093842,"view":"1316","category_id":3,"slug":"","love_cover":"","level":0,"like":0,"weight":0,"starlight":0,"check":true,"avatar":"http://image.quanmin.tv/avatar/a4f17a5f4302d1ff65523db2df771856png?imageView2/2/w/300/","follow":400,"play_count":0,"play_true":0,"fans":0,"max_view":0,"default_image":"","last_end_at":"1970-01-01 08:00:00","position":"","create_at":"2017-01-07 07:18:23","last_thumb":"3093842-1482812727-298.jpg","landscape":1,"category_slug":"heartstone","play_status":true,"anniversary":0,"status":2,"coin":0,"link":"http://www.quanmin.tv/v/3093842","stream":"","icontext":""},{"beauty_cover":"","no":1704968,"first_play_at":"1970-01-01 08:00:00","category_name":"全民户外","thumb":"http://snap.quanmin.tv/1704968-1483692722-659.jpg?imageView2/2/w/390/","last_play_at":"1970-01-01 08:00:00","screen":0,"video":"http://thumb.quanmin.tv/1704968.mp4?t=1483692600","title":"上课啦上课啦，还在感冒。","recommend_image":"","is_shield":false,"nick":"戴牙套的小猫","uid":1704968,"view":"6340","category_id":13,"slug":"crazy","love_cover":"","level":0,"like":0,"weight":0,"starlight":0,"check":true,"avatar":"http://image.quanmin.tv/avatar/57bfa03efbd1bbee4d3f7780de04b19bjpg?imageView2/2/w/300/","follow":8108,"play_count":0,"play_true":0,"fans":0,"max_view":0,"default_image":"","last_end_at":"1970-01-01 08:00:00","position":"","create_at":"2017-01-07 08:07:56","last_thumb":"1704968-1483523907-54.jpg","landscape":1,"category_slug":"huwai","play_status":true,"anniversary":0,"status":2,"coin":0,"link":"http://www.quanmin.tv/v/crazy","stream":"","icontext":""},{"beauty_cover":"","no":313,"first_play_at":"1970-01-01 08:00:00","category_name":"英雄联盟","thumb":"http://snap.quanmin.tv/313-1483599166-985.jpg?imageView2/2/w/390/","last_play_at":"1970-01-01 08:00:00","screen":0,"video":"http://thumb.quanmin.tv/313.mp4?t=1483599000","title":"失眠通宵好难受~~~~~~~~~~~~~","recommend_image":"http://image.quanmin.tv/33bae0df3a7b962dd9700faec959cd0ajpg","is_shield":false,"nick":"小猪是超级大帅B","uid":313,"view":"172299","category_id":1,"slug":"","love_cover":"","level":0,"like":0,"weight":0,"starlight":0,"check":true,"avatar":"http://image.quanmin.tv/avatar/84352ff55f1c53b636312e3281734125png?imageView2/2/w/300/","follow":164449,"play_count":0,"play_true":0,"fans":0,"max_view":0,"default_image":"","last_end_at":"1970-01-01 08:00:00","position":"","app_shuffling_image":"http://image.quanmin.tv/35d70135be48dea41d37b835f7c6fdb6jpg","create_at":"2017-01-07 04:55:26","last_thumb":"313-1483428363-587.jpg","landscape":1,"category_slug":"lol","play_status":true,"anniversary":0,"status":2,"coin":0,"link":"http://www.quanmin.tv/v/313","stream":"","icontext":""}]
         */

        public int id;
        public String name;
        public int is_default;
        public String icon;
        public String slug;
        public String category_more;
        public int type;
        public int screen;
        public List<ListBean> list;

        public static class ListBean {
            /**
             * beauty_cover :
             * no : 2252160
             * first_play_at : 1970-01-01 08:00:00
             * category_name : 英雄联盟
             * thumb : http://snap.quanmin.tv/2252160-1483749623-600.jpg?imageView2/2/w/390/
             * last_play_at : 1970-01-01 08:00:00
             * screen : 0
             * video : http://thumb.quanmin.tv/2252160.mp4?t=1483749600
             * title : 最强盲僧个人秀 让你目瞪口呆 受益匪浅
             * recommend_image : http://image.quanmin.tv/1019ebf1d0b17ed6c11f06f5e2a6be5ejpg
             * is_shield : false
             * nick : 驯良Zz
             * uid : 2252160
             * view : 117021
             * category_id : 1
             * slug : xunliang
             * love_cover :
             * level : 0
             * like : 0
             * weight : 0
             * starlight : 0
             * check : true
             * avatar : http://image.quanmin.tv/avatar/d287fdda97154434b76d62774fff2f2bpng?imageView2/2/w/300/
             * follow : 34945
             * play_count : 0
             * play_true : 0
             * fans : 0
             * max_view : 0
             * default_image :
             * last_end_at : 1970-01-01 08:00:00
             * position :
             * app_shuffling_image : http://image.quanmin.tv/b61bd53b497a8412674de9a9851e3711jpg
             * create_at : 2017-01-07 08:05:36
             * last_thumb : 2252160-1483517132-501.jpg
             * landscape : 1
             * category_slug : lol
             * play_status : true
             * anniversary : 0
             * status : 2
             * coin : 0
             * link : http://www.quanmin.tv/v/xunliang
             * stream :
             * icontext :
             */

            public String beauty_cover;
            public int no;
            public String first_play_at;
            public String category_name;
            public String thumb;
            public String last_play_at;
            public int screen;
            public String video;
            public String title;
            public String recommend_image;
            public boolean is_shield;
            public String nick;
            public int uid;
            public String view;
            public int category_id;
            public String slug;
            public String love_cover;
            public int level;
            public int like;
            public int weight;
            public int starlight;
            public boolean check;
            public String avatar;
            public int follow;
            public int play_count;
            public int play_true;
            public int fans;
            public int max_view;
            public String default_image;
            public String last_end_at;
            public String position;
            public String app_shuffling_image;
            public String create_at;
            public String last_thumb;
            public int landscape;
            public String category_slug;
            public boolean play_status;
            public int anniversary;
            public int status;
            public int coin;
            public String link;
            public String stream;
            public String icontext;

            @Override
            public String toString() {
                return "ListBean{" +
                        "beauty_cover='" + beauty_cover + '\'' +
                        ", no=" + no +
                        ", first_play_at='" + first_play_at + '\'' +
                        ", category_name='" + category_name + '\'' +
                        ", thumb='" + thumb + '\'' +
                        ", last_play_at='" + last_play_at + '\'' +
                        ", screen=" + screen +
                        ", video='" + video + '\'' +
                        ", title='" + title + '\'' +
                        ", recommend_image='" + recommend_image + '\'' +
                        ", is_shield=" + is_shield +
                        ", nick='" + nick + '\'' +
                        ", uid=" + uid +
                        ", view='" + view + '\'' +
                        ", category_id=" + category_id +
                        ", slug='" + slug + '\'' +
                        ", love_cover='" + love_cover + '\'' +
                        ", level=" + level +
                        ", like=" + like +
                        ", weight=" + weight +
                        ", starlight=" + starlight +
                        ", check=" + check +
                        ", avatar='" + avatar + '\'' +
                        ", follow=" + follow +
                        ", play_count=" + play_count +
                        ", play_true=" + play_true +
                        ", fans=" + fans +
                        ", max_view=" + max_view +
                        ", default_image='" + default_image + '\'' +
                        ", last_end_at='" + last_end_at + '\'' +
                        ", position='" + position + '\'' +
                        ", app_shuffling_image='" + app_shuffling_image + '\'' +
                        ", create_at='" + create_at + '\'' +
                        ", last_thumb='" + last_thumb + '\'' +
                        ", landscape=" + landscape +
                        ", category_slug='" + category_slug + '\'' +
                        ", play_status=" + play_status +
                        ", anniversary=" + anniversary +
                        ", status=" + status +
                        ", coin=" + coin +
                        ", link='" + link + '\'' +
                        ", stream='" + stream + '\'' +
                        ", icontext='" + icontext + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "RoomBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", is_default=" + is_default +
                    ", icon='" + icon + '\'' +
                    ", slug='" + slug + '\'' +
                    ", category_more='" + category_more + '\'' +
                    ", type=" + type +
                    ", screen=" + screen +
                    ", list=" + list +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "YanZhiBean{" +
                "room=" + room +
                ", ad=" + ad +
                '}';
    }
}
