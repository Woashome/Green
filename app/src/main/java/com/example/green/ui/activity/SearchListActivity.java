package com.example.green.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.example.green.R;
import com.example.green.adapter.store.MyFragmentAdapter;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.model.HomePageModel;
import com.example.green.ui.fragment.search.SearchGoodsFragment;
import com.example.green.ui.fragment.store.RecommendFragment;
import com.example.green.ui.fragment.store.StoreHomePageFragment;
import com.example.green.ui.fragment.store.StoreclassifyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchListActivity extends BaseMvpActivity<CommonPresenter, HomePageModel>
        implements ICommonView {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.keyword)
    EditText mKeyword;
    @BindView(R.id.tab)
    XTabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    private String keyWord; // 关键词
    private String gcId; // 商品gc_id
    private MyFragmentAdapter mMyFragmentAdapter;
    private List<Fragment> mFragments;
    private static final String TAG = "SearchListActivity";
    @Override
    protected void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        Intent intent = getIntent();
        keyWord = intent.getStringExtra("keyword");
        gcId = intent.getStringExtra("gcId");
        Log.e(TAG, "initView: "+keyWord );
        Log.e(TAG, "initView: "+gcId );
        mFragments = new ArrayList<>();
        SearchGoodsFragment searchGoodsFragment_synthesize = SearchGoodsFragment.newInstance(keyWord,gcId,0);
        SearchGoodsFragment searchGoodsFragment_sales = SearchGoodsFragment.newInstance(keyWord,gcId,3);
        SearchGoodsFragment searchGoodsFragment_price = SearchGoodsFragment.newInstance(keyWord,gcId,2);

        mFragments.add(searchGoodsFragment_synthesize);
        mFragments.add(searchGoodsFragment_sales);
        mFragments.add(searchGoodsFragment_price);


        mMyFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), mFragments);
        mTab.addTab(mTab.newTab().setText("综合"));
        mTab.addTab(mTab.newTab().setText("销量"));
        mTab.addTab(mTab.newTab().setText("价格"));
        mVp.setAdapter(mMyFragmentAdapter);

        mVp.setCurrentItem(0);
        mTab.addOnTabSelectedListener(new XTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(XTabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(XTabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(XTabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new XTabLayout.TabLayoutOnPageChangeListener(mTab));
        mKeyword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //点击搜索的时候隐藏软键盘
                    hideKeyboard(mKeyword);
                    // 在这里写搜索的操作,一般都是网络请求数据
                    mPresenter.getData(ApiConfig.SEARCH_GOODS);
                    return true;
                }

                return false;
            }
        });

    }

    @Override
    protected void initData() {
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
        }
    }
    /**
     * 隐藏软键盘
     * @param view    :一般为EditText
     */
    public void hideKeyboard(View view) {
        InputMethodManager manager = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
