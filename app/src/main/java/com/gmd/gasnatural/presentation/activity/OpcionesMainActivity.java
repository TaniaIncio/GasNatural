package com.gmd.gasnatural.presentation.activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.gmd.gasnatural.R;
import com.gmd.gasnatural.presentation.adapter.AdapterRecyclerBeneficios;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OpcionesMainActivity extends AppCompatActivity{

    @Bind(R.id.linear_verficar_red)
    LinearLayout linearLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rec_beneficios)
    RecyclerView recBeneficios;
    RecyclerView.LayoutManager mLayoutManager;
    AdapterRecyclerBeneficios mAdapterBeneficios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    //    toolbar.setTitle(getResources().getString(R.string.title_activity_opciones_main));

        mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        String[] array = getResources().getStringArray(R.array.array_elements_recycler);
        mAdapterBeneficios = new AdapterRecyclerBeneficios(array);
        recBeneficios.setLayoutManager(mLayoutManager);
        recBeneficios.setAdapter(mAdapterBeneficios);
    }

    @Override
    protected void onResume() {
        super.onResume();
    /*    linearLayout.setOnClickListener(v->{
          //  showMapUbicacion();
        });*/
    }

    int PLACE_PICKER_REQUEST = 1;
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

}
