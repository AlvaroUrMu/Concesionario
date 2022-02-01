package org.ivz.pmdm.aurbano.concesionario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    private Coche coche;
    ArrayList<Coche> listaCoches = new ArrayList<>();
    private ImageView ivDetailImage;
    private TextView tvDetailTitulo, tvDetailDesc, tvDetailPrecio, tvDetailComb, tvDetailKm, tvDetailCambio,
        tvDetailPotencia, tvDetailNpuertas, tvDetailColor, tvDetailAño;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Inicializar componentes
        initialize();

        //Recibir el intent de la MainActivity
        this.coche = getIntent().getParcelableExtra("coche");

        //Mostrar los datos recibidos
        Glide.with(getApplicationContext()).load(coche.getImg()).into(ivDetailImage);
        tvDetailTitulo.setText(coche.getTitulo());
        tvDetailDesc.setText(coche.getDesc());
        tvDetailPrecio.setText(coche.getPrecio());
        tvDetailComb.setText(coche.getComb());
        tvDetailKm.setText(coche.getKm());
        tvDetailCambio.setText(coche.getCambio());
        tvDetailPotencia.setText(coche.getPotencia());
        tvDetailNpuertas.setText(coche.getNpuertas());
        tvDetailColor.setText(coche.getColor());
        tvDetailAño.setText(coche.getAño());
    }

    //Método para inicializar los componentes
    private void initialize() {
        ivDetailImage = findViewById(R.id.ivDetailImage);
        tvDetailTitulo = findViewById(R.id.tvDetailTitulo);
        tvDetailDesc = findViewById(R.id.tvDetailDesc);
        tvDetailPrecio = findViewById(R.id.tvDetailPrecio);
        tvDetailComb = findViewById(R.id.tvDetailComb);
        tvDetailKm = findViewById(R.id.tvDetailKm);
        tvDetailCambio = findViewById(R.id.tvDetailCambio);
        tvDetailPotencia = findViewById(R.id.tvDetailPotencia);
        tvDetailNpuertas = findViewById(R.id.tvDetailNpuertas);
        tvDetailColor = findViewById(R.id.tvDetailColor);
        tvDetailAño = findViewById(R.id.tvDetailAño);
    }
}