package com.example.green.ui.activity.mine;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.bean.mine.MineInfobean;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.local_utils.SPUtils;
import com.example.green.model.MineModel;
import com.example.green.ui.activity.homepage.LoginActivity;
import com.example.green.ui.fragment.mine.CollegeFragment;
import com.example.green.ui.fragment.mine.VideoFragment;
import com.yiyatech.utils.ext.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class WalletActivity extends BaseMvpActivity<CommonPresenter, MineModel> implements ICommonView {


    private static int FRAGMENT_COLLEGE = 0;
    private static int FRAGMENT_VIDEO = 1;
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
    @BindView(R.id.college)
    TextView mCollege;
    @BindView(R.id.video)
    TextView mVideo;
    @BindView(R.id.tip_1)
    ImageView mTip1;
    @BindView(R.id.tip_2)
    ImageView mTip2;
    @BindView(R.id.fl)
    FrameLayout mFl;

    private CollegeFragment mCollegeFragment;
    private VideoFragment mVideoFragment;
    private String key;
    private MineInfobean.ResultBean.MemberInfoBean mMember_info;

    @Override
    protected void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        // 商学院
        selectFragment(FRAGMENT_COLLEGE);
        mTip1.setVisibility(View.VISIBLE);
        mTip2.setVisibility(View.GONE);
        mCollege.setTextColor(getResources().getColor(R.color.c_27b28b));

        key = SPUtils.getInstance().getValue(SPUtils.KEY_USER_TOKEN, "");
    }

    @Override
    protected void initData() {
        mPresenter.getData(ApiConfig.MINEINFO, key, LoadConfig.NORMAL);
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
        switch (whichApi) {
            case ApiConfig.MINEINFO:
                MineInfobean mineInfobeans = (MineInfobean) t[0];
                if (null != mineInfobeans && mineInfobeans.getCode().equals("100")) {
                    ToastUtils.show(this, mineInfobeans.getMessage());
                    startActivity(new Intent(this, LoginActivity.class));
                    finish();
                } else if (null != mineInfobeans && mineInfobeans.getCode().equals("200")) {
                    mMember_info = mineInfobeans.getResult().getMember_info();
                    RequestOptions options = new RequestOptions().circleCrop();
                    Glide.with(this).load(mMember_info.getAvator()).apply(options).into(mHeaderIv);
                    mName.setText(mMember_info.getUser_name());
                    mNumber.setText(mMember_info.getMobile());
                }
        }
    }

    @OnClick({R.id.back, R.id.rl_user_level, R.id.rl_user_company, R.id.rl_chongzhi, R.id.rl_tixian,
            R.id.rl_huzhuan, R.id.rl_chuzhi, R.id.rl_jiaoyi, R.id.rl_jifen, R.id.rl_shiming, R.id.rl_team,
            R.id.rl_yaoqing, R.id.rl_college, R.id.rl_video})
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
            case R.id.rl_college: // 商学院
                selectFragment(FRAGMENT_COLLEGE);
                mTip1.setVisibility(View.VISIBLE);
                mTip2.setVisibility(View.GONE);
                mCollege.setTextColor(getResources().getColor(R.color.c_27b28b));
                mVideo.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.rl_video: // 视频
                selectFragment(FRAGMENT_VIDEO);
                mTip1.setVisibility(View.GONE);
                mTip2.setVisibility(View.VISIBLE);
                mCollege.setTextColor(getResources().getColor(R.color.black));
                mVideo.setTextColor(getResources().getColor(R.color.c_27b28b));
                break;
        }
    }

    public void selectFragment(int position) {//设置传入第几值显示第几个fragment
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (position) {
            case 0:
                if (mCollegeFragment == null) {
                    mCollegeFragment = CollegeFragment.newInstance();
                }
                //将原来的Fragment替换掉---此处R.id.fragmen指的是FrameLayout
                ft.replace(R.id.fl, mCollegeFragment);
                break;
            case 1:
                if (mVideoFragment == null) {
                    mVideoFragment = VideoFragment.newInstance();
                }
                ft.replace(R.id.fl, mVideoFragment);
                break;
            default:
                break;
        }
        ft.commit();
    }
}
