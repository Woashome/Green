package com.example.green.bean.mine;

/**
 * @ProjectName: Green
 * @Package: com.example.green.bean.mine
 * @ClassName: ChangePswbean
 * @Author: hjl
 * @email: 51721997@163.com
 * @Description: 修改支付密码bean
 * @CreateDate: 2019/12/20 16:55
 */
public class ChangePayPswbean {

    /**
     * code : 200
     * result : {"state":1,"msg":"密码设置成功"}
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
         * state : 1
         * msg : 密码设置成功
         */

        private int state;
        private String msg;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
