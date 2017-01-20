package com.example.wanghui1.androidstudy.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.example.wanghui1.androidstudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghui on 2017/1/20.
 * 通用的viewpager
 */
public abstract class BaseViewPagerActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private PagerSlidingTabStrip mTabStrip;
    private List<PagerData> mPagerContainer = new ArrayList<>();
    private ViewPagerAdapter mAdapter;


    /**
     * viewpager布局，一般为默认布局
     * @return
     */
    protected View getContentView(){
        return View.inflate(this, R.layout.common_view_pager, null);
    }

    protected abstract List<PagerData> getPagerData();

    /**
     * 设置tab样式
     * @param mTabStrip
     */
    protected void setTabPattern(PagerSlidingTabStrip mTabStrip){
        mTabStrip.setDividerColorResource(R.color.colorPrimary);
        mTabStrip.setIndicatorColorResource(R.color.colorPrimary);
        mTabStrip.setTextColorResource(android.R.color.black);
        mTabStrip.setTextSize(16);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabStrip = (PagerSlidingTabStrip) findViewById(R.id.tab_strip);
        setTabPattern(mTabStrip);

        mPagerContainer = getPagerData();
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mTabStrip.setViewPager(mViewPager);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter{

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mPagerContainer.get(position).getFragment();
        }

        @Override
        public int getCount() {
            return mPagerContainer.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mPagerContainer.get(position).getPageTitle();
        }
    }

}
