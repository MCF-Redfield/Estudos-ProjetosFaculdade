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
import android.widget.Toast;

public class Calculadora extends Activity {
	
	Button btcalcula, voltar, limpar, tabela;
	EditText peso, altura;
	double pesos, alturas, result;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculadora_imc);
		
		btcalcula= (Button) findViewById(R.id.btCalcula);
		peso=(EditText) findViewById(R.id.etpeso);
		altura=(EditText) findViewById(R.id.etaltura);
		voltar = (Button) findViewById(R.id.btvoltar);
		limpar = (Button) findViewById(R.id.btlimpar);
		tabela=(Button) findViewById(R.id.bttabela);
		
		tabela.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(Calculadora.this,
                        Tabela.class);

                startActivity(intent);

                finish();
				
			}
		});
		
		limpar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			altura.setText("");
			peso.setText("");
			peso.requestFocus();
				
			}
		});
		
		voltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
                intent.setClass(Calculadora.this,
                        CorpoSaude.class);

                startActivity(intent);

                finish();
				
			}
		});
		
		btcalcula.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				CLicar();
				
			}
		});
		

	}

	@SuppressWarnings("deprecation")
	private void CLicar() {
		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		
	double alturas, pesos, result;
	
		

		
	try{
		alturas= new Double(altura.getText().toString());
		pesos= new Double(peso.getText().toString());
		result = pesos / (alturas * alturas);
		if (result <= 17.0) {
			
			alertDialog.setTitle("Calculando IMC");
			alertDialog.setMessage("Cuidado!! Voce esta muito abaixo do Peso\nSeu IMC: "+String.format("%.2f", result));
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent();
	                intent.setClass(Calculadora.this,
	                        Calculadora.class);

	                startActivity(intent);

	                finish();
				}
				});
			
		} else if (result >17 && result <= 18.49) {
			
			alertDialog.setTitle("Calculando IMC");
			alertDialog.setMessage("Abaixo do peso.\nSeu IMC: "+ String.format("%.2f", result));
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent();
	                intent.setClass(Calculadora.this,
	                        Calculadora.class);

	                startActivity(intent);

	                finish();
				}
				});
		
		} else if(result>18.5 && result <= 24.99){
			
			alertDialog.setTitle("Calculando IMC");
			alertDialog.setMessage("Peso normal\nSeu IMC: "+String.format("%.2f", result));
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent();
	                intent.setClass(Calculadora.this,
	                        Calculadora.class);

	                startActivity(intent);

	                finish();
				}
				});
			
			} else if (result >25 && result <= 29.99) {
				
				alertDialog.setTitle("Calculando IMC");
				alertDialog.setMessage("Acima do peso.\nSeu IMC: "+ String.format("%.2f", result));
				alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent();
		                intent.setClass(Calculadora.this,
		                        Calculadora.class);

		                startActivity(intent);

		                finish();
					}
					});
			
			}
			 else if (result >30 && result <= 34.99) {
					
					alertDialog.setTitle("Calculando IMC");
					alertDialog.setMessage("Obesidade I.\nSeu IMC: "+ String.format("%.2f", result));
					alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							Intent intent = new Intent();
			                intent.setClass(Calculadora.this,
			                        Calculadora.class);

			                startActivity(intent);

			                finish();
						}
						});
				
				}
			 else if (result >35 && result <= 39.99) {
					
					alertDialog.setTitle("Calculando IMC");
					alertDialog.setMessage("Obesidade II (Severa).\nSeu IMC: "+ String.format("%.2f", result));
					alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							Intent intent = new Intent();
			                intent.setClass(Calculadora.this,
			                        Calculadora.class);

			                startActivity(intent);

			                finish();
						}
						});
				
				} else if (result >40) {
					
					alertDialog.setTitle("Calculando IMC");
					alertDialog.setMessage("Obesidade III (Mórbida).\nSeu IMC: "+ String.format("%.2f", result));
					alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							Intent intent = new Intent();
			                intent.setClass(Calculadora.this,
			                        Calculadora.class);

			                startActivity(intent);

			                finish();
						}
						});
				
				}

		
		} catch(NumberFormatException e){
			
			alertDialog.setTitle("Error");
			alertDialog.setMessage("Campos Vazios");
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent();
	                intent.setClass(Calculadora.this,
	                        Calculadora.class);

	                startActivity(intent);

	                finish();
				}
				});
		}
	alertDialog.show();
	}
}
