package com.gmd.gasnatural.presentation.view;

import com.gmd.gasnatural.data.services.response.EmpresaInstaladoraSeleccionadaOutRO;

/**
 * Created by tincio on 22/07/2016.
 */
public interface DetalleEmpresaInstaladoraView extends MvpView {

    void showDetalleEmpresaInstaladora(EmpresaInstaladoraSeleccionadaOutRO mEmpresasInstaladorasOutRO, String message);
    void showLoading();
    void closeLoading();
}
