package com.example.wanghui1.androidstudy.design;

import android.os.Bundle;

import com.example.wanghui1.androidstudy.R;
import com.example.wanghui1.androidstudy.viewpager.BaseViewPagerActivity;
import com.example.wanghui1.androidstudy.viewpager.BaseViewPagerCommonActivity;
import com.example.wanghui1.androidstudy.viewpager.PagerData;
import com.example.wanghui1.androidstudy.viewpager.PagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanghui on 2017/1/19.
 */

public class ViewPagerTestActivity extends BaseViewPagerCommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentPage(3);
        List<PagerData> pagerDatas = new ArrayList<>();
        for (int i = 0; i < 6; i ++){
            PagerData data = new PagerData();
            data.setFragment(new PagerFragment());
            data.setPageTitle(getString(R.string.test) + (i+ 1));
            pagerDatas.add(data);
        }
        updatePagerData(pagerDatas);
    }

    @Override
    protected List<PagerData> getPagerData() {
        List<PagerData> pagerDatas = new ArrayList<>();
        for (int i = 0; i < 5; i ++){
            PagerData data = new PagerData();
            data.setFragment(new PagerFragment());
            data.setPageTitle(getString(R.string.test) + i);
            pagerDatas.add(data);
        }
        return pagerDatas;
    }
}
