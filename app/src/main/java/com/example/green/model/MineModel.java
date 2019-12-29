package com.example.green.model;

import com.example.green.base.ICommonModel;
import com.example.green.base.ICommonView;
import com.example.green.config.ApiConfig;
import com.example.green.net.NetManager;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MineModel implements ICommonModel {
    NetManager mNetManager = NetManager.getNetManager();

    @Override
    public void getData(ICommonView view, int whichApi, Object[] t) {
        switch (whichApi) {
            /*个人页面*/
            case ApiConfig.MINEINFO:
                String key = (String) t[0];
                mNetManager.getNetManager().netMethod(mNetManager
                        .getHttpService()
                        .getMineInfo(key), view, whichApi, 0);
                break;
            /*商学院*/
            case ApiConfig.COLLEGE:
                int type = (int) t[0];
                int page = (int) t[1];
                int loadMode = (int) t[2];
                mNetManager.getNetManager().netMethod(mNetManager
                        .getHttpService()
                        .getCollegeList(type, page), view, whichApi, loadMode);
                break;
            /*收货列表*/
            case ApiConfig.SHOPPING_ADDRESS:
                String key_site = (String) t[0];
                mNetManager.getNetManager().netMethod(mNetManager
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
                mNetManager.getNetManager().netMethod(mNetManager
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

                mNetManager.getNetManager().netMethod(mNetManager
                        .getHttpService()
                        .getEditorAddressbean(userToken, name, phone, cityId, areaId, details_site, areaInfo, isDefault, address_id), view, whichApi, 0);
                break;
            /*删除收货地址*/
            case ApiConfig.DELETE_ADDRESS:
                String Key = (String) t[0];
                String AddressId = (String) t[1];

                mNetManager.getNetManager().netMethod(mNetManager
                        .getHttpService()
                        .getDeleteAddressbean(Key, AddressId), view, whichApi, 0);
                break;
            /*用户上传头像*/
            case ApiConfig.URL_UPLOAD_PICTURE://get
                String path = (String) t[0];
                String mtoken = (String) t[1];

                //获取路径对应的文件
                File file = new File(path);
                //得到请求体
                RequestBody fileRQ = RequestBody.create(MediaType.parse("image/jpeg"), file);
                //创建MultipartBody.Part对象
                //注意:这个file是后台定义的参数名
                MultipartBody.Part part = MultipartBody.Part.createFormData("pic", file.getName(), fileRQ);
                MultipartBody.Part part1 = MultipartBody.Part.createFormData("key", mtoken);
                mNetManager.netMethod(mNetManager
                        .getHttpUploadService()
                        .uploadPicture(part, part1), view, whichApi, 0);
                break;
            /*个人资料编辑*/
            case ApiConfig.URL_EDIT_USER_INFO:
                String userkey = (String) t[0];
                int commit = (int) t[1];
                String Name = (String) t[2];
                String Sex = (String) t[3];
                String Email = (String) t[4];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getEditMineInfo(userkey, commit, Name, Sex, Email), view, whichApi, 0);
                break;
            /*实名认证*/
            case ApiConfig.USER_AUTONYM:// post 上传实名身份信息
                int member_id = (int) t[0];
                String user_name = (String) t[1];
                String idcard = (String) t[2];
                String member_bankname = (String) t[3];
                String member_bankcard = (String) t[4];
                String member_idcard_image2 = (String) t[5];
                String member_idcard_image3 = (String) t[6];
                String member_provinceid = (String) t[7];
                String member_cityid = (String) t[8];
                String member_areaid = (String) t[9];
                String member_areainfo = (String) t[10];
                int Commit = (int) t[11];

                RequestBody id = RequestBody.create(null, String.valueOf(member_id));
                RequestBody xingming = RequestBody.create(null, user_name);
                RequestBody IdNumber = RequestBody.create(null, idcard);
                RequestBody bankName = RequestBody.create(null, member_bankname);
                RequestBody bankCard = RequestBody.create(null, member_bankcard);
                RequestBody provinceid = RequestBody.create(null, member_provinceid);
                RequestBody cityid = RequestBody.create(null, member_cityid);
                RequestBody areaid = RequestBody.create(null, member_areaid);
                RequestBody areainfo = RequestBody.create(null, member_areainfo);
                RequestBody commit_type = RequestBody.create(null, String.valueOf(Commit));
                //获取路径对应的文件
                File file_img2 = new File(member_idcard_image2);
                //得到请求体
                RequestBody fileRQ_2 = RequestBody.create(MediaType.parse("image/jpeg"), file_img2);
                //创建MultipartBody.Part对象
                //注意:这个file是后台定义的参数名
                MultipartBody.Part img_2 = MultipartBody.Part.createFormData("member_idcard_image2", file_img2.getName(), fileRQ_2);

                File file_img3 = new File(member_idcard_image3);
                RequestBody fileRQ_3 = RequestBody.create(MediaType.parse("image/jpeg"), file_img3);
                MultipartBody.Part img_3 = MultipartBody.Part.createFormData("member_idcard_image3", file_img3.getName(), fileRQ_3);

                mNetManager.netMethod(mNetManager
                        .getHttpService()
                        .getAutonym(id, xingming, IdNumber, bankName, bankCard,
                                img_2, img_3, provinceid, cityid, areaid, areainfo, commit_type), view, whichApi, 0);
                break;
            /*订单列表*/
            case ApiConfig.GOODSORDER:
                String tokenq = (String) t[0];
                String typeq = (String) t[1];
                String keyq = (String) t[2];
                int prge = (int) t[3];
                int prgesize = (int) t[4];
                int loadModea = (int) t[5];

                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getGoodsOrder(tokenq,typeq,keyq,prge,prgesize), view, whichApi, loadModea);

                break;
            /*生成充值订单并支付*/
            case ApiConfig.GETPAYMENT:
                String Token = (String) t[0];
                String payment_code = (String) t[1];
                String pdr_amount = (String) t[2];
                NetManager.getNetManager().netMethod(NetManager.getNetManager()
                        .getHttpService()
                        .getPayCodeInfo(Token, payment_code, pdr_amount), view, whichApi, 0);
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
