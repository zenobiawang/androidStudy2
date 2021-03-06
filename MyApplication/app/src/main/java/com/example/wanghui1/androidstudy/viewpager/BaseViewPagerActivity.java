package com.example.wanghui1.androidstudy.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.wanghui1.androidstudy.R;
import com.example.wanghui1.androidstudy.viewpager.PagerSlidingTabStrip.TabStyleProvider;

import org.w3c.dom.Text;

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
        mTabStrip.setDividerColorResource(android.R.color.darker_gray);
        mTabStrip.setIndicatorColorResource(R.color.colorPrimary);
        mTabStrip.setIndicatorHeight(4);
        mTabStrip.setUnderlineHeight(0);
        mTabStrip.setTextColorResource(android.R.color.black);
        mTabStrip.setTextSize(32);
        mTabStrip.setTextColorResource(R.drawable.tab_text_color);
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
        mViewPager.setAdapter(mAdapter);
        mTabStrip.setViewPager(mViewPager);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter implements TabStyleProvider{

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
        mTabStrip.notifyDataSetChanged();
    }

    public View getTabPattern(int position, int selectPosition){
        TextView tab = new TextView(this);
        tab.setText(mAdapter.getPageTitle(position));
        tab.setGravity(Gravity.CENTER);
        tab.setSingleLine();
        if (position == selectPosition){
            tab.setTextColor(getResources().getColor(R.color.colorPrimary));
        }else {
            tab.setTextColor(getResources().getColor(R.color.black_overlay));
        }
        return tab;
    }

}
