package com.gmd.gasnatural.data.services;
import com.gmd.gasnatural.data.services.request.CoberturaServicioGasNaturalInRO;
import com.gmd.gasnatural.data.services.response.CoberturaServicioGasNaturalOutRO;
import com.gmd.gasnatural.presentation.util.Constants;
import com.google.gson.Gson;

/**
 * Created by tincio on 01/08/2016.
 */
public class CoberturaRedService implements UtilVolleyCallback {

    CoberturaRedServiceCallback mCallback;
    public void getCoberturaRed(CoberturaServicioGasNaturalInRO mCobertura, CoberturaRedServiceCallback mCallback){
        try{
            this.mCallback = mCallback;
            UtilVolley.getRequestWithPOST(Constants.Servicios.POST_VERIFICAR_RED, mCobertura.toJSON(),this);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void onResponse(String response, Boolean isError) {
        Gson gson = new Gson();
        CoberturaServicioGasNaturalOutRO mCoberturaResp = null;
        if(isError==false)
            mCoberturaResp = gson.fromJson(response, CoberturaServicioGasNaturalOutRO.class);

        mCallback.onCallbackVerificarRed(mCoberturaResp, response);
    }
}
