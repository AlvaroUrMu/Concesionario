package org.ivz.pmdm.aurbano.concesionario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Coche> listaCoches;
    private Context context;

    public Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_coches, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Coche cochazo = listaCoches.get(position);

        holder.coche = cochazo;
        holder.tvRef.setText(cochazo.getRef());
        holder.tvTitulo.setText(cochazo.getTitulo());
        holder.tvAño.setText(cochazo.getAño());
        holder.tvKm.setText(cochazo.getKm());
        holder.tvPotencia.setText(cochazo.getPotencia());
        holder.tvComb.setText(cochazo.getComb());
        holder.tvCambio.setText(cochazo.getCambio());
        holder.tvPrecio.setText(cochazo.getPrecio());

        Glide.with(context).load(cochazo.getImg()).into(holder.ivCar);
    }

    @Override
    public int getItemCount() {
        if (listaCoches == null)
            return 0;
        return listaCoches.size();
    }

    public void setListaCoches(ArrayList<Coche> listaCoches){
        this.listaCoches = listaCoches;
    }
}
