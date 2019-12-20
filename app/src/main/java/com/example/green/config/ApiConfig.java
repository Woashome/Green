package com.example.green.config;

public class ApiConfig {

    public static final int SEARCH_GOODS = 10; // 搜索商品
    /*首页*/
    public static final int URL_HOMEDATA = 0;  // 首页数据
    public static final int SYSTEM_MESSAGE = 22;  // 消息列表
    public static final int URL_GOODSDATA = 1;   // 商品推荐
    public static final int HOT_SEARCH_KEY = 2; // 搜索页面热门搜索词
    public static final int GOODS_DETAILS = 13; // 商品详情

    /*分类*/
    public static final int URL_ALLCLASSIFY = 3;   // 分类首页
    public static final int URL_RIGHTCLASSIFY = 4;   // 右侧分类

    /*店铺*/
    public static final int RECOMMEND_STORE = 5; // 推荐店铺
    public static final int STORE_CLASSIFY = 6; // 店铺分类
    public static final int STORE_INFO = 7; // 店铺首页
    public static final int STORE_RECOMMEND = 8; // 店铺首页推荐商品
    public static final int ALL_STOREGOODS = 9; // 全部商品(获取店铺商品)

    /*我的*/
    public static final int MINEINFO = 11; // 我的信息
    public static final int COLLEGE = 12; // 商学院
    public static final int LOGOUT = 17; // 退出登录
    public static final int SHOPPING_ADDRESS = 18; // 收货地址列表
    public static final int ADDADDRESS = 19; // 添加收货地址
    public static final int EDITOR_ADDRESS = 20; // 编辑收货地址
    public static final int DELETE_ADDRESS = 21; // 删除收货地址


    /*注册 登录*/
    public static final int REGISTER = 14; // 注册
    public static final int ACCQUIRE_CODE = 15; // 验证码发送
    public static final int LOGIN = 16; // 登录
    public static final int MODIFICATION_PSW = 23; // 登陆密码修改-修改登陆密码
    public static final int CHANGE_PAYPSW = 24; // 登陆密码修改-修改登陆密码

    // 支付
    public static final int URL_USESHOUYI = 22; // 收益支付
    public static final int URL_USECODE = 23; // 观影码支付
    public static final int PAYFOR = 24; // 购买支付，movie/moviePayInfo?movieId=28   back：影片信息，价格，订单号，支付方式
    public static final int PAYPARAMS = 25; // 获取支付参数  movie/payParams?orderId=105&channelId=8&clientIp=192.168.1.7
    public static final int URL_ORDERSTATUS = 26; // 查询订单状态


    public static final int URL_LOGINLICENSE = 36; // 用户登录协议及政策
    public static final int URL_WATCHRECORD = 37; // 观影记录
    public static final int URL_USERCODE = 38; // 用户观影码
    public static final int URL_ORDER = 39; // 订单列表
    public static final int URL_ORDERDETAILS = 40; // 订单详情
    public static final int URL_USERBIND = 41; // 用户绑定信息
    public static final int FEEDBACK = 42; // 用户反馈
    public static final int ABOUTUS = 43; // 关于我们
    public static final int USERTRADE = 44; // 用户收益详情
    public static final int URL_DAYLABEL = 45; // 我的日签
    public static final int ADDCODE = 46; // 添加观影码
    public static final int USABLECODE = 47; // 用户可用兑换码

    public static final int NEWVERSION = 49; // 新版本
    public static final int REMOVE_BIND = 50; // 解除绑定
    public static final int BINDTHIRD = 51; // 绑定第三方账号

    //星球页面
    public static final int URL_WATCH_LIST = 100; // 星球列表
    public static final int URL_WATCH_USER_LIST = 101; // 星球用户
    public static final int URL_WATCH_INVITER_INFO = 102; // 获取邀请人的信息
    public static final int URL_WATCH_INVITER_OTHER = 103; // 去邀请他人
    public static final int URL_MESSAGE_INVITER = 104; // 他人的邀请
    public static final int URL_MESSAGE_INVITER_OK = 105; //接受 他人的邀请
    public static final int URL_MESSAGE_INVITER_CANCEL = 106; //拒绝 他人的邀请
    public static final int URL_MESSAGE_USER_DETAIL = 107; //获取主控的消息
    public static final int URL_EDIT_USER_INFO = 108; //设置用户的数据
    public static final int URL_UPLOAD_PICTURE = 109; //上传图片
    public static final int URL_UPLOAD_NICK_NAME = 120; //修改昵称
    public static final int URL_USER_INFO_DETAILS = 121; // 用户信息,另外的接口\
    public static final int URL_USER_LOCATION_PROVINCE = 122; // 获取省份
    public static final int URL_USER_LOCATION_CITY = 123; // 获取城市
    public static final int URL_USER_LOCATION_COUNTY = 124; // 获取县城
    public static final int URL_CREATE_POSTER_DOWN = 125; // 生成海报,供下载使用(目前的逻辑没有使用)
    public static final int URL_UPLOAD_WATCH_PROGRESS = 126; // 保存播放进度


    //提现
    public static final int CASHOUT_INFO = 200;//提现信息
    public static final int APPLY_CASHOUT = 201;//提现申请
    public static final int SAVE_ALIPAY_INFO = 202;//保存支付宝信息
    public static final int PROMOTION_APPLY = 203;


}
