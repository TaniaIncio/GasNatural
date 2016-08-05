package com.gmd.gasnatural.presentation.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmd.gasnatural.R;
import com.gmd.gasnatural.data.services.response.EmpresaInstaladoraSeleccionadaOutRO;
import com.gmd.gasnatural.presentation.util.AlertSender;
import com.gmd.gasnatural.presentation.view.DetalleEmpresaInstaladoraView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetalleEmpresaInstaladoraActivity extends AppCompatActivity implements View.OnClickListener, DetalleEmpresaInstaladoraView{

    @Bind(R.id.txt_nombre_empresainstaladora)
    TextView txtNombreEmpresaInstaladora;
    @Bind(R.id.txt_nroruc_activitydetalle)
    TextView txtRucEmpresaInstaladora;
    @Bind(R.id.txt_tipoinstalacion_activitydetalle)
    TextView txtTipoInstalacion;
    @Bind(R.id.txt_direccion_activitydetalle)
    TextView txtDireccion;
    @Bind(R.id.txt_telefono_activitydetalle)
    TextView txtTelefono;
    @Bind(R.id.txt_correo_activitydetalle)
    TextView txtCorreo;
    @Bind(R.id.txt_web_activitydetalle)
    TextView txtWeb;
    @Bind(R.id.txt_servicios_activitydetalle)
    TextView txtServicios;
    @Bind(R.id.linear_seleccionar_instalador)
    LinearLayout linearSeleccionar;
    ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_empresa_instaladora);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        linearSeleccionar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linear_seleccionar_instalador:
                onBackPressed();
                break;
        }
    }

    @Override
    public void showDetalleEmpresaInstaladora(EmpresaInstaladoraSeleccionadaOutRO mEmpresasInstaladorasOutRO, String message) {
        if(mEmpresasInstaladorasOutRO==null)
            AlertSender.showAlert(this,message);
        else
            this.setValuesEmpresaSeleccionada(mEmpresasInstaladorasOutRO);
    }

    @Override
    public void showLoading() {
        mProgress= AlertSender.showProgressDialog(this,"","");
    }

    @Override
    public void closeLoading() {
        mProgress.dismiss();
    }

    @Override
    public Context getContext() {
        return this;
    }

    public void setValuesEmpresaSeleccionada(EmpresaInstaladoraSeleccionadaOutRO mEmpresasInstaladorasOutRO){
        try{
            txtNombreEmpresaInstaladora.setText(mEmpresasInstaladorasOutRO.getNombreEmpresaInstaladora());
            txtRucEmpresaInstaladora.setText(mEmpresasInstaladorasOutRO.getNumeroIdentificacionEmpresaInstaladora());
            txtTipoInstalacion.setText(getResources().getStringArray(R.array.array_tipoinstalacion)[mEmpresasInstaladorasOutRO.getIdCategoriaInstalacion()]);
            txtDireccion.setText(mEmpresasInstaladorasOutRO.getDomicilioFiscalUbigeoEmpresaInstaladora());
            txtTelefono.setText(mEmpresasInstaladorasOutRO.getTelefonoEmpresaInstaladora());
            txtCorreo.setText(mEmpresasInstaladorasOutRO.getEmailEmpresaInstaladora());
            txtWeb.setText(mEmpresasInstaladorasOutRO.getPaginaWebEmpresaInstaladora());
            txtServicios.setText(mEmpresasInstaladorasOutRO.getInformacionAdicionalEmpresaInstaladora());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
