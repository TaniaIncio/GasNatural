package com.gmd.gasnatural.presentation.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmd.gasnatural.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListaInstaladoresActivity extends AppCompatActivity {

    @Bind(R.id.icon_back_listainstaladores)
    ImageView imgBack;
    @Bind(R.id.txt_titulo_listainstaladores)
    TextView txtTituloToolbar;
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_instaladores, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
