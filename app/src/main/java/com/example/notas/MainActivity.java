package com.example.notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notas.db.helpers.DBnotas;
import com.example.notas.models.Notas;

public class MainActivity extends AppCompatActivity {

    TextView txtNombre, txtnota1, txtnota2, txtnota3, txtnota4;
    Button btnCalcular;
    double nota1, nota2, nota3, nota4, sumNotas,promedio;
    int ErrorNota;
    int cantNotasIngreso=0, camposVacios=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //conexion con layout
        txtNombre = findViewById(R.id.txtNombre);
        txtnota1 = findViewById(R.id.txtnota1);
        txtnota2 = findViewById(R.id.txtnota2);
        txtnota3 = findViewById(R.id.txtnota3);
        txtnota4 = findViewById(R.id.txtnota4);
        btnCalcular = findViewById(R.id.btnCalcular);


        //Evento click boton Calcular
        btnCalcular.setOnClickListener(v-> {
            ErrorNota=0;
            camposVacios=0;
            if (txtNombre.getText().toString().length()==0 ){
                Toast.makeText(this,"Digite el nombre del estudiante",Toast.LENGTH_LONG).show();
            }
            else {
                if (txtnota1.getText().toString().length() > 0) {
                    nota1 = Integer.parseInt(txtnota1.getText().toString());
                    if (nota1 < 0 || nota1 > 5) {
                        txtnota1.setText("");
                        ErrorNota = 1;
                    } else {
                        sumNotas = sumNotas + nota1;
                        cantNotasIngreso++;
                    }
                } else {
                    camposVacios++;
                }
                if (txtnota2.getText().toString().length() > 0) {
                    nota2 = Integer.parseInt(txtnota2.getText().toString());
                    if (nota2 < 0 || nota2 > 5) {
                        txtnota2.setText("");
                        ErrorNota = 1;
                    } else {
                        sumNotas = sumNotas + nota2;
                        cantNotasIngreso++;
                    }
                } else {
                    camposVacios++;
                }
                if (txtnota3.getText().toString().length() > 0) {
                    nota3 = Integer.parseInt(txtnota3.getText().toString());
                    if (nota3 < 0 || nota3 > 5) {
                        txtnota3.setText("");
                        ErrorNota = 1;
                    } else {
                        sumNotas = sumNotas + nota3;
                        cantNotasIngreso++;
                    }
                } else {
                    camposVacios++;
                }

                if (txtnota4.getText().toString().length() > 0) {
                    nota4 = Integer.parseInt(txtnota4.getText().toString());
                    if (nota4 < 0 || nota4 > 5) {
                        txtnota4.setText("");
                        ErrorNota = 1;
                    } else {
                        sumNotas = sumNotas + nota4;
                        cantNotasIngreso++;
                    }
                } else {
                    camposVacios++;
                }
                if (camposVacios <= 2) {
                    if (ErrorNota == 0) {
                        promedio = sumNotas / cantNotasIngreso;
                        if (promedio >= 3) {
                            Toast.makeText(this, "El estudiante " + txtNombre.getText() + " ha pasado la materia, su nota final es :" + promedio, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(this, "El estudiante " + txtNombre.getText() + " NO ha pasado la materia, su nota final es:" + promedio, Toast.LENGTH_LONG).show();
                        }
                        //GUARDAR EN BASE DE DATOS --INICIO
                        Notas notas = new Notas();
                        notas.setNombre(txtNombre.getText().toString());
                        notas.setNota_1(nota1);
                        notas.setNota_2(nota2);
                        notas.setNota_3(nota3);
                        notas.setNota_4(nota4);

                        DBnotas dBnotas = new DBnotas(this);
                        Long resultado = dBnotas.insert(notas);
                        String msg = resultado ==0 ? "No se guardo la información":"Información guardada";
                        Toast.makeText(this, msg,Toast.LENGTH_LONG).show();
                        //GUARDAR EN BASE DE DATOS --FIN
                        promedio = 0;
                        sumNotas = 0;
                        cantNotasIngreso = 0;
                        txtNombre.setText("");
                        txtnota1.setText("");
                        txtnota2.setText("");
                        txtnota3.setText("");
                        txtnota4.setText("");
                        ErrorNota = 0;
                    } else {
                        Toast.makeText(this, "La nota debe estar en un rango de 0 a 5", Toast.LENGTH_LONG).show();
                        sumNotas = 0;
                        cantNotasIngreso = 0;
                    }
                }
                else{
                    Toast.makeText(this, "Debe digitar al menos dos notas", Toast.LENGTH_LONG).show();
                }
            }

        });

    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuConsultar: consultarEstudiante();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private void consultarEstudiante(){
        Intent intent=new Intent(this, ListadoEstudiantes.class);
        startActivity(intent);
    }
}