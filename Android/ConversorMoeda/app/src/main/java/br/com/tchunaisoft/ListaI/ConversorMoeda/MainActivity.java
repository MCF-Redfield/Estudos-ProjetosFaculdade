package br.com.tchunaisoft.ListaI.ConversorMoeda;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class MainActivity extends ActionBarActivity {

	private Spinner sp00, sp01;
	private TextView result;
	private Double aux;
	private EditText valor1, valorDolar, valorEuro;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sp00 = (Spinner) findViewById(R.id.spinner1);
		sp01 = (Spinner) findViewById(R.id.Spinner01);
		result = (TextView) findViewById(R.id.tvResultado);
		valor1 = (EditText) findViewById(R.id.Valor1);
		valorDolar = (EditText) findViewById(R.id.ValorDolar);
		valorEuro = (EditText) findViewById(R.id.ValorEuro);

		List<String> list = new ArrayList<String>();
		list.add("Real");
		list.add("Dolar");
		list.add("Euro");

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);

		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		sp00.setAdapter(dataAdapter);
		sp01.setAdapter(dataAdapter);

	}

	public void mostrar(View v) {

		if (valorDolar.getText().toString().trim().equals("")
				&& valorEuro.getText().toString().trim().equals("")
				&& valor1.getText().toString().trim().equals("")) {
			Context context = getApplicationContext();
			CharSequence text = "Não deixe os campos vazios!!";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();

		} else if (valorDolar.getText().toString().trim().equals("")
				&& valorEuro.getText().toString().trim().equals("")) {
			Context context = getApplicationContext();
			CharSequence text = "Informe a cotação do Dolar e do Euro!!";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();

		} else if (valor1.getText().toString().trim().equals("")) {
			Context context = getApplicationContext();
			CharSequence text = "Informe o Valor para a Conversão!!";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();

		} else if (valorDolar.getText().toString().trim().equals("")) {
			Context context = getApplicationContext();
			CharSequence text = "Informe a cotação do Dolar!!";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		} else if (valorEuro.getText().toString().trim().equals("")) {
			Context context = getApplicationContext();
			CharSequence text = "Informe a cotação do Euro!!";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		} else {

			DecimalFormat decimal = new DecimalFormat("0.00");

			if (sp00.getSelectedItemPosition() == 0
					&& sp01.getSelectedItemPosition() == 0) { // Real para Real
				aux = Double.parseDouble(valor1.getText().toString());
			} else if (sp00.getSelectedItemPosition() == 0
					&& sp01.getSelectedItemPosition() == 1) { // Real para Dolar
				aux = Double.parseDouble(valor1.getText().toString())
						/ Double.parseDouble(valorDolar.getText().toString());
			} else if (sp00.getSelectedItemPosition() == 0
					&& sp01.getSelectedItemPosition() == 2) { // Real para Euro
				aux = Double.parseDouble(valor1.getText().toString())
						/ Double.parseDouble(valorEuro.getText().toString());
			} else if (sp00.getSelectedItemPosition() == 1
					&& sp01.getSelectedItemPosition() == 0) { // Dolar para Real
				aux = Double.parseDouble(valor1.getText().toString())
						* Double.parseDouble(valorDolar.getText().toString());
			} else if (sp00.getSelectedItemPosition() == 1
					&& sp01.getSelectedItemPosition() == 1) { // Dolar para
																// Dolar
				aux = Double.parseDouble(valor1.getText().toString());
			} else if (sp00.getSelectedItemPosition() == 1
					&& sp01.getSelectedItemPosition() == 2) { // Dolar para Euro
				aux = (Double.parseDouble(valor1.getText().toString())
						* Double.parseDouble(valorDolar.getText().toString()) / Double
						.parseDouble(valorEuro.getText().toString()));
			} else if (sp00.getSelectedItemPosition() == 2
					&& sp01.getSelectedItemPosition() == 0) { // Euro para Real
				aux = Double.parseDouble(valor1.getText().toString())
						* Double.parseDouble(valorEuro.getText().toString());
			} else if (sp00.getSelectedItemPosition() == 2
					&& sp01.getSelectedItemPosition() == 1) { // Euro para Dolar
				aux = (Double.parseDouble(valor1.getText().toString())
						* Double.parseDouble(valorEuro.getText().toString()) / Double
						.parseDouble(valorDolar.getText().toString()));
			} else if (sp00.getSelectedItemPosition() == 2
					&& sp01.getSelectedItemPosition() == 2) { // Euro para Euro
				aux = Double.parseDouble(valor1.getText().toString());
			}

			result.setText("" + decimal.format(aux));

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
