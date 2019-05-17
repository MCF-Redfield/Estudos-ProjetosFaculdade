package com.corposaude;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Detalhamento extends Activity {

	List<Exercicio> ficha = null;;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhamento);
		
		String nome_ficha = (String) getIntent().getSerializableExtra("nome_ficha");
		
		ficha = new ArrayList<Exercicio>();
		File file = getFileStreamPath(nome_ficha);
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ficha = (ArrayList<Exercicio>) ois.readObject();
			fis.close();
			ois.close();
			
			gerarTabela();
		} catch (Exception e) {
		}
	}
	
	private void gerarTabela()
	{
		TableLayout table_layout = (TableLayout) findViewById(R.id.table_layout);
		
		for (Exercicio exercicio : ficha) {			
			TableRow row = new TableRow(this);
			row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.WRAP_CONTENT));

			TextView tv = new TextView(this);			
			tv.setText("Exercicio: "+exercicio.getNome());
			row.addView(tv);
			
			tv = new TextView(this);
			tv.setText("Series: "+exercicio.getSeries());
			row.addView(tv);
			
			tv = new TextView(this);
			tv.setText("Repet.: "+exercicio.getRepeticoes());
			row.addView(tv);
			
			tv = new TextView(this);
			tv.setText("Peso: "+exercicio.getPeso());
			row.addView(tv);

			table_layout.addView(row);
			
			findViewById(android.R.id.content).invalidate();
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
}
