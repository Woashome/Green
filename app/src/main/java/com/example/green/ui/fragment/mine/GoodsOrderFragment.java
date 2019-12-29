package com.example.green.ui.fragment.mine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.green.R;
import com.example.green.adapter.mine.GoodsOrderAdapter;
import com.example.green.base.BaseMvpFragment;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.bean.MyOrderbean;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.local_utils.SPUtils;
import com.example.green.model.MineModel;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodsOrderFragment extends BaseMvpFragment<CommonPresenter, MineModel> implements ICommonView {


    @BindView(R.id.order_recyclerview)
    RecyclerView mOrderRecyclerview;
    @BindView(R.id.tv_occupied)
    TextView mTvOccupied;
    private String status_type;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    public static GoodsOrderFragment newInstance(String status_type) {
        GoodsOrderFragment myFragment = new GoodsOrderFragment();
        Bundle bundle = new Bundle();
        /*
        state_new:待付款 ，
        state_pay：待发货 ，
        state_send：待收货 ，
        state_notakes：待自提 ，
        state_noeval：带评价 ，
        state_success：已完成 ，
        state_cancel：已经取消的订单 ，
        为空  表示全部订单
        */
        bundle.putString("state_type", status_type); // 订单状态
        myFragment.setArguments(bundle);
        return myFragment;
    }

    public GoodsOrderFragment() {
        // Required empty public constructor
    }

    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected MineModel initModel() {
        return new MineModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_goods_order;
    }

    @Override
    protected void initView() {
        Bundle bundle = getArguments();
        if (null != bundle) {
            status_type = bundle.getString("state_type");

            String token = SPUtils.getInstance().getValue(SPUtils.KEY_USER_TOKEN, "");

            mPresenter.getData(ApiConfig.GOODSORDER,token,status_type,"",1,5, LoadConfig.LOADMORE);

        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        if (whichApi == ApiConfig.GOODSORDER) {
            MyOrderbean myOrderbean = (MyOrderbean) t[0];
            List<MyOrderbean.ResultBean.OrderGroupListBean> order_group_list = myOrderbean.getResult().getOrder_group_list();

            GoodsOrderAdapter goodsOrderAdapter = new GoodsOrderAdapter(R.layout.layout_goodsorder,order_group_list);

            Log.e("zll", "onResponse: "+myOrderbean.getCode());
        }


    }
}
