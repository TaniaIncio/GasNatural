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

}
