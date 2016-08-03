package com.gmd.gasnatural.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmd.gasnatural.R;
import com.gmd.gasnatural.data.services.response.EmpresaInstaladora;
import com.gmd.gasnatural.domain.interactor.EmpresasInstaladorasInteractor;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tincio on 22/07/2016.
 */
public class AdapterRecyclerInstaladores extends RecyclerView.Adapter<AdapterRecyclerInstaladores.ViewHolderItem> {

    List<EmpresaInstaladora> listaEmpresas;

    public AdapterRecyclerInstaladores(List<EmpresaInstaladora> listaEmpresas){
        this.listaEmpresas = listaEmpresas;
    }
    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_instaladores, parent, false);
        ViewHolderItem viewHolder = new ViewHolderItem(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        //holder.txtItemRecycler.setText(arrayString[position]);
        EmpresaInstaladora mEmpresa = listaEmpresas.get(position);
        holder.txtIdEmpresa.setText(mEmpresa.getIdEmpresaInstaladora().toString());
        holder.txtNombreEmpresaInstaladora.setText(mEmpresa.getNombreEmpresaInstaladora());
        holder.txtPrecioEstimado.setText(mEmpresa.getPrecioEstimadoInstalacionTipicaEmpresaInstaladora());
    }

    @Override
    public int getItemCount() {
        return listaEmpresas.size();
    }

    public class ViewHolderItem extends RecyclerView.ViewHolder {

        @Bind(R.id.txt_idempresa)
        TextView txtIdEmpresa;
        @Bind(R.id.txt_nombre_empresainstaladora)
        TextView txtNombreEmpresaInstaladora;
        @Bind(R.id.txt_precioestimado)
        TextView txtPrecioEstimado;
        @Bind(R.id.linear_row_instalador)
        LinearLayout linearRowInstalador;
        public ViewHolderItem(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.setOnItemClickListener(listaEmpresas.get(getPosition()));
                }
            });
            linearRowInstalador.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.setOnItemClickListener(listaEmpresas.get(getPosition()));
                }
            });
        }
    }

    OnItemClickListener mOnItemClickListener;
    public interface OnItemClickListener{
        public void setOnItemClickListener(EmpresaInstaladora mEmpresa);
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener){
        this.mOnItemClickListener = mItemClickListener;
    }

}
