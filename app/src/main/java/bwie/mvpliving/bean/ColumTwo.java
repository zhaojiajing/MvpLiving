package bwie.mvpliving.bean;

import com.pick.library.net.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/4.
 */

public class ColumTwo extends ResponseBean{
    /**
     * timestamp : 1481880360
     * stories : [{"images":["http://pic1.zhimg.com/a06ee9626b45b48383ecd0fdc121bbbc.jpg"],"date":"20170104","display_date":"1 月 4 日","id":9122609,"title":"知乎好问题 · 有哪些好看又好玩的装置作品？"},{"images":["http://pic2.zhimg.com/2bac46074820ba4e8ede4e849109ea69.jpg"],"date":"20170103","display_date":"1 月 3 日","id":9119126,"title":"知乎好问题 · 为什么接纳自己是一件很重要的事？"},{"images":["http://pic2.zhimg.com/31aa4ce47a0071dbe644033d1593ea35.jpg"],"date":"20170102","display_date":"1 月 2 日","id":9116662,"title":"知乎好问题 · 思维和语言的关系是什么？"},{"images":["http://pic3.zhimg.com/1e8c5dfd20a6e3a3f91e5c06a739e03a.jpg"],"date":"20170101","display_date":"1 月 1 日","id":9114251,"title":"知乎好问题 · 除旧换新的方式有哪些讲究？"},{"images":["http://pic2.zhimg.com/970e003b6fc5036ae9e06a1a5d94ea31.jpg"],"date":"20161231","display_date":"12 月 31 日","id":9112073,"title":"知乎好问题 · 逃避痛苦的力量和追求快乐的力量哪个更大？"},{"images":["http://pic2.zhimg.com/7a53542bcc2c4ad3ab8ab19a53b2405d.jpg"],"date":"20161230","display_date":"12 月 30 日","id":9111035,"title":"知乎好问题 · 有什么礼物适合旅行，实用又走心？"},{"images":["http://pic3.zhimg.com/5288777176ed140a0cd4be9d7e88b9ae.jpg"],"date":"20161229","display_date":"12 月 29 日","id":9107484,"title":"知乎好问题 · 初为人父觉得时间被孩子剥夺，该如何调整？"},{"images":["http://pic4.zhimg.com/6aba8539df59fb3dbadeaedbfaf54b4b.jpg"],"date":"20161228","display_date":"12 月 28 日","id":9104500,"title":"知乎好问题 · 如何学习单板滑雪？"},{"images":["http://pic2.zhimg.com/61efbe78a6780ff0875a5da602ee911d.jpg"],"date":"20161227","display_date":"12 月 27 日","id":9101443,"title":"知乎好问题 · 有哪些适合普通人阅读的经济学论文？"},{"images":["http://pic2.zhimg.com/0f538fd0371952e1b9199161772b9349.jpg"],"date":"20161226","display_date":"12 月 26 日","id":9098294,"title":"知乎好问题 · 为什么明明不饿，还是想吃？"},{"images":["http://pic1.zhimg.com/deb98c89f8f5db50f5387286223ac76c.jpg"],"date":"20161225","display_date":"12 月 25 日","id":9095060,"title":"知乎好问题 · 为产妇及婴儿要准备哪些物品？"},{"images":["http://pic1.zhimg.com/b6dacfedc42d9d621b02e5a03286f394.jpg"],"date":"20161224","display_date":"12 月 24 日","id":9092782,"title":"知乎好问题 · 租房和选酒店时如何判断周围的安全程度？"},{"images":["http://pic3.zhimg.com/9e0bc05d5b4cbcbb972e7a67a6847f06.jpg"],"date":"20161223","display_date":"12 月 23 日","id":9090757,"title":"知乎好问题 · 台北有什么「鲜为人知但很有意思」的景点？"},{"images":["http://pic2.zhimg.com/0b52c179e4ad14427766d88f6727069d.jpg"],"date":"20161222","display_date":"12 月 22 日","id":9088080,"title":"知乎好问题 · 一家书店怎样的细节最能打动你？"},{"images":["http://pic1.zhimg.com/a7f7913416b79fcfefa4e070d0d39324.jpg"],"date":"20161221","display_date":"12 月 21 日","id":9085140,"title":"知乎好问题 · 用芝士能做出哪些特别好吃的食物？"},{"images":["http://pic4.zhimg.com/bc39e96d85ce619e7b3ab03e38ffacdb.jpg"],"date":"20161220","display_date":"12 月 20 日","id":9081991,"title":"知乎好问题 · 怎样找到靠谱的心理咨询师？"},{"images":["http://pic2.zhimg.com/05c2e1624468f785ff56829e854b6435.jpg"],"date":"20161219","display_date":"12 月 19 日","id":9078824,"title":"知乎好问题 · 有哪些心理学入门的书推荐？"},{"images":["http://pic3.zhimg.com/e0f43cf9f30540f87c740b95f652b9ba.jpg"],"date":"20161218","display_date":"12 月 18 日","id":9075943,"title":"知乎好问题 · 初学滑雪需要注意些什么？"},{"images":["http://pic2.zhimg.com/c5b9c33e5913d021e5faa1c1d32e9681.jpg"],"date":"20161217","display_date":"12 月 17 日","id":9073905,"title":"知乎好问题 · 哪些电影拥有最美丽的风景？"},{"images":["http://pic3.zhimg.com/24514abdd68befd1955746b27734bcd6.jpg"],"date":"20161216","display_date":"12 月 16 日","id":9071610,"title":"知乎好问题 · 有哪些很重要却被忽视的炒菜技巧？"}]
     * name : 知乎好问题
     */

    public int timestamp;
    public String name;
    public List<StoriesBean> stories;

    public static class StoriesBean {
        /**
         * images : ["http://pic1.zhimg.com/a06ee9626b45b48383ecd0fdc121bbbc.jpg"]
         * date : 20170104
         * display_date : 1 月 4 日
         * id : 9122609
         * title : 知乎好问题 · 有哪些好看又好玩的装置作品？
         */

        public String date;
        public String display_date;
        public int id;
        public String title;
        public List<String> images;

        @Override
        public String toString() {
            return "StoriesBean{" +
                    "date='" + date + '\'' +
                    ", display_date='" + display_date + '\'' +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    ", images=" + images +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ColumTwo{" +
                "timestamp=" + timestamp +
                ", name='" + name + '\'' +
                ", stories=" + stories +
                '}';
    }
}
