package com.example.green.model;

import com.example.green.base.ICommonModel;
import com.example.green.base.ICommonView;
import com.example.green.config.ApiConfig;
import com.example.green.net.NetManager;

public class UserModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            /*注册*/
            case ApiConfig.REGISTER:
                String username = (String) t[0];
                String password = (String) t[1];
                String password_confirm = (String) t[2];
                String client = (String) t[3];
                String inviter_code = (String) t[4];
                String sms_captcha = (String) t[5];
                int log_type = (int) t[6]; // 短信类型:1为注册,2为登录,3为找回密码,4绑定手机,5安全验证,默认为1

                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getRegisterbean(username, password, password_confirm,
                                client, inviter_code, sms_captcha, log_type), view, whichApi, 0);
                break;
            /*获取验证码*/
            case ApiConfig.ACCQUIRE_CODE:
                String member_mobile = (String) t[0];
                int type = (int) t[1]; // 短信类型:1为注册,2为登录,3为找回密码

                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getAccquirebean(member_mobile, type), view, whichApi, 0);
                break;
            /*登录*/
            case ApiConfig.LOGIN:
                String user_name = (String) t[0];
                String psw = (String) t[1];
                String Client = (String) t[2];

                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getLoginbean(user_name, psw, Client), view, whichApi, 0);
                break;

        }
    }
}
