package com.example.green.ui.activity;

import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.bean.homepage.HotSearchKeyListbean;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.model.HomePageModel;

import java.util.List;

public class SearchActivity extends BaseMvpActivity<CommonPresenter, HomePageModel>
        implements ICommonView {


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mPresenter.getData(ApiConfig.HOT_SEARCH_KEY, LoadConfig.NORMAL);
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
        return R.layout.activity_search;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.HOT_SEARCH_KEY:
                HotSearchKeyListbean searchKeyListbeans = (HotSearchKeyListbean) t[0];
                if (null != searchKeyListbeans) {
                    List<String> list = searchKeyListbeans.getResult().getList();
                    toastActivity(list.toString());
                }
                break;
        }
    }
}
