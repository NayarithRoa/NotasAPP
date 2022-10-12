package com.example.notas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.notas.adapters.ListaEstudiantesAdapter;
import com.example.notas.db.helpers.DBnotas;
import com.example.notas.models.Notas;

import java.util.ArrayList;

public class ListadoEstudiantes extends AppCompatActivity {
    RecyclerView listaEstudiantes;
    ArrayList<Notas> listaArrayEstudiantes;
    ListaEstudiantesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_estudiante);

        listaEstudiantes = findViewById(R.id.listaEstudiantes);
        listaEstudiantes.setLayoutManager(new LinearLayoutManager(this));

        DBnotas dBnotas = new DBnotas(ListadoEstudiantes.this);

        listaArrayEstudiantes= new ArrayList<>();
        adapter= new ListaEstudiantesAdapter(dBnotas.mostrarEstudiantes());
        listaEstudiantes.setAdapter(adapter);
    }
}