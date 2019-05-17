package com.example.mcf.conversor2;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


import android.widget.Toast;

import static java.lang.Math.pow;


public class MainActivityConversor extends ActionBarActivity {

    TextView resultAux;
    EditText valor;
    RadioGroup grupo1;
    Button calcula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_conversor);

        resultAux = (TextView) findViewById(R.id.resultado);
        valor = (EditText) findViewById(R.id.val);
        grupo1 = (RadioGroup) findViewById(R.id.radioGroup1);
        calcula = (Button) findViewById(R.id.calcula);

        calcula.setOnClickListener(new View.OnClickListener()
                                   {
                                       @Override
                                       public void onClick(View v)
                                       {

                                           onRadioButtonClicked(v);
                                       }
                                   }
        );


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_conversor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view) {



        switch (grupo1.getCheckedRadioButtonId()) {
            case R.id.radio0:

                /*Context context = getApplicationContext();
                CharSequence text = "Somou 2 n�meros!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
*/
                Double x = Double.parseDouble(valor.getText().toString());
                resultAux.setText(kgTon(x));
                break;

            case R.id.radio1:
                Double x2 = Double.parseDouble(valor.getText().toString());
                resultAux.setText(tonKg(x2));
                break;

            case R.id.radio2:
                Double x3 = Double.parseDouble(valor.getText().toString());
                resultAux.setText(metroKm(x3));
                break;

            case R.id.radio3:
                Double x4 = Double.parseDouble(valor.getText().toString());
                resultAux.setText(kmMetro(x4));
                break;

            case R.id.radio4:
                Double x5 = Double.parseDouble(valor.getText().toString());
                resultAux.setText(metroAcre(x5));
                break;

            case R.id.radio5:
                Double x6 = Double.parseDouble(valor.getText().toString());
                resultAux.setText(acreMetro(x6));
                break;

            case R.id.radio6:
                Double x7 = Double.parseDouble(valor.getText().toString());
                resultAux.setText(CF(x7));
                break;

            case R.id.radio7:
                Double x8 = Double.parseDouble(valor.getText().toString());
                resultAux.setText(FC(x8));
                break;

            case R.id.radio8:
                Double x9 = Double.parseDouble(valor.getText().toString());
                resultAux.setText(KC(x9));
                break;

            case R.id.radio9:
                Double x10 = Double.parseDouble(valor.getText().toString());
                resultAux.setText(FK(x10));
                break;

            case R.id.radio10:
                Double x11 = Double.parseDouble(valor.getText().toString());
                resultAux.setText(CK(x11));
                break;

            case R.id.radio11:
                Double x12 = Double.parseDouble(valor.getText().toString());
                resultAux.setText(KF(x12));
                break;


        }
    }
    public String metroKm(double metro)
    {
        double km = (metro/1000);
        return metro + " Metros = " + km + "Km";
    }

    public String kmMetro(double km)
    {
        double metro = (km*1000);
        return km + "Km = " + metro + " Metros";
    }

    public String tonKg(double ton)
    {

        double kg = (ton*1000);
        return ton + "ton = " + kg + "Kg";
    }

    public String kgTon(double kg)
    {
        double ton = (kg/1000);
        return kg + "Kg = " + ton + "ton";
    }

    public String metroAcre(double metro)
    {

        double acre = (metro*(2.47*(pow(10, -3))));
        return metro + "m² = " + acre + "acre";
    }

    public String acreMetro(double acre)
    {
        double metro = (acre*4046.85);
        return acre + " acre = " + metro+ "m²";
    }

    public String CF(double cel)
    {
        double far = (cel*1.8+32);
        return cel + "°C = " + far+ "°F";
    }

    public String FC(double far)
    {
        double cel = (far-32)/1.8;
        return far+ "°F = " + cel + "°C";
    }

    public String CK(double cel)
    {
        double kel = cel+273;
        return cel+ "°C = " + kel + "K";
    }

    public String KC(double kel)
    {
        double cel = kel-273;
        return kel+ "K = " + cel + "°C";
    }

    public String FK(double far)
    {
        double kel = (far - 32) * 5 / 9 + 273.15 ;
        return far+ "°F = " + kel + "K";
    }

    public String KF(double kel)
    {
        double far = 1.8*(kel-273)+32;
        return kel+ "K = " + far + "ºF";
    }
}
