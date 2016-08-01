package com.gmd.gasnatural.domain.interactor;

import android.content.Context;

import com.gmd.gasnatural.data.model.DataOpciones;
import com.gmd.gasnatural.data.services.CoberturaRedService;
import com.gmd.gasnatural.data.services.CoberturaRedServiceCallback;
import com.gmd.gasnatural.data.services.request.CoberturaServicioGasNaturalInRO;
import com.gmd.gasnatural.data.services.response.CoberturaServicioGasNaturalOutRO;
import com.gmd.gasnatural.domain.callback.OpcionesMainCallback;
import com.gmd.gasnatural.presentation.view.OpcionesMainView;

/**
 * Created by tincio on 22/07/2016.
 */
public class OpcionesMainInteractor {
    OpcionesMainCallback callback;
    DataOpciones dataOpciones;
    Context context;

    public OpcionesMainInteractor(OpcionesMainCallback callback, Context context){
        this.callback = callback;
        this.context = context;
    }

    public void getListOpciones(){
        try{
            dataOpciones = new DataOpciones(context);
            callback.onResponse(dataOpciones.getListaOpciones());
        }catch(Exception e){
            throw e;
        }
    }


}
