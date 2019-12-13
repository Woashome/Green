package com.example.green.ui.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.green.R;
import com.example.green.adapter.homepage.MyDetailsRecommendAdapter;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.bean.homepage.DetailsDatabean;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.model.HomePageModel;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsDetailsActivity extends BaseMvpActivity<CommonPresenter, HomePageModel>
        implements ICommonView, NestedScrollView.OnScrollChangeListener {

    @BindView(R.id.details_scroll_view)
    NestedScrollView mScrollView;
    @BindView(R.id.details_toolbar_container)
    LinearLayout mToolbarContainer;
    @BindView(R.id.details_back_image)
    ImageView mToolbarImg;
    @BindView(R.id.details_toolbar_title)
    TextView mToolbarTitle;

    @BindView(R.id.banner)
    Banner mBannerView;
    @BindView(R.id.details_web_view)
    WebView mWebView;
    @BindView(R.id.price)
    TextView mPrice;

    @BindView(R.id.goods_title)
    TextView mGoodsTitle;
    @BindView(R.id.goods_info)
    TextView mGoodsInfo;
    @BindView(R.id.specification)
    TextView mSpecification;
    @BindView(R.id.site)
    TextView mSite;
    @BindView(R.id.iv_store)
    ImageView mIvStore;
    @BindView(R.id.store_name)
    TextView mStoreName;
    @BindView(R.id.sale_num)
    TextView mSaleNum;
    @BindView(R.id.goods_recommend)
    RecyclerView mRecommendRecyclerview;
    @BindView(R.id.ll_go_store)
    LinearLayout mLlGoStore;

    @BindView(R.id.details_finish)
    LinearLayout mDetailsFinish;
    @BindView(R.id.rl_shopping)
    RelativeLayout mRlShopping;
    @BindView(R.id.rl_service)
    RelativeLayout mRlService;
    @BindView(R.id.rl_trolley)
    RelativeLayout mRlTrolley;
    @BindView(R.id.details_add_cart)
    TextView mDetailsAddCart;
    @BindView(R.id.details_buy)
    TextView mDetailsBuy;
    private String goodsId;
    private static final String TAG = "GoodsDetailsActivity";
    /**
     * 偏移量阈值，大于300后Toolbar由全透明变成不透明
     */
    protected float mGradualChange;

    private int mToolbarTopPadding;
    private List<String> imgs;
    private MyDetailsRecommendAdapter mDetailsRecommendAdapter;
    private List<DetailsDatabean.ResultBean.GoodsCommendListBean> mCommendListBeans;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        goodsId = intent.getStringExtra("goodsId");
        Log.e(TAG, "initView: " + goodsId);
        mScrollView.setOnScrollChangeListener(this);
        mToolbarTopPadding = getResources().getDimensionPixelSize(R.dimen.margin_size_24);
        mToolbarContainer.setPadding(0, mToolbarTopPadding, 0, 0);
        mToolbarContainer.getBackground().setAlpha(0);
        mGradualChange = getResources().getDimensionPixelSize(R.dimen.margin_size_300);
        mToolbarTitle.setAlpha(0);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
        //不支持屏幕缩放
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        //不显示webview缩放按钮
        webSettings.setDisplayZoomControls(false);

        imgs = new ArrayList<>();
        mCommendListBeans = new ArrayList<>();
        mDetailsRecommendAdapter = new MyDetailsRecommendAdapter(R.layout.layout_details_recommend_item, mCommendListBeans);
        mRecommendRecyclerview.setLayoutManager(new LinearLayoutManager(GoodsDetailsActivity.this, LinearLayoutManager.HORIZONTAL, false));
        mRecommendRecyclerview.setAdapter(mDetailsRecommendAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.getData(ApiConfig.GOODS_DETAILS, goodsId, LoadConfig.NORMAL);
    }

    @Override
    protected HomePageModel initModel() {
        return new HomePageModel();
    }

    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_goods_details;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.GOODS_DETAILS:
                DetailsDatabean detailsDatabean = (DetailsDatabean) t[0];
                if (null != detailsDatabean) {
                    DetailsDatabean.ResultBean result = detailsDatabean.getResult();
                    imgs.addAll(result.getGoods_image());
                    initBanner();
                    String mobile_body = result.getGoods_info().getMobile_body();
                    /**
                     * 将文本HTML显示在webview中
                     */
                    mWebView.loadDataWithBaseURL(null, getHtmlData(mobile_body), "text/html", "utf-8", null);
                    mPrice.setText(result.getGoods_info().getGoods_price());
                    mGoodsTitle.setText(result.getGoods_info().getGoods_name());
                    mGoodsInfo.setText(result.getGoods_info().getGoods_advword());
                    Glide.with(this).load(result.getStore_info().getStore_avatar()).into(mIvStore);
                    mStoreName.setText(result.getStore_info().getStore_name());
                    mSaleNum.setText("在售商品" + result.getStore_info().getGoods_count() + "件");
                    mCommendListBeans.addAll(result.getGoods_commend_list());
                    mDetailsRecommendAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

    /*
     * 初始化轮播图
     * */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initBanner() {
        mBannerView.setIndicatorGravity(BannerConfig.CENTER);//圆点的位置
        mBannerView.setImages(imgs)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .isAutoPlay(true)
                .setDelayTime(2000).start();//图片循环滑动的时间2秒

        mBannerView.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(GoodsDetailsActivity.this).load(path).into(imageView);
            }
        }).start();
    }

    /**
     * 加载html标签
     *
     * @param bodyHTML
     * @return
     */
    private String getHtmlData(String bodyHTML) {
        String head = "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "<style>img{max-width: 100%; width:auto; height:auto!important;}</style>" +
                "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }

    public void onScrollChange(NestedScrollView nestedScrollView, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        int mMoveDistance = oldScrollY - mToolbarTopPadding;
        int startOffset = 0;
        if (mMoveDistance <= startOffset) {
            mToolbarContainer.getBackground().setAlpha(0);
            mToolbarImg.setBackgroundResource(R.drawable.draw_gray_circle_shape);
            mToolbarTitle.setAlpha(0);
        } else if (mMoveDistance < mGradualChange) {
            int alpha = Math.round(((mMoveDistance - startOffset) / mGradualChange) * 255);
            mToolbarContainer.getBackground().setAlpha(alpha);
            if (mToolbarImg.getBackground() != null) {
                mToolbarImg.getBackground().setAlpha(255 - alpha);
            }
            mToolbarTitle.setAlpha(255 - alpha);
        } else if (mMoveDistance >= mGradualChange) {
            mToolbarContainer.getBackground().setAlpha(255);
            mToolbarImg.setBackgroundResource(0);
            mToolbarTitle.setAlpha(1);
        }
    }


    @OnClick({R.id.look, R.id.rl_select_goods, R.id.rl_select_site, R.id.iv_store, R.id.ll_go_store,
            R.id.details_finish, R.id.rl_shopping,
            R.id.rl_service, R.id.rl_trolley, R.id.details_add_cart, R.id.details_buy})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.look: // 进店逛逛
                break;
            case R.id.rl_select_goods: // 选择商品规格
                break;
            case R.id.rl_select_site: // 选择配送地址
                break;
            case R.id.iv_store: // 店铺头像
                break;
            case R.id.ll_go_store: // 进店
                break;
            case R.id.details_finish: // 返回
                finish();
                break;
            case R.id.rl_shopping: // 商家
                break;
            case R.id.rl_service: // 客服
                break;
            case R.id.rl_trolley: // 购物车
                break;
            case R.id.details_add_cart: // 加入购物车
                break;
            case R.id.details_buy: // 立即购买
                break;
        }
    }
}