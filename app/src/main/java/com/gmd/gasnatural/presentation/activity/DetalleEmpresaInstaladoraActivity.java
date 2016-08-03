package com.gmd.gasnatural.presentation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gmd.gasnatural.R;

import butterknife.Bind;

public class DetalleEmpresaInstaladoraActivity extends AppCompatActivity {

    @Bind(R.id.txt_nombre_empresainstaladora)
    TextView txtNombreEmpresaInstaladora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_empresa_instaladora);
    }
}
