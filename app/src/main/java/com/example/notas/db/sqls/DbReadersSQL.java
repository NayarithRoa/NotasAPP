package com.example.notas.db.sqls;

import com.example.notas.db.contracts.DbReaderContract.NotasSchema;

public final class DbReadersSQL {
    private DbReadersSQL(){}

    public static class NotasSchemaSQL{
        public static final String SQL_CREATE = "CREATE TABLE "+ NotasSchema.TABLE_NAME+"("
                +NotasSchema._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +NotasSchema.COLUMN_NAME_NOMBRES + " TEXT,"
                +NotasSchema.COLUMN_NAME_NOTA1 + " TEXT,"
                +NotasSchema.COLUMN_NAME_NOTA2 + " TEXT,"
                +NotasSchema.COLUMN_NAME_NOTA3 + " TEXT,"
                +NotasSchema.COLUMN_NAME_NOTA4 + " TEXT"
                +")";

        public static final String SQL_DELETE = "DROP TABLE IF EXISTS " + NotasSchema.TABLE_NAME;
    }
}
