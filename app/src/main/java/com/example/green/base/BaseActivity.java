package com.example.green.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.green.R;
import com.example.green.customs.LoadingDialogWithContent;
import com.example.green.local_utils.StatusBarManager;

public class BaseActivity extends AppCompatActivity {

    //更新头像，修改昵称
    public static final String RECTIFY_UPDATE_HEAD = "rectify_update_head";
    

    //登录成功
    public static final String LOGIN_SUCCESS = "LOGIN_SUCCESS";
    //退出登录
    public static final String LOGIN_OUT = "login_out";
    //修改标签
    public static final String MINE_LABEL = "mine_label";
    //预告片播放
    public static final String PLAY_VIDEO = "play_video";

    //修改城市
    public static final String MODIFY_CITY = "modify_city";

    //电影进度,给Main专用
    public static final String UPLOAD_PLAY_WATCH = "upload_play_watch";

    // 解绑成功
    public static final String UNBIND_SUCCESS = "UNBIND_SUCCESS";
    private MyApplication application;
    public int mAppColor;
    private LoadingDialogWithContent mDialog;

    private UserBroadCastReceiver mUserBroadCastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 获取userId Token
        application = (MyApplication) getApplication();
        Log.e("-------绿色长城-------", this.getClass().getSimpleName());
        mAppColor = ContextCompat.getColor(this, R.color.app_theme_color);
        mDialog = new LoadingDialogWithContent(this, false, getString(R.string.Info));

        mUserBroadCastReceiver = new UserBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RECTIFY_UPDATE_HEAD);
        intentFilter.addAction(LOGIN_SUCCESS);
        intentFilter.addAction(LOGIN_OUT);
        intentFilter.addAction(MINE_LABEL);
        intentFilter.addAction(PLAY_VIDEO);
        intentFilter.addAction(MODIFY_CITY);
        intentFilter.addAction(UNBIND_SUCCESS);
        initBroadCastReceiver(intentFilter);
        LocalBroadcastManager.getInstance(this).registerReceiver(mUserBroadCastReceiver, intentFilter);
    }

    public void showLoadingDialog() {
        if (!mDialog.isShowing()) mDialog.show();
    }

    public void hideLoadingDialog() {
        if (mDialog.isShowing()) mDialog.dismiss();
    }

    public void showToast(String content) {// 2.5s
        Toast.makeText(getApplicationContext(), "" + content, Toast.LENGTH_SHORT).show();
    }


    public void showLongToast(String content) { // 3.5s
        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_LONG).show();
    }

    /**
     * @param color 沉浸式状态栏颜色
     */
    public void setStatusBarColor(int color) {
        StatusBarManager.setStatusBarColor(this, color);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUserBroadCastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(mUserBroadCastReceiver);
        }
    }

    private class UserBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            receiverBroadCast(intent);
        }
    }

    protected void initBroadCastReceiver(IntentFilter intentFilter) {
    }

    protected void receiverBroadCast(Intent intent) {
    }

}