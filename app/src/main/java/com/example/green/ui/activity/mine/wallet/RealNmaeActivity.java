package com.example.green.ui.activity.mine.wallet;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.green.R;
import com.example.green.base.BaseMvpActivity;
import com.example.green.base.CommonPresenter;
import com.example.green.base.ICommonView;
import com.example.green.base.MyApplication;
import com.example.green.bean.mine.AddressBean;
import com.example.green.bean.mine.AutonymBean;
import com.example.green.config.ApiConfig;
import com.example.green.config.LoadConfig;
import com.example.green.customs.AreaPickerView;
import com.example.green.local_utils.SPUtils;
import com.example.green.model.MineModel;
import com.example.green.ui.activity.mine.PersonalDataActivity;
import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RealNmaeActivity extends BaseMvpActivity<CommonPresenter, MineModel> implements ICommonView {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_Name)
    EditText mEtName;
    @BindView(R.id.et_IDnumber)
    EditText mEtIDnumber;
    @BindView(R.id.tv_Area)
    TextView mTvArea;
    @BindView(R.id.front_pic)
    ImageView mFrontPic;
    @BindView(R.id.reverse_pic)
    ImageView mReversePic;
    @BindView(R.id.et_bank_name)
    EditText mEtBankName;
    @BindView(R.id.et_bank_account)
    EditText mEtBankAccount;
    @BindView(R.id.btn_commit)
    Button mBtnCommit;
    private static final String TAG = "RealNmaeActivity";
    private BottomSheetDialog selectPicDialog;
    private int TYPE;
    //所选相册图片的路径(原图/压缩后/剪裁后)
    String FrontPic = "";
    String ReversePic = "";
    private AreaPickerView areaPickerView;
    private List<AddressBean.ResultBean.AreaListBeanXX> addressBeans;
    private int[] i;
    private String province_id;
    private String city_id;
    private String area_id;

    @Override
    protected void initView() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        addressBeans = new ArrayList<>();
        Gson gson = new Gson();
        AddressBean addressBean = gson.fromJson(getCityJson(), AddressBean.class);
        Log.e(TAG, "initData: " + addressBean.toString());
        addressBeans.addAll(addressBean.getResult().getArea_list());
        areaPickerView = new AreaPickerView(this, R.style.Dialog, addressBeans);
        areaPickerView.setAreaPickerViewCallback(new AreaPickerView.AreaPickerViewCallback() {
            @Override
            public void callback(int... value) {
                i = value;
                if (value.length == 3) {
                    mTvArea.setText(addressBeans.get(value[0]).getArea_name()
                            + " " + addressBeans.get(value[0]).getArea_list().get(value[1]).getArea_name()
                            + " " + addressBeans.get(value[0]).getArea_list().get(value[1]).getArea_list().get(value[2]).getArea_name());
                    province_id = addressBeans.get(value[0]).getArea_id() + "";
                    city_id = addressBeans.get(value[0]).getArea_list().get(value[1]).getArea_id() + "";
                    area_id = addressBeans.get(value[0]).getArea_list().get(value[1]).getArea_list().get(value[2]).getArea_id() + "";
                } else {
                    mTvArea.setText(addressBeans.get(value[0]).getArea_name()
                            + " " + addressBeans.get(value[0]).getArea_list().get(value[1]).getArea_name());
                }
            }
        });
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
        return R.layout.activity_real_nmae;
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: " + e.getMessage());
    }

    @Override
    public void onResponse(int whichApi, Object[] t) {
        switch (whichApi) {
            case ApiConfig.USER_AUTONYM:
                AutonymBean autonymBean = (AutonymBean) t[0];
                if (null != autonymBean && autonymBean.getCode() == 200) {
                    toastActivity("认证成功");
                } else {
                    toastActivity(autonymBean.getMessage());
                }
                break;
        }
    }

    @OnClick({R.id.back, R.id.tv_Area, R.id.front_pic, R.id.reverse_pic, R.id.btn_commit})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                finish();
                break;
            case R.id.tv_Area:
                hideInput();
                areaPickerView.setSelect(i);
                areaPickerView.show();
                break;
            case R.id.front_pic:
                TYPE = 1;
                showSelectPictureDialog();
                break;
            case R.id.reverse_pic:
                TYPE = 2;
                showSelectPictureDialog();
                break;
            case R.id.btn_commit:
                Integer userId = SPUtils.getInstance().getValue(SPUtils.KEY_USER_ID, 0);
                String name = mEtName.getText().toString().trim();
                String Idnumber = mEtIDnumber.getText().toString().trim();
                String area = mTvArea.getText().toString().trim();
                String bankname = mEtBankName.getText().toString().trim();
                String account = mEtBankAccount.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(Idnumber) && !TextUtils.isEmpty(area) && !TextUtils.isEmpty(bankname) && !TextUtils.isEmpty(account)) {
                    if (isIDNumber(Idnumber)) {
                        if (!FrontPic.equals("") && !ReversePic.equals("")) {
                            mPresenter.getData(ApiConfig.USER_AUTONYM, userId, name, Idnumber, bankname, account,
                                    FrontPic, ReversePic, province_id, city_id, area_id, area, 1);
                        } else {
                            toastActivity("请选择身份证正反面照片");
                        }
                    } else {
                        toastActivity("身份证号有误");
                    }
                } else {
                    toastActivity("请完善信息");
                }

                break;
        }
    }

    /*验证是否为身份证号*/
    public static boolean isIDNumber(String IDNumber) {
        if (IDNumber == null || "".equals(IDNumber)) {
            return false;
        }
        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
        String regularExpression =
                "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|"
                        + "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        boolean matches = IDNumber.matches(regularExpression);
        // 判断第18位校验值
        if (matches) {
            if (IDNumber.length() == 18) {
                try {
                    char[] charArray = IDNumber.toCharArray();
                    // 前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    // 这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase()
                            .equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
                        System.out.println("身份证最后一位:" + String.valueOf(idCardLast).toUpperCase()
                                + "错误,正确的应该是:" + idCardY[idCardMod].toUpperCase());
                        return false;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            } else {
                return false;
            }
        }
        return matches;
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
                PictureSelector.create(RealNmaeActivity.this)
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
                PictureSelector.create(RealNmaeActivity.this)
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    List<LocalMedia> localMedia = PictureSelector.obtainMultipleResult(data);

                    if (localMedia != null) {
                        if (localMedia.size() > 0) {
                            LocalMedia localMedia1 = localMedia.get(0);
                            if (localMedia1.isCut()) {
                               /* albumPath = localMedia1.getCompressPath();
                                //设置图片圆角角度
                                //通过RequestOptions扩展功能
                                RequestOptions options = RequestOptions.overrideOf(300, 300)
                                        //圆形
                                        .circleCrop();
                                Glide.with(RealNmaeActivity.this)
                                        .load(albumPath).apply(options).into(mFrontPic);*/

                                String path = localMedia1.getCutPath();
                                if (TYPE == 1) {
                                    mFrontPic.setImageURI(Uri.fromFile(new File(path)));
                                    FrontPic = path;
                                } else if (TYPE == 2) {
                                    mReversePic.setImageURI(Uri.fromFile(new File(path)));
                                    ReversePic = path;
                                }
                            } else {
                                String path = localMedia1.getPath();
                                if (TYPE == 1) {
                                    mFrontPic.setImageURI(Uri.fromFile(new File(path)));
                                    FrontPic = path;
                                } else if (TYPE == 2) {
                                    mReversePic.setImageURI(Uri.fromFile(new File(path)));
                                    ReversePic = path;
                                }
                            }
                        }
                    }

                    break;
                case 200:

                    break;
            }
        }
    }

    private String getCityJson() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = this.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open("area.json")));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 隐藏键盘
     */
    protected void hideInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View v = getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}
