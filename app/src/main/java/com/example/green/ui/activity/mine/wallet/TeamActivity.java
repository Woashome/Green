package com.example.green.ui.activity.mine.wallet;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeamActivity extends BaseMvpActivity<CommonPresenter, MineModel>
        implements ICommonView {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_zhitui)
    TextView mTvZhitui;
    @BindView(R.id.tv_team)
    TextView mTvTeam;
    @BindView(R.id.rl_invite)
    RelativeLayout mRlInvite;
    @BindView(R.id.recycler_record)
    RecyclerView mRecyclerRecord;


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
        return R.layout.activity_team;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.back, R.id.rl_invite})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.rl_invite:
                break;
        }
    }
}
