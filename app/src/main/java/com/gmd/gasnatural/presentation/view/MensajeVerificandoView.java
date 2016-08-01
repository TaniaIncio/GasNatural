package com.gmd.gasnatural.presentation.view;

import com.gmd.gasnatural.data.services.response.CoberturaServicioGasNaturalOutRO;

/**
 * Created by tincio on 22/07/2016.
 */
public interface MensajeVerificandoView extends MvpView {

    public void showCoberturaOutRO(CoberturaServicioGasNaturalOutRO mCoberturaOutRO, String message);
}
