package com.example.green.ui.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.green.R;
import com.example.green.base.BaseMvpFragment;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.bean.mine.MineInfobean;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.model.MineModel;
import com.example.green.ui.activity.mine.WalletActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseMvpFragment<CommonPresenter, MineModel>
        implements ICommonView {

    static MineFragment fragment;

    @BindView(R.id.header)
    ImageView mHeader;
    @BindView(R.id.user_name)
    TextView mUserName;
    @BindView(R.id.user_phone)
    TextView mUserPhone;
    @BindView(R.id.rl_join)
    RelativeLayout mRlJoin;
    @BindView(R.id.tuiguang)
    RelativeLayout mTuiguang;
    @BindView(R.id.wait_pay_ll)
    LinearLayout mWaitPayLl;
    @BindView(R.id.wait_deliver_ll)
    LinearLayout mWaitDeliverLl;
    @BindView(R.id.finish_ll)
    LinearLayout mFinishLl;
    @BindView(R.id.finish_num)
    TextView mFinishNum;
    @BindView(R.id.cancel_ll)
    LinearLayout mCancelLl;
    @BindView(R.id.rl_status)
    RelativeLayout mRlStatus;
    @BindView(R.id.rl_info)
    RelativeLayout mRlInfo;
    @BindView(R.id.rl_login_password)
    RelativeLayout mRlLoginPassword;
    @BindView(R.id.rl_pay_password)
    RelativeLayout mRlPayPassword;
    @BindView(R.id.rl_site)
    RelativeLayout mRlSite;
    @BindView(R.id.rl_quit)
    RelativeLayout mRlQuit;

    private String key = "bd271df2d303ad1cefc8f21e99a70431";  // token

    public static MineFragment newInstance() {
        if (fragment == null) fragment = new MineFragment();
        return fragment;
    }

    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected MineModel initModel() {
        return new MineModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mPresenter.getData(ApiConfig.MINEINFO, key, LoadConfig.NORMAL);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.MINEINFO:
                MineInfobean mineInfobeans = (MineInfobean) t[0];
                if (null != mineInfobeans) {
                    MineInfobean.ResultBean.MemberInfoBean
                            member_info = mineInfobeans.getResult().getMember_info();
                    RequestOptions options = new RequestOptions().circleCrop();
                    Glide.with(getContext()).load(member_info.getAvator()).apply(options).into(mHeader);
                    mUserName.setText(member_info.getUser_name());
                    mUserPhone.setText(member_info.getMobile());
                }
                break;
        }
    }

    @OnClick({R.id.header, R.id.rl_join, R.id.wait_pay_ll, R.id.wait_deliver_ll,
            R.id.finish_ll, R.id.cancel_ll, R.id.rl_info, R.id.rl_login_password,
            R.id.rl_pay_password, R.id.rl_site, R.id.rl_quit})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.header: // 头像
                break;
            case R.id.rl_join: // 进入钱包
                startActivity(new Intent(getContext(), WalletActivity.class));
                break;
            case R.id.wait_pay_ll: // 待付款
                break;
            case R.id.wait_deliver_ll: // 待发货
                break;
            case R.id.finish_ll: // 已完成
                break;
            case R.id.cancel_ll: // 已取消
                break;
            case R.id.rl_info: // 个人资料
                break;
            case R.id.rl_login_password: // 登录密码
                break;
            case R.id.rl_pay_password: // 支付密码
                break;
            case R.id.rl_site: // 收货地址
                break;
            case R.id.rl_quit: // 退出登录
                break;
        }
    }
}
