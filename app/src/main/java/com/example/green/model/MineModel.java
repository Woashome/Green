package com.example.green.model;

import com.example.green.base.ICommonModel;
import com.example.green.base.ICommonView;
import com.example.green.config.ApiConfig;
import com.example.green.net.NetManager;

public class MineModel implements ICommonModel {
    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            /*个人页面*/
            case ApiConfig.MINEINFO:
                String key = (String) t[0];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getMineInfo(key), view, whichApi, 0);
                break;
            /*商学院*/
            case ApiConfig.COLLEGE:
                int type = (int) t[0];
                int page = (int) t[1];
                int loadMode = (int) t[2];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getCollegeList(type, page), view, whichApi, loadMode);
                break;
            /*收货列表*/
            case ApiConfig.SHOPPING_ADDRESS:
                String key_site = (String) t[0];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getShoppingAddressList(key_site), view, whichApi, 0);
                break;
            /*添加收货地址*/
            case ApiConfig.ADDADDRESS:
                String true_name = (String) t[0]; // 姓名
                String mob_phone = (String) t[1]; // 手机号
                String city_id = (String) t[2]; // 城市ID
                String area_id = (String) t[3]; // 县/区ID
                String address = (String) t[4]; // 详细地址
                String area_info = (String) t[5]; // 省 市 县   空格拼接
                String is_default = (String) t[6]; // 0不默认，1默认地址
                String user_token = (String) t[7]; // 用户token
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getAddSite(true_name, mob_phone, city_id, area_id, address, area_info, is_default, user_token), view, whichApi, 0);
                break;
            /*编辑收货地址*/
            case ApiConfig.EDITOR_ADDRESS:
                String userToken = (String) t[0]; // 用户token
                String name = (String) t[1]; // 姓名
                String phone = (String) t[2]; // 手机号
                String cityId = (String) t[3]; // 城市ID
                String areaId = (String) t[4]; // 县/区ID
                String details_site = (String) t[5]; // 详细地址
                String areaInfo = (String) t[6]; // 省 市 县   空格拼接
                String isDefault = (String) t[7]; // 0不默认，1默认地址
                String address_id = (String) t[8]; // 收货地址ID

                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getEditorAddressbean(userToken, name, phone, cityId, areaId, details_site, areaInfo, isDefault, address_id), view, whichApi, 0);
                break;
            /*删除收货地址*/
            case ApiConfig.DELETE_ADDRESS:
                String Key = (String) t[0];
                String AddressId = (String) t[1];

                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getDeleteAddressbean(Key, AddressId), view, whichApi, 0);
                break;
            /*退出登录*/
            case ApiConfig.LOGOUT:
                String username = (String) t[0];
                String token = (String) t[1];
                String client = (String) t[2];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getLogOutbean(username, token, client), view, whichApi, 0);
                break;
        }
    }
}
