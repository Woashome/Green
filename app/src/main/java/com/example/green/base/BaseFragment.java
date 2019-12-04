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
import com.example.green.local_utils.StatusBarManager;

public class BaseFragment extends Fragment {

    public int mAppColor;
//    private LoadingDialogWithContent mDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mAppColor = ContextCompat.getColor(getContext(), R.color.app_theme_color);
//        mDialog = new LoadingDialogWithContent(getContext(), getString(R.string.loading));
        return super.onCreateView(inflater, container, savedInstanceState);
    }


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

    public void setStatusBarColor(int color) {
        StatusBarManager.setStatusBarColor(getActivity(), color);
    }

    public void showLog(String content) {
        Log.e("睚眦必报", content);
    }
}
