package com.gmd.gasnatural.domain.interactor;

import com.gmd.gasnatural.data.model.DataOpciones;
import com.gmd.gasnatural.domain.callback.OpcionesMainCallback;
import com.gmd.gasnatural.presentation.view.OpcionesMainView;

/**
 * Created by tincio on 22/07/2016.
 */
public class OpcionesMainInteractor {
    OpcionesMainCallback callback;
    DataOpciones dataOpciones;
    OpcionesMainView view;

    public OpcionesMainInteractor(OpcionesMainCallback callback, OpcionesMainView view){
        this.callback = callback;
        this.view = view;
    }

    public void getListOpciones(){
        try{
            dataOpciones = new DataOpciones(view.getContext());
            callback.onResponse(dataOpciones.getListaOpciones());
        }catch(Exception e){
            throw e;
        }
    }

}
