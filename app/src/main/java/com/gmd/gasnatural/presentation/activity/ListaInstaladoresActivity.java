package com.gmd.gasnatural.presentation.activity;

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
import com.gmd.gasnatural.presentation.adapter.AdapterRecyclerInstaladores;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListaInstaladoresActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.icon_back_listainstaladores)
    ImageView imgBack;
    @Bind(R.id.txt_titulo_listainstaladores)
    TextView txtTituloToolbar;
    @Bind(R.id.rec_instaladores)
    RecyclerView recInstaladores;
    AdapterRecyclerInstaladores adapterInstaladores;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_instaladores);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_lista_instaladores);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        txtTituloToolbar.setText(getResources().getString(R.string.titulo_lista_instaladores));
        mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recInstaladores.setLayoutManager(mLayoutManager);
        String[] array = new String[6];
        adapterInstaladores = new AdapterRecyclerInstaladores(array);
        recInstaladores.setAdapter(adapterInstaladores);
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
}
