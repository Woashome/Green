package com.example.green.ui.activity.mine;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.local_utils.SPUtils;
import com.example.green.model.MineModel;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalDataActivity extends BaseMvpActivity<CommonPresenter, MineModel>
        implements ICommonView {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.tv_editor)
    TextView mTvEditor;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.user_iv)
    ImageView mUserIv;
    @BindView(R.id.rl_icon)
    RelativeLayout mRlIcon;
    @BindView(R.id.phone)
    TextView mPhone;
    @BindView(R.id.account)
    RelativeLayout mAccount;
    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.username)
    RelativeLayout mUsername;

    private BottomSheetDialog selectPicDialog;

    @Override
    protected void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        // 账号
        mPhone.setText(SPUtils.getInstance().getValue(SPUtils.KEY_USER_NAME, ""));
        Intent intent = getIntent();
        String icon = intent.getStringExtra("icon");
        String nick = intent.getStringExtra("nick");
        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(this).load(icon).apply(options).into(mUserIv);
        mName.setText(nick);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected MineModel initModel() {
        return new MineModel();
    }

    @Override
    protected CommonPresenter initPresenter() {
        return new CommonPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_data;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onResponse(int whichApi, Object[] t) {

    }

    @OnClick({R.id.back, R.id.tv_editor, R.id.rl_icon, R.id.account, R.id.username})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.tv_editor:
                break;
            case R.id.rl_icon:
                showSelectPictureDialog();
                break;
            case R.id.account:
                break;
            case R.id.username:
                break;
        }
    }

    /**
     * 选择图片弹框
     */
    private void showSelectPictureDialog() {
        selectPicDialog = new BottomSheetDialog(this, R.style.Dialog_NoTitle);
        selectPicDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

            }
        });
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_bottom_select_pictrue, null);
        // 相册
        TextView album = view.findViewById(R.id.tv_select_pictrue_album);
        // 相机
        TextView camera = view.findViewById(R.id.tv_select_pictrue_camera);
        // 取消
        TextView cancel = view.findViewById(R.id.tv_select_pictrue_cancel);

        album.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                PictureSelector.create(PersonalDataActivity.this)
                        .openGallery(PictureMimeType.ofImage())
                        .maxSelectNum(1)
                        .selectionMode(PictureConfig.MULTIPLE)
                        .previewImage(true)
                        .isZoomAnim(false)
                        .isCamera(false)
                        .imageFormat(PictureMimeType.JPEG)
                        .enableCrop(true)
                        .cropWH(400, 400)
                        .rotateEnabled(false)
                        .compress(true)
                        .withAspectRatio(1, 1)
                        .minimumCompressSize(200)
                        .isDragFrame(true)
                        .forResult(PictureConfig.CHOOSE_REQUEST);

                selectPicDialog.dismiss();

            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureSelector.create(PersonalDataActivity.this)
                        .openCamera(PictureMimeType.ofImage())
                        .maxSelectNum(1)
                        .selectionMode(PictureConfig.SINGLE)
                        .previewImage(true)
                        .isZoomAnim(false)
                        .isCamera(true)
                        .imageFormat(PictureMimeType.JPEG)
                        .enableCrop(true)
                        .cropWH(400, 400)
                        .rotateEnabled(false)
                        .compress(true)
                        .withAspectRatio(1, 1)
                        .minimumCompressSize(200)
                        .isDragFrame(true)
                        .forResult(PictureConfig.CHOOSE_REQUEST);

                selectPicDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPicDialog.dismiss();
            }
        });

        selectPicDialog.setContentView(view);
        selectPicDialog.show();
    }
}
