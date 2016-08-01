package com.gmd.gasnatural.domain.callback;

import com.gmd.gasnatural.data.services.response.CoberturaServicioGasNaturalOutRO;

/**
 * Created by tincio on 22/07/2016.
 */
public interface MensajeVerificandoCallback {
    /**Verificar red de gas por tu localidad*/
    public void onResponseVerificarRed(CoberturaServicioGasNaturalOutRO mCobertura, String message);
}
