package com.example.green.bean.shopping;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @ProjectName: Green
 * @Package: com.example.green.bean.shopping
 * @ClassName: ShoppingInfobean
 * @Author: hjl
 * @email: 51721997@163.com
 * @Description: java类作用描述
 * @CreateDate: 2019/12/27 16:09
 */
public class ShoppingInfobean {

    /**
     * code : 200
     * result : {"store_cart_list":{"1":{"goods_list":[{"goods_num":3,"goods_id":133,"goods_commonid":2,"is_virtual":0,"gc_id":75,"store_id":1,"goods_name":"荣耀V9 play 标配版 3+32G 全网通4G手机 铂光金 全网通 黑 128G","goods_price":"998.00","store_name":"自营店铺","goods_image":"1_2017092120144795113.jpg","transport_id":0,"goods_freight":"0.00","goods_vat":0,"goods_storage":93,"goods_storage_alarm":0,"is_goodsfcode":0,"is_have_gift":0,"state":true,"storage_state":true,"groupbuy_info":"","xianshi_info":"","pintuan_info":"","bargain_info":null,"mgdiscount_info":"","cart_id":133,"bl_id":0,"goods_total":"2994.00","goods_image_url":"http://w.gw.com/uploads/home/store/goods/1/1_2017092120144795113.jpg"}],"store_goods_total":"2994.00","store_mansong_rule_list":"","store_voucher_info":[],"store_voucher_list":[],"store_name":"自营店铺","store_id":1}},"store_cart_list_api":[{"goods_list":[{"goods_num":3,"goods_id":133,"goods_commonid":2,"is_virtual":0,"gc_id":75,"store_id":1,"goods_name":"荣耀V9 play 标配版 3+32G 全网通4G手机 铂光金 全网通 黑 128G","goods_price":"998.00","store_name":"自营店铺","goods_image":"1_2017092120144795113.jpg","transport_id":0,"goods_freight":"0.00","goods_vat":0,"goods_storage":93,"goods_storage_alarm":0,"is_goodsfcode":0,"is_have_gift":0,"state":true,"storage_state":true,"groupbuy_info":"","xianshi_info":"","pintuan_info":"","bargain_info":null,"mgdiscount_info":"","cart_id":133,"bl_id":0,"goods_total":"2994.00","goods_image_url":"http://w.gw.com/uploads/home/store/goods/1/1_2017092120144795113.jpg"}],"store_goods_total":"2994.00","store_mansong_rule_list":"","store_voucher_info":[],"store_voucher_list":[],"store_name":"自营店铺","store_id":1}],"freight_hash":"T1u9S4A8R3D-QrUrKziZlFUYd5NYVGj0yLIQYFAB6k4RQkzFWkDC8VDRS1_FyhIk3pxzDYyfE6omPSarAF_wi0XERoNKWbJCOCkGAFR_D7l6kSjzCJ1MFwRufEs6Wvc8FDe","address_info":{"address_id":1,"member_id":8,"address_realname":"王某某","city_id":36,"area_id":47,"area_info":"北京 北京市 通州区","address_detail":"西马庄园","address_tel_phone":"","address_mob_phone":"15236615592","address_is_default":"0","dlyp_id":0,"address_longitude":"116.636503","address_latitude":"39.918474"},"ifshow_offpay":true,"vat_hash":"iDmebAVjZjQqwU5UDazY7i-0v1TXsDuaqOc","inv_info":{"content":"不需要发票"},"available_predeposit":"6008.00","available_rc_balance":[],"rpt_list":[],"zk_list":[],"order_amount":"2994.00","rpt_info":[],"address_api":"","store_final_total_list":{"1":"2994.00"}}
     * message : ok
     */

    private String code;
    private ResultBean result;
    private String message;

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

    public static class ResultBean {
        /**
         * store_cart_list : {"1":{"goods_list":[{"goods_num":3,"goods_id":133,"goods_commonid":2,"is_virtual":0,"gc_id":75,"store_id":1,"goods_name":"荣耀V9 play 标配版 3+32G 全网通4G手机 铂光金 全网通 黑 128G","goods_price":"998.00","store_name":"自营店铺","goods_image":"1_2017092120144795113.jpg","transport_id":0,"goods_freight":"0.00","goods_vat":0,"goods_storage":93,"goods_storage_alarm":0,"is_goodsfcode":0,"is_have_gift":0,"state":true,"storage_state":true,"groupbuy_info":"","xianshi_info":"","pintuan_info":"","bargain_info":null,"mgdiscount_info":"","cart_id":133,"bl_id":0,"goods_total":"2994.00","goods_image_url":"http://w.gw.com/uploads/home/store/goods/1/1_2017092120144795113.jpg"}],"store_goods_total":"2994.00","store_mansong_rule_list":"","store_voucher_info":[],"store_voucher_list":[],"store_name":"自营店铺","store_id":1}}
         * store_cart_list_api : [{"goods_list":[{"goods_num":3,"goods_id":133,"goods_commonid":2,"is_virtual":0,"gc_id":75,"store_id":1,"goods_name":"荣耀V9 play 标配版 3+32G 全网通4G手机 铂光金 全网通 黑 128G","goods_price":"998.00","store_name":"自营店铺","goods_image":"1_2017092120144795113.jpg","transport_id":0,"goods_freight":"0.00","goods_vat":0,"goods_storage":93,"goods_storage_alarm":0,"is_goodsfcode":0,"is_have_gift":0,"state":true,"storage_state":true,"groupbuy_info":"","xianshi_info":"","pintuan_info":"","bargain_info":null,"mgdiscount_info":"","cart_id":133,"bl_id":0,"goods_total":"2994.00","goods_image_url":"http://w.gw.com/uploads/home/store/goods/1/1_2017092120144795113.jpg"}],"store_goods_total":"2994.00","store_mansong_rule_list":"","store_voucher_info":[],"store_voucher_list":[],"store_name":"自营店铺","store_id":1}]
         * freight_hash : T1u9S4A8R3D-QrUrKziZlFUYd5NYVGj0yLIQYFAB6k4RQkzFWkDC8VDRS1_FyhIk3pxzDYyfE6omPSarAF_wi0XERoNKWbJCOCkGAFR_D7l6kSjzCJ1MFwRufEs6Wvc8FDe
         * address_info : {"address_id":1,"member_id":8,"address_realname":"王某某","city_id":36,"area_id":47,"area_info":"北京 北京市 通州区","address_detail":"西马庄园","address_tel_phone":"","address_mob_phone":"15236615592","address_is_default":"0","dlyp_id":0,"address_longitude":"116.636503","address_latitude":"39.918474"}
         * ifshow_offpay : true
         * vat_hash : iDmebAVjZjQqwU5UDazY7i-0v1TXsDuaqOc
         * inv_info : {"content":"不需要发票"}
         * available_predeposit : 6008.00
         * available_rc_balance : []
         * rpt_list : []
         * zk_list : []
         * order_amount : 2994.00
         * rpt_info : []
         * address_api :
         * store_final_total_list : {"1":"2994.00"}
         */

        private StoreCartListBean store_cart_list;
        private String freight_hash;
        private AddressInfoBean address_info;
        private boolean ifshow_offpay;
        private String vat_hash;
        private InvInfoBean inv_info;
        private String available_predeposit;
        private String order_amount;
        private String address_api;
        private StoreFinalTotalListBean store_final_total_list;
        private List<StoreCartListApiBean> store_cart_list_api;
        private List<?> available_rc_balance;
        private List<?> rpt_list;
        private List<?> zk_list;
        private List<?> rpt_info;

        public StoreCartListBean getStore_cart_list() {
            return store_cart_list;
        }

        public void setStore_cart_list(StoreCartListBean store_cart_list) {
            this.store_cart_list = store_cart_list;
        }

        public String getFreight_hash() {
            return freight_hash;
        }

        public void setFreight_hash(String freight_hash) {
            this.freight_hash = freight_hash;
        }

        public AddressInfoBean getAddress_info() {
            return address_info;
        }

        public void setAddress_info(AddressInfoBean address_info) {
            this.address_info = address_info;
        }

        public boolean isIfshow_offpay() {
            return ifshow_offpay;
        }

        public void setIfshow_offpay(boolean ifshow_offpay) {
            this.ifshow_offpay = ifshow_offpay;
        }

        public String getVat_hash() {
            return vat_hash;
        }

        public void setVat_hash(String vat_hash) {
            this.vat_hash = vat_hash;
        }

        public InvInfoBean getInv_info() {
            return inv_info;
        }

        public void setInv_info(InvInfoBean inv_info) {
            this.inv_info = inv_info;
        }

        public String getAvailable_predeposit() {
            return available_predeposit;
        }

        public void setAvailable_predeposit(String available_predeposit) {
            this.available_predeposit = available_predeposit;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

        public String getAddress_api() {
            return address_api;
        }

        public void setAddress_api(String address_api) {
            this.address_api = address_api;
        }

        public StoreFinalTotalListBean getStore_final_total_list() {
            return store_final_total_list;
        }

        public void setStore_final_total_list(StoreFinalTotalListBean store_final_total_list) {
            this.store_final_total_list = store_final_total_list;
        }

        public List<StoreCartListApiBean> getStore_cart_list_api() {
            return store_cart_list_api;
        }

        public void setStore_cart_list_api(List<StoreCartListApiBean> store_cart_list_api) {
            this.store_cart_list_api = store_cart_list_api;
        }

        public List<?> getAvailable_rc_balance() {
            return available_rc_balance;
        }

        public void setAvailable_rc_balance(List<?> available_rc_balance) {
            this.available_rc_balance = available_rc_balance;
        }

        public List<?> getRpt_list() {
            return rpt_list;
        }

        public void setRpt_list(List<?> rpt_list) {
            this.rpt_list = rpt_list;
        }

        public List<?> getZk_list() {
            return zk_list;
        }

        public void setZk_list(List<?> zk_list) {
            this.zk_list = zk_list;
        }

        public List<?> getRpt_info() {
            return rpt_info;
        }

        public void setRpt_info(List<?> rpt_info) {
            this.rpt_info = rpt_info;
        }

        public static class StoreCartListBean {
            /**
             * 1 : {"goods_list":[{"goods_num":3,"goods_id":133,"goods_commonid":2,"is_virtual":0,"gc_id":75,"store_id":1,"goods_name":"荣耀V9 play 标配版 3+32G 全网通4G手机 铂光金 全网通 黑 128G","goods_price":"998.00","store_name":"自营店铺","goods_image":"1_2017092120144795113.jpg","transport_id":0,"goods_freight":"0.00","goods_vat":0,"goods_storage":93,"goods_storage_alarm":0,"is_goodsfcode":0,"is_have_gift":0,"state":true,"storage_state":true,"groupbuy_info":"","xianshi_info":"","pintuan_info":"","bargain_info":null,"mgdiscount_info":"","cart_id":133,"bl_id":0,"goods_total":"2994.00","goods_image_url":"http://w.gw.com/uploads/home/store/goods/1/1_2017092120144795113.jpg"}],"store_goods_total":"2994.00","store_mansong_rule_list":"","store_voucher_info":[],"store_voucher_list":[],"store_name":"自营店铺","store_id":1}
             */

            @SerializedName("1")
            private _$1Bean _$1;

            public _$1Bean get_$1() {
                return _$1;
            }

            public void set_$1(_$1Bean _$1) {
                this._$1 = _$1;
            }

            public static class _$1Bean {
                /**
                 * goods_list : [{"goods_num":3,"goods_id":133,"goods_commonid":2,"is_virtual":0,"gc_id":75,"store_id":1,"goods_name":"荣耀V9 play 标配版 3+32G 全网通4G手机 铂光金 全网通 黑 128G","goods_price":"998.00","store_name":"自营店铺","goods_image":"1_2017092120144795113.jpg","transport_id":0,"goods_freight":"0.00","goods_vat":0,"goods_storage":93,"goods_storage_alarm":0,"is_goodsfcode":0,"is_have_gift":0,"state":true,"storage_state":true,"groupbuy_info":"","xianshi_info":"","pintuan_info":"","bargain_info":null,"mgdiscount_info":"","cart_id":133,"bl_id":0,"goods_total":"2994.00","goods_image_url":"http://w.gw.com/uploads/home/store/goods/1/1_2017092120144795113.jpg"}]
                 * store_goods_total : 2994.00
                 * store_mansong_rule_list :
                 * store_voucher_info : []
                 * store_voucher_list : []
                 * store_name : 自营店铺
                 * store_id : 1
                 */

                private String store_goods_total;
                private String store_mansong_rule_list;
                private String store_name;
                private int store_id;
                private List<GoodsListBean> goods_list;
                private List<?> store_voucher_info;
                private List<?> store_voucher_list;

                public String getStore_goods_total() {
                    return store_goods_total;
                }

                public void setStore_goods_total(String store_goods_total) {
                    this.store_goods_total = store_goods_total;
                }

                public String getStore_mansong_rule_list() {
                    return store_mansong_rule_list;
                }

                public void setStore_mansong_rule_list(String store_mansong_rule_list) {
                    this.store_mansong_rule_list = store_mansong_rule_list;
                }

                public String getStore_name() {
                    return store_name;
                }

                public void setStore_name(String store_name) {
                    this.store_name = store_name;
                }

                public int getStore_id() {
                    return store_id;
                }

                public void setStore_id(int store_id) {
                    this.store_id = store_id;
                }

                public List<GoodsListBean> getGoods_list() {
                    return goods_list;
                }

                public void setGoods_list(List<GoodsListBean> goods_list) {
                    this.goods_list = goods_list;
                }

                public List<?> getStore_voucher_info() {
                    return store_voucher_info;
                }

                public void setStore_voucher_info(List<?> store_voucher_info) {
                    this.store_voucher_info = store_voucher_info;
                }

                public List<?> getStore_voucher_list() {
                    return store_voucher_list;
                }

                public void setStore_voucher_list(List<?> store_voucher_list) {
                    this.store_voucher_list = store_voucher_list;
                }

                public static class GoodsListBean {
                    /**
                     * goods_num : 3
                     * goods_id : 133
                     * goods_commonid : 2
                     * is_virtual : 0
                     * gc_id : 75
                     * store_id : 1
                     * goods_name : 荣耀V9 play 标配版 3+32G 全网通4G手机 铂光金 全网通 黑 128G
                     * goods_price : 998.00
                     * store_name : 自营店铺
                     * goods_image : 1_2017092120144795113.jpg
                     * transport_id : 0
                     * goods_freight : 0.00
                     * goods_vat : 0
                     * goods_storage : 93
                     * goods_storage_alarm : 0
                     * is_goodsfcode : 0
                     * is_have_gift : 0
                     * state : true
                     * storage_state : true
                     * groupbuy_info :
                     * xianshi_info :
                     * pintuan_info :
                     * bargain_info : null
                     * mgdiscount_info :
                     * cart_id : 133
                     * bl_id : 0
                     * goods_total : 2994.00
                     * goods_image_url : http://w.gw.com/uploads/home/store/goods/1/1_2017092120144795113.jpg
                     */

                    private int goods_num;
                    private int goods_id;
                    private int goods_commonid;
                    private int is_virtual;
                    private int gc_id;
                    private int store_id;
                    private String goods_name;
                    private String goods_price;
                    private String store_name;
                    private String goods_image;
                    private int transport_id;
                    private String goods_freight;
                    private int goods_vat;
                    private int goods_storage;
                    private int goods_storage_alarm;
                    private int is_goodsfcode;
                    private int is_have_gift;
                    private boolean state;
                    private boolean storage_state;
                    private String groupbuy_info;
                    private String xianshi_info;
                    private String pintuan_info;
                    private Object bargain_info;
                    private String mgdiscount_info;
                    private int cart_id;
                    private int bl_id;
                    private String goods_total;
                    private String goods_image_url;

                    public int getGoods_num() {
                        return goods_num;
                    }

                    public void setGoods_num(int goods_num) {
                        this.goods_num = goods_num;
                    }

                    public int getGoods_id() {
                        return goods_id;
                    }

                    public void setGoods_id(int goods_id) {
                        this.goods_id = goods_id;
                    }

                    public int getGoods_commonid() {
                        return goods_commonid;
                    }

                    public void setGoods_commonid(int goods_commonid) {
                        this.goods_commonid = goods_commonid;
                    }

                    public int getIs_virtual() {
                        return is_virtual;
                    }

                    public void setIs_virtual(int is_virtual) {
                        this.is_virtual = is_virtual;
                    }

                    public int getGc_id() {
                        return gc_id;
                    }

                    public void setGc_id(int gc_id) {
                        this.gc_id = gc_id;
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

                    public String getGoods_price() {
                        return goods_price;
                    }

                    public void setGoods_price(String goods_price) {
                        this.goods_price = goods_price;
                    }

                    public String getStore_name() {
                        return store_name;
                    }

                    public void setStore_name(String store_name) {
                        this.store_name = store_name;
                    }

                    public String getGoods_image() {
                        return goods_image;
                    }

                    public void setGoods_image(String goods_image) {
                        this.goods_image = goods_image;
                    }

                    public int getTransport_id() {
                        return transport_id;
                    }

                    public void setTransport_id(int transport_id) {
                        this.transport_id = transport_id;
                    }

                    public String getGoods_freight() {
                        return goods_freight;
                    }

                    public void setGoods_freight(String goods_freight) {
                        this.goods_freight = goods_freight;
                    }

                    public int getGoods_vat() {
                        return goods_vat;
                    }

                    public void setGoods_vat(int goods_vat) {
                        this.goods_vat = goods_vat;
                    }

                    public int getGoods_storage() {
                        return goods_storage;
                    }

                    public void setGoods_storage(int goods_storage) {
                        this.goods_storage = goods_storage;
                    }

                    public int getGoods_storage_alarm() {
                        return goods_storage_alarm;
                    }

                    public void setGoods_storage_alarm(int goods_storage_alarm) {
                        this.goods_storage_alarm = goods_storage_alarm;
                    }

                    public int getIs_goodsfcode() {
                        return is_goodsfcode;
                    }

                    public void setIs_goodsfcode(int is_goodsfcode) {
                        this.is_goodsfcode = is_goodsfcode;
                    }

                    public int getIs_have_gift() {
                        return is_have_gift;
                    }

                    public void setIs_have_gift(int is_have_gift) {
                        this.is_have_gift = is_have_gift;
                    }

                    public boolean isState() {
                        return state;
                    }

                    public void setState(boolean state) {
                        this.state = state;
                    }

                    public boolean isStorage_state() {
                        return storage_state;
                    }

                    public void setStorage_state(boolean storage_state) {
                        this.storage_state = storage_state;
                    }

                    public String getGroupbuy_info() {
                        return groupbuy_info;
                    }

                    public void setGroupbuy_info(String groupbuy_info) {
                        this.groupbuy_info = groupbuy_info;
                    }

                    public String getXianshi_info() {
                        return xianshi_info;
                    }

                    public void setXianshi_info(String xianshi_info) {
                        this.xianshi_info = xianshi_info;
                    }

                    public String getPintuan_info() {
                        return pintuan_info;
                    }

                    public void setPintuan_info(String pintuan_info) {
                        this.pintuan_info = pintuan_info;
                    }

                    public Object getBargain_info() {
                        return bargain_info;
                    }

                    public void setBargain_info(Object bargain_info) {
                        this.bargain_info = bargain_info;
                    }

                    public String getMgdiscount_info() {
                        return mgdiscount_info;
                    }

                    public void setMgdiscount_info(String mgdiscount_info) {
                        this.mgdiscount_info = mgdiscount_info;
                    }

                    public int getCart_id() {
                        return cart_id;
                    }

                    public void setCart_id(int cart_id) {
                        this.cart_id = cart_id;
                    }

                    public int getBl_id() {
                        return bl_id;
                    }

                    public void setBl_id(int bl_id) {
                        this.bl_id = bl_id;
                    }

                    public String getGoods_total() {
                        return goods_total;
                    }

                    public void setGoods_total(String goods_total) {
                        this.goods_total = goods_total;
                    }

                    public String getGoods_image_url() {
                        return goods_image_url;
                    }

                    public void setGoods_image_url(String goods_image_url) {
                        this.goods_image_url = goods_image_url;
                    }
                }
            }
        }

        public static class AddressInfoBean {
            /**
             * address_id : 1
             * member_id : 8
             * address_realname : 王某某
             * city_id : 36
             * area_id : 47
             * area_info : 北京 北京市 通州区
             * address_detail : 西马庄园
             * address_tel_phone :
             * address_mob_phone : 15236615592
             * address_is_default : 0
             * dlyp_id : 0
             * address_longitude : 116.636503
             * address_latitude : 39.918474
             */

            private int address_id;
            private int member_id;
            private String address_realname;
            private int city_id;
            private int area_id;
            private String area_info;
            private String address_detail;
            private String address_tel_phone;
            private String address_mob_phone;
            private String address_is_default;
            private int dlyp_id;
            private String address_longitude;
            private String address_latitude;

            public int getAddress_id() {
                return address_id;
            }

            public void setAddress_id(int address_id) {
                this.address_id = address_id;
            }

            public int getMember_id() {
                return member_id;
            }

            public void setMember_id(int member_id) {
                this.member_id = member_id;
            }

            public String getAddress_realname() {
                return address_realname;
            }

            public void setAddress_realname(String address_realname) {
                this.address_realname = address_realname;
            }

            public int getCity_id() {
                return city_id;
            }

            public void setCity_id(int city_id) {
                this.city_id = city_id;
            }

            public int getArea_id() {
                return area_id;
            }

            public void setArea_id(int area_id) {
                this.area_id = area_id;
            }

            public String getArea_info() {
                return area_info;
            }

            public void setArea_info(String area_info) {
                this.area_info = area_info;
            }

            public String getAddress_detail() {
                return address_detail;
            }

            public void setAddress_detail(String address_detail) {
                this.address_detail = address_detail;
            }

            public String getAddress_tel_phone() {
                return address_tel_phone;
            }

            public void setAddress_tel_phone(String address_tel_phone) {
                this.address_tel_phone = address_tel_phone;
            }

            public String getAddress_mob_phone() {
                return address_mob_phone;
            }

            public void setAddress_mob_phone(String address_mob_phone) {
                this.address_mob_phone = address_mob_phone;
            }

            public String getAddress_is_default() {
                return address_is_default;
            }

            public void setAddress_is_default(String address_is_default) {
                this.address_is_default = address_is_default;
            }

            public int getDlyp_id() {
                return dlyp_id;
            }

            public void setDlyp_id(int dlyp_id) {
                this.dlyp_id = dlyp_id;
            }

            public String getAddress_longitude() {
                return address_longitude;
            }

            public void setAddress_longitude(String address_longitude) {
                this.address_longitude = address_longitude;
            }

            public String getAddress_latitude() {
                return address_latitude;
            }

            public void setAddress_latitude(String address_latitude) {
                this.address_latitude = address_latitude;
            }
        }

        public static class InvInfoBean {
            /**
             * content : 不需要发票
             */

            private String content;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public static class StoreFinalTotalListBean {
            /**
             * 1 : 2994.00
             */

            @SerializedName("1")
            private String _$1;

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }
        }

        public static class StoreCartListApiBean {
            /**
             * goods_list : [{"goods_num":3,"goods_id":133,"goods_commonid":2,"is_virtual":0,"gc_id":75,"store_id":1,"goods_name":"荣耀V9 play 标配版 3+32G 全网通4G手机 铂光金 全网通 黑 128G","goods_price":"998.00","store_name":"自营店铺","goods_image":"1_2017092120144795113.jpg","transport_id":0,"goods_freight":"0.00","goods_vat":0,"goods_storage":93,"goods_storage_alarm":0,"is_goodsfcode":0,"is_have_gift":0,"state":true,"storage_state":true,"groupbuy_info":"","xianshi_info":"","pintuan_info":"","bargain_info":null,"mgdiscount_info":"","cart_id":133,"bl_id":0,"goods_total":"2994.00","goods_image_url":"http://w.gw.com/uploads/home/store/goods/1/1_2017092120144795113.jpg"}]
             * store_goods_total : 2994.00
             * store_mansong_rule_list :
             * store_voucher_info : []
             * store_voucher_list : []
             * store_name : 自营店铺
             * store_id : 1
             */

            private String store_goods_total;
            private String store_mansong_rule_list;
            private String store_name;
            private int store_id;
            private List<GoodsListBeanX> goods_list;
            private List<?> store_voucher_info;
            private List<?> store_voucher_list;

            public String getStore_goods_total() {
                return store_goods_total;
            }

            public void setStore_goods_total(String store_goods_total) {
                this.store_goods_total = store_goods_total;
            }

            public String getStore_mansong_rule_list() {
                return store_mansong_rule_list;
            }

            public void setStore_mansong_rule_list(String store_mansong_rule_list) {
                this.store_mansong_rule_list = store_mansong_rule_list;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public int getStore_id() {
                return store_id;
            }

            public void setStore_id(int store_id) {
                this.store_id = store_id;
            }

            public List<GoodsListBeanX> getGoods_list() {
                return goods_list;
            }

            public void setGoods_list(List<GoodsListBeanX> goods_list) {
                this.goods_list = goods_list;
            }

            public List<?> getStore_voucher_info() {
                return store_voucher_info;
            }

            public void setStore_voucher_info(List<?> store_voucher_info) {
                this.store_voucher_info = store_voucher_info;
            }

            public List<?> getStore_voucher_list() {
                return store_voucher_list;
            }

            public void setStore_voucher_list(List<?> store_voucher_list) {
                this.store_voucher_list = store_voucher_list;
            }

            public static class GoodsListBeanX {
                /**
                 * goods_num : 3
                 * goods_id : 133
                 * goods_commonid : 2
                 * is_virtual : 0
                 * gc_id : 75
                 * store_id : 1
                 * goods_name : 荣耀V9 play 标配版 3+32G 全网通4G手机 铂光金 全网通 黑 128G
                 * goods_price : 998.00
                 * store_name : 自营店铺
                 * goods_image : 1_2017092120144795113.jpg
                 * transport_id : 0
                 * goods_freight : 0.00
                 * goods_vat : 0
                 * goods_storage : 93
                 * goods_storage_alarm : 0
                 * is_goodsfcode : 0
                 * is_have_gift : 0
                 * state : true
                 * storage_state : true
                 * groupbuy_info :
                 * xianshi_info :
                 * pintuan_info :
                 * bargain_info : null
                 * mgdiscount_info :
                 * cart_id : 133
                 * bl_id : 0
                 * goods_total : 2994.00
                 * goods_image_url : http://w.gw.com/uploads/home/store/goods/1/1_2017092120144795113.jpg
                 */

                private int goods_num;
                private int goods_id;
                private int goods_commonid;
                private int is_virtual;
                private int gc_id;
                private int store_id;
                private String goods_name;
                private String goods_price;
                private String store_name;
                private String goods_image;
                private int transport_id;
                private String goods_freight;
                private int goods_vat;
                private int goods_storage;
                private int goods_storage_alarm;
                private int is_goodsfcode;
                private int is_have_gift;
                private boolean state;
                private boolean storage_state;
                private String groupbuy_info;
                private String xianshi_info;
                private String pintuan_info;
                private Object bargain_info;
                private String mgdiscount_info;
                private int cart_id;
                private int bl_id;
                private String goods_total;
                private String goods_image_url;

                public int getGoods_num() {
                    return goods_num;
                }

                public void setGoods_num(int goods_num) {
                    this.goods_num = goods_num;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public int getGoods_commonid() {
                    return goods_commonid;
                }

                public void setGoods_commonid(int goods_commonid) {
                    this.goods_commonid = goods_commonid;
                }

                public int getIs_virtual() {
                    return is_virtual;
                }

                public void setIs_virtual(int is_virtual) {
                    this.is_virtual = is_virtual;
                }

                public int getGc_id() {
                    return gc_id;
                }

                public void setGc_id(int gc_id) {
                    this.gc_id = gc_id;
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

                public String getGoods_price() {
                    return goods_price;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public String getStore_name() {
                    return store_name;
                }

                public void setStore_name(String store_name) {
                    this.store_name = store_name;
                }

                public String getGoods_image() {
                    return goods_image;
                }

                public void setGoods_image(String goods_image) {
                    this.goods_image = goods_image;
                }

                public int getTransport_id() {
                    return transport_id;
                }

                public void setTransport_id(int transport_id) {
                    this.transport_id = transport_id;
                }

                public String getGoods_freight() {
                    return goods_freight;
                }

                public void setGoods_freight(String goods_freight) {
                    this.goods_freight = goods_freight;
                }

                public int getGoods_vat() {
                    return goods_vat;
                }

                public void setGoods_vat(int goods_vat) {
                    this.goods_vat = goods_vat;
                }

                public int getGoods_storage() {
                    return goods_storage;
                }

                public void setGoods_storage(int goods_storage) {
                    this.goods_storage = goods_storage;
                }

                public int getGoods_storage_alarm() {
                    return goods_storage_alarm;
                }

                public void setGoods_storage_alarm(int goods_storage_alarm) {
                    this.goods_storage_alarm = goods_storage_alarm;
                }

                public int getIs_goodsfcode() {
                    return is_goodsfcode;
                }

                public void setIs_goodsfcode(int is_goodsfcode) {
                    this.is_goodsfcode = is_goodsfcode;
                }

                public int getIs_have_gift() {
                    return is_have_gift;
                }

                public void setIs_have_gift(int is_have_gift) {
                    this.is_have_gift = is_have_gift;
                }

                public boolean isState() {
                    return state;
                }

                public void setState(boolean state) {
                    this.state = state;
                }

                public boolean isStorage_state() {
                    return storage_state;
                }

                public void setStorage_state(boolean storage_state) {
                    this.storage_state = storage_state;
                }

                public String getGroupbuy_info() {
                    return groupbuy_info;
                }

                public void setGroupbuy_info(String groupbuy_info) {
                    this.groupbuy_info = groupbuy_info;
                }

                public String getXianshi_info() {
                    return xianshi_info;
                }

                public void setXianshi_info(String xianshi_info) {
                    this.xianshi_info = xianshi_info;
                }

                public String getPintuan_info() {
                    return pintuan_info;
                }

                public void setPintuan_info(String pintuan_info) {
                    this.pintuan_info = pintuan_info;
                }

                public Object getBargain_info() {
                    return bargain_info;
                }

                public void setBargain_info(Object bargain_info) {
                    this.bargain_info = bargain_info;
                }

                public String getMgdiscount_info() {
                    return mgdiscount_info;
                }

                public void setMgdiscount_info(String mgdiscount_info) {
                    this.mgdiscount_info = mgdiscount_info;
                }

                public int getCart_id() {
                    return cart_id;
                }

                public void setCart_id(int cart_id) {
                    this.cart_id = cart_id;
                }

                public int getBl_id() {
                    return bl_id;
                }

                public void setBl_id(int bl_id) {
                    this.bl_id = bl_id;
                }

                public String getGoods_total() {
                    return goods_total;
                }

                public void setGoods_total(String goods_total) {
                    this.goods_total = goods_total;
                }

                public String getGoods_image_url() {
                    return goods_image_url;
                }

                public void setGoods_image_url(String goods_image_url) {
                    this.goods_image_url = goods_image_url;
                }
            }
        }
    }
}
