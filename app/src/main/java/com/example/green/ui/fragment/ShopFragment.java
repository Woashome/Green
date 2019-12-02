package com.example.green.ui.fragment;


import android.support.v4.app.Fragment;

import com.example.green.R;
import com.example.green.base.BaseMvpFragment;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.model.ShopModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends BaseMvpFragment<CommonPresenter, ShopModel>
        implements ICommonView {

    static ShopFragment fragment;

    public static ShopFragment newInstance() {
        if (fragment == null) fragment = new ShopFragment();
        return fragment;
    }

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected ShopModel initModel() {
        return new ShopModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shop;
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

    }
}
