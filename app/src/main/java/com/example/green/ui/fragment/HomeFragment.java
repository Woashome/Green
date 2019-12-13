package com.example.green.ui.fragment;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.green.R;
import com.example.green.adapter.homepage.MyBoutiqueItemAdapter;
import com.example.green.adapter.homepage.MyOptionsItemAdapter;
import com.example.green.adapter.homepage.MyRecommendGoodsItemAdapter;
import com.example.green.base.BaseMvpFragment;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.bean.homepage.GoodsListbean;
import com.example.green.bean.homepage.HomePgaeList;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.model.HomePageModel;
import com.example.green.ui.activity.GoodsDetailsActivity;
import com.example.green.ui.activity.PayModeActivity;
import com.example.green.ui.activity.SearchActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yiyatech.utils.ext.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseMvpFragment<CommonPresenter, HomePageModel>
        implements ICommonView {
    private static final String TAG = "HomeFragment";
    private static HomeFragment fragment;
    private int page = 1;

    @BindView(R.id.top_1)
    ImageView top;
    @BindView(R.id.iv_1)
    ImageView img_1;
    @BindView(R.id.iv_2)
    ImageView img_2;
    @BindView(R.id.iv_3)
    ImageView img_3;
    @BindView(R.id.iv_4)
    ImageView img_4;
    @BindView(R.id.iv_5)
    ImageView img_5;
    @BindView(R.id.iv_6)
    ImageView img_6;
    @BindView(R.id.name1)
    TextView name_1;
    @BindView(R.id.name2)
    TextView name_2;
    @BindView(R.id.name3)
    TextView name_3;
    @BindView(R.id.name4)
    TextView name_4;
    @BindView(R.id.up_promotion)
    TextView name_5;
    @BindView(R.id.up_promotion_info)
    TextView name_6;
    @BindView(R.id.down_promotion)
    TextView name_7;
    @BindView(R.id.down_promotion_info)
    TextView name_8;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.search_key)
    TextView searchKey;
    @BindView(R.id.information)
    ImageView mInformation;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.option)
    RecyclerView mOption;
    @BindView(R.id.adv_img)
    ImageView mImageView;
    @BindView(R.id.boutique)
    RecyclerView mBoutique;
    @BindView(R.id.seckill)
    RecyclerView mSeckill;
    @BindView(R.id.SmartRefresh)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.more_goods)
    RecyclerView mRecommendGoods;

    private List<HomePgaeList.ResultBean.ChartBean> mChart;
    private List<String> imgs;
    private List<HomePgaeList.ResultBean.MenuBean> mMenu;
    private List<HomePgaeList.ResultBean.PromotionBean> mPromotion;
    private MyOptionsItemAdapter mMyOptionsItemAdapter;
    private MyBoutiqueItemAdapter mMyBoutiqueItemAdapter;
    private MyBoutiqueItemAdapter mMySeckillItemAdapter;
    private MyRecommendGoodsItemAdapter mMyRecommendGoodsItemAdapter;
    private List<HomePgaeList.ResultBean.DiscountBean.DateBean> mData_left;
    private List<HomePgaeList.ResultBean.DiscountBean.DateBean> mData_right;
    private List<HomePgaeList.ResultBean.DiscountBean.DateBean.GoodsInfoBean> mBoutique_goods;
    private List<HomePgaeList.ResultBean.DiscountBean.DateBean.GoodsInfoBean> mSeckill_goods;
    private List<GoodsListbean.ResultBean> mRecommend;
    private GoodsListbean mResultBean;
    Activity mActivity;

    public static HomeFragment newInstance() {
        if (fragment == null) fragment = new HomeFragment();
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected HomePageModel initModel() {
        return new HomePageModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        mActivity = getActivity();
        mToolbar.setTitle("");
        AppCompatActivity appCompatActivity = (AppCompatActivity) mActivity;
        appCompatActivity.setSupportActionBar(mToolbar);

        mChart = new ArrayList<>(); // 轮播图
        imgs = new ArrayList<>(); // 轮播图图片
        mMenu = new ArrayList<>(); // 菜单
        mData_left = new ArrayList<>(); // 左侧超值好货
        mBoutique_goods = new ArrayList<>(); // 精品
        mData_right = new ArrayList<>(); // 右侧热品限时
        mSeckill_goods = new ArrayList<>(); // 秒杀
        mPromotion = new ArrayList<>();
        mRecommend = new ArrayList<>(); // 商品推荐

        mMyOptionsItemAdapter = new MyOptionsItemAdapter(R.layout.layout_option_item, mMenu);
        mOption.setLayoutManager(new GridLayoutManager(getContext(), 5, LinearLayoutManager.VERTICAL, false));
        mOption.setNestedScrollingEnabled(false); //禁止滑动
        mOption.setAdapter(mMyOptionsItemAdapter);
        // 超值精品
        mMyBoutiqueItemAdapter = new MyBoutiqueItemAdapter(R.layout.layout_boutique_item, mBoutique_goods);
        mBoutique.setLayoutManager(new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false));
        mBoutique.setNestedScrollingEnabled(false); //禁止滑动
        mBoutique.setAdapter(mMyBoutiqueItemAdapter);
        // 限时秒杀
        mMySeckillItemAdapter = new MyBoutiqueItemAdapter(R.layout.layout_seckill_item, mSeckill_goods);
        mSeckill.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));
        mSeckill.setNestedScrollingEnabled(false); //禁止滑动
        mSeckill.setAdapter(mMySeckillItemAdapter);

        mMyRecommendGoodsItemAdapter = new MyRecommendGoodsItemAdapter(R.layout.layout_recommendgoods_item, mRecommend);
        mRecommendGoods.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));
        mRecommendGoods.setAdapter(mMyRecommendGoodsItemAdapter);

        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                if (null != mResultBean.getResult()) {
                    mResultBean.getResult().clear();
                    mPresenter.getData(ApiConfig.URL_HOMEDATA, LoadConfig.REFRESH);
                }
                if (null != mRecommend) {
                    mRecommend.clear();
                    mPresenter.getData(ApiConfig.URL_GOODSDATA, 6, page, LoadConfig.REFRESH);
                }
                mSmartRefreshLayout.finishRefresh();
            }
        });

        mSmartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                if (null != mResultBean) {
                    mPresenter.getData(ApiConfig.URL_GOODSDATA, 6, ++page, LoadConfig.LOADMORE);
                }
                mSmartRefreshLayout.finishLoadmore();
            }
        });

        // 热品限时
        mMySeckillItemAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.rl:
                        Intent intent = new Intent(getContext(), GoodsDetailsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("goodsId", mSeckill_goods.get(position).getGoods_id() + "");
                        intent.putExtras(bundle);
                        getActivity().startActivity(intent);
                        break;
                }
            }
        });


        // 超值好货
        mMyBoutiqueItemAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.rl:
                        Intent intent = new Intent(getContext(), GoodsDetailsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("goodsId", mBoutique_goods.get(position).getGoods_id() + "");
                        intent.putExtras(bundle);
                        getActivity().startActivity(intent);
                        break;
                }
            }
        });

        // 推荐商品列表
        mMyRecommendGoodsItemAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.goods_card:
                        Intent intent = new Intent(getContext(), GoodsDetailsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("goodsId", mRecommend.get(position).getGoods_id() + "");
                        intent.putExtras(bundle);
                        getActivity().startActivity(intent);
                        break;
                }
            }
        });

    }

    @Override
    protected void initData() {
        mPresenter.getData(ApiConfig.URL_HOMEDATA, LoadConfig.NORMAL);
        // 推荐商品
        mPresenter.getData(ApiConfig.URL_GOODSDATA, 6, page, LoadConfig.NORMAL);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.URL_HOMEDATA:
                HomePgaeList homePgaeLists = (HomePgaeList) t[0];
                if (null != homePgaeLists) {
                    HomePgaeList.ResultBean result = homePgaeLists.getResult();

                    List<HomePgaeList.ResultBean.ChartBean>
                            chart = result.getChart();
                    List<HomePgaeList.ResultBean.MenuBean>
                            menu = result.getMenu();
                    List<HomePgaeList.ResultBean.TransverseBean>
                            transverse = result.getTransverse();
                    List<HomePgaeList.ResultBean.DiscountBean.DateBean>
                            date = result.getDiscount().getDate();
                    List<String> title = result.getDiscount().getTitle();
                    List<HomePgaeList.ResultBean.PromotionBean>
                            promotion = result.getPromotion();
                    int loadType = (int) t[1]; // 加载方式
                    if (loadType == LoadConfig.NORMAL) {
                        // 轮播图
                        mChart.addAll(chart);
                        for (int i = 0; i < mChart.size(); i++) {
                            imgs.add(mChart.get(i).getAdv_code());
                        }
                        // 选项菜单
                        mMenu.addAll(menu);
                        // 精品
                        for (int i = 0; i < 6; i++) {
                            mData_left.add(date.get(i));
                        }
                        for (int i = 0; i < mData_left.size(); i++) {
                            mBoutique_goods.add(mData_left.get(i).getGoodsInfo());
                        }

                        // 秒杀
                        for (int i = 6; i < date.size(); i++) {
                            mData_right.add(date.get(i));
                        }
                        for (int i = 0; i < mData_right.size(); i++) {
                            mSeckill_goods.add(mData_right.get(i).getGoodsInfo());
                        }
                        // 超值好货-数码精品
                        String s = title.get(0);
                        String[] split = s.split("-");
                        name_1.setText(split[0]);
                        name_2.setText(split[1]);
                        // 热品限时-超值秒杀
                        String s1 = title.get(1);
                        String[] split1 = s1.split("-");
                        name_3.setText(split1[0]);
                        name_4.setText(split1[1]);
                        // 天然山货-大自然的馈赠
                        String s2 = title.get(2);
                        String[] split2 = s2.split("-");
                        name_5.setText(split2[0]);
                        name_6.setText(split2[1]);
                        // 海鲜大咖-海的味道我知道
                        String s3 = title.get(3);
                        String[] split3 = s3.split("-");
                        name_7.setText(split3[0]);
                        name_8.setText(split3[1]);

                        // 促销
                        mPromotion.addAll(promotion);
                        Glide.with(getContext()).load(promotion.get(0).getAdv_code()).into(top);
                        Glide.with(getContext()).load(promotion.get(1).getAdv_code()).into(img_1);
                        Glide.with(getContext()).load(promotion.get(2).getAdv_code()).into(img_2);
                        Glide.with(getContext()).load(promotion.get(3).getAdv_code()).into(img_3);
                        Glide.with(getContext()).load(promotion.get(4).getAdv_code()).into(img_4);
                        Glide.with(getContext()).load(promotion.get(5).getAdv_code()).into(img_5);
                        Glide.with(getContext()).load(promotion.get(6).getAdv_code()).into(img_6);


                    } else if (loadType == LoadConfig.REFRESH) {
                        mChart.clear();
                        imgs.clear();
                        mMenu.clear();
                        mData_left.clear();
                        mBoutique_goods.clear();
                        mData_right.clear();
                        mSeckill_goods.clear();
                        mPromotion.clear();
                        /*
                         * 顶部轮播图
                         * */
                        mChart.addAll(result.getChart());
                        for (int i = 0; i < mChart.size(); i++) {
                            imgs.add(mChart.get(i).getAdv_code());
                        }
                        mMenu.addAll(result.getMenu());
                        /*
                         * 精品
                         * */
                        for (int i = 0; i < 6; i++) {
                            mData_left.add(result.getDiscount().getDate().get(i));
                        }
                        for (int i = 0; i < mData_left.size(); i++) {
                            mBoutique_goods.add(mData_left.get(i).getGoodsInfo());
                        }
                        /*
                         * 秒杀
                         * */
                        for (int i = 6; i < result.getDiscount().getDate().size(); i++) {
                            mData_right.add(result.getDiscount().getDate().get(i));
                        }
                        for (int i = 0; i < mData_right.size(); i++) {
                            mSeckill_goods.add(mData_right.get(i).getGoodsInfo());
                        }
                        mSmartRefreshLayout.finishRefresh();
                    }
                    initBanner();
                    Glide.with(getContext()).load(transverse.get(0).getAdv_code()).into(mImageView);
                    mMyOptionsItemAdapter.notifyDataSetChanged();

                    mMyBoutiqueItemAdapter.notifyDataSetChanged();

                    mMySeckillItemAdapter.notifyDataSetChanged();
                }
                break;

            case ApiConfig.URL_GOODSDATA:
                mResultBean = (GoodsListbean) t[0];
                if (null != mResultBean) {
                    int loadType = (int) t[1]; // 加载方式
                    if (loadType == LoadConfig.NORMAL) {
                        mRecommend.addAll(mResultBean.getResult());
                    } else if (loadType == LoadConfig.REFRESH) {
                        mRecommend.clear();
                        mRecommend.addAll(mResultBean.getResult());

                    } else if (loadType == LoadConfig.LOADMORE) {
                        mRecommend.addAll(mResultBean.getResult());
                        mSmartRefreshLayout.finishLoadmore();
                    }
                    mMyRecommendGoodsItemAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

    /*
     * 初始化轮播图
     * */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initBanner() {
        mBanner.setIndicatorGravity(BannerConfig.CENTER);//圆点的位置
        mBanner.setImages(imgs)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .isAutoPlay(true)
                .setDelayTime(2000).start();//图片循环滑动的时间2秒

        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                RequestOptions transform = new RequestOptions().transform(new RoundedCorners(20));
                Glide.with(getContext()).load(path).apply(transform).into(imageView);
            }
        }).start();

        mBanner.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 20);
            }
        });
        mBanner.setClipToOutline(true);

        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                switch (position) {
                    case 0:
                        ToastUtils.show(getContext(), "点击了第" + position + "张轮播图 id:" + mChart.get(position).getAdv_id());
                        break;
                    case 1:
                        ToastUtils.show(getContext(), "点击了第" + position + "张轮播图 id:" + mChart.get(position).getAdv_id());
                        break;
                    case 2:
                        ToastUtils.show(getContext(), "点击了第" + position + "张轮播图 id:" + mChart.get(position).getAdv_id());
                        break;
                }
            }
        });
    }

    @OnClick({R.id.information, R.id.rl_search, R.id.top_1, R.id.iv_1, R.id.iv_3, R.id.iv_5, R.id.iv_2, R.id.iv_4, R.id.iv_6})
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), GoodsDetailsActivity.class);
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            default:
                break;
            case R.id.tip_1: // 热卖商品
                break;
            case R.id.iv_1: // 促销右上1
                bundle.putString("goodsId", mPromotion.get(1).getGoodsInfo().getGoods_id() + "");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_3: // 促销右上2
                bundle.putString("goodsId", mPromotion.get(2).getGoodsInfo().getGoods_id() + "");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_5: // 促销右上3
                bundle.putString("goodsId", mPromotion.get(3).getGoodsInfo().getGoods_id() + "");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_2: // 促销右下1
                bundle.putString("goodsId", mPromotion.get(4).getGoodsInfo().getGoods_id() + "");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_4: // 促销右下2
                bundle.putString("goodsId", mPromotion.get(5).getGoodsInfo().getGoods_id() + "");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
                break;
            case R.id.iv_6: // 促销右下3
                bundle.putString("goodsId", mPromotion.get(6).getGoodsInfo().getGoods_id() + "");
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
                break;
            case R.id.information: // 消息
                startActivity(new Intent(getContext(), PayModeActivity.class));
                break;
            case R.id.rl_search: // 搜索
                startActivity(new Intent(getContext(), SearchActivity.class));
                break;
        }
    }
}
