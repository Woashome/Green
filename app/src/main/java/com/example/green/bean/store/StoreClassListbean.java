package com.example.green.bean.store;

import com.google.gson.annotations.SerializedName;

public class StoreClassListbean {

    /**
     * code : 200
     * result : {"1":{"storeclass_id":1,"storeclass_name":"农副/副食","storeclass_bail":0,"storeclass_sort":8},"2":{"storeclass_id":2,"storeclass_name":"水果","storeclass_bail":0,"storeclass_sort":1},"3":{"storeclass_id":3,"storeclass_name":"蔬菜","storeclass_bail":0,"storeclass_sort":2},"4":{"storeclass_id":4,"storeclass_name":"种苗","storeclass_bail":0,"storeclass_sort":3},"5":{"storeclass_id":5,"storeclass_name":"禽畜牧蛋肉","storeclass_bail":0,"storeclass_sort":4},"6":{"storeclass_id":6,"storeclass_name":"水产","storeclass_bail":0,"storeclass_sort":5},"7":{"storeclass_id":7,"storeclass_name":"中药材","storeclass_bail":0,"storeclass_sort":6},"8":{"storeclass_id":8,"storeclass_name":"坚果干果","storeclass_bail":0,"storeclass_sort":7},"9":{"storeclass_id":9,"storeclass_name":"粮油作物","storeclass_bail":0,"storeclass_sort":9},"10":{"storeclass_id":10,"storeclass_name":"种子","storeclass_bail":0,"storeclass_sort":10},"11":{"storeclass_id":11,"storeclass_name":"食用菌","storeclass_bail":0,"storeclass_sort":11}}
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
         * 1 : {"storeclass_id":1,"storeclass_name":"农副/副食","storeclass_bail":0,"storeclass_sort":8}
         * 2 : {"storeclass_id":2,"storeclass_name":"水果","storeclass_bail":0,"storeclass_sort":1}
         * 3 : {"storeclass_id":3,"storeclass_name":"蔬菜","storeclass_bail":0,"storeclass_sort":2}
         * 4 : {"storeclass_id":4,"storeclass_name":"种苗","storeclass_bail":0,"storeclass_sort":3}
         * 5 : {"storeclass_id":5,"storeclass_name":"禽畜牧蛋肉","storeclass_bail":0,"storeclass_sort":4}
         * 6 : {"storeclass_id":6,"storeclass_name":"水产","storeclass_bail":0,"storeclass_sort":5}
         * 7 : {"storeclass_id":7,"storeclass_name":"中药材","storeclass_bail":0,"storeclass_sort":6}
         * 8 : {"storeclass_id":8,"storeclass_name":"坚果干果","storeclass_bail":0,"storeclass_sort":7}
         * 9 : {"storeclass_id":9,"storeclass_name":"粮油作物","storeclass_bail":0,"storeclass_sort":9}
         * 10 : {"storeclass_id":10,"storeclass_name":"种子","storeclass_bail":0,"storeclass_sort":10}
         * 11 : {"storeclass_id":11,"storeclass_name":"食用菌","storeclass_bail":0,"storeclass_sort":11}
         */

        @SerializedName("1")
        private _$1Bean _$1;
        @SerializedName("2")
        private _$2Bean _$2;
        @SerializedName("3")
        private _$3Bean _$3;
        @SerializedName("4")
        private _$4Bean _$4;
        @SerializedName("5")
        private _$5Bean _$5;
        @SerializedName("6")
        private _$6Bean _$6;
        @SerializedName("7")
        private _$7Bean _$7;
        @SerializedName("8")
        private _$8Bean _$8;
        @SerializedName("9")
        private _$9Bean _$9;
        @SerializedName("10")
        private _$10Bean _$10;
        @SerializedName("11")
        private _$11Bean _$11;

        public _$1Bean get_$1() {
            return _$1;
        }

        public void set_$1(_$1Bean _$1) {
            this._$1 = _$1;
        }

        public _$2Bean get_$2() {
            return _$2;
        }

        public void set_$2(_$2Bean _$2) {
            this._$2 = _$2;
        }

        public _$3Bean get_$3() {
            return _$3;
        }

        public void set_$3(_$3Bean _$3) {
            this._$3 = _$3;
        }

        public _$4Bean get_$4() {
            return _$4;
        }

        public void set_$4(_$4Bean _$4) {
            this._$4 = _$4;
        }

        public _$5Bean get_$5() {
            return _$5;
        }

        public void set_$5(_$5Bean _$5) {
            this._$5 = _$5;
        }

        public _$6Bean get_$6() {
            return _$6;
        }

        public void set_$6(_$6Bean _$6) {
            this._$6 = _$6;
        }

        public _$7Bean get_$7() {
            return _$7;
        }

        public void set_$7(_$7Bean _$7) {
            this._$7 = _$7;
        }

        public _$8Bean get_$8() {
            return _$8;
        }

        public void set_$8(_$8Bean _$8) {
            this._$8 = _$8;
        }

        public _$9Bean get_$9() {
            return _$9;
        }

        public void set_$9(_$9Bean _$9) {
            this._$9 = _$9;
        }

        public _$10Bean get_$10() {
            return _$10;
        }

        public void set_$10(_$10Bean _$10) {
            this._$10 = _$10;
        }

        public _$11Bean get_$11() {
            return _$11;
        }

        public void set_$11(_$11Bean _$11) {
            this._$11 = _$11;
        }

        public static class _$1Bean {
            /**
             * storeclass_id : 1
             * storeclass_name : 农副/副食
             * storeclass_bail : 0
             * storeclass_sort : 8
             */

            private int storeclass_id;
            private String storeclass_name;
            private int storeclass_bail;
            private int storeclass_sort;

            public int getStoreclass_id() {
                return storeclass_id;
            }

            public void setStoreclass_id(int storeclass_id) {
                this.storeclass_id = storeclass_id;
            }

            public String getStoreclass_name() {
                return storeclass_name;
            }

            public void setStoreclass_name(String storeclass_name) {
                this.storeclass_name = storeclass_name;
            }

            public int getStoreclass_bail() {
                return storeclass_bail;
            }

            public void setStoreclass_bail(int storeclass_bail) {
                this.storeclass_bail = storeclass_bail;
            }

            public int getStoreclass_sort() {
                return storeclass_sort;
            }

            public void setStoreclass_sort(int storeclass_sort) {
                this.storeclass_sort = storeclass_sort;
            }
        }

        public static class _$2Bean {
            /**
             * storeclass_id : 2
             * storeclass_name : 水果
             * storeclass_bail : 0
             * storeclass_sort : 1
             */

            private int storeclass_id;
            private String storeclass_name;
            private int storeclass_bail;
            private int storeclass_sort;

            public int getStoreclass_id() {
                return storeclass_id;
            }

            public void setStoreclass_id(int storeclass_id) {
                this.storeclass_id = storeclass_id;
            }

            public String getStoreclass_name() {
                return storeclass_name;
            }

            public void setStoreclass_name(String storeclass_name) {
                this.storeclass_name = storeclass_name;
            }

            public int getStoreclass_bail() {
                return storeclass_bail;
            }

            public void setStoreclass_bail(int storeclass_bail) {
                this.storeclass_bail = storeclass_bail;
            }

            public int getStoreclass_sort() {
                return storeclass_sort;
            }

            public void setStoreclass_sort(int storeclass_sort) {
                this.storeclass_sort = storeclass_sort;
            }
        }

        public static class _$3Bean {
            /**
             * storeclass_id : 3
             * storeclass_name : 蔬菜
             * storeclass_bail : 0
             * storeclass_sort : 2
             */

            private int storeclass_id;
            private String storeclass_name;
            private int storeclass_bail;
            private int storeclass_sort;

            public int getStoreclass_id() {
                return storeclass_id;
            }

            public void setStoreclass_id(int storeclass_id) {
                this.storeclass_id = storeclass_id;
            }

            public String getStoreclass_name() {
                return storeclass_name;
            }

            public void setStoreclass_name(String storeclass_name) {
                this.storeclass_name = storeclass_name;
            }

            public int getStoreclass_bail() {
                return storeclass_bail;
            }

            public void setStoreclass_bail(int storeclass_bail) {
                this.storeclass_bail = storeclass_bail;
            }

            public int getStoreclass_sort() {
                return storeclass_sort;
            }

            public void setStoreclass_sort(int storeclass_sort) {
                this.storeclass_sort = storeclass_sort;
            }
        }

        public static class _$4Bean {
            /**
             * storeclass_id : 4
             * storeclass_name : 种苗
             * storeclass_bail : 0
             * storeclass_sort : 3
             */

            private int storeclass_id;
            private String storeclass_name;
            private int storeclass_bail;
            private int storeclass_sort;

            public int getStoreclass_id() {
                return storeclass_id;
            }

            public void setStoreclass_id(int storeclass_id) {
                this.storeclass_id = storeclass_id;
            }

            public String getStoreclass_name() {
                return storeclass_name;
            }

            public void setStoreclass_name(String storeclass_name) {
                this.storeclass_name = storeclass_name;
            }

            public int getStoreclass_bail() {
                return storeclass_bail;
            }

            public void setStoreclass_bail(int storeclass_bail) {
                this.storeclass_bail = storeclass_bail;
            }

            public int getStoreclass_sort() {
                return storeclass_sort;
            }

            public void setStoreclass_sort(int storeclass_sort) {
                this.storeclass_sort = storeclass_sort;
            }
        }

        public static class _$5Bean {
            /**
             * storeclass_id : 5
             * storeclass_name : 禽畜牧蛋肉
             * storeclass_bail : 0
             * storeclass_sort : 4
             */

            private int storeclass_id;
            private String storeclass_name;
            private int storeclass_bail;
            private int storeclass_sort;

            public int getStoreclass_id() {
                return storeclass_id;
            }

            public void setStoreclass_id(int storeclass_id) {
                this.storeclass_id = storeclass_id;
            }

            public String getStoreclass_name() {
                return storeclass_name;
            }

            public void setStoreclass_name(String storeclass_name) {
                this.storeclass_name = storeclass_name;
            }

            public int getStoreclass_bail() {
                return storeclass_bail;
            }

            public void setStoreclass_bail(int storeclass_bail) {
                this.storeclass_bail = storeclass_bail;
            }

            public int getStoreclass_sort() {
                return storeclass_sort;
            }

            public void setStoreclass_sort(int storeclass_sort) {
                this.storeclass_sort = storeclass_sort;
            }
        }

        public static class _$6Bean {
            /**
             * storeclass_id : 6
             * storeclass_name : 水产
             * storeclass_bail : 0
             * storeclass_sort : 5
             */

            private int storeclass_id;
            private String storeclass_name;
            private int storeclass_bail;
            private int storeclass_sort;

            public int getStoreclass_id() {
                return storeclass_id;
            }

            public void setStoreclass_id(int storeclass_id) {
                this.storeclass_id = storeclass_id;
            }

            public String getStoreclass_name() {
                return storeclass_name;
            }

            public void setStoreclass_name(String storeclass_name) {
                this.storeclass_name = storeclass_name;
            }

            public int getStoreclass_bail() {
                return storeclass_bail;
            }

            public void setStoreclass_bail(int storeclass_bail) {
                this.storeclass_bail = storeclass_bail;
            }

            public int getStoreclass_sort() {
                return storeclass_sort;
            }

            public void setStoreclass_sort(int storeclass_sort) {
                this.storeclass_sort = storeclass_sort;
            }
        }

        public static class _$7Bean {
            /**
             * storeclass_id : 7
             * storeclass_name : 中药材
             * storeclass_bail : 0
             * storeclass_sort : 6
             */

            private int storeclass_id;
            private String storeclass_name;
            private int storeclass_bail;
            private int storeclass_sort;

            public int getStoreclass_id() {
                return storeclass_id;
            }

            public void setStoreclass_id(int storeclass_id) {
                this.storeclass_id = storeclass_id;
            }

            public String getStoreclass_name() {
                return storeclass_name;
            }

            public void setStoreclass_name(String storeclass_name) {
                this.storeclass_name = storeclass_name;
            }

            public int getStoreclass_bail() {
                return storeclass_bail;
            }

            public void setStoreclass_bail(int storeclass_bail) {
                this.storeclass_bail = storeclass_bail;
            }

            public int getStoreclass_sort() {
                return storeclass_sort;
            }

            public void setStoreclass_sort(int storeclass_sort) {
                this.storeclass_sort = storeclass_sort;
            }
        }

        public static class _$8Bean {
            /**
             * storeclass_id : 8
             * storeclass_name : 坚果干果
             * storeclass_bail : 0
             * storeclass_sort : 7
             */

            private int storeclass_id;
            private String storeclass_name;
            private int storeclass_bail;
            private int storeclass_sort;

            public int getStoreclass_id() {
                return storeclass_id;
            }

            public void setStoreclass_id(int storeclass_id) {
                this.storeclass_id = storeclass_id;
            }

            public String getStoreclass_name() {
                return storeclass_name;
            }

            public void setStoreclass_name(String storeclass_name) {
                this.storeclass_name = storeclass_name;
            }

            public int getStoreclass_bail() {
                return storeclass_bail;
            }

            public void setStoreclass_bail(int storeclass_bail) {
                this.storeclass_bail = storeclass_bail;
            }

            public int getStoreclass_sort() {
                return storeclass_sort;
            }

            public void setStoreclass_sort(int storeclass_sort) {
                this.storeclass_sort = storeclass_sort;
            }
        }

        public static class _$9Bean {
            /**
             * storeclass_id : 9
             * storeclass_name : 粮油作物
             * storeclass_bail : 0
             * storeclass_sort : 9
             */

            private int storeclass_id;
            private String storeclass_name;
            private int storeclass_bail;
            private int storeclass_sort;

            public int getStoreclass_id() {
                return storeclass_id;
            }

            public void setStoreclass_id(int storeclass_id) {
                this.storeclass_id = storeclass_id;
            }

            public String getStoreclass_name() {
                return storeclass_name;
            }

            public void setStoreclass_name(String storeclass_name) {
                this.storeclass_name = storeclass_name;
            }

            public int getStoreclass_bail() {
                return storeclass_bail;
            }

            public void setStoreclass_bail(int storeclass_bail) {
                this.storeclass_bail = storeclass_bail;
            }

            public int getStoreclass_sort() {
                return storeclass_sort;
            }

            public void setStoreclass_sort(int storeclass_sort) {
                this.storeclass_sort = storeclass_sort;
            }
        }

        public static class _$10Bean {
            /**
             * storeclass_id : 10
             * storeclass_name : 种子
             * storeclass_bail : 0
             * storeclass_sort : 10
             */

            private int storeclass_id;
            private String storeclass_name;
            private int storeclass_bail;
            private int storeclass_sort;

            public int getStoreclass_id() {
                return storeclass_id;
            }

            public void setStoreclass_id(int storeclass_id) {
                this.storeclass_id = storeclass_id;
            }

            public String getStoreclass_name() {
                return storeclass_name;
            }

            public void setStoreclass_name(String storeclass_name) {
                this.storeclass_name = storeclass_name;
            }

            public int getStoreclass_bail() {
                return storeclass_bail;
            }

            public void setStoreclass_bail(int storeclass_bail) {
                this.storeclass_bail = storeclass_bail;
            }

            public int getStoreclass_sort() {
                return storeclass_sort;
            }

            public void setStoreclass_sort(int storeclass_sort) {
                this.storeclass_sort = storeclass_sort;
            }
        }

        public static class _$11Bean {
            /**
             * storeclass_id : 11
             * storeclass_name : 食用菌
             * storeclass_bail : 0
             * storeclass_sort : 11
             */

            private int storeclass_id;
            private String storeclass_name;
            private int storeclass_bail;
            private int storeclass_sort;

            public int getStoreclass_id() {
                return storeclass_id;
            }

            public void setStoreclass_id(int storeclass_id) {
                this.storeclass_id = storeclass_id;
            }

            public String getStoreclass_name() {
                return storeclass_name;
            }

            public void setStoreclass_name(String storeclass_name) {
                this.storeclass_name = storeclass_name;
            }

            public int getStoreclass_bail() {
                return storeclass_bail;
            }

            public void setStoreclass_bail(int storeclass_bail) {
                this.storeclass_bail = storeclass_bail;
            }

            public int getStoreclass_sort() {
                return storeclass_sort;
            }

            public void setStoreclass_sort(int storeclass_sort) {
                this.storeclass_sort = storeclass_sort;
            }
        }
    }
}
