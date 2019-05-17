package com.corposaude;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tabela extends Activity {
	
	Button  voltar;	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabela);

		voltar= (Button) findViewById(R.id.btvoltarr);

		

		voltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
                intent.setClass(Tabela.this,
                        Calculadora.class);

                startActivity(intent);

                finish();
				
			}
		});

	}

	
}
