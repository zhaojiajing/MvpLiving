package bwie.mvpliving.bean;

import com.pick.library.net.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:zhaojingjing
 * 3.2017/1/4.
 */
public class WechatBean extends ResponseBean{
    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-01-04","title":"未来简史：本书只适合高智商且勇敢的人","description":"中信书店","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/nqelflZYRc7OrkYxwhHZvQicwnG7LJQ3s3nz2fiaCMFx1pgNxmyveUxPkVpkpHNpnMKAOLmz2uOdNex4dGlkDExQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/GHPl131MXZDMoIp1lg6C2Q"},{"ctime":"2017-01-04","title":"体验了下微信小程序，感受到了腾讯的野心。","description":"差评","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/yZPTcMGWibvtfOSUMkd7NjQF88nkSDKNFLyRMXTbeMqex5T6CCfY2FFEnMz5uia4SARSNpicUIrBib2rC8E6zPiaLkA/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/6t8YEOzkUezWJO7Y9v3qnw"},{"ctime":"2017-01-04","title":"如何度过20岁开头的穷苦日子","description":"新世相","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/5ROs96OaibImYXialxp8GBuWdAmCbvdZ5f8zEjPQOr49PIVUdkVcIVgpVJtBeP5Y7AIueBbwk1qhnX10eZnp7icrA/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/BsWITk-EI9LYz7dhyg3icQ"},{"ctime":"2017-01-02","title":"发财树也能开花，花朵还很漂亮！","description":"流意盆栽","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/5hX4zhRicEEHxTdyFibfe1xrbcI1qaAs6yOnY31L6v02T96VxCR3GcZhEwS956NLAFpLLktN34R4baaBauWg4N5A/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/yficc0tDfgFIoKGxhJZMsg"},{"ctime":"2017-01-02","title":"很多事都是后知后觉，比如喝水、添衣和想你。","description":"我要WhatYouNeed","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/zynprs47B4RfDAH6Os3rIFOwzVHGR37yywpmwm7icwJ2q2OgylXt1v1c4pXv2GZl863Oh5tP5FMLubT5uQnxT8Q/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/psvCdmdncjAeYov_dzmQOQ"},{"ctime":"2017-01-02","title":"这个神奇的眼罩只需戴19分钟，比做大保健还舒服！","description":"差评","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/yZPTcMGWibvucibXtEFAYXic59vNKADwhjicATjicbIic68bZvGnPCXWicf7IkOPhLmYaBj8sJvHIBDbY3XNbDw2EQiaOQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/j9uTFY5Bw0wYWRBCmSssmA"},{"ctime":"2017-01-02","title":"从段首空两格说起","description":"小道消息","picUrl":"http://mmbiz.qpic.cn/mmbiz/ow5rEn8QGlEL46kJgQzicrPNevGzU1xtwjOeLwQDxm8s3RPs7XvNfOlz3qkhdv3hiaKUyCOrZZGU4saAfW9gK52w/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/V7hN40XyuSF7cIW8Og0SlA"},{"ctime":"2017-01-02","title":"罗振宇《时间的朋友》跨年演讲精华版：2017年的5大趋势与变化","description":"腾讯科技","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/ow6przZuPIHMrXsUsOOBxS3GibwyCicH9JxJrbQ1icaWEqqMPmybia7RuFJyicam8njlqgubeAlgr4Kw1icOucGXaOLQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/qyC9KS308xKhALR-dAyeWQ"},{"ctime":"2017-01-02","title":"王小川：让搜狗少犯错的，不是精通，而是不懂","description":"科技50","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/kfceBEgJM8ATns4R7iakibiazo3qJf31icILIcwQa8dBDRCYuLJnUibAGYcxWMYGjCbfN005MnUSFULRrLYYn2GjyRg/640?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/difkR5jVDKNODKVazfZLxQ"},{"ctime":"2017-01-02","title":"习近平首次点评\u201c95后\u201d大学生，他都说了啥？","description":"人民日报","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/xrFYciaHL08Aaf9fxlw9NVicUXGjShBhBOqziakENm5d8hwB7PBs3XLpalIicz2RcFe14btT3Fpib9jhtotnSDkIctQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/ApjXZK34Gvsi6pIZvJmNMA"}]
     */

    public int code;
    public String msg;
    public List<NewslistBean> newslist;

    public static class NewslistBean {
        /**
         * ctime : 2017-01-04
         * title : 未来简史：本书只适合高智商且勇敢的人
         * description : 中信书店
         * picUrl : http://mmbiz.qpic.cn/mmbiz_jpg/nqelflZYRc7OrkYxwhHZvQicwnG7LJQ3s3nz2fiaCMFx1pgNxmyveUxPkVpkpHNpnMKAOLmz2uOdNex4dGlkDExQ/0?wx_fmt=jpeg
         * url : http://mp.weixin.qq.com/s/GHPl131MXZDMoIp1lg6C2Q
         */

        public String ctime;
        public String title;
        public String description;
        public String picUrl;
        public String url;
    }
}
