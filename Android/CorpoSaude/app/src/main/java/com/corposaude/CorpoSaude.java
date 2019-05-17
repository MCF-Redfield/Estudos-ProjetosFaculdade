package com.corposaude;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CorpoSaude extends Activity {

	Button btficha, btcalculadora;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_corpo_saude);
		
		btficha =(Button) findViewById(R.id.btficha);
		btcalculadora=(Button) findViewById(R.id.btcalculadora);
		
		btcalculadora.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(CorpoSaude.this,
                        Calculadora.class);

                startActivity(intent);

                finish();
				
			}
		});
		

	btficha.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
            intent.setClass(CorpoSaude.this,
                    Fichas.class);

            startActivity(intent);

            finish();
			
		}
	});
	}
	}

