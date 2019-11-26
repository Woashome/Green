package com.example.green.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.stx.xhb.xbanner.XBanner;

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
    private int page = 0;


    @BindView(R.id.information)
    ImageView mInformation;
    @BindView(R.id.banner)
    XBanner mBanner;
    @BindView(R.id.option)
    RecyclerView mOption;
    @BindView(R.id.boutique)
    RecyclerView mBoutique;
    @BindView(R.id.SmartRefresh)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.more_goods)
    RecyclerView mRecommendGoods;

    private List<HomePgaeList.ResultBean.ChartBean> mChart;
    private List<HomePgaeList.ResultBean.MenuBean> mMenu;
    private MyOptionsItemAdapter mMyOptionsItemAdapter;
    private MyBoutiqueItemAdapter mMyBoutiqueItemAdapter;
    private MyRecommendGoodsItemAdapter mMyRecommendGoodsItemAdapter;

    private List<HomePgaeList.ResultBean.DiscountBean.DateBean.GoodsInfoBean> mGoods;
    private List<HomePgaeList.ResultBean.DiscountBean.DateBean> mData;
    private List<GoodsListbean.ResultBean> mRecommend;
    private GoodsListbean mResultBean;

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
        mChart = new ArrayList<>(); // 轮播图
        mMenu = new ArrayList<>(); // 菜单
        mGoods = new ArrayList<>(); // 精品
        mData = new ArrayList<>();
        mRecommend = new ArrayList<>(); // 商品推荐

        mMyOptionsItemAdapter = new MyOptionsItemAdapter(R.layout.layout_option_item, mMenu);
        mOption.setLayoutManager(new GridLayoutManager(getContext(), 5, LinearLayoutManager.VERTICAL, false));
        mOption.setNestedScrollingEnabled(false); //禁止滑动
        mOption.setAdapter(mMyOptionsItemAdapter);
        mMyBoutiqueItemAdapter = new MyBoutiqueItemAdapter(R.layout.layout_boutique_item, mGoods);
        mBoutique.setLayoutManager(new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false));
        mBoutique.setNestedScrollingEnabled(false); //禁止滑动
        mBoutique.setAdapter(mMyBoutiqueItemAdapter);
        mMyRecommendGoodsItemAdapter = new MyRecommendGoodsItemAdapter(R.layout.layout_recommendgoods_item, mRecommend);
        mRecommendGoods.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));
        mRecommendGoods.setNestedScrollingEnabled(false); //禁止滑动
        mRecommendGoods.setAdapter(mMyRecommendGoodsItemAdapter);
        initBanner();

        mSmartRefreshLayout.setEnableRefresh(false); // 不能刷新
        mSmartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                if (null != mResultBean) {
                    mPresenter.getData(ApiConfig.URL_GOODSDATA, 6, ++page, LoadConfig.LOADMORE);
                }
            }
        });
    }

    private void initBanner() {
        //设置广告图片点击事件
        mBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                Toast.makeText(getContext(), "点击了第" + (position + 1) + "图片", Toast.LENGTH_SHORT).show();
            }
        });
        //加载广告图片
        mBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                //在此处使用图片加载框架加载图片，demo中使用glide加载，可替换成自己项目中的图片加载框架
                for (int i = 0; i < mChart.size(); i++) {
                    Glide.with(getActivity()).load(mChart.get(i).getAdv_code()).into((ImageView) view);
                }
            }
        });
        mBanner.setBannerData(mChart);
    }

    @Override
    protected void initData() {
        mPresenter.getData(ApiConfig.URL_HOMEDATA, LoadConfig.NORMAL);
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
                    // 轮播图
                    mChart = homePgaeLists.getResult().getChart();
                    //刷新数据之后，需要重新设置是否支持自动轮播
                    mBanner.setAutoPlayAble(mChart.size() > 1);
                    mBanner.setBannerData(mChart);
                    // 选项菜单
                    List<HomePgaeList.ResultBean.MenuBean> menu = homePgaeLists.getResult().getMenu();
                    mMenu.addAll(menu);
                    mMyOptionsItemAdapter.notifyDataSetChanged();
                    // 精品
                    List<HomePgaeList.ResultBean.DiscountBean.DateBean> date =
                            homePgaeLists.getResult().getDiscount().getDate();
                    for (int i = 0; i < 6; i++) {
                        mData.add(date.get(i));
                    }
                    for (int i = 0; i < mData.size(); i++) {
                        mGoods.add(mData.get(i).getGoodsInfo());
                    }
                    mMyBoutiqueItemAdapter.notifyDataSetChanged();

                }
                break;

            case ApiConfig.URL_GOODSDATA:
                mResultBean = (GoodsListbean) t[0];
                if (null != mResultBean) {
                    mRecommend.addAll(mResultBean.getResult());

                    int loadType = (int) t[1]; // 加载方式
                    if (loadType == LoadConfig.NORMAL) {
                        mRecommend.clear();
                        mRecommend.addAll(mResultBean.getResult());
                    } else if (loadType == LoadConfig.LOADMORE) {
                        mRecommend.addAll(mResultBean.getResult());
                    }
                    mMyRecommendGoodsItemAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @OnClick(R.id.information)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.information: // 消息
                break;
        }
    }
}
