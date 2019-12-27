package com.example.green.ui.activity.shopping;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.green.R;
import com.example.green.adapter.homepage.MyRecommendGoodsItemAdapter;
import com.example.green.adapter.store.MyRandomGoodsAdapter;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.bean.store.RandomRecListbean;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.model.ShopModel;
import com.example.green.model.StoreModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PaymentSuccessActivity extends BaseMvpActivity<CommonPresenter, ShopModel>
        implements ICommonView {

    @BindView(R.id.tv_down)
    TextView mTvDown;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.pay_price)
    TextView mPayPrice;
    @BindView(R.id.discounts_price)
    TextView mDiscountsPrice;
    @BindView(R.id.recommend_recycler)
    RecyclerView mRecommendRecycler;
    private MyRandomGoodsAdapter mMyRecommendGoodsItemAdapter;
    private List<RandomRecListbean.ResultBean> mRecommend;

    @Override
    protected void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mRecommend = new ArrayList<>();
        mMyRecommendGoodsItemAdapter = new MyRandomGoodsAdapter(R.layout.layout_recommendgoods_item, mRecommend);
        mRecommendRecycler.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
        mRecommendRecycler.setAdapter(mMyRecommendGoodsItemAdapter);

    }

    @Override
    protected void initData() {
        mPresenter.getData(ApiConfig.RANDOM_GOODS, LoadConfig.NORMAL);
    }

    @Override
    protected ShopModel initModel() {
        return new ShopModel();
    }

    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_payment_success;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.RANDOM_GOODS:
                RandomRecListbean randomRecListbean = (RandomRecListbean) t[0];
                if (null != randomRecListbean && randomRecListbean.getCode().equals("200")) {
                    List<RandomRecListbean.ResultBean> result = randomRecListbean.getResult();
                    mRecommend.addAll(result);
                    mMyRecommendGoodsItemAdapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @OnClick(R.id.tv_down)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_down:
                finish();
                break;
        }
    }
}
