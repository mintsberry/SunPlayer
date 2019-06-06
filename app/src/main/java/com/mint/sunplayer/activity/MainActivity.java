package com.mint.sunplayer.activity;

import android.graphics.Color;
import android.icu.util.IndianCalendar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mint.sunplayer.R;
import com.mint.sunplayer.adapter.IndicatorAdapter;
import com.mint.sunplayer.adapter.MainPageAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

public class MainActivity extends BaseActivity {

    private MagicIndicator mIndicator;
    private IndicatorAdapter mIndicatorAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //导航栏切换
        CommonNavigator commonNavigator = new CommonNavigator(this);
        mIndicator = findViewById(R.id.indicator_main);
        mIndicatorAdapter = new IndicatorAdapter(this);
        commonNavigator.setAdapter(mIndicatorAdapter);
        commonNavigator.setAdjustMode(true);
        mIndicator.setNavigator(commonNavigator);
        //ViewPage
        mViewPager = this.findViewById(R.id.vp_main);
        MainPageAdapter mainPageAdapter = new MainPageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mainPageAdapter);
        //ViewPage和导航栏绑定
        ViewPagerHelper.bind(mIndicator, mViewPager);
        //监听导航栏点击切换
        mIndicatorAdapter.setOnIndicatorAdapter((i) ->{
            mViewPager.setCurrentItem(i);
        });

    }
}
