package com.gmd.gasnatural.presentation.util;


import com.gmd.gasnatural.R;

public enum ModelObject {
    RED(R.string.app_name, R.layout.intro_layout);

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