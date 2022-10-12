package com.example.notas.db.contracts;

import android.provider.BaseColumns;

    public final class DbReaderContract {
        private DbReaderContract() {}

        public static class NotasSchema implements BaseColumns {
            public static final String TABLE_NAME = "notasAlumnos";
            public static final String COLUMN_NAME_NOMBRES = "nombres";
            public static final String COLUMN_NAME_NOTA1 = "nota1";
            public static final String COLUMN_NAME_NOTA2 = "nota2";
            public static final String COLUMN_NAME_NOTA3 = "nota3";
            public static final String COLUMN_NAME_NOTA4 = "nota4";
        }
}
