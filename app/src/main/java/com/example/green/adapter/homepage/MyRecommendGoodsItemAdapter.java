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
import com.example.green.bean.homepage.GoodsListbean;

import java.util.List;

public class MyRecommendGoodsItemAdapter extends BaseQuickAdapter<GoodsListbean.ResultBean, BaseViewHolder> {

    public MyRecommendGoodsItemAdapter(int layoutResId, @Nullable List<GoodsListbean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsListbean.ResultBean item) {
        GoodsListbean.ResultBean resultBean = item;
        if (null != resultBean) {
            TextView name = helper.getView(R.id.goods_name);
            name.setText(item.getGoods_name());
            TextView price = helper.getView(R.id.goods_price);
            price.setText("￥" + item.getGoods_price());
            TextView pre_price = helper.getView(R.id.goods_preprice);
            pre_price.setText("￥" + item.getGoods_promotion_price());
            pre_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            ImageView imageView = helper.getView(R.id.goods_iv);
            RequestOptions options = new RequestOptions()
                    .placeholder(R.mipmap.ic_launcher)//图片加载出来前，显示的图片
                    .fallback(R.mipmap.ic_launcher) //url为空的时候,显示的图片
                    .error(R.mipmap.ic_launcher)
                    .centerCrop();//
            // 图片加载失败后，显示的图片
            if (null != resultBean.getGoods_image()) {
                Glide.with(mContext).load(resultBean.getGoods_image()).apply(options).into(imageView);
            }
            helper.addOnClickListener(R.id.price);
            helper.addOnClickListener(R.id.pre_price);
            helper.addOnClickListener(R.id.boutique_goods);
            helper.addOnClickListener(R.id.goods_card);
        }
    }
}
