package com.example.green.net;


import com.example.green.bean.classify.AllClassifyListbean;
import com.example.green.bean.classify.RightClassifyListbean;
import com.example.green.bean.homepage.DetailsDatabean;
import com.example.green.bean.homepage.GoodsListbean;
import com.example.green.bean.homepage.HomePgaeList;
import com.example.green.bean.homepage.HotSearchKeyListbean;
import com.example.green.bean.register.AccquireSmsbean;
import com.example.green.bean.register.CodeVerifybean;
import com.example.green.bean.register.RegisterDatabean;
import com.example.green.bean.homepage.SearchListbean;
import com.example.green.bean.mine.CollegeListbean;
import com.example.green.bean.mine.MineInfobean;
import com.example.green.bean.store.AllStoreListbean;
import com.example.green.bean.store.StoreClassListbean;
import com.example.green.bean.store.StoreInfoListbean;
import com.example.green.bean.store.StoreListbean;
import com.example.green.bean.store.StoreRecommendListbean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface INetService {
    /*
     * 商品搜索
     * https://shop.bayi-shop.com/mobile/goods/goods_list
     * */
    @GET("goods/goods_list")
    Observable<SearchListbean> getSearchList(@Query("keyword") String keyword,
                                             @Query("page") int page,
                                             @Query("key") String key,
                                             @Query("gc_id") String gcId);

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
     * 搜索页面热门搜索词
     * https://shop.bayi-shop.com/mobile/index/search_key_list
     * */
    @GET("index/search_key_list")
    Observable<HotSearchKeyListbean> getHotSearchKeyList();

    /*
     * 商品详情
     * https://shop.bayi-shop.com/mobile/goods/goods_detail
     * */
    @GET("goods/goods_detail")
    Observable<DetailsDatabean> getGoodsDetailsList(@Query("goods_id") String goods_id);

    /*
     * 获取消息列表
     * https://shop.bayi-shop.com/index.php/mobile/Membermessage/systemmsg
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
     * 店铺列表
     * https://shop.bayi-shop.com/mobile/Storelist/index
     * */
    @GET("Storelist/index")
    Observable<StoreListbean> getStoreList(@Query("page") int index);

    /*
     * 店铺首页
     * https://shop.bayi-shop.com/mobile/Store/store_info
     * */
    @GET("Store/store_info")
    Observable<StoreInfoListbean> getStoreInfoList(@Query("store_id") String store_id);

    /*
     * 店铺首页推荐商品
     * https://shop.bayi-shop.com/mobile/Store/GetStoreCommentGoods
     * */
    @GET("Store/GetStoreCommentGoods")
    Observable<StoreRecommendListbean> getStoreRecommendList(@Query("store_id") String store_id,
                                                             @Query("page") int page);

    /*
     * 店铺分类
     * https://shop.bayi-shop.com/mobile/storelist/getStoreClassList
     * */
    @GET("storelist/getStoreClassList")
    Observable<StoreClassListbean> getStoreClassList();

    /*
     * 获取店铺商品
     * https://shop.bayi-shop.com/mobile/Store/store_goods
     * */
    @GET("Store/store_goods")
    Observable<AllStoreListbean> getAllStoreList(@Query("store_id") String store_id,
                                                 @Query("page") int page);

    /*
     * 我的页面
     * https://shop.bayi-shop.com/mobile/member/index
     * */
    @GET("member/index")
    Observable<MineInfobean> getMineInfo(@Query("key") String key);

    /*
     * 商学院
     * https://shop.bayi-shop.com/mobile/college/college
     * article_type: 0-文章 1-视频
     * */
    @GET("college/college")
    Observable<CollegeListbean> getCollegeList(@Query("article_type") int type,
                                               @Query("page") int page);

    /*
     * 注册
     * https://shop.bayi-shop.com/mobile/login/register
     * */
    @POST("login/register")
    @FormUrlEncoded
    Observable<RegisterDatabean> getRegisterbean(@Field("username") String username,
                                                 @Field("password") String password,
                                                 @Field("password_confirm") String password_confirm,
                                                 @Field("client") String client,
                                                 @Field("inviter_code") String inviter_code,
                                                 @Field("sms_captcha") String sms_captcha,
                                                 @Field("log_type") int log_type);

    /*
     * 验证码发送
     * https://shop.bayi-shop.com/mobile/Connect/get_sms_captcha
     * */
    @POST("Connect/get_sms_captcha")
    @FormUrlEncoded
    Observable<AccquireSmsbean> getAccquirebean(@Field("member_mobile") String member_mobile,
                                                @Field("type") int type);

    /*
     * 登录
     * https://shop.bayi-shop.com/mobile/login/index
     * */
    @POST("login/index")
    @FormUrlEncoded
    Observable<RegisterDatabean> getLoginbean(@Field("username") String username,
                                              @Field("password") String password,
                                              @Field("client") String client);

}

