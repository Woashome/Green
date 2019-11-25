package com.example.green.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.green.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import static com.scwang.smartrefresh.layout.util.DensityUtil.px2dp;

public class BaseFragment extends Fragment {

    public int mAppColor;
//    private LoadingDialogWithContent mDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mAppColor = ContextCompat.getColor(getContext(), R.color.app_theme_color);
//        mDialog = new LoadingDialogWithContent(getContext(), getString(R.string.loading));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

   /* public void initRecycleView(RecyclerView recyclerView, RefreshLayout refreshLayout) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        if (refreshLayout != null) {
            refreshLayout.setHeaderHeight(px2dp(120));
            refreshLayout.setFooterHeight(px2dp(120));
            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(RefreshLayout refreshLayout) {
                    refresh();
                }
            });
            refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
                @Override
                public void onLoadmore(RefreshLayout refreshlayout) {
                    loadMore();
                }
            });
        }
    }*/

    public void refresh() {
    }

    public void loadMore() {
    }

//    public void showLoadingDialog() {
//        if (!mDialog.isShowing()) mDialog.show();
//    }
//
//    public void hideLoadingDialog() {
//        if (mDialog.isShowing()) mDialog.dismiss();
//    }

    public void showToast(String content) {// 2.5s
        Toast.makeText(getContext().getApplicationContext(), content, Toast.LENGTH_SHORT).show();
    }


    public void showLongToast(String content) { // 3.5s
        Toast.makeText(getContext().getApplicationContext(), content, Toast.LENGTH_LONG).show();
    }

    /**
     *
     */
//    public void setStatusBarColor(int color) {
//        StatusBarManager.setStatusBarColor(getActivity(), color);
//    }
    public void showLog(String content) {
        Log.e("睚眦必报", content);
    }
}
