package com.corposaude;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SobreCorpo extends Activity{
	
	Button ecto, meso, volta, endo;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sobrecorpo);
		
		ecto =(Button) findViewById(R.id.ectomorfo);
		meso =(Button) findViewById(R.id.mesomorfo);
		endo=(Button) findViewById(R.id.endomorfo);
		volta =(Button) findViewById(R.id.btvoltar);
		endo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(SobreCorpo.this,
                        SobreCorpoEndo.class); 

                startActivity(intent);

                finish();
			}
		});
		meso.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(SobreCorpo.this,
                        SobreCorpoMeso.class); 

                startActivity(intent);

                finish();
				
			}
		});
		
		
		ecto.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(SobreCorpo.this,
                        SobreCorpoEcto.class); 

                startActivity(intent);

                finish();
				
			}
		});
		volta.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(SobreCorpo.this,
                       Fichas.class); 

                startActivity(intent);

                finish();
				
			}
		});
}
}
