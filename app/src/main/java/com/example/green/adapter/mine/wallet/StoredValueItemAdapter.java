package com.example.green.adapter.mine.wallet;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.green.R;
import com.example.green.bean.mine.wallet.StoredValueListbean;

import java.util.List;

/**
 * @ProjectName: Green
 * @Package: com.example.green.adapter.mine.wallet
 * @ClassName: StoredValueItemAdapter
 * @Author: hjl
 * @email: 51721997@163.com
 * @Description: 储值卡交易明细适配器
 * @CreateDate: 2020/1/3 12:05
 */
public class StoredValueItemAdapter extends BaseQuickAdapter<StoredValueListbean.ResultBean.ListBean, BaseViewHolder> {

    public StoredValueItemAdapter(int layoutResId, @Nullable List<StoredValueListbean.ResultBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StoredValueListbean.ResultBean.ListBean item) {
        StoredValueListbean.ResultBean.ListBean listBean = item;
        if (null != listBean) {
            TextView date = helper.getView(R.id.date);
            TextView info = helper.getView(R.id.info);

            date.setText(listBean.getLg_add_time_text());
            info.setText(listBean.getLg_desc());
        }
    }
}
