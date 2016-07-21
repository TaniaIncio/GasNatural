package com.gmd.gasnatural.presentation.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.gmd.gasnatural.R;
import com.gmd.gasnatural.presentation.fragment.SampleSlide;

public class AppintroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
       // setContentView(R.layout.activity_appintro);
       /* Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_intro);
        setSupportActionBar(toolbar);*/
        //setSupportActionBar(R.id.app_bar_layout);
        //set transparent
      /*  getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("");*/
        /*View view = getLayoutInflater().inflate(R.layout.toolbar_intro, null);
        Toolbar toolbar = (Toolbar) view;
        setSupportActionBar(toolbar);*/

        /*Toolbar toolbar = (Toolbar) getLayoutInflater().inflate(R.layout.toolbar_intro, null);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        addSlide(SampleSlide.newInstance(R.layout.activity_appintro));
        addSlide(SampleSlide.newInstance(R.layout.activity_appintro));
        addSlide(SampleSlide.newInstance(R.layout.activity_appintro));

        addSlide(AppIntroFragment.newInstance("Titulo", "Descripcion", R.mipmap.flechaazul, android.R.color.white));

        setBarColor(getResources().getColor(R.color.btn_verificar));
        setSeparatorColor(Color.parseColor("#2196F3"));
        showSkipButton(true);
        setProgressButtonEnabled(true);

        setDoneText("Siguiente");
        setSkipText("Omitir");

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_intro,menu);
        return super.onCreateOptionsMenu(menu);
    }*/
}
