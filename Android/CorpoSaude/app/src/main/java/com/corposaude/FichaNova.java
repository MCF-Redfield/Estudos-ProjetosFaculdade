package com.corposaude;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class FichaNova extends Activity {
Button bt;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fichasnova);
		
		bt =(Button) findViewById(R.id.button1);
		
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(FichaNova.this, Fichas.class);

				startActivity(intent);

				finish();
				
			}
		});
	}

@Override
protected void onResume() {
	super.onResume();

	try {
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		File file = getFileStreamPath("fichas");

		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<String> fichas = (ArrayList<String>) ois.readObject();

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, fichas);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);

		fis.close();
		ois.close();
	} catch (Exception e) {
	}
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();
	if (id == R.id.action_settings) {
		return true;
	}
	return super.onOptionsItemSelected(item);
}

public void showDetalhamento(View view) {
	Spinner spinner = (Spinner) findViewById(R.id.spinner);
	String nome_ficha = spinner.getSelectedItem().toString();
	
	Intent it = new Intent(this, Detalhamento.class);
	it.putExtra("nome_ficha", nome_ficha);
	startActivity(it);
}

public void showCadastro(View view) {
	Intent it = new Intent(this, Cadastro.class);
	startActivity(it);
}
}
