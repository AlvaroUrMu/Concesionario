package org.ivz.pmdm.aurbano.concesionario;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    Context context;
    public Coche coche;
    public TextView tvTitulo, tvRef, tvAño, tvKm, tvPotencia, tvComb, tvCambio, tvPrecio;
    public ImageView ivCar;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitulo = itemView.findViewById(R.id.tvTitulo);
        tvRef = itemView.findViewById(R.id.tvRef);
        tvAño = itemView.findViewById(R.id.tvAño);
        tvKm = itemView.findViewById(R.id.tvKm);
        tvPotencia = itemView.findViewById(R.id.tvPotencia);
        tvComb = itemView.findViewById(R.id.tvComb);
        tvCambio = itemView.findViewById(R.id.tvCambio);
        tvPrecio = itemView.findViewById(R.id.tvPrecio);
        ivCar = itemView.findViewById(R.id.ivCar);

        itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("coche", coche);
            context.startActivity(intent);
        });
    }
}
