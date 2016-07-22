package com.gmd.gasnatural.presentation.presenter;

import com.gmd.gasnatural.domain.callback.OpcionesMainCallback;
import com.gmd.gasnatural.domain.interactor.OpcionesMainInteractor;
import com.gmd.gasnatural.presentation.view.OpcionesMainView;

/**
 * Created by tincio on 22/07/2016.
 */
public class OpcionesMainPresenter implements MvpPresenter<OpcionesMainView>, OpcionesMainCallback {

    OpcionesMainView view;
    OpcionesMainInteractor interactor;
    @Override
    public void setView(OpcionesMainView view) {
        this.view = view;
        interactor = new OpcionesMainInteractor(this);
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onResponse(String[] arrayOpciones) {
        view.showListOpciones(arrayOpciones);
    }
}
