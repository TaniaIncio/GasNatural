package com.gmd.gasnatural.data.services;
import com.gmd.gasnatural.data.services.request.EmpresaInstaladoraInRO;
import com.gmd.gasnatural.data.services.request.EmpresaInstaladoraSeleccionadaInRO;
import com.gmd.gasnatural.data.services.response.EmpresaInstaladoraSeleccionadaOutRO;
import com.gmd.gasnatural.data.services.response.EmpresasInstaladorasOutRO;
import com.gmd.gasnatural.presentation.util.Constants;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by tincio on 01/08/2016.
 */
public class DetalleEmpresaInstaladoraService implements UtilVolleyCallback {

    DetalleEmpresaInstaladoraServiceCallback mCallback;
    public void getListaEmpresasInstaladoras(EmpresaInstaladoraSeleccionadaInRO mEmpresa, DetalleEmpresaInstaladoraServiceCallback mCallback){
        try{
            this.mCallback = mCallback;
            UtilVolley.getRequestWithPOST(Constants.Servicios.POST_OBTENER_EMPRESA_INSTALADORA, mEmpresa.toJSON(),this);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void onResponse(String response, Boolean isError) {
        try{
            Gson gson = new Gson();
            EmpresaInstaladoraSeleccionadaOutRO mEmpresaResp = null;
            JSONObject objJson =null;
            JSONObject objJsonFinal = null;
            if(isError==false){
                objJson = new JSONObject(response);
                objJsonFinal = objJson.optJSONObject("empresaInstaladora");
                mEmpresaResp = gson.fromJson(objJsonFinal.toString(), EmpresaInstaladoraSeleccionadaOutRO.class);
            }
            mCallback.onCallbackDetalleEmpresaInstaladora(mEmpresaResp, response);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
