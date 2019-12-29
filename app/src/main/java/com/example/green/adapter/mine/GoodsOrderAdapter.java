package com.example.green.adapter.mine;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.green.bean.MyOrderbean;

import java.util.List;

public class GoodsOrderAdapter extends BaseQuickAdapter<MyOrderbean.ResultBean.OrderGroupListBean, BaseViewHolder> {

    public GoodsOrderAdapter(int layoutResId, @Nullable List<MyOrderbean.ResultBean.OrderGroupListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyOrderbean.ResultBean.OrderGroupListBean item) {



    }
}
