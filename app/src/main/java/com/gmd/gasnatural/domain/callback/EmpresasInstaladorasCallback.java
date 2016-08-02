package com.gmd.gasnatural.domain.callback;

import com.gmd.gasnatural.data.services.response.CoberturaServicioGasNaturalOutRO;
import com.gmd.gasnatural.data.services.response.EmpresasInstaladorasOutRO;

/**
 * Created by tincio on 01/08/2016.
 */
public interface EmpresasInstaladorasCallback {
    public void onResponse(EmpresasInstaladorasOutRO objEmpresas, String message);

}
