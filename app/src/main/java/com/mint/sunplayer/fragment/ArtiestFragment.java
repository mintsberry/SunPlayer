package com.mint.sunplayer.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mint.sunplayer.R;

public class ArtiestFragment extends BaseFragment{
    @Override
    public View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.fragemet_artist, viewGroup, false);
    }
}
