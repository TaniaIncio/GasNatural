package com.gmd.gasnatural.presentation.util;


import com.gmd.gasnatural.R;

public enum ModelObject {
    SLIDE1(R.string.app_name, R.layout.slideshow1_view1),
    SLIDE2(R.string.app_name, R.layout.slideshow1_view2),
    SLIDE3(R.string.app_name, R.layout.slideshow1_view3),
    SLIDE4(R.string.app_name, R.layout.slideshow1_view4);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}