package com.matheus.projetofinalmatheuscorreiaflorencio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matheus on 28/06/2017.
 */

public class DBHelper
{
    public static final String DATABASE_NAME = "cpf.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "pfisica";

    private Context context;
    private SQLiteDatabase db;

    private SQLiteStatement insertStmt;
    public static final String INSERT = "insert into " + TABLE_NAME + " (cpf, email, fone, idade, nome) values (?,?,?,?,?)";

    public DBHelper(Context context) {
        this.context = context;
        OpenHelper openHelper = new OpenHelper(context);
        this.db = openHelper.getWritableDatabase();
        this.insertStmt = this.db.compileStatement(INSERT);
    }

    /*método para inserir no BD*/
    public long insert(String cpf, String email, String fone, int idade, String nome) {
        Log.i("TeeesteDBH»", "inserir1");
        this.insertStmt.bindString(1, cpf);
        this.insertStmt.bindString(2, email);
        this.insertStmt.bindString(3, fone);
        this.insertStmt.bindString(4, idade+"");
        this.insertStmt.bindString(5, nome);

        Log.i("TeeesteDBH»", "inserir2");
        return this.insertStmt.executeInsert();

    }

    /*método para deletar tabela no BD*/
    public void deleteAll() {
        this.db.delete(TABLE_NAME, null, null);
    }

    /*método para listar itens o BD*/
    public List<PessoaFisica> queryGetAll()
    {
        List<PessoaFisica> listPFisica = new ArrayList<PessoaFisica>();

        Cursor cursor = this.db.query(TABLE_NAME, new String[]{"cpf", "email", "fone", "idade", "nome"},
                null, null, null, null, null, null);

        int numRegistros = cursor.getCount();
        if (numRegistros != 0) {
            cursor.moveToFirst();
            do {
                PessoaFisica pessoaFisica = new PessoaFisica(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                        Integer.parseInt(cursor.getString(3)),cursor.getString(4));

                listPFisica.add(pessoaFisica);
            } while (cursor.moveToNext());

            if (cursor != null && !cursor.isClosed())
                cursor.close();

            return listPFisica;

        } else {
            return null;
        }
    }

    private static class OpenHelper extends SQLiteOpenHelper
    {
        public OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            String sql = "create table if not exists " + TABLE_NAME + " (id INTEGER primary key AUTOINCREMENT, nome TEXT," +
                    " email TEXT, cpf TEXT, fone TEXT, idade smallint);";
            db.execSQL(sql);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            db.execSQL("drop table if exists " + TABLE_NAME);
            onCreate(db);
        }
    }


}
