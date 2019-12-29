package com.example.green.ui.activity.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.bean.mine.AddressBean;
import com.example.green.bean.shopping.ShoppingInfobean;
import com.example.green.config.ApiConfig;
import com.example.green.local_utils.SPUtils;
import com.example.green.model.ShopModel;
import com.example.green.model.StoreModel;
import com.example.green.ui.activity.PayModeActivity;
import com.example.green.ui.activity.mine.ShoppingAddressActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AffirmOrderActivity extends BaseMvpActivity<CommonPresenter, ShopModel>
        implements ICommonView {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_site)
    TextView mTvSite;
    @BindView(R.id.person_name)
    TextView mPersonName;
    @BindView(R.id.person_phone)
    TextView mPersonPhone;
    @BindView(R.id.rl_site)
    RelativeLayout mRlSite;
    @BindView(R.id.rl_replace)
    RelativeLayout mRl_Replace;
    @BindView(R.id.rl_address_info)
    RelativeLayout mRl_address;
    @BindView(R.id.store_name)
    TextView mStoreName;
    @BindView(R.id.sp_iv)
    ImageView mSpIv;
    @BindView(R.id.sp_info)
    TextView mSpInfo;
    @BindView(R.id.sp_num)
    TextView mSpNum;
    @BindView(R.id.bt_commit_order)
    Button mBtCommitOrder;
    @BindView(R.id.order_price)
    TextView mOrderPrice;
    private String cart_id;
    private String grossPrice;

    @Override
    protected void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        Intent intent = getIntent();
        cart_id = intent.getStringExtra("cart_id");
        String name = intent.getStringExtra("name");
        String img = intent.getStringExtra("img");
        String prices = intent.getStringExtra("price");
        String store_name = intent.getStringExtra("store_name");
        String num = intent.getStringExtra("num");

        Log.e("zll", "initView: "+ name +"--"+img +"--"+prices +"--"+store_name+"--"+num );

        mStoreName.setText(store_name);
        mSpInfo.setText(name);
        mSpNum.setText(num);

        double v = Double.parseDouble(prices);
        int i = Integer.parseInt(num);
        grossPrice =String.valueOf(v*i);

        mOrderPrice.setText(prices);
        Glide.with(this).load(img).into(mSpIv);


        mRl_Replace.setVisibility(View.VISIBLE);
        mRl_address.setVisibility(View.GONE);
    }

    @Override
    protected void initData() {
        String key = SPUtils.getInstance().getValue(SPUtils.KEY_USER_TOKEN, "");
        String ifcart = "";

        mPresenter.getData(ApiConfig.SHOPPING_STEP_ONE, key, cart_id, ifcart); // 第一步 生成购物信息
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
        return R.layout.activity_affirm_order;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.SHOPPING_STEP_ONE:
                ShoppingInfobean shoppingInfobean = (ShoppingInfobean) t[0];
                if (null != shoppingInfobean && shoppingInfobean.getCode().equals("200")) {

//                    mPresenter.getData(ApiConfig.SHOPPING_STEP_TWO); // 第二步 生成订单

                } else {
                    toastActivity(shoppingInfobean.getMessage());
                }
                break;
        }
    }

    @OnClick({R.id.back, R.id.rl_site, R.id.bt_commit_order})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.rl_site:
                Intent intent_site = new Intent(this, ShoppingAddressActivity.class);
                startActivityForResult(intent_site, 0);//此处的requestCode应与下面结果处理函中调用的requestCode一致
                break;
            case R.id.bt_commit_order:// 提交订单
                Intent intent = new Intent(AffirmOrderActivity.this, PayModeActivity.class);

                startActivity(intent);
                break;
        }
    }

    //结果处理函数，当从secondActivity中返回时调用此函数
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            mRl_Replace.setVisibility(View.GONE);
            mRl_address.setVisibility(View.VISIBLE);
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                String site = bundle.getString("site");
                String name = bundle.getString("name");
                String phone = bundle.getString("phone");
                String addressId = bundle.getString("addressId");

                mTvSite.setText(site);
                mPersonName.setText(name);
                mPersonPhone.setText(phone);
            }
        }
    }
}