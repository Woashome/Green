package com.example.green.ui.activity.mine.wallet;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.model.MineModel;
import com.example.green.ui.fragment.store.AllGoodsFragment;
import com.example.green.ui.fragment.store.StoreHomePageFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class IntegralActivity extends BaseMvpActivity<CommonPresenter, MineModel>
        implements ICommonView {

    @BindView(R.id.login_back)
    ImageView mLoginBack;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ji)
    TextView mJi;
    @BindView(R.id.ji_ge)
    TextView mJiGe;
    @BindView(R.id.rl_huzhuang)
    LinearLayout mRlHuzhuang;
    @BindView(R.id.rl_tixian)
    LinearLayout mRlTixian;
    @BindView(R.id.fl)
    FrameLayout mFl;
    public static final int FRAGMENT_ONE = 0;
    public static final int FRAGMENT_TWO = 1;
    public FragmentManager fragmentManager;

    @Override
    protected void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected MineModel initModel() {
        return new MineModel();
    }

    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_integral;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.login_back, R.id.rl_huzhuang, R.id.rl_tixian})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login_back:
                finish();
                break;
            case R.id.rl_huzhuang:
                //                selectFragment(FRAGMENT_ONE);
                break;
            case R.id.rl_tixian:
                //                selectFragment(FRAGMENT_TWO);
                break;
        }
    }
    /*public void selectFragment(int position) {//设置传入第几值显示第几个fragment
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (position) {
            case 0:
                if (mStoreHomePageFragment == null) {
                    mStoreHomePageFragment = new StoreHomePageFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("storeId", mStoreId);
                    mStoreHomePageFragment.setArguments(bundle);
                }
                //将原来的Fragment替换掉---此处R.id.fragmen指的是FrameLayout
                ft.replace(R.id.fl, mStoreHomePageFragment);
                break;
            case 1:
                if (mAllGoodsFragment == null) {
                    mAllGoodsFragment =new AllGoodsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("storeId", mStoreId);
                    mAllGoodsFragment.setArguments(bundle);
                }
                ft.replace(R.id.fl, mAllGoodsFragment);
                break;
            default:
                break;
        }
        ft.commit();
    }*/
}
