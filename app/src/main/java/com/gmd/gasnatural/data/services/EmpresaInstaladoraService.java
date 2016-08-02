package com.gmd.gasnatural.data.services;
import com.gmd.gasnatural.data.services.request.EmpresaInstaladoraInRO;
import com.gmd.gasnatural.data.services.response.EmpresasInstaladorasOutRO;
import com.gmd.gasnatural.presentation.util.Constants;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by tincio on 01/08/2016.
 */
public class EmpresaInstaladoraService implements UtilVolleyCallback {

    EmpresaInstaladoraServiceCallback mCallback;
    public void getListaEmpresasInstaladoras(EmpresaInstaladoraInRO mEmpresa, EmpresaInstaladoraServiceCallback mCallback){
        try{
            this.mCallback = mCallback;
            UtilVolley.getRequestWithPOST(Constants.Servicios.POST_VERIFICAR_RED, mEmpresa.toJSON(),this);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void onResponse(String response, Boolean isError) {
        try{
            Gson gson = new Gson();
            EmpresasInstaladorasOutRO mCoberturaResp = null;
            JSONObject objJson =null;
            JSONObject objJsonFinal = null;
            if(isError==false){
                objJson = new JSONObject(response);
                objJsonFinal = objJson.optJSONObject("empresaInstaladora");
                mCoberturaResp = gson.fromJson(objJsonFinal.toString(), EmpresasInstaladorasOutRO.class);
            }

            mCallback.onCallbackEmpresaInstaladora(mCoberturaResp, response);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
