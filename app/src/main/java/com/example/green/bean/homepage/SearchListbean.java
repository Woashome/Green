package com.example.green.bean.homepage;

import java.util.List;

public class SearchListbean {

    /**
     * code : 200
     * result : {"goods_list":[]}
     * message : ok
     * page_total : 1
     * hasmore : false
     */

    private String code;
    private ResultBean result;
    private String message;
    private int page_total;
    private boolean hasmore;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPage_total() {
        return page_total;
    }

    public void setPage_total(int page_total) {
        this.page_total = page_total;
    }

    public boolean isHasmore() {
        return hasmore;
    }

    public void setHasmore(boolean hasmore) {
        this.hasmore = hasmore;
    }

    public static class ResultBean {
        private List<?> goods_list;

        public List<?> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<?> goods_list) {
            this.goods_list = goods_list;
        }
    }
}
