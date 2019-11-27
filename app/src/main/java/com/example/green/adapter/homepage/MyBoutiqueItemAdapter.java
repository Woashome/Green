package com.example.green.adapter.homepage;

import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.green.R;
import com.example.green.bean.homepage.HomePgaeList;

import java.util.List;

public class MyBoutiqueItemAdapter extends BaseQuickAdapter<HomePgaeList.ResultBean.DiscountBean.DateBean.GoodsInfoBean, BaseViewHolder> {
    public MyBoutiqueItemAdapter(int layoutResId, @Nullable List<HomePgaeList.ResultBean.DiscountBean.DateBean.GoodsInfoBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomePgaeList.ResultBean.DiscountBean.DateBean.GoodsInfoBean item) {
        HomePgaeList.ResultBean.DiscountBean.DateBean.GoodsInfoBean goodsInfoBean = item;
        if (null != goodsInfoBean) {
            TextView price = helper.getView(R.id.price);
            price.setText("￥" + item.getGoods_price());
            TextView pre_price = helper.getView(R.id.pre_price);
            pre_price.setText("￥" + item.getGoods_promotion_price());
            pre_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            ImageView imageView = helper.getView(R.id.boutique_goods);
            RequestOptions options = new RequestOptions()
                    .placeholder(R.mipmap.ic_launcher)//图片加载出来前，显示的图片
                    .fallback(R.mipmap.ic_launcher) //url为空的时候,显示的图片
                    .error(R.mipmap.ic_launcher)
                    .centerCrop();//
            // 图片加载失败后，显示的图片
            if (null != goodsInfoBean.getGoods_image()) {
                Glide.with(mContext).load(goodsInfoBean.getGoods_image()).apply(options).into(imageView);
            }
            helper.addOnClickListener(R.id.price);
            helper.addOnClickListener(R.id.pre_price);
            helper.addOnClickListener(R.id.boutique_goods);
            helper.addOnClickListener(R.id.rl);
        }
    }
}
