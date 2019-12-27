package com.example.green.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.config.ApiConfig;
import com.example.green.model.ShopModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PayModeActivity extends BaseMvpActivity<CommonPresenter, ShopModel>
        implements ICommonView {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.order_sum)
    TextView mOrderSum;
    @BindView(R.id.balance)
    TextView mBalance;
    @BindView(R.id.check_xianjin)
    RadioButton mCheckXianjin;
    @BindView(R.id.bt_payment)
    Button mPayment;


    @Override
    protected void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void initData() {
//        mPresenter.getData(ApiConfig.SHOPPING_THIRD); // 第三步 获取订单信息
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
        return R.layout.activity_pay_mode;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.back, R.id.check_xianjin, R.id.bt_payment})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.check_xianjin:
                break;
            case R.id.bt_payment:
//                mPresenter.getData(ApiConfig.SHOPPING_FOURTH); 第四步 购买
                break;
        }
    }
}
