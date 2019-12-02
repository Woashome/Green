package com.example.green.bean.store;

import java.util.List;

public class StoreListbean {

    /**
     * code : 200
     * result : [{"store_id":1,"store_name":"自营店铺","is_platform_store":1,"seller_name":"seller","store_sort":255,"store_addtime":1572950123,"store_logo":"https://shop.bayi-shop.com/uploads/home/common/default_store_avatar.png","num_sales_jq":0,"goods_count":114,"store_credit_percent":100,"store_credit":{"store_desccredit":{"text":"描述相符","credit":5},"store_servicecredit":{"text":"服务态度","credit":5},"store_deliverycredit":{"text":"发货速度","credit":5}},"search_list_goods":[{"goods_id":2,"store_id":1,"goods_name":"荣耀V9 play 标配版 3+32G 全网通4G手机 铂光金","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120144795113.jpg","goods_price":"998.00","goods_salenum":0},{"goods_id":3,"store_id":1,"goods_name":"Apple/苹果 iPhone 7plus 128GB 玫瑰金色 移动联通电信4G手机","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120244885492.jpg","goods_price":"6999.00","goods_salenum":0},{"goods_id":4,"store_id":1,"goods_name":"nubia/努比亚Z17 6G+64G 全网通4G手机 烈焰红 无边框","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120312320763.jpg","goods_price":"2699.00","goods_salenum":0},{"goods_id":5,"store_id":1,"goods_name":"智能电动代步车","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120345719915.jpg","goods_price":"1990.00","goods_salenum":0},{"goods_id":6,"store_id":1,"goods_name":"灵动Lite版 NV3012 视频通话智能机器人","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120365848023.jpg","goods_price":"149.00","goods_salenum":0},{"goods_id":7,"store_id":1,"goods_name":"HOST好帅智能云教育机器人二蛋Q6 ","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120382376796.jpg","goods_price":"1699.00","goods_salenum":0},{"goods_id":8,"store_id":1,"goods_name":"先锋(Pioneer)LED-39B700S 39英寸 高清 网络 智能 液晶电视","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120445748551.jpg","goods_price":"1599.00","goods_salenum":0},{"goods_id":9,"store_id":1,"goods_name":"长虹（CHANGHONG）39M1 39英寸 窄边高清液晶电视（黑色）","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120480147477.jpg","goods_price":"1399.00","goods_salenum":0}]}]
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
         * store_id : 1
         * store_name : 自营店铺
         * is_platform_store : 1
         * seller_name : seller
         * store_sort : 255
         * store_addtime : 1572950123
         * store_logo : https://shop.bayi-shop.com/uploads/home/common/default_store_avatar.png
         * num_sales_jq : 0
         * goods_count : 114
         * store_credit_percent : 100
         * store_credit : {"store_desccredit":{"text":"描述相符","credit":5},"store_servicecredit":{"text":"服务态度","credit":5},"store_deliverycredit":{"text":"发货速度","credit":5}}
         * search_list_goods : [{"goods_id":2,"store_id":1,"goods_name":"荣耀V9 play 标配版 3+32G 全网通4G手机 铂光金","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120144795113.jpg","goods_price":"998.00","goods_salenum":0},{"goods_id":3,"store_id":1,"goods_name":"Apple/苹果 iPhone 7plus 128GB 玫瑰金色 移动联通电信4G手机","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120244885492.jpg","goods_price":"6999.00","goods_salenum":0},{"goods_id":4,"store_id":1,"goods_name":"nubia/努比亚Z17 6G+64G 全网通4G手机 烈焰红 无边框","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120312320763.jpg","goods_price":"2699.00","goods_salenum":0},{"goods_id":5,"store_id":1,"goods_name":"智能电动代步车","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120345719915.jpg","goods_price":"1990.00","goods_salenum":0},{"goods_id":6,"store_id":1,"goods_name":"灵动Lite版 NV3012 视频通话智能机器人","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120365848023.jpg","goods_price":"149.00","goods_salenum":0},{"goods_id":7,"store_id":1,"goods_name":"HOST好帅智能云教育机器人二蛋Q6 ","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120382376796.jpg","goods_price":"1699.00","goods_salenum":0},{"goods_id":8,"store_id":1,"goods_name":"先锋(Pioneer)LED-39B700S 39英寸 高清 网络 智能 液晶电视","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120445748551.jpg","goods_price":"1599.00","goods_salenum":0},{"goods_id":9,"store_id":1,"goods_name":"长虹（CHANGHONG）39M1 39英寸 窄边高清液晶电视（黑色）","goods_image":"https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120480147477.jpg","goods_price":"1399.00","goods_salenum":0}]
         */

        private int store_id;
        private String store_name;
        private int is_platform_store;
        private String seller_name;
        private int store_sort;
        private int store_addtime;
        private String store_logo;
        private int num_sales_jq;
        private int goods_count;
        private int store_credit_percent;
        private StoreCreditBean store_credit;
        private List<SearchListGoodsBean> search_list_goods;

        public int getStore_id() {
            return store_id;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public int getIs_platform_store() {
            return is_platform_store;
        }

        public void setIs_platform_store(int is_platform_store) {
            this.is_platform_store = is_platform_store;
        }

        public String getSeller_name() {
            return seller_name;
        }

        public void setSeller_name(String seller_name) {
            this.seller_name = seller_name;
        }

        public int getStore_sort() {
            return store_sort;
        }

        public void setStore_sort(int store_sort) {
            this.store_sort = store_sort;
        }

        public int getStore_addtime() {
            return store_addtime;
        }

        public void setStore_addtime(int store_addtime) {
            this.store_addtime = store_addtime;
        }

        public String getStore_logo() {
            return store_logo;
        }

        public void setStore_logo(String store_logo) {
            this.store_logo = store_logo;
        }

        public int getNum_sales_jq() {
            return num_sales_jq;
        }

        public void setNum_sales_jq(int num_sales_jq) {
            this.num_sales_jq = num_sales_jq;
        }

        public int getGoods_count() {
            return goods_count;
        }

        public void setGoods_count(int goods_count) {
            this.goods_count = goods_count;
        }

        public int getStore_credit_percent() {
            return store_credit_percent;
        }

        public void setStore_credit_percent(int store_credit_percent) {
            this.store_credit_percent = store_credit_percent;
        }

        public StoreCreditBean getStore_credit() {
            return store_credit;
        }

        public void setStore_credit(StoreCreditBean store_credit) {
            this.store_credit = store_credit;
        }

        public List<SearchListGoodsBean> getSearch_list_goods() {
            return search_list_goods;
        }

        public void setSearch_list_goods(List<SearchListGoodsBean> search_list_goods) {
            this.search_list_goods = search_list_goods;
        }

        public static class StoreCreditBean {
            /**
             * store_desccredit : {"text":"描述相符","credit":5}
             * store_servicecredit : {"text":"服务态度","credit":5}
             * store_deliverycredit : {"text":"发货速度","credit":5}
             */

            private StoreDesccreditBean store_desccredit;
            private StoreServicecreditBean store_servicecredit;
            private StoreDeliverycreditBean store_deliverycredit;

            public StoreDesccreditBean getStore_desccredit() {
                return store_desccredit;
            }

            public void setStore_desccredit(StoreDesccreditBean store_desccredit) {
                this.store_desccredit = store_desccredit;
            }

            public StoreServicecreditBean getStore_servicecredit() {
                return store_servicecredit;
            }

            public void setStore_servicecredit(StoreServicecreditBean store_servicecredit) {
                this.store_servicecredit = store_servicecredit;
            }

            public StoreDeliverycreditBean getStore_deliverycredit() {
                return store_deliverycredit;
            }

            public void setStore_deliverycredit(StoreDeliverycreditBean store_deliverycredit) {
                this.store_deliverycredit = store_deliverycredit;
            }

            public static class StoreDesccreditBean {
                /**
                 * text : 描述相符
                 * credit : 5
                 */

                private String text;
                private int credit;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getCredit() {
                    return credit;
                }

                public void setCredit(int credit) {
                    this.credit = credit;
                }
            }

            public static class StoreServicecreditBean {
                /**
                 * text : 服务态度
                 * credit : 5
                 */

                private String text;
                private int credit;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getCredit() {
                    return credit;
                }

                public void setCredit(int credit) {
                    this.credit = credit;
                }
            }

            public static class StoreDeliverycreditBean {
                /**
                 * text : 发货速度
                 * credit : 5
                 */

                private String text;
                private int credit;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getCredit() {
                    return credit;
                }

                public void setCredit(int credit) {
                    this.credit = credit;
                }
            }
        }

        public static class SearchListGoodsBean {
            /**
             * goods_id : 2
             * store_id : 1
             * goods_name : 荣耀V9 play 标配版 3+32G 全网通4G手机 铂光金
             * goods_image : https://shop.bayi-shop.com/uploads/home/store/goods/1/1_2017092120144795113.jpg
             * goods_price : 998.00
             * goods_salenum : 0
             */

            private int goods_id;
            private int store_id;
            private String goods_name;
            private String goods_image;
            private String goods_price;
            private int goods_salenum;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public int getStore_id() {
                return store_id;
            }

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public int getGoods_salenum() {
                return goods_salenum;
            }

            public void setGoods_salenum(int goods_salenum) {
                this.goods_salenum = goods_salenum;
            }
        }
    }
}
