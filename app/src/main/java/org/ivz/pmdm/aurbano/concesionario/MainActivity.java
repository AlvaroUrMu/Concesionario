package org.ivz.pmdm.aurbano.concesionario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    private static final String URL = "jdbc:mariadb://146.59.237.189:3306/dam208_aumconcesionario";
    private static final String USER = "dam208_aum";
    private static final String PASSWORD = "dam208_aum";

    Context context;
    AppBarConfiguration appBarConfiguration;
    ArrayList<Coche> listaCoches = new ArrayList<>();

    RecyclerView recyclerCoches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        //Ejecutar la extracción de datos de la BD
        new InfoAsyncTask().execute();

        //Creación de la toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        //Creación del menú lateral desplegable
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        appBarConfiguration = new AppBarConfiguration.Builder()
                .setOpenableLayout(drawer)
                .build();
    }

    public void initialize(){
        recyclerCoches = findViewById(R.id.recyclerCoches);
        recyclerCoches.setLayoutManager(new LinearLayoutManager(context));
        Adapter adapter = new Adapter(context);
        recyclerCoches.setAdapter(adapter);
        adapter.setListaCoches(listaCoches);
    }

    //Crear clase necesaria para la conexión con la base de datos
    //Básicamente extraigo los datos de MySQL y los introduzco en un ArrayList
    @SuppressLint("StaticFieldLeak")
    public class InfoAsyncTask extends AsyncTask<Void, Void, ArrayList<Coche>> {
        @Override
        protected ArrayList<Coche> doInBackground(Void... voids) {
            ArrayList<Coche> coches = new ArrayList<>();
            Connection connection;

            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                String sql = "SELECT * FROM coches";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                resultSet.first();
                Coche coche;
                coche = carCreator(resultSet);
                listaCoches.add(coche);
                while (resultSet.next()) {
                    coche = carCreator(resultSet);
                    listaCoches.add(coche);
                    coches.add(coche);
                }
                return coches;
            } catch (Exception e) {
                Log.e("InfoAsyncTask", "Error reading school information", e);
            }
            return coches;
        }

        public Coche carCreator(ResultSet resultSet){
            int ref = 0, precio = 0, km = 0, potencia = 0, npuertas = 0, año = 0;
            String titulo = "", descripcion = "", url = "", imagenes = "", combustible = "",
                    cambio = "", color = "";

            try{
                ref = resultSet.getInt("ref");
                titulo = resultSet.getString("titulo");
                descripcion = resultSet.getString("descripcion");
                url = resultSet.getString("url");
                imagenes = resultSet.getString("imagenes");
                precio = resultSet.getInt("precio");
                combustible = resultSet.getString("combustible");
                km = resultSet.getInt("km");
                cambio = resultSet.getString("cambio");
                potencia = resultSet.getInt("potencia");
                npuertas = resultSet.getInt("npuertas");
                color = resultSet.getString("color");
                año = resultSet.getInt("año");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            Coche coche = new Coche(ref, titulo, descripcion, url, imagenes, precio, combustible, km,
                    cambio, potencia, npuertas, color, año);

            return coche;
        }

        @Override
        protected void onPostExecute(ArrayList<Coche> lista) {
            if (!lista.isEmpty()) {

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}