package com.example.green.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.customs.MyBottomView;
import com.example.green.model.HomePageModel;
import com.example.green.ui.fragment.ClassifyFragment;
import com.example.green.ui.fragment.HomeFragment;
import com.example.green.ui.fragment.MineFragment;
import com.example.green.ui.fragment.ShopFragment;
import com.example.green.ui.fragment.StoreFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity<CommonPresenter, HomePageModel>
        implements ICommonView, MyBottomView.OnBottomClick {
    private static final String TAG = "MainActivity";

    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    private MyBottomView mBottomView;
    private final int HOME = 1;
    private final int STORE = 2;
    private final int CLASSIFY = 3;
    private final int SHOP = 4;
    private final int MINE = 5;
    private FragmentManager mManager;


    @Override
    protected void initView() {
        mBottomView = findViewById(R.id.bottom_view);
        mBottomView.setBottomBg(Color.WHITE);
        mBottomView.setBottomTextSize(this, 10f);
        mBottomView.setOnBottomClickListener(this);
        mManager = getSupportFragmentManager();
        showFragment(HOME);
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
        return R.layout.activity_main;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @Override
    public void onFirstClick() {
        showFragment(HOME);
    }

    @Override
    public void onSecondClick() {
        showFragment(STORE);
    }

    @Override
    public void onThirdClick() {
        showFragment(CLASSIFY);
    }

    @Override
    public void onFourthClick() {
        showFragment(SHOP);
    }

    @Override
    public void onFifthClick() {
        showFragment(MINE);
    }

    private void showFragment(int index) {
        FragmentTransaction fragmentTransaction = mManager.beginTransaction();
        switch (index) {
            case HOME:
                fragmentTransaction.replace(R.id.frame_layout, HomeFragment.newInstance());
                break;
            case STORE:
                fragmentTransaction.replace(R.id.frame_layout, StoreFragment.newInstance());
                break;
            case CLASSIFY:
                fragmentTransaction.replace(R.id.frame_layout, ClassifyFragment.newInstance());
                break;
            case SHOP:
                fragmentTransaction.replace(R.id.frame_layout, ShopFragment.newInstance());
                break;
            case MINE:
                fragmentTransaction.replace(R.id.frame_layout, MineFragment.newInstance());
                break;
        }
        fragmentTransaction.commit();
    }
}
