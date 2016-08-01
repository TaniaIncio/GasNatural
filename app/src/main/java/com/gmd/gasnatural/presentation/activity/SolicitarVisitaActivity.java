package com.gmd.gasnatural.presentation.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmd.gasnatural.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SolicitarVisitaActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.linear_solicitar_visita)
    LinearLayout linearSolicitarVisita;
    @Bind(R.id.txt_mensaje_superior)
    TextView txtMensajeSuperior;
    @Bind(R.id.txt_mensaje_inferior)
    TextView txtMensajeInferior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_visita);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle extras = getIntent().getExtras();

        if(extras.getString("gas").equals("S")){
            txtMensajeSuperior.setText(getString(R.string.title_red_gas));
            txtMensajeInferior.setText(getString(R.string.title_solicitar_visita));
        }else{
            if(extras.getString("promocion").equals("S")){
                txtMensajeSuperior.setText(getString(R.string.title_red_gas_promocion));
                txtMensajeInferior.setText(getString(R.string.title_solicitar_visita_promocion));
            }else{
                if(extras.getString("fise").equals("S")){
                    txtMensajeSuperior.setText(getString(R.string.title_red_gas_fise));
                    txtMensajeInferior.setText(getString(R.string.title_solicitar_visita_fise));
                }else{
                    txtMensajeSuperior.setText(getString(R.string.title_red_gas_nopasa));
                    txtMensajeInferior.setText(getString(R.string.title_solicitar_visita_nopasa));
                }
            }
        }
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
