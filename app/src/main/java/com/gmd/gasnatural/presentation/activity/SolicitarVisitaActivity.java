package com.gmd.gasnatural.presentation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmd.gasnatural.R;

public class SolicitarVisitaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_visita);
        getSupportActionBar().hide();
    }
}
