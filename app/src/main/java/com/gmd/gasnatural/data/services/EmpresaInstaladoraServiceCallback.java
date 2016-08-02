package com.gmd.gasnatural.data.services;

import com.gmd.gasnatural.data.services.response.CoberturaServicioGasNaturalOutRO;
import com.gmd.gasnatural.data.services.response.EmpresasInstaladorasOutRO;

/**
 * Created by tincio on 01/08/2016.
 */
public interface EmpresaInstaladoraServiceCallback {

    public void onCallbackEmpresaInstaladora(EmpresasInstaladorasOutRO mEmpresa, String message);
}
