package com.mariano.ejemplobuscador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.mariano.ejemplobuscador.Adaptadores.AdaptadorIntegrantes;
import com.mariano.ejemplobuscador.Models.Integrantes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView txtBuscar;
    RecyclerView re;
    AdaptadorIntegrantes awd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBuscar = findViewById(R.id.txt_search);

        txtBuscar.setOnQueryTextListener(this);

        //Lista
        List<Integrantes> integrantes = new ArrayList<>();

        integrantes.add(
                new Integrantes("Martin Vargas")
        );

        integrantes.add(
                new Integrantes("Simon Vargas")
        );

        integrantes.add(
                new Integrantes("Juan Isaza")
        );

        integrantes.add(
                new Integrantes("Juan Villamil")
        );

        integrantes.add(
                new Integrantes("Alejandro Pos")
        );

        integrantes.add(
                new Integrantes("Grant Gaustin")
        );

        integrantes.add(
                new Integrantes("Shakira")
        );

        integrantes.add(
                new Integrantes("Harry Styles")
        );

        integrantes.add(
                new Integrantes("Dua Lipa")
        );

        integrantes.add(
                new Integrantes("Enrique Bunbury")
        );

        integrantes.add(
                new Integrantes("Zoe")
        );

        integrantes.add(
                new Integrantes("Ross Lynch")
        );

        integrantes.add(
                new Integrantes("Laura Marano")
        );

        integrantes.add(
                new Integrantes("Danielle Panabeaker")
        );

        integrantes.add(
                new Integrantes("Mariano Rodriguez")
        );

        re = findViewById(R.id.recyclerM);
        re.setHasFixedSize(true);

        awd = new AdaptadorIntegrantes(integrantes, this);
        LinearLayoutManager lr = new LinearLayoutManager(this);
        re.setLayoutManager(lr);
        re.setAdapter(awd);
    }


    //Este metodo es para cuando le de enter se haga la busqueda

    @Override
    public boolean onQueryTextSubmit(String s) {
        awd.filtrado(s);
        return false;
    }

    //Este metodo es para que se haga la busqueda en tiempo real
    @Override
    public boolean onQueryTextChange(String s) {
       // awd.filtrado(s);
        return false;
    }
}