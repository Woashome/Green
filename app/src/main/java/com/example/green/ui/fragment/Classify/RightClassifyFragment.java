package com.example.green.ui.fragment.Classify;


import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.example.green.R;
import com.example.green.base.BaseMvpFragment;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.bean.classify.AllClassifyListbean;
import com.example.green.bean.classify.RightClassifyListbean;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.model.ClassifyModel;
import com.yiyatech.utils.ext.ToastUtils;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RightClassifyFragment extends BaseMvpFragment<CommonPresenter, ClassifyModel>
        implements ICommonView {

    @BindView(R.id.right_recyclerview)
    RecyclerView mRecyclerView;

    private AllClassifyListbean.ResultBean.ClassListBean mClassListBean;

    public RightClassifyFragment() {
        // Required empty public constructor
    }


    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected ClassifyModel initModel() {
        return new ClassifyModel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_right_classify;
    }

    @Override
    protected void initView() {
        // 分类ID
        mClassListBean = (AllClassifyListbean.ResultBean.ClassListBean) getArguments().getSerializable("gc_id");

    }

    @Override
    protected void initData() {
        if (null != mClassListBean && mClassListBean.getGc_id() > 0)
            mPresenter.getData(ApiConfig.URL_RIGHTCLASSIFY, mClassListBean.getGc_id(), LoadConfig.NORMAL);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.URL_RIGHTCLASSIFY:
                RightClassifyListbean rightClassifyListbeans = (RightClassifyListbean) t[0];
                if (null != rightClassifyListbeans) {
                    RightClassifyListbean.ResultBean result = rightClassifyListbeans.getResult();
                    ToastUtils.show(getContext(), result.toString());
                }
                break;
        }
    }
}
