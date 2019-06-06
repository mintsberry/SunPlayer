package com.mint.sunplayer.util;

import com.mint.sunplayer.fragment.ArtiestFragment;
import com.mint.sunplayer.fragment.BaseFragment;
import com.mint.sunplayer.fragment.LikeFragment;
import com.mint.sunplayer.fragment.SongFragment;

import java.util.HashMap;
import java.util.Map;

public class FragmentCreator {
    public static final int INDEX_SONG = 0;
    public static final int INDEX_LIKE = 1;
    public static final int INDEX_ARTIST = 2;

    public static final int PAGE_COUNT = 3;

    public static Map<Integer, BaseFragment> sMap = new HashMap<>();

    public static BaseFragment getFragment(int index){
        BaseFragment baseFragment = sMap.get(index);
        if (sMap.get(index) != null){
            return baseFragment;
        }
        switch (index){
            case INDEX_SONG:
                baseFragment = new SongFragment();
                break;
            case INDEX_LIKE:
                baseFragment = new LikeFragment();
                break;
            case INDEX_ARTIST:
                baseFragment = new ArtiestFragment();
                break;
        }
        sMap.put(index, baseFragment);
        return baseFragment;
    }

}
