package com.gmd.gasnatural.presentation.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.gmd.gasnatural.R;
import com.gmd.gasnatural.presentation.adapter.CustomPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

public class SlideActivity extends AppCompatActivity {
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        mViewPager  = (ViewPager) findViewById(R.id.viewPager);
        mViewPager .setAdapter(new CustomPagerAdapter(this));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mViewPager);

        Button bt_next = (Button)findViewById(R.id.bt_next);
        bt_next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("TAG", "next");
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            }
        });


        ImageButton bt_prev = (ImageButton)findViewById(R.id.bt_back);
        bt_prev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("TAG", "prev");
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
            }
        });


    }
}
