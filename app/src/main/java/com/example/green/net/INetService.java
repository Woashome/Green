package com.example.green.net;


import com.example.green.bean.classify.AllClassifyListbean;
import com.example.green.bean.classify.RightClassifyListbean;
import com.example.green.bean.homepage.GoodsListbean;
import com.example.green.bean.homepage.HomePgaeList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface INetService {
    /*
     * 获取首页数据
     * https://shop.bayi-shop.com/mobile/Index/index
     * */
    @GET("Index/index")
    Observable<HomePgaeList> getHomeListbean();

    /*
     * 商品推荐
     * https://shop.bayi-shop.com/mobile/Index/getCommendGoods
     * */
    @GET("Index/getCommendGoods")
    Observable<GoodsListbean> getGoodsList(@Query("limit") int size,
                                           @Query("page") int index);

    /*
     * 店铺列表
     * https://shop.bayi-shop.com/mobile/Storelist/index
     * */


    /*
     * 分类首页
     * https://shop.bayi-shop.com/mobile/goodsclass/index
     * */
    @GET("goodsclass/index")
    Observable<AllClassifyListbean> getClassifyList();

    /*
     * 分类右侧
     * https://shop.bayi-shop.com/mobile/goodsclass/get_child_all.html
     * */
    @GET("goodsclass/get_child_all.html")
    Observable<RightClassifyListbean> getRightClassifyList(@Query("gc_id") int gc_id);



    /*
     *//*
     * 获取验证码
     * https://api.chuanyingtech.com/common/getVerificationCode
     * *//*
    @POST("common/getVerificationCode")
    @FormUrlEncoded
//    @Headers("Content-Type:application/x-www-form-urlencoded")
    Observable<VerifyInfo> getVerify(@Field("phone") String phone);

    *//*
     * 用户登录协议及政策
     * https://api.chuanyingtech.com/login/loginLicense
     * *//*
    @GET("login/loginLicense")
    Observable<PolicyInfo> getPolicy();

    *//*
     * 手机登录
     * https://api.chuanyingtech.com/login/phoneLogin
     * *//*
    @POST("login/phoneLogin")
    @FormUrlEncoded
    Observable<PhoneLoginInfo> getLogin(@Field("phone") String phone,
                                        @Field("verificationCode") String verificationCode,
                                        @Field("inviteUserId") String inviteUserId);

    *//*
     * 极光推送设备激活
     * https://api.chuanyingtech.com/login/activateDevice
     * *//*
    @GET("login/activateDevice")
    Observable<VerifyInfo> getDevice(@Query("deviceId") String deviceId,
                                     @Query("userId") int userId,
                                     @Query("deviceType") int type);

    *//*
     * 登陆输入昵称
     * https://api.chuanyingtech.com/login/enterNick
     * *//*
    @POST("login/enterNick")
    @FormUrlEncoded
    Observable<VerifyInfo> getInputName(@Field("userId") int userId,
                                        @Field("nick") String nick);

    *//*
     * 完善个人信息
     * https://api.chuanyingtech.com/login/enterUserInfo
     * userHeadImage		头像
        gender	性别（0未知，1男，2女）
        birthday	生日（yyyy-MM-dd）
     *
     * *//*
    @POST("login/enterUserInfo")
    Observable<VerifyInfo> getInputUserInfo(@Query("userHeadImage") String userHeadImage,
                                            @Query("gender") String gender,
                                            @Query("birthday") String birthday,
                                            @Query("desc") String desc,
                                            @Query("provinceId") String provinceId,
                                            @Query("cityId") String cityId,
                                            @Query("countryId") String countryId
    );

    *//*
     * 第三方登录
     * https://api.chuanyingtech.com/login/thirdLogin
     * *//*
    @POST("login/thirdLogin")
    @FormUrlEncoded
    Observable<VerifyInfo> getThirdLogin(@Field("loginType") String loginType,
                                         @Field("code") String code);

    *//*
     *  通过accesstoken进行第三方登录
     *  https://api.chuanyingtech.com/login/thirdLoginByAccessToken
     * *//*
    @POST("login/thirdLoginByAccessToken")
    Observable<LoginByAccessTokenInfo> getAccessToken(@Query("loginType") int loginType,
                                                      @Query("unionId") String unionId,
                                                      @Query("accessToken") String accessToken);

    *//*
     *  绑定手机号
     *  https://api.chuanyingtech.com/login/bindPhone
     * *//*
    @POST("login/bindPhone")
    @FormUrlEncoded
    Observable<VerifyInfo> getBindphone(@Field("phone") String phone,
                                        @Field("verificationCode") String verificationCode,
                                        @Field("inviteUserId") String inviteUserId);

    *//*
     * 标签列表
     * https://api.chuanyingtech.com/login/tagList
     * *//*
    @GET("login/tagList")
    Observable<LoginTagInfo> getLoginTagList(@Query("tagType") int tagType,*//*1-导演；2-演员；3-电影类型*//*
                                             @Query("pageIndex") int pageIndex,
                                             @Query("pageSize") int pageSize);

    *//*
     * 选择喜欢导演
     * https://api.chuanyingtech.com/login/enterFavouriteDirector
     * *//*
    @POST("login/enterFavouriteDirector")
    @FormUrlEncoded
    Observable<VerifyInfo> getfavourdirector(@Field("favouriteDirector") String favouriteDirector);

    *//*
     * 选择喜欢演员
     * https://api.chuanyingtech.com/login/enterFavouriteActor
     * *//*
    @POST("login/enterFavouriteActor")
    @FormUrlEncoded
    Observable<VerifyInfo> getfavouractor(@Field("favouriteActor") String favouriteActor);

    *//*
     * 选择喜欢电影类型
     * https://api.chuanyingtech.com/login/enterFavouriteMovieType
     * *//*
    @POST("login/enterFavouriteMovieType")
    @FormUrlEncoded
    Observable<VerifyInfo> getfavourmovietype(@Field("favouriteMovieType") String favouriteMovieType);

    *//*
     * 用户日签
     * https://api.chuanyingtech.com/my/dailyPictureList
     * *//*
    @GET("my/dailyPictureList")
    Observable<DailyTagInfo> getDailyTagList(@Query("userId") String userId,
                                             @Query("pageIndex") int pageIndex,
                                             @Query("pageSize") int pageSize);

    *//*
     * 收益规则
     * https://api.chuanyingtech.com/my/incomeRule
     * *//*
    @GET("my/incomeRule")
    Observable<RuleInfo> getRule();

    *//*
     * 用户收益详情
     * https://api.chuanyingtech.com/my/userTradeList
     * *//*
    @GET("my/userTradeList")
    Observable<UserTradeInfo> getUserTrade();

    *//*
     * 观看记录
     * https://api.chuanyingtech.com/my/playRecordList
     * *//*
    @GET("my/playRecordList")
    Observable<PlayRecordInfo> getPlayRecordList();

    *//*
     * 用户反馈
     * https://api.chuanyingtech.com/my/feedback
     * *//*
    @POST("my/feedback")
    @FormUrlEncoded
    Observable<VerifyInfo> getFeedBack(@Field("userId") int userId,
                                       @Field("feedback") String feedback);

    *//*
     * 关于我们
     * https://api.chuanyingtech.com/my/about
     * *//*
    @GET("my/about")
    Observable<AboutUsInfo> getAboutUs();

    *//*
     * 交易记录
     * https://api.chuanyingtech.com/my/orderList
     * *//*
    @GET("my/orderList")
    Observable<OrderInfo> getOrder(@Query("pageIndex") int pageIndex,
                                   @Query("pageSize") int pageSize);

    *//*
     * 购买支付
     * https://api.chuanyingtech.com/movie/moviePayInfo
     * *//*
    @GET("movie/moviePayInfo")
    Observable<PayForInfo> getMoviePay(@Query("movieId") String movieId);

    *//*
     * 获取支付参数
     * https://api.chuanyingtech.com/movie/payParams
     * *//*
    @GET("movie/payParams")
    Observable<AliPayBean> getPayParams(@Query("orderId") int orderId,
                                        @Query("channelId") int channelId,
                                        @Query("clientIp") String clientIp);

    *//*
     * 订单详情
     * https://api.chuanyingtech.com/my/orderDetail
     * *//*
    @GET("my/orderDetail")
    Observable<OrderDetailsInfo> getOrderDetails(@Query("orderId") int orderId);


    *//*
     * 查询订单状态
     * https://api.chuanyingtech.com/movie/orderInfo
     * *//*
    @GET("movie/orderInfo")
    Observable<OrderStateInfo> getOrderState(@Query("orderId") int orderId,
                                             @Query("time") int time);// 查询次数（客户端记录，从0开始）

    *//*
     * 影片详情
     * https://api.chuanyingtech.com/movie/movieDeatil
     * *//*
    @GET("movie/movieDeatil")
    Observable<MovieDetailsInfo> getMovieDetails(@Query("movieId") String movieId);

    *//*
     * 全部预告片
     * https://api.chuanyingtech.com/movie/movieTrailerList
     * *//*
    @GET("movie/movieTrailerList")
    Observable<MovieTrailerInfo> getMovieTrailer(@Query("movieId") String movieId,
                                                 @Query("pageIndex") int pageIndex,
                                                 @Query("pageSize") int pageSize);

    *//*
     * 全部海报壁纸
     * https://api.chuanyingtech.com/movie/moviePosterList
     * *//*
    @GET("movie/moviePosterList")
    Observable<MoviePosterInfo> getMoviePoster(@Query("movieId") int movieId,
                                               @Query("pageIndex") int pageIndex,
                                               @Query("pageSize") int pageSize);

    *//*
     * 绑定第三方帐号
     * https://api.chuanyingtech.com/login/bindThirdAccountByAccessToken
     * *//*
    @POST("login/bindThirdAccountByAccessToken")
    @FormUrlEncoded
    Observable<BindInfo> getBindThird(@Field("loginType") int loginType,
                                      @Field("unionId") String unionId,
                                      @Field("accessToken") String accessToken);

    *//*
     * 解绑第三方帐号
     * https://api.chuanyingtech.com/login/unbindThirdAccount
     * *//*
    @POST("login/unbindThirdAccount")
    @FormUrlEncoded
    Observable<VerifyInfo> getUnBindThird(@Field("loginType") int loginType,
                                          @Field("mobile") String mobile,
                                          @Field("verifyCode") String verifyCode);

    *//*
     * 退出登录
     * https://api.chuanyingtech.com/login/logout
     * *//*
    @POST("login/logout")
    Observable<VerifyInfo> getExitInfo();

    *//*
     * 绑定兑换码
     * https://api.chuanyingtech.com/my/bindCode
     * *//*
    @POST("my/bindCode")
    @FormUrlEncoded
    Observable<VerifyInfo> getBindCode(@Field("code") String code);

    *//*
     * 获取用户兑换码列表
     * https://api.chuanyingtech.com/my/userCodeList
     * *//*
    @GET("my/userCodeList")
    Observable<UserCodeInfo> getUserCode(@Query("status") int status,
                                         @Query("pageIndex") int pageIndex,
                                         @Query("pageSize") int pageSize);


    *//*
     * 删除用户邀请信息
     * https://api.chuanyingtech.com/my/deleteInvitationInfo
     * *//*
    @POST("my/deleteInvitationInfo")
    @FormUrlEncoded
    Observable<VerifyInfo> getDeleteInvitation(@Field("invitationId") String invitationId);

    *//*
     * 用户绑定信息
     * https://api.chuanyingtech.com/my/userBindInfo
     * *//*
    @GET("my/userBindInfo")
    Observable<UserBindInfo> getUserBindInfo();


    *//*
     * 分享生成海报
     * https://api.chuanyingtech.com/movie/moviePosterShareInfo
     * *//*
    @POST("movie/moviePosterShareInfo")
    @FormUrlEncoded
    Observable<SharePosterInfo> getSharePoster(@Field("posterId") String posterId,
                                               @Field("content") String content);

    *//*
     * 使用观影码支付
     * https://api.chuanyingtech.com/my/useCode
     * *//*
    @POST("my/useCode")
    @FormUrlEncoded
    Observable<OrderStateInfo> getCodePay(@Field("detailId") String detailId,
                                          @Field("orderId") String orderId);

    *//*
     * 收益支付
     * https://api.chuanyingtech.com/movie/userBalancePay
     * *//*
    @POST("movie/userBalancePay")
    @FormUrlEncoded
    Observable<OrderStateInfo> getShouYipay(@Field("orderId") String orderId);


    *//*
     * 获取影片可用兑换码列表
     * https://api.chuanyingtech.com/my/userCodeListByMovieId
     * *//*
    @GET("my/userCodeListByMovieId")
    Observable<UsableCodeInfo> getUsableCode(@Query("movieId") String movieId,
                                             @Query("pageIndex") int pageIndex,
                                             @Query("pageSize") int pageSize);

    *//*
     * 头像-个人信息-点击发送邀请
     * https://api.chuanyingtech.com/movie/inviteUser
     * *//*
    @POST("movie/inviteUser")
    @FormUrlEncoded
    Observable<VerifyInfo> getSendInvitation(@Field("userId") int userId,
                                             @Field("invitedUserId") int invitedUserId,
                                             @Field("movieId") String movieId,
                                             @Field("orderId") String orderId);

    *//*
     * 购买后01邀请好友星球
     * http://front.api.movienow.xtech.fun/planet/planetList
     * *//*
    @GET("planet/planetList")
    Observable<PlanetInfo> getPlanetList();

    *//*
     * 星球用户列表
     * http://front.api.movienow.xtech.fun/planet/userList
     * *//*
    @GET("planet/userList")
    Observable<PlanetUserInfo> getUserList(@Query("planetId") int planetId);

    *//*
     * 启动页广告
     * http://front.api.movienow.xtech.fun/start/startPageAd
     * *//*
    @GET("start/startPageAd")
    Observable<SplashInfo> getSplash();

    *//*
     * 每日签
     * http://front.api.movienow.xtech.fun/start/dailyPicture
     * *//*
    @GET("start/dailyPicture")
    Observable<DailyPictureInfo> getDailyPicture(@Query("currentDate") String currentDate);

    *//*
     * app新版本接口
     * http://front.api.movienow.xtech.fun/start/updateInfo
     * *//*
    @GET("start/updateInfo")
    Observable<UpdateStateInfo> getUpdateState();

    *//*
     * 引导页
     * http://front.api.movienow.xtech.fun/start/advertisementList
     * *//*
    @GET("start/advertisementList")
    Observable<VerifyInfo> getAdvertisement();

    *//*
     * 个人信息
     * http://front.api.movienow.xtech.fun/my/userInfo
     * *//*
    @GET("my/userInfo")
    Observable<MineInfo> getMineInfo();

    *//*
     * 获取邀请口令信息
     * http://front.api.movienow.xtech.fun/movie/getInvitationInfo
     * *//*
    @GET("movie/getInvitationInfo")
    Observable<InvitationInfo> getInvitation(@Query("InvitationCode") String InvitationCode);

    *//*
     * 购买后邀请微信好友
     * http://front.api.movienow.xtech.fun/movie/getInvitationCode
     * *//*
    @POST("movie/getInvitationCode")
    @FormUrlEncoded
    Observable<VerifyInfo> getInvitationCode(@Field("orderId") String orderId,
                                             @Field("movieId") String movieId);


    *//*
     * watch-3. 获取星球列表（购买后01邀请好友星球）
     * http://front.api.movienow.xtech.fun/planet/planetList?pageIndex=2&pageSize=10
     * *//*
    @GET("planet/planetList")
    Observable<WatchStarList> getWatchStarList(@Query("pageIndex") int pageIndex,
                                               @Query("pageSize") int pageSize);


    *//**
     * watch-4. 获取星球好友列表（星球用户列表）
     * http://front.api.movienow.xtech.fun/planet/userList?planetId=8
     *
     * @param planetId 上面接口获取的id
     * @return
     *//*
    @GET("planet/userList")
    Observable<WatchStarItemList> getWatchStarItemList(@Query("pageIndex") int pageIndex,
                                                       @Query("pageSize") int pageSize,
                                                       @Query("planetId") int planetId);


    *//**
     * watch-5. 获取星球好友详细信息（获取邀请人信息）
     * http://front.api.movienow.xtech.fun/my/inviteUserDetail?inviteUserId=3
     *
     * @return
     *//*
    @GET("my/inviteUserDetail")
    Observable<WatchInviterInfo> getWatchInviterInfo(@Query("inviteUserId") int inviteUserId);


    *//**
     * watch-6. 头像-个人信息-点击发送邀请
     * http://front.api.movienow.xtech.fun/movie/inviteUser
     *
     * @return
     *//*

    @GET("movie/inviteUser")
    Observable<WatchInviterOther> getSendInvitation(@Query("userId") String userId,
                                                    @Query("invitedUserId") String invitedUserId,
                                                    @Query("movieId") String movieId,
                                                    @Query("orderId") String orderId);


    *//*
     * watch-7. 用户邀请列表
     *my/userInviteList
     * *//*
    @GET("my/userInviteList")
    Observable<MessageInviteItem> getMessageInvitation(@Query("pageIndex") int pageIndex,
                                                       @Query("pageSize") int pageSize);


    *//*
     * watch-8. 接受邀请
     *my/userInviteList
     * *//*
    @POST("movie/accessInvitation")
    Observable<MessageOk> acceptInvitation(@Query("roomId") int pageIndex);


    *//*
     * watch-9. 拒绝
     *my/userInviteList
     * *//*
    @POST("movie/rejectInvitation")
    Observable<MessageCancel> refuseInvitation(@Query("roomId") int pageIndex);


    *//*
     * watch-10. 获取主被控的消息
     *my/userInviteList
     * *//*
    @GET("movie/movieUserDetail")
    Observable<MovieControlInfo> getMovieUserDetail(
            @Query("movieId") String movieId,
            @Query("roomId") String roomId
    );


    *//**
     * 图片上传
     *
     * @return
     *//*

    @Multipart
    @POST(value = "file/images")
    Observable<PictureUploadBean> uploadPicture(@Part MultipartBody.Part body);


    *//*
     * 获取用户详情
     * http://yapi.xtech.fun/mock/55/my/userDetail
     * *//*
    @GET("my/userDetail")
    Observable<MineInfoDetails> getUserInfoDetails();

    *//**
     * 获取用户提现信息
     * http://yapi.xtech.fun/mock/55/my/userWithdrawInfo
     *//*
    @GET("/my/userWithdrawInfo")
    Observable<AlipayInfo> getCashoutInfo();

    *//**
     * 提现申请
     * http://yapi.xtech.fun/mock/55/my/withdraw
     *//*
    @POST("/my/withdraw")
    @FormUrlEncoded
    Observable<VerifyInfo> getApplyCashout(@Field("amount") String amount);

    *//*
     * 获取所有的城市
     * *//*

    @GET("/login/locationList")
    Observable<MineCityBean> getCityList(@Query("locationType") int locationType);

    *//**
     * 保存用户支付宝信息
     * http://yapi.xtech.fun/mock/55/my/saveUserAlipayInfo
     *//*
    @FormUrlEncoded
    @POST("/my/saveUserAlipayInfo")
    Observable<VerifyInfo> getSaveAlipayInfo(@Field("alipayRealName") String alipayRealName,
                                             @Field("alipayAccount") String alipayAccount);

    *//*
     *  上传播放进度
     *  /moive/saveWatchProgress

     * *//*
    @POST("movie/saveWatchProgress")
    Observable<MovieControlInfo> uploadWatchProgress(
            @Query("roomId") String roomId,
            @Query("watchSeconds") String watchSeconds
    );

    *//**
     * http://yapi.xtech.fun/mock/55/my/applyTalent
     *//*
    @FormUrlEncoded
    @POST("/my/applyTalent")
    Observable<VerifyInfo> getPromotionApply(@Field("description") String description,
                                             @Field("imgArray") String imgArray,
                                             @Field("urlArray") String urlArray);*/
}

