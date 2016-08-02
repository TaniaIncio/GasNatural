package com.gmd.gasnatural.presentation.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmd.gasnatural.R;
import com.gmd.gasnatural.data.services.request.CoberturaServicioGasNaturalInRO;
import com.gmd.gasnatural.data.services.response.CoberturaServicioGasNaturalOutRO;
import com.gmd.gasnatural.presentation.presenter.MensajeVerificandoPresenter;
import com.gmd.gasnatural.presentation.util.AlertSender;
import com.gmd.gasnatural.presentation.view.MensajeVerificandoView;

public class MensajeVerificandoActivity extends AppCompatActivity implements MensajeVerificandoView {

    MensajeVerificandoPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        getSupportActionBar().hide();
        presenter = new MensajeVerificandoPresenter();
        presenter.setView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle extras = getIntent().getExtras();
        presenter.getVerificarRed(setCobertura(extras.getDouble("latitud"),
                extras.getDouble("longitud")));
    }

    @Override
    public void showCoberturaOutRO(CoberturaServicioGasNaturalOutRO mCoberturaOutRO, String message) {
        if(mCoberturaOutRO== null){
            AlertSender.showAlert(this, message);
        }else{
            Intent intent = new Intent(this, SolicitarVisitaActivity.class);
            intent.putExtra("fise",mCoberturaOutRO.getResultadoIndFise());
            intent.putExtra("promocion",mCoberturaOutRO.getResultadoIndMecanismoPromocion());
            intent.putExtra("gas",mCoberturaOutRO.getResultadoIndGasNatural());
            startActivity(intent);
        }
    }

    @Override
    public Context getContext() {
        return this;
    }


    public CoberturaServicioGasNaturalInRO setCobertura(Double latitud, Double longitud){
        CoberturaServicioGasNaturalInRO mCobertura = new CoberturaServicioGasNaturalInRO();
        mCobertura.setCantidadMetros(50);
        mCobertura.setCoordenadaX(latitud.toString());
        mCobertura.setCoordenadaY(longitud.toString());
        mCobertura.setToken("0000");
        return mCobertura;
    }
}
