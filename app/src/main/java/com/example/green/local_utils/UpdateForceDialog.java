
package com.example.green.local_utils;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.green.R;


/**
 * 强制升级的弹窗
 */

public class UpdateForceDialog extends UpdateBaseDialog implements View.OnClickListener {
    public UpdateForceDialog(Context context, int layoutResID, String version, String info) {
        super(context, R.style.dialog_custom, version, info); //dialog的样式
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private OnCenterItemClickListener listener;

    public interface OnCenterItemClickListener {
        void OnCenterItemClick(UpdateForceDialog dialog, View view);
    }

    public void setOnCenterItemClickListener(OnCenterItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        listener.OnCenterItemClick(this, view);
    }
}
