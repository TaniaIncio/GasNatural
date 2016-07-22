package com.gmd.gasnatural.domain.interactor;

import com.gmd.gasnatural.domain.callback.OpcionesMainCallback;
import com.gmd.gasnatural.presentation.view.OpcionesMainView;

/**
 * Created by tincio on 22/07/2016.
 */
public class OpcionesMainInteractor {
    OpcionesMainCallback callback;

    public OpcionesMainInteractor(OpcionesMainCallback callback){
        this.callback = callback;
    }

    public void getListOpciones(){
        try{

           // callback.onResponse();
        }catch(Exception e){
            throw e;
        }
    }

}
