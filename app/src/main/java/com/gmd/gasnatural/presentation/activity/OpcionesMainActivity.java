package com.gmd.gasnatural.presentation.activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.gmd.gasnatural.R;
import com.gmd.gasnatural.presentation.adapter.AdapterRecyclerBeneficios;
import com.gmd.gasnatural.presentation.presenter.OpcionesMainPresenter;
import com.gmd.gasnatural.presentation.view.OpcionesMainView;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OpcionesMainActivity extends AppCompatActivity implements OpcionesMainView, View.OnClickListener
{

    @Bind(R.id.linear_verficar_red)
    LinearLayout linearLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rec_beneficios)
    RecyclerView recBeneficios;
    RecyclerView.LayoutManager mLayoutManager;
    AdapterRecyclerBeneficios mAdapterBeneficios;

    OpcionesMainPresenter presenter;
    int PLACE_PICKER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recBeneficios.setLayoutManager(mLayoutManager);
        presenter = new OpcionesMainPresenter();
        presenter.setView(this);
        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        Log.d("Tag",Boolean.toString(pref.getBoolean("activity_executed",true)));

        if (pref.getBoolean("activity_executed", true)) {
            Intent intent = new Intent(this, SlideActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        presenter.getListOpciones();
        linearLayout.setOnClickListener(this);
    }

    @Override
    public void showListOpciones(String[] opciones) {
        mAdapterBeneficios = new AdapterRecyclerBeneficios(opciones);
        recBeneficios.setAdapter(mAdapterBeneficios);
        mAdapterBeneficios.setOnItemClickListener(new AdapterRecyclerBeneficios.OnItemClickListener() {
            @Override
            public void setOnItemClickListener(int posicion) {
                if (posicion==0)
                    startActivity(new Intent(getApplicationContext(),SlideActivity.class));
                else if (posicion==1)
                    startActivity(new Intent(getApplicationContext(),AhorroActivity.class));

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linear_verficar_red:
                showMapUbicacion();
                //startActivity(new Intent(getApplicationContext(),SlideActivity.class));

                break;
        }
    }

    public void showMapUbicacion(){
        try{
            //if (Util.checkGpsActived(this)){
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            try {
                startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
                //  btnLocalizacion.setEnabled(false);
            } catch (GooglePlayServicesRepairableException e) {
                e.printStackTrace();
                //     btnLocalizacion.setEnabled(true);
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
                //   btnLocalizacion.setEnabled(true);
            }
            //  }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                Intent intent = new Intent(this,MensajeVerificandoActivity.class);
                intent.putExtra("latitud", place.getLatLng().latitude);
                intent.putExtra("longitud", place.getLatLng().longitude);
                startActivity(intent);
            }else{
              //  Place place = PlacePicker.getPlace(data, this);
                Intent intent = new Intent(this,MensajeVerificandoActivity.class);
                intent.putExtra("latitud", 12.11111);
                intent.putExtra("longitud", 12.12345);
                startActivity(intent);
            }
        }
    }


    @Override
    public Context getContext() {
        return this;
    }
}
