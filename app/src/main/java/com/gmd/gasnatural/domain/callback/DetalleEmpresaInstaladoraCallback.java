package com.gmd.gasnatural.domain.callback;

import com.gmd.gasnatural.data.services.response.EmpresaInstaladoraSeleccionadaOutRO;

/**
 * Created by tincio on 01/08/2016.
 */
public interface DetalleEmpresaInstaladoraCallback {
    public void onResponse(EmpresaInstaladoraSeleccionadaOutRO mEmpresa, String message);
}
