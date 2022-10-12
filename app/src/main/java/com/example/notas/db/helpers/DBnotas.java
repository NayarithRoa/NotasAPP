package com.example.notas.db.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;
import com.example.notas.db.contracts.DbReaderContract.NotasSchema;
import com.example.notas.models.Notas;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBnotas extends DbHelper {

    private Context context;

    public DBnotas(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insert(Notas notas){
        try{
            DbHelper dbHelper = new DbHelper(this.context);
            SQLiteDatabase db = dbHelper.getWritableDatabase(); //Crea base de datos
            ContentValues contentValues = new ContentValues();
            contentValues.put(NotasSchema.COLUMN_NAME_NOMBRES, notas.getNombre());
            contentValues.put(NotasSchema.COLUMN_NAME_NOTA1, notas.getNota_1());
            contentValues.put(NotasSchema.COLUMN_NAME_NOTA2, notas.getNota_2());
            contentValues.put(NotasSchema.COLUMN_NAME_NOTA3, notas.getNota_3());
            contentValues.put(NotasSchema.COLUMN_NAME_NOTA4, notas.getNota_4());
            return db.insert(NotasSchema.TABLE_NAME,null,contentValues);
        }catch (Exception ex){
            System.err.println(ex);
            return 0;
        }
    }

    public ArrayList<Notas> mostrarEstudiantes() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase(); //Escribe

        ArrayList<Notas> listaEstudiante = new ArrayList<>();
        Notas nota;
        Cursor cursorEstudiante;

        cursorEstudiante = db.rawQuery("SELECT * FROM " + NotasSchema.TABLE_NAME + " ORDER BY nombres ASC", null);

        if (cursorEstudiante.moveToFirst()) {
            do {
                nota = new Notas();
                nota.setId(cursorEstudiante.getInt(0));
                nota.setNombre(cursorEstudiante.getString(1));

                listaEstudiante.add(nota);
            } while (cursorEstudiante.moveToNext());
        }

        cursorEstudiante.close();

        return listaEstudiante;
    }

}
