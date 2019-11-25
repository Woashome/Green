package com.example.green.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.green.R;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<String> mTabList;
    private Context mContext;
    private List<Fragment> mFragments;
    private ImageView mTabIcon;
    private TextView mTabText;
    private int[] mTabImgs;

    public ViewPagerAdapter(FragmentManager fm, List<String> tabList, Context context, List<Fragment> fragments, int[] tabImgs) {
        super(fm);
        mTabList = tabList;
        mContext = context;
        mFragments = fragments;
        mTabImgs = tabImgs;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTabList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabList.get(position);
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_tablayout_item, null);
        mTabText = (TextView) view.findViewById(R.id.tab_text);
        mTabIcon = (ImageView) view.findViewById(R.id.tab_img);
        mTabText.setText(mTabList.get(position));
        mTabIcon.setImageResource(mTabImgs[position]);
        if (0 == position) {//the default color of item home is green
            mTabText.setTextColor(ContextCompat.getColor(mContext, R.color.black)); //设置字体的颜色
            mTabIcon.setImageResource(R.mipmap.home_s);
        }
        return view;
    }
}