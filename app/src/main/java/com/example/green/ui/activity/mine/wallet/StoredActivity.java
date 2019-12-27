package com.example.green.ui.activity.mine.wallet;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.model.MineModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StoredActivity extends BaseMvpActivity<CommonPresenter, MineModel>
        implements ICommonView {

    @BindView(R.id.login_back)
    ImageView mLoginBack;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.jiang)
    TextView mJiang;
    @BindView(R.id.jiang_ge)
    TextView mJiangGe;
    @BindView(R.id.ll_chongzhi)
    LinearLayout mLlChongzhi;
    @BindView(R.id.jiang_recycler)
    RecyclerView mJiangRecycler;


    @Override
    protected void initView() {

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
        return R.layout.activity_stored;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.login_back, R.id.ll_chongzhi})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login_back:
                finish();
                break;
            case R.id.ll_chongzhi: // 充值
                break;
        }
    }
}
