package com.mint.sunplayer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.mint.sunplayer.R;

import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class IndicatorAdapter extends CommonNavigatorAdapter {
    private String[] mTitle;
    private onIndicatorTabClickListener listener;
    public IndicatorAdapter(Context context){
        mTitle = context.getResources().getStringArray(R.array.indicator_title);
    }
    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
        simplePagerTitleView.setText(mTitle[index]);
        simplePagerTitleView.setNormalColor(Color.parseColor("#000000"));
        simplePagerTitleView.setSelectedColor(Color.parseColor("#81ecec"));
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mViewPager.setCurrentItem(index);
                listener.onTabClick(index);
            }
        });
        return simplePagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator indicator = new LinePagerIndicator(context);
        indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
        indicator.setLineHeight(UIUtil.dip2px(context, 6));
        indicator.setLineWidth(UIUtil.dip2px(context, 10));
        indicator.setRoundRadius(UIUtil.dip2px(context, 3));
        indicator.setStartInterpolator(new AccelerateInterpolator());
        indicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
        indicator.setColors(Color.parseColor("#81ecec"));
        return indicator;
    }

    public void setOnIndicatorAdapter(onIndicatorTabClickListener listener){
        this.listener = listener;
    }

    public interface onIndicatorTabClickListener{
        void onTabClick(int index);
    }
}
