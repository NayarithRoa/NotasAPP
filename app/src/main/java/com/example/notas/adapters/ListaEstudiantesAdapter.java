package com.example.notas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.notas.R;
import com.example.notas.models.Notas;

import java.util.ArrayList;
import java.util.List;

public class ListaEstudiantesAdapter extends RecyclerView.Adapter<ListaEstudiantesAdapter.ViewHolder> {

    private ArrayList<Notas> listaEstudiantes;

    public ListaEstudiantesAdapter(ArrayList<Notas> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
        //this.layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ListaEstudiantesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_estudiante, null, false);
        return new ListaEstudiantesAdapter.ViewHolder(view);
    }

    @Override
    //Asignar los elementos a cada una de las opciones
    public void onBindViewHolder(@NonNull ListaEstudiantesAdapter.ViewHolder viewHolder, int position) {
        viewHolder.viewNombre.setText(listaEstudiantes.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaEstudiantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView viewNombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewNombre = itemView.findViewById(R.id.viewNombre);
        }

    }
}
