package com.example.green.ui.fragment.store;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.green.R;
import com.example.green.adapter.store.MyStoreRecommendListAdapter;
import com.example.green.base.BaseMvpFragment;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.bean.store.StoreInfoListbean;
import com.example.green.bean.store.StoreRecommendListbean;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.model.StoreModel;
import com.yiyatech.utils.ext.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoreHomePageFragment extends BaseMvpFragment<CommonPresenter, StoreModel>
        implements ICommonView {

    static StoreHomePageFragment fragment;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.goods_recyclerview)
    RecyclerView mRecyclerView;
    private List<StoreRecommendListbean.ResultBean.RecGoodsListBean> mRecommendList;
    private List<StoreInfoListbean.ResultBean.StoreInfoBean.MbSlidersBean> mBannerList;
    private List<String> imgs;
    private MyStoreRecommendListAdapter mRecommendListAdapter;
    private String mStoreId;
    private int page = 1;

    public StoreHomePageFragment() {
        // Required empty public constructor
    }

    public static StoreHomePageFragment newInstance() {
        if (fragment == null) {
            fragment = new StoreHomePageFragment();
        }
        return fragment;
    }

    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected StoreModel initModel() {
        return new StoreModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_store_home_page;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        mStoreId = bundle.getString("storeId");
        imgs = new ArrayList<>();
        mBannerList = new ArrayList<>();
        mRecommendList = new ArrayList<>();

        for (int i = 0; i < mBannerList.size(); i++) {
            imgs.add(mBannerList.get(i).getImgUrl());
        }

        mRecommendListAdapter = new MyStoreRecommendListAdapter(R.layout.layout_store_recommend_item, mRecommendList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecyclerView.setAdapter(mRecommendListAdapter);

        mRecommendListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.rl_goods:
                        ToastUtils.show(getContext(), "点击了第" + position + "件商品");
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getData(ApiConfig.STORE_INFO, mStoreId, LoadConfig.NORMAL);
        mPresenter.getData(ApiConfig.STORE_RECOMMEND, mStoreId, page, LoadConfig.NORMAL);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.STORE_INFO:
                StoreInfoListbean storeInfoListbean = (StoreInfoListbean) t[0];
                if (null != storeInfoListbean) {
                    StoreInfoListbean.ResultBean.StoreInfoBean
                            store_info = storeInfoListbean.getResult().getStore_info();
                    mBannerList.addAll(store_info.getMb_sliders());
                    for (int i = 0; i < mBannerList.size(); i++) {
                        imgs.add(mBannerList.get(i).getImgUrl());
                    }
                    initBanner();
                }
                break;
            case ApiConfig.STORE_RECOMMEND:
                StoreRecommendListbean recommendListbeans = (StoreRecommendListbean) t[0];
                if (null != recommendListbeans) {
                    List<StoreRecommendListbean.ResultBean.RecGoodsListBean>
                            rec_goods_list = recommendListbeans.getResult().getRec_goods_list();
                    mRecommendList.addAll(rec_goods_list);
                    mRecommendListAdapter.notifyDataSetChanged();
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
                Glide.with(getContext()).load(path).into(imageView);
            }
        }).start();

        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                switch (position) {
                    case 0:
                        ToastUtils.show(getContext(), "点击了第" + position + "张轮播图 id:" + mBannerList.get(position).getLink());
                        break;
                    case 1:
                        ToastUtils.show(getContext(), "点击了第" + position + "张轮播图 id:" + mBannerList.get(position).getLink());
                        break;
                    /*case 2:
                        ToastUtils.show(StoreInfoActivity.this, "点击了第" + position + "张轮播图 id:" + mChart.get(position).getAdv_id());
                        break;*/
                }
            }
        });
    }
}
