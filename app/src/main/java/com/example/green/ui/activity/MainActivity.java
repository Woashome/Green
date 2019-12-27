package com.example.green.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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

    String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    List<String> mPermissionList = new ArrayList<>();

    // private ImageView welcomeImg = null;
    private static final int PERMISSION_REQUEST = 1;
    // 检查权限

    @Override
    protected void initView() {
        checkPermission();
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

    private void checkPermission() {
        mPermissionList.clear();

        //判断哪些权限未授予
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(this, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                mPermissionList.add(permissions[i]);
            }
        }
        /**
         * 判断是否为空
         */
        if (mPermissionList.isEmpty()) {//未授予的权限为空，表示都授予了

        } else {//请求权限方法
            String[] permissions = mPermissionList.toArray(new String[mPermissionList.size()]);//将List转为数组
            ActivityCompat.requestPermissions(MainActivity.this, permissions, PERMISSION_REQUEST);
        }
    }

    /**
     * 响应授权
     * 这里不管用户是否拒绝，都进入首页，不再重复申请权限
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST:

                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                break;
        }
    }
}
