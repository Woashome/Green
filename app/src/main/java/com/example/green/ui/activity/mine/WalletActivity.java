package com.example.green.ui.activity.mine;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.model.MineModel;

import butterknife.BindView;
import butterknife.OnClick;

public class WalletActivity extends BaseMvpActivity<CommonPresenter, MineModel> implements ICommonView {


    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.header_iv)
    ImageView mHeaderIv;
    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.number)
    TextView mNumber;
    @BindView(R.id.member)
    ImageView mMember;
    @BindView(R.id.user_level)
    TextView mUserLevel;
    @BindView(R.id.rl_user_level)
    RelativeLayout mRlUserLevel;
    @BindView(R.id.company)
    ImageView mCompany;
    @BindView(R.id.user_company)
    TextView mUserCompany;
    @BindView(R.id.rl_user_company)
    RelativeLayout mRlUserCompany;
    @BindView(R.id.chuzhika_balance)
    TextView mChuzhikaBalance;
    @BindView(R.id.usable_integral)
    TextView mUsableIntegral;
    @BindView(R.id.unuse_integral)
    TextView mUnuseIntegral;
    @BindView(R.id.rl_chongzhi)
    RelativeLayout mRlChongzhi;
    @BindView(R.id.rl_tixian)
    RelativeLayout mRlTixian;
    @BindView(R.id.rl_huzhuan)
    RelativeLayout mRlHuzhuan;
    @BindView(R.id.rl_chuzhi)
    RelativeLayout mRlChuzhi;
    @BindView(R.id.rl_jiaoyi)
    RelativeLayout mRlJiaoyi;
    @BindView(R.id.rl_jifen)
    RelativeLayout mRlJifen;
    @BindView(R.id.rl_shiming)
    RelativeLayout mRlShiming;
    @BindView(R.id.rl_team)
    RelativeLayout mRlTeam;
    @BindView(R.id.rl_yaoqing)
    RelativeLayout mRlYaoqing;

    @Override
    protected void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
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
        return R.layout.activity_wallet;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.back, R.id.rl_user_level, R.id.rl_user_company, R.id.rl_chongzhi, R.id.rl_tixian, R.id.rl_huzhuan, R.id.rl_chuzhi, R.id.rl_jiaoyi, R.id.rl_jifen, R.id.rl_shiming, R.id.rl_team, R.id.rl_yaoqing})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.rl_user_level: // 用户级别
                break;
            case R.id.rl_user_company: // 用户公司
                break;
            case R.id.rl_chongzhi: // 充值
                break;
            case R.id.rl_tixian: // 提现
                break;
            case R.id.rl_huzhuan: // 互转
                break;
            case R.id.rl_chuzhi: // 储值卡
                break;
            case R.id.rl_jiaoyi: // 交易码
                break;
            case R.id.rl_jifen: // 积分
                break;
            case R.id.rl_shiming: // 实名
                break;
            case R.id.rl_team: // 团队
                break;
            case R.id.rl_yaoqing: // 邀请好友
                break;
        }
    }
}
