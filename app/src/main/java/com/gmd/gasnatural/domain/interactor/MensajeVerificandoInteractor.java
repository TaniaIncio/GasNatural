package com.gmd.gasnatural.domain.interactor;

import android.content.Context;

import com.gmd.gasnatural.data.model.DataOpciones;
import com.gmd.gasnatural.data.services.CoberturaRedService;
import com.gmd.gasnatural.data.services.CoberturaRedServiceCallback;
import com.gmd.gasnatural.data.services.request.CoberturaServicioGasNaturalInRO;
import com.gmd.gasnatural.data.services.response.CoberturaServicioGasNaturalOutRO;
import com.gmd.gasnatural.domain.callback.MensajeVerificandoCallback;

/**
 * Created by tincio on 22/07/2016.
 */
public class MensajeVerificandoInteractor implements CoberturaRedServiceCallback{
    MensajeVerificandoCallback callback;
    Context context;

    public MensajeVerificandoInteractor(MensajeVerificandoCallback callback, Context context){
        this.callback = callback;
        this.context = context;
    }

    /**Devuelve objeto para verificar si la red pasa por su vivienda*/
    public void getVerificarRed(CoberturaServicioGasNaturalInRO mCobertura){
        try{
            CoberturaRedService service = new CoberturaRedService();
            service.getCoberturaRed(mCobertura, this);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void onCallbackVerificarRed(CoberturaServicioGasNaturalOutRO mCobertura, String message) {
        callback.onResponseVerificarRed(mCobertura , message);
    }


}
