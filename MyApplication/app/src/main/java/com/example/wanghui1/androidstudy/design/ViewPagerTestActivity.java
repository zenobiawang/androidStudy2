package com.example.wanghui1.androidstudy.design;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wanghui1.androidstudy.R;

/**
 * Created by wanghui on 2017/1/19.
 */

public class ViewPagerTestActivity extends Activity {
    private ViewPager mViewPager;
    private PagerTabStrip mTabStrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_pager);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabStrip = (PagerTabStrip) findViewById(R.id.viewpager_tab);
        mTabStrip.setTextSpacing(100);
        mTabStrip.setDrawFullUnderline(true);
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                TextView textView = new TextView(ViewPagerTestActivity.this);
                textView.setText("ViewPager + " + position);
                return textView;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return String.valueOf(position);
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
