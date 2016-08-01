package com.gmd.gasnatural.presentation.presenter;

import com.gmd.gasnatural.data.services.request.CoberturaServicioGasNaturalInRO;
import com.gmd.gasnatural.data.services.response.CoberturaServicioGasNaturalOutRO;
import com.gmd.gasnatural.domain.callback.MensajeVerificandoCallback;
import com.gmd.gasnatural.domain.interactor.MensajeVerificandoInteractor;
import com.gmd.gasnatural.presentation.view.MensajeVerificandoView;

/**
 * Created by tincio on 22/07/2016.
 */
public class MensajeVerificandoPresenter implements MvpPresenter<MensajeVerificandoView>, MensajeVerificandoCallback {

    MensajeVerificandoView view;
    MensajeVerificandoInteractor interactor;
    @Override
    public void setView(MensajeVerificandoView view) {
        this.view = view;
        interactor = new MensajeVerificandoInteractor(this,view.getContext());
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    /**Para verificar si la red pasa por tu vivienda*/
    public void getVerificarRed(CoberturaServicioGasNaturalInRO mCobertura){
        interactor.getVerificarRed(mCobertura);
    }

    @Override
    public void onResponseVerificarRed(CoberturaServicioGasNaturalOutRO mCobertura, String message) {
        view.showCoberturaOutRO(mCobertura, message);
    }
    /***Fin verificar red*/
}
