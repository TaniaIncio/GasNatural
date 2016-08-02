package com.gmd.gasnatural.presentation.presenter;

import com.gmd.gasnatural.data.services.request.EmpresaInstaladoraInRO;
import com.gmd.gasnatural.data.services.response.EmpresasInstaladorasOutRO;
import com.gmd.gasnatural.domain.callback.EmpresasInstaladorasCallback;
import com.gmd.gasnatural.domain.interactor.EmpresasInstaladorasInteractor;
import com.gmd.gasnatural.presentation.view.ListaInstaladoresView;

/**
 * Created by tincio on 22/07/2016.
 */
public class EmpresaInstaladoraPresenter implements MvpPresenter<ListaInstaladoresView>, EmpresasInstaladorasCallback {

    ListaInstaladoresView view;
    EmpresasInstaladorasInteractor interactor;
    @Override
    public void setView(ListaInstaladoresView view) {
        this.view = view;
        interactor = new EmpresasInstaladorasInteractor(this,view.getContext());
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    /**Para verificar si la red pasa por tu vivienda*/
    public void getListaEmpresasInstaladoras(EmpresaInstaladoraInRO mEmpresa){
        interactor.getListaEmpresasInstaladoras(mEmpresa);
    }

    @Override
    public void onResponse(EmpresasInstaladorasOutRO objEmpresas, String message) {
        view.showEmpresasInstaladorasOutRO(objEmpresas, message);
    }
    /***Fin verificar red*/
}
