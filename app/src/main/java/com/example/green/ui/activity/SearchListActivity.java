package com.example.green.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.androidkun.xtablayout.XTabLayout;
import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.model.HomePageModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchListActivity extends BaseMvpActivity<CommonPresenter, HomePageModel>
        implements ICommonView {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rl_search_view)
    RelativeLayout mRlSearchView;
    @BindView(R.id.tab)
    XTabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    private String keyWord;
    private int page = 1;
    private int key; // 0为默认综合排序，2为价格排序，3销量排序，5人气排序
    private String gcId;

    @Override
    protected void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

    }

    @Override
    protected void initData() {
        mPresenter.getData(ApiConfig.SEARCH_GOODS, keyWord, page, key, gcId, LoadConfig.NORMAL);
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
        return R.layout.activity_search_list;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
    }

    @OnClick({R.id.back, R.id.rl_search_view})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.rl_search_view:
                startActivity(new Intent(SearchListActivity.this, SearchActivity.class));
                finish();
                break;
        }
    }
}
