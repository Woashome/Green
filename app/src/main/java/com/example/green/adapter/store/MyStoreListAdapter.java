package com.example.green.adapter.store;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.green.R;
import com.example.green.bean.store.StoreListbean;

import java.util.ArrayList;
import java.util.List;

public class MyStoreListAdapter extends BaseQuickAdapter<StoreListbean.ResultBean, BaseViewHolder> {

    public MyStoreListAdapter(int layoutResId, @Nullable List<StoreListbean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StoreListbean.ResultBean item) {
        StoreListbean.ResultBean resultBean = item;
        if (null != resultBean) {
            TextView platform = helper.getView(R.id.platform);
            TextView store_name = helper.getView(R.id.store_name);
            ImageView store_logo = helper.getView(R.id.store_logo);
            TextView deal_num = helper.getView(R.id.deal_num);
            RecyclerView store_list = helper.getView(R.id.show_recyclerview);

            int platform_store = resultBean.getIs_platform_store();
            if (platform_store == 1) {
                platform.setBackgroundResource(R.mipmap.ziying);
            } else {
                platform.setBackgroundResource(R.mipmap.qianyue);
            }
            store_name.setText(resultBean.getStore_name());
            deal_num.setText("成交订单数量：" + resultBean.getNum_sales_jq());
            RequestOptions options = new RequestOptions().circleCrop();
            Glide.with(mContext).load(resultBean.getStore_logo()).apply(options).into(store_logo);
            // 所有商品
            List<StoreListbean.ResultBean.SearchListGoodsBean>
                    search_list_goods = resultBean.getSearch_list_goods();
            // 拿出三条(展示商品)
            List<StoreListbean.ResultBean.SearchListGoodsBean> show_list = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                show_list.add(search_list_goods.get(i));
            }
            MyStoreShowListAdapter myStoreShowListAdapter = new MyStoreShowListAdapter(mContext, show_list);
            store_list.setLayoutManager(new GridLayoutManager(mContext, 3));
            store_list.setAdapter(myStoreShowListAdapter);
            myStoreShowListAdapter.notifyDataSetChanged();
        }
        helper.addOnClickListener(R.id.store_card);
        helper.addOnClickListener(R.id.go_store);
    }
}