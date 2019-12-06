package com.example.green.ui.activity;

import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.model.HomePageModel;

public class GoodsDetailsActivity extends BaseMvpActivity<CommonPresenter, HomePageModel>
        implements ICommonView {


    @Override
    protected void initView() {
//        text.setText(Html.fromHtml("html文本"));
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
        return R.layout.activity_goods_details;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }
}
