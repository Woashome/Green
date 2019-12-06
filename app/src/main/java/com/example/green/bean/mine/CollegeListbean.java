package com.example.green.bean.mine;

import java.util.List;

public class CollegeListbean {


    /**
     * code : 200
     * result : [{"article_id":48,"ac_id":8,"article_url":"http://shop.com/admin/index/index.html","article_show":1,"article_sort":0,"article_title":"啊啊士大夫","article_content":"&lt;p&gt;爱的施工方&lt;/p&gt;","article_time":"2019-12-03 15:44:35","article_pic":"","article_type":0}]
     * message : ok
     */

    private String code;
    private String message;
    private List<ResultBean> result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * article_id : 48
         * ac_id : 8
         * article_url : http://shop.com/admin/index/index.html
         * article_show : 1
         * article_sort : 0
         * article_title : 啊啊士大夫
         * article_content : &lt;p&gt;爱的施工方&lt;/p&gt;
         * article_time : 2019-12-03 15:44:35
         * article_pic :
         * article_type : 0
         */

        private int article_id;
        private int ac_id;
        private String article_url;
        private int article_show;
        private int article_sort;
        private String article_title;
        private String article_content;
        private String article_time;
        private String article_pic;
        private int article_type;

        public int getArticle_id() {
            return article_id;
        }

        public void setArticle_id(int article_id) {
            this.article_id = article_id;
        }

        public int getAc_id() {
            return ac_id;
        }

        public void setAc_id(int ac_id) {
            this.ac_id = ac_id;
        }

        public String getArticle_url() {
            return article_url;
        }

        public void setArticle_url(String article_url) {
            this.article_url = article_url;
        }

        public int getArticle_show() {
            return article_show;
        }

        public void setArticle_show(int article_show) {
            this.article_show = article_show;
        }

        public int getArticle_sort() {
            return article_sort;
        }

        public void setArticle_sort(int article_sort) {
            this.article_sort = article_sort;
        }

        public String getArticle_title() {
            return article_title;
        }

        public void setArticle_title(String article_title) {
            this.article_title = article_title;
        }

        public String getArticle_content() {
            return article_content;
        }

        public void setArticle_content(String article_content) {
            this.article_content = article_content;
        }

        public String getArticle_time() {
            return article_time;
        }

        public void setArticle_time(String article_time) {
            this.article_time = article_time;
        }

        public String getArticle_pic() {
            return article_pic;
        }

        public void setArticle_pic(String article_pic) {
            this.article_pic = article_pic;
        }

        public int getArticle_type() {
            return article_type;
        }

        public void setArticle_type(int article_type) {
            this.article_type = article_type;
        }
    }
}
