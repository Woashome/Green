package com.example.green.ui.fragment.search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.green.R;
import com.example.green.base.BaseMvpFragment;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.config.ApiConfig;
import com.example.green.model.HomePageModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchGoodsFragment extends BaseMvpFragment<CommonPresenter,HomePageModel> implements ICommonView {


    public SearchGoodsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_goods, container, false);
    }

    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected HomePageModel initModel() {
        return new HomePageModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_goods;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.SEARCH_GOODS:
                break;
        }
    }
}
