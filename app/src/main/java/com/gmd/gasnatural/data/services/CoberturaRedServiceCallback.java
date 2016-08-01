package com.gmd.gasnatural.data.services;

import com.gmd.gasnatural.data.services.response.CoberturaServicioGasNaturalOutRO;

/**
 * Created by tincio on 01/08/2016.
 */
public interface CoberturaRedServiceCallback {

    public void onCallbackVerificarRed(CoberturaServicioGasNaturalOutRO mCobertura, String message);
}
