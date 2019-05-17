package com.matheus.bloconotas;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BNMainActivity extends AppCompatActivity {

    EditText editTextNota;
    Button buttonCriar;
    ListView listView;
    private ArrayList<String> notas = new ArrayList<String>();
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bnmain);

        buttonCriar = (Button) findViewById(R.id.buttonCriar);
        editTextNota = (EditText) findViewById(R.id.editTextNota);
        listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notas);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(BNMainActivity.this);
                alerta.setTitle("Alerta!");
                alerta.setMessage("Deseja excluir essa nota?");
                final int posicaoToRemover = position;
                alerta.setNegativeButton("Não", null);
                alerta.setPositiveButton("Sim", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        notas.remove(posicaoToRemover);
                        adapter.notifyDataSetChanged();
                    }
                });
                AlertDialog desparaAlerta = alerta.create();
                desparaAlerta.show();
                Log.i("qwert", "algo");
            }
        });
    }

    public void addNota(View view) {
        if (editTextNota.length() > 0) {
            notas.add(editTextNota.getText().toString());
            editTextNota.setText("");
            editTextNota.findFocus();
            adapter.notifyDataSetChanged();
        }
    }


}
