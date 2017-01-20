package com.example.wanghui1.androidstudy.viewpager;

import android.support.v4.app.Fragment;

/**
 * Created by wanghui on 2017/1/20.
 */

public class PagerData {
    private String pageTitle;
    private Fragment fragment;

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
