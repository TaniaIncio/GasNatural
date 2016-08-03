package com.gmd.gasnatural.data.services;

import com.gmd.gasnatural.data.services.response.EmpresaInstaladoraSeleccionadaOutRO;

/**
 * Created by tincio on 01/08/2016.
 */
public interface DetalleEmpresaInstaladoraServiceCallback {

    public void onCallbackDetalleEmpresaInstaladora(EmpresaInstaladoraSeleccionadaOutRO mEmpresa, String message);

}
