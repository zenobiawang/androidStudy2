package com.example.wanghui1.androidstudy.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.wanghui1.androidstudy.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghui on 2017/1/22.
 */

public abstract class BaseViewPagerCommonActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private TabLayout mTabStrip;
    private List<PagerData> mPagerContainer = new ArrayList<>();
    private ViewPagerAdapter mAdapter;
    /**
     * viewpager布局，一般为默认布局
     * @return
     */
    protected View getContentView(){
        return View.inflate(this, R.layout.activity_common_view_pager, null);
    }

    protected abstract List<PagerData> getPagerData();

    /**
     * 设置tab样式
     * @param mTabStrip
     */
    protected void setTabPattern(TabLayout mTabStrip){};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabStrip = (TabLayout) findViewById(R.id.tab_strip);
        setTabPattern(mTabStrip);

        mPagerContainer = getPagerData();
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabStrip.setupWithViewPager(mViewPager);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.TabStyleProvider {

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

        @Override
        public View getTabView(int position, int selectPosition) {

            return null;
        }
    }

    public void setCurrentPage(int page){
        mViewPager.setCurrentItem(page, false);
    }

    public void updatePagerData(List<PagerData> datas){
        mPagerContainer = datas;
        mAdapter.notifyDataSetChanged();
    }

//    public View getTabPattern(int position, int selectPosition){
//        TextView tab = new TextView(this);
//        tab.setText(mAdapter.getPageTitle(position));
//        tab.setGravity(Gravity.CENTER);
//        tab.setSingleLine();
//        if (position == selectPosition){
//            tab.setTextColor(getResources().getColor(R.color.colorPrimary));
//        }else {
//            tab.setTextColor(getResources().getColor(R.color.black_overlay));
//        }
//        return tab;
//    }
    public int getCurrentPage(){
        return mViewPager.getCurrentItem();
    }
}
