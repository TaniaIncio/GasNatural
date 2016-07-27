package com.gmd.gasnatural.presentation.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmd.gasnatural.R;
import com.gmd.gasnatural.presentation.adapter.AdapterRecyclerDistritos;
import com.gmd.gasnatural.presentation.adapter.AdapterRecyclerInstaladores;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListDistritoFragment extends Fragment {


    @Bind(R.id.rec_distritos)
    RecyclerView recDistritos;
    AdapterRecyclerDistritos adapterDistritos;
    RecyclerView.LayoutManager mLayoutManager;
    public static String TAG = "ListDistritoFragment";

    public ListDistritoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_list_distrito, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recDistritos.setLayoutManager(mLayoutManager);
        String[] array = new String[10];
        adapterDistritos = new AdapterRecyclerDistritos(array);
        recDistritos.setAdapter(adapterDistritos);
    }
}
