package com.mariano.ejemplobuscador.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mariano.ejemplobuscador.Models.Integrantes;
import com.mariano.ejemplobuscador.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdaptadorIntegrantes extends RecyclerView.Adapter<AdaptadorIntegrantes.ViewHolder> {

    private List<Integrantes> lista;
    private List<Integrantes> listaOriginal;
    private Context con;

    public AdaptadorIntegrantes(List<Integrantes> lista) {
        this.lista=lista;
    }
    public AdaptadorIntegrantes(List<Integrantes> lista, Context c){
        this.lista=lista;
        this.con=c;

        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(lista);
    }

    @NonNull
    @Override
    public AdaptadorIntegrantes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(con).inflate(R.layout.item_integrante, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorIntegrantes.ViewHolder holder, int position) {
        holder.llenar(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }

    public void filtrado(String txtBuscar)
    {
        int longitud = txtBuscar.length();

        if (longitud == 0)
        {
            lista.clear();
            lista.addAll(listaOriginal);
        }
        else
        {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Integrantes> collection = lista.stream().filter(i -> i.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())).collect(Collectors.toList());
                lista.clear();
                lista.addAll(collection);
            }
        }

        //Para notificar cambios en la data
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txt_name);
        }

        public void llenar(Integrantes integrantes)
        {
            txt.setText(integrantes.getNombre());
        }
    }
}
