package com.gmd.gasnatural.domain.interactor;

import android.content.Context;

import com.gmd.gasnatural.data.services.EmpresaInstaladoraService;
import com.gmd.gasnatural.data.services.EmpresaInstaladoraServiceCallback;
import com.gmd.gasnatural.data.services.request.EmpresaInstaladoraInRO;
import com.gmd.gasnatural.data.services.response.EmpresasInstaladorasOutRO;
import com.gmd.gasnatural.domain.callback.EmpresasInstaladorasCallback;

/**
 * Created by tincio on 22/07/2016.
 */
public class EmpresasInstaladorasInteractor implements EmpresaInstaladoraServiceCallback{
    EmpresasInstaladorasCallback callback;
    Context context;

    public EmpresasInstaladorasInteractor(EmpresasInstaladorasCallback callback, Context context){
        this.callback = callback;
        this.context = context;
    }

    /**Devuelve objeto para verificar si la red pasa por su vivienda*/
    public void getListaEmpresasInstaladoras(EmpresaInstaladoraInRO mEmpresa){
        try{
            EmpresaInstaladoraService service = new EmpresaInstaladoraService();
            service.getListaEmpresasInstaladoras(mEmpresa, this);
        }catch(Exception e){
            throw e;
        }
    }


    @Override
    public void onCallbackEmpresaInstaladora(EmpresasInstaladorasOutRO mEmpresa, String message) {
        callback.onResponse(mEmpresa , message);
    }
}
