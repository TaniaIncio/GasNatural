package com.gmd.gasnatural.presentation.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.gmd.gasnatural.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OpcionesMainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.linear_verficar_red)
    LinearLayout linearLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_main);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        linearLayout.setOnClickListener(v->{

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        linearLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linear_verficar_red:

        }
    }
}
