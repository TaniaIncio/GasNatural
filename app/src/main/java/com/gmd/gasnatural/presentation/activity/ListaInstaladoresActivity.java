package com.gmd.gasnatural.presentation.activity;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmd.gasnatural.R;
import com.gmd.gasnatural.data.services.request.EmpresaInstaladoraInRO;
import com.gmd.gasnatural.data.services.response.EmpresaInstaladora;
import com.gmd.gasnatural.data.services.response.EmpresasInstaladorasOutRO;
import com.gmd.gasnatural.presentation.adapter.AdapterRecyclerInstaladores;
import com.gmd.gasnatural.presentation.presenter.EmpresaInstaladoraPresenter;
import com.gmd.gasnatural.presentation.util.AlertSender;
import com.gmd.gasnatural.presentation.view.ListaInstaladoresView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListaInstaladoresActivity extends AppCompatActivity implements ListaInstaladoresView, View.OnClickListener{

    @Bind(R.id.icon_back_listainstaladores)
    ImageView imgBack;
    @Bind(R.id.txt_titulo_listainstaladores)
    TextView txtTituloToolbar;
    @Bind(R.id.rec_instaladores)
    RecyclerView recInstaladores;
    AdapterRecyclerInstaladores adapterInstaladores;
    RecyclerView.LayoutManager mLayoutManager;
    EmpresaInstaladoraPresenter presenter;
    ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_instaladores);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_lista_instaladores);
        ButterKnife.bind(this);
        presenter = new EmpresaInstaladoraPresenter();
        presenter.setView(this);
        /****/
        EmpresaInstaladoraInRO mEmpresa = new EmpresaInstaladoraInRO();
        mEmpresa.setToken("");
        mEmpresa.setAppInvoker("GMD");
        mEmpresa.setAsociadoFiseEmpresaInstaladora("S");
        mEmpresa.setIdCategoriaInstalacion(1);
        mEmpresa.setUbigeoEmpresaInstaladora("150135");
        mEmpresa.setTipoPersonaEmpresaInstaladora("J");
        presenter.getListaEmpresasInstaladoras(mEmpresa);
    }

    @Override
    protected void onResume() {
        super.onResume();
        txtTituloToolbar.setText(getResources().getString(R.string.titulo_lista_instaladores));
        mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recInstaladores.setLayoutManager(mLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_instaladores, menu);
        // Associate searchable configuration with the SearchView
        /****
         * Uso de Search widget
         */
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            /***Para superponer el toolbar con una caja de busqueda*/
         //   onSearchRequested();
            return true;
        }
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, FiltrosActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSearchRequested() {
        Bundle appData = new Bundle();
        appData.putString("hello", "world");
        startSearch(null, false, appData, false);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.icon_back_listainstaladores:
                onBackPressed();break;
        }
    }

    @Override
    public void showEmpresasInstaladorasOutRO(EmpresasInstaladorasOutRO mEmpresasInstaladorasOutRO, String message) {
        if(mEmpresasInstaladorasOutRO.getResultCode()==1)
            adapterInstaladores = new AdapterRecyclerInstaladores(mEmpresasInstaladorasOutRO.getEmpresasInstaladoras());
        recInstaladores.setAdapter(adapterInstaladores);
        setEventClickItemList();
    }

    @Override
    public void showLoading() {
        mProgress= AlertSender.showProgressDialog(this,"","");
    }

    @Override
    public void closeLoading() {
        mProgress.dismiss();
    }

    @Override
    public Context getContext() {
        return this;
    }

    public void setEventClickItemList(){
        try{
            adapterInstaladores.setOnItemClickListener(new AdapterRecyclerInstaladores.OnItemClickListener() {
                @Override
                public void setOnItemClickListener(EmpresaInstaladora mEmpresa) {
                    startActivity(new Intent(getApplicationContext(), DetalleEmpresaInstaladoraActivity.class));
                }
            });
        }catch(Exception e){

        }
    }
}
