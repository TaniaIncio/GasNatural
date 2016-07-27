package com.gmd.gasnatural.presentation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.gmd.gasnatural.R;

import butterknife.Bind;

public class SolicitarVisitaActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.linear_solicitar_visita)
    LinearLayout linearSolicitarVisita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_visita);
        getSupportActionBar().hide();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linear_solicitar_visita:
                startActivity(new Intent(this, TerminosCondicionesActivity.class));
                break;
        }
    }
}
