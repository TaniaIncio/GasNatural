package com.gmd.gasnatural.presentation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.gmd.gasnatural.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TerminosCondicionesActivity extends AppCompatActivity  {

    @Bind(R.id.linear_continuar)
    LinearLayout linearContinuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos_condiciones);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        linearContinuar.bringToFront();
        linearContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
