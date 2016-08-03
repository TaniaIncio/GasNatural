package com.gmd.gasnatural.presentation.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gmd.gasnatural.R;
import com.gmd.gasnatural.presentation.adapter.CustomPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.Bind;

public class SlideActivity extends AppCompatActivity {

    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        getSupportActionBar().hide();
        mViewPager  = (ViewPager) findViewById(R.id.viewPager);
        mViewPager .setAdapter(new CustomPagerAdapter(this));

        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor edt = pref.edit();
        edt.putBoolean("activity_executed", false);
        edt.commit();

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
                Log.d("TAG", "set 0");
                startActivity(new Intent(getApplicationContext(),OpcionesMainActivity.class));
                finish();
            }
        });


        TextView tv_omitir = (TextView)findViewById(R.id.main_return);
        tv_omitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),OpcionesMainActivity.class));
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {

                Log.i("Tag","Pagina #"+position);

                Button bt_next = (Button)findViewById(R.id.bt_next);
                bt_next.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Log.d("TAG", "next");
                        mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                    }
                });
                bt_next.setText("Siguiente");
                ImageButton bt_prev = (ImageButton)findViewById(R.id.bt_back);
                bt_prev.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Log.d("TAG", "prev");
                        mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
                    }
                });
                TextView tv_omitir = (TextView)findViewById(R.id.main_return);
                tv_omitir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),OpcionesMainActivity.class));
                    }
                });




                if (position==3)
                {
                    bt_next = (Button)findViewById(R.id.bt_next);
                    bt_next.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            Log.d("TAG", "setea3");
                            startActivity(new Intent(getApplicationContext(),OpcionesMainActivity.class));
                        }
                    });
                    bt_next.setText("Finalizar");

                }
                else if (position==0 )
                {
                    bt_prev.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            Log.d("TAG", "set 0");
                            startActivity(new Intent(getApplicationContext(),OpcionesMainActivity.class));
                            finish();
                        }
                    });

                }

               }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
