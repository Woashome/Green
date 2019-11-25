package com.example.green.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.green.R;
import com.example.green.ui.activity.MainActivity;
import com.stx.xhb.xbanner.XBanner;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    static HomeFragment fragment;

    public static HomeFragment newInstance() {
        if (fragment == null) fragment = new HomeFragment();
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    /**
     * 初始化XBanner
     */
    private void initBanner(XBanner banner) {
        //设置广告图片点击事件
        banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                Toast.makeText(getContext(), "点击了第" + (position + 1) + "图片", Toast.LENGTH_SHORT).show();
            }
        });
        //加载广告图片
        banner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                //此处适用Fresco加载图片，可自行替换自己的图片加载框架
                Log.e("canshushi", "\nposition=" + position + "\nbanner=" + banner.getRealCount() + "\nmodel=" + model.toString() + "\nview=" + view.getId() + "");
/*                SimpleDraweeView draweeView = (SimpleDraweeView) view;
                Bean.ObjBean listBean = ((Bean.ObjBean) model);
                String url = listBean.getImageurl();
                draweeView.setImageURI(Uri.parse(url));
                Glide.with(MainActivity.this).load(url).placeholder(R.drawable.default_image).error(R.drawable.default_image).into((ImageView) view);*/

            }
        });
    }

}
