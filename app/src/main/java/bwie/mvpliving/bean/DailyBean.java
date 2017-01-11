package bwie.mvpliving.bean;

import com.pick.library.net.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/3.
 */

public class DailyBean extends ResponseBean {
    /**
     * date : 20170103
     * stories : [{"images":["http://pic3.zhimg.com/88dfefc31c598621126947d6aaed416a.jpg"],"type":0,"id":9115115,"ga_prefix":"010311","title":"孩子自尊心最脆弱的部分，别让最爱他们的家人伤害"},{"images":["http://pic1.zhimg.com/827de756a51a5fddc15f1d5727822e98.jpg"],"type":0,"id":9115328,"ga_prefix":"010310","title":"手机支付的未来，是 NFC 还是二维码？"},{"images":["http://pic3.zhimg.com/9ac068d081db9a1fabb3c715d28afd82.jpg"],"type":0,"id":9115215,"ga_prefix":"010309","title":"如果有一个「快乐按钮」，一摁就会有无与伦比的满足感"},{"images":["http://pic2.zhimg.com/569beaf58b2170a20a2106d0b4689e21.jpg"],"type":0,"id":9117233,"ga_prefix":"010308","title":"企业文化到底是什么呢？"},{"title":"新的一年，试试这些简单营养的西式早餐","ga_prefix":"010307","images":["http://pic2.zhimg.com/ab771f4069b58780abfbe2d3a3fd28c5.jpg"],"multipic":true,"type":0,"id":9112602},{"images":["http://pic1.zhimg.com/14883948fc305c7413dc877da9ff5dbc.jpg"],"type":0,"id":9117424,"ga_prefix":"010307","title":"先别急着掏钱，看起来神奇的洗脸刷不一定适合你"},{"images":["http://pic3.zhimg.com/ecce3489d8f8ea124948e15033f20822.jpg"],"type":0,"id":9117444,"ga_prefix":"010307","title":"如何在无领导小组面试中脱颖而出？"},{"images":["http://pic2.zhimg.com/3f95089e27191e0535bd03921e0e0df1.jpg"],"type":0,"id":9108463,"ga_prefix":"010306","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic2.zhimg.com/07823621d12a90c16acb51caa291f3b9.jpg","type":0,"id":9117444,"ga_prefix":"010307","title":"如何在无领导小组面试中脱颖而出？"},{"image":"http://pic1.zhimg.com/ab88987a9e0af72a768f9c68bbfdb3c4.jpg","type":0,"id":9115328,"ga_prefix":"010310","title":"手机支付的未来，是 NFC 还是二维码？"},{"image":"http://pic1.zhimg.com/a9eb2560fd255dc4e848131ebf037da4.jpg","type":0,"id":9112602,"ga_prefix":"010307","title":"新的一年，试试这些简单营养的西式早餐"},{"image":"http://pic2.zhimg.com/69666b4a7f0d6accbd9a2e641de8bde9.jpg","type":0,"id":9116372,"ga_prefix":"010219","title":"单身独居，越来越多人打算就这样过下去"},{"image":"http://pic4.zhimg.com/f619e4420ac09ab6b755892d73d35f77.jpg","type":0,"id":9116662,"ga_prefix":"010217","title":"知乎好问题 · 思维和语言的关系是什么？"}]
     */

    public String date;
    public List<StoriesBean> stories;
    public List<TopStoriesBean> top_stories;

    public static class StoriesBean {
        /**
         * images : ["http://pic3.zhimg.com/88dfefc31c598621126947d6aaed416a.jpg"]
         * type : 0
         * id : 9115115
         * ga_prefix : 010311
         * title : 孩子自尊心最脆弱的部分，别让最爱他们的家人伤害
         * multipic : true
         */

        public int type;
        public int id;
        public String ga_prefix;
        public String title;
        public boolean multipic;
        public List<String> images;
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic2.zhimg.com/07823621d12a90c16acb51caa291f3b9.jpg
         * type : 0
         * id : 9117444
         * ga_prefix : 010307
         * title : 如何在无领导小组面试中脱颖而出？
         */

        public String image;
        public int type;
        public int id;
        public String ga_prefix;
        public String title;
    }
}
