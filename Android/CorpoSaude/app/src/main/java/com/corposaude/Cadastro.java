package com.corposaude;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Cadastro extends Activity {

	List<Exercicio> nova_ficha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro);
		
		nova_ficha = new ArrayList<Exercicio>();
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

	public void salvarFicha(View view) {
		List<String> fichas = new ArrayList<String>();
		File file = getFileStreamPath("fichas");

		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			fichas = (ArrayList<String>) ois.readObject();
			fis.close();
			ois.close();
		} catch (Exception e) {
		}

		EditText et_nova_lista = (EditText) findViewById(R.id.et_nova_lista);
		fichas.add(et_nova_lista.getText().toString());

		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(fichas);
			oos.close();
			fos.close();
			
			file = getFileStreamPath(et_nova_lista.getText().toString());
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(nova_ficha);
			oos.close();
			fos.close();
			
			 Toast.makeText(this, "Ficha Salva!", Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
		}
		
		
	}

	public void adicionarExercicio(View view) {
		EditText et_nome = (EditText) findViewById(R.id.et_exercicio);
		EditText et_series = (EditText) findViewById(R.id.et_series);
		EditText et_repeticoes = (EditText) findViewById(R.id.et_repeticoes);
		EditText et_peso = (EditText) findViewById(R.id.et_peso);
		
		String nome = et_nome.getText().toString();
		String series = et_series.getText().toString();
		String repeticoes = et_repeticoes.getText().toString();
		String peso = et_peso.getText().toString();
		
		nova_ficha.add(new Exercicio(nome, series, repeticoes, peso));
		
		et_nome.setText("");
		et_series.setText("");
		et_repeticoes.setText("");
		et_peso.setText("");
		
		atualizarTabela();
	}
	
	private void atualizarTabela()
	{
		TableLayout table_layout = (TableLayout) findViewById(R.id.table_layout);
		table_layout.removeAllViews();
		
		for (Exercicio exercicio : nova_ficha) {			
			TableRow row = new TableRow(this);
			row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT));

			TextView tv = new TextView(this);			
			tv.setText(exercicio.getNome());
			row.addView(tv);
			
			tv = new TextView(this);
			tv.setText(exercicio.getSeries());
			row.addView(tv);
			
			tv = new TextView(this);
			tv.setText(exercicio.getRepeticoes());
			row.addView(tv);
			
			tv = new TextView(this);
			tv.setText(exercicio.getPeso());
			row.addView(tv);

			table_layout.addView(row);
			
			findViewById(android.R.id.content).invalidate();
		}
	}
}