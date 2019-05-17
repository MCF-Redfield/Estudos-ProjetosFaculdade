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

public class Fichas extends Activity {
	
	Button btmecto, voltar, btmeso, btsobre, btendo, criar;	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fichas);
		
		btmecto= (Button) findViewById(R.id.btectomorfo);
		btmeso= (Button) findViewById(R.id.btmesomorfo);
		voltar= (Button) findViewById(R.id.btvoltar);
		btsobre= (Button) findViewById(R.id.btsobre);
		btendo= (Button) findViewById(R.id.btendomorfo);
		criar =(Button) findViewById(R.id.criarficha);
		
		criar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(Fichas.this,
                        FichaNova.class);

                startActivity(intent);

                finish();
			}
		});
		
		btendo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(Fichas.this,
                        FichaEndomorfo.class);

                startActivity(intent);

                finish();
			}
		});
		btsobre.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(Fichas.this,
                        SobreCorpo.class);

                startActivity(intent);

                finish();
				

				
			}
		});
		
		btmeso.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(Fichas.this,
                        FichaMesomorfo.class);

                startActivity(intent);

                finish();
				
			}
		});
		btmecto.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(Fichas.this,
                        FichaEctomorfo.class);

                startActivity(intent);

                finish();
				
			}
		});
		
		voltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
                intent.setClass(Fichas.this,
                        CorpoSaude.class);

                startActivity(intent);

                finish();
				
			}
		});

	}

	
}
