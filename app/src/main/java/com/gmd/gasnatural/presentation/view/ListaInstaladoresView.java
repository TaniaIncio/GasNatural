package com.gmd.gasnatural.presentation.view;

import com.gmd.gasnatural.data.services.response.CoberturaServicioGasNaturalOutRO;
import com.gmd.gasnatural.data.services.response.EmpresasInstaladorasOutRO;

/**
 * Created by tincio on 22/07/2016.
 */
public interface ListaInstaladoresView extends MvpView {

    public void showEmpresasInstaladorasOutRO(EmpresasInstaladorasOutRO mEmpresasInstaladorasOutRO, String message);
}
