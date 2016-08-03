package com.gmd.gasnatural.domain.interactor;

import android.content.Context;

import com.gmd.gasnatural.data.services.DetalleEmpresaInstaladoraService;
import com.gmd.gasnatural.data.services.DetalleEmpresaInstaladoraServiceCallback;
import com.gmd.gasnatural.data.services.EmpresaInstaladoraService;
import com.gmd.gasnatural.data.services.EmpresaInstaladoraServiceCallback;
import com.gmd.gasnatural.data.services.request.EmpresaInstaladoraInRO;
import com.gmd.gasnatural.data.services.request.EmpresaInstaladoraSeleccionadaInRO;
import com.gmd.gasnatural.data.services.response.EmpresaInstaladoraSeleccionadaOutRO;
import com.gmd.gasnatural.data.services.response.EmpresasInstaladorasOutRO;
import com.gmd.gasnatural.domain.callback.DetalleEmpresaInstaladoraCallback;
import com.gmd.gasnatural.domain.callback.EmpresasInstaladorasCallback;

/**
 * Created by tincio on 22/07/2016.
 */
public class DetalleEmpresaInstaladoraInteractor implements DetalleEmpresaInstaladoraServiceCallback {
    DetalleEmpresaInstaladoraCallback callback;
    Context context;
    //icono sale una estrella al instalador
    //carita feliz cambiar



    public DetalleEmpresaInstaladoraInteractor(DetalleEmpresaInstaladoraCallback callback, Context context){
        this.callback = callback;
        this.context = context;
    }

    /**Devuelve el detalle de la empresa instaladora seleccionada*/
    public void getDetalleEmpresaInstaladora(EmpresaInstaladoraSeleccionadaInRO mEmpresa){
        try{
            DetalleEmpresaInstaladoraService service = new DetalleEmpresaInstaladoraService();
            service.getListaEmpresasInstaladoras(mEmpresa, this);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void onCallbackDetalleEmpresaInstaladora(EmpresaInstaladoraSeleccionadaOutRO mEmpresa, String message) {
        callback.onResponse(mEmpresa , message);
    }
}
