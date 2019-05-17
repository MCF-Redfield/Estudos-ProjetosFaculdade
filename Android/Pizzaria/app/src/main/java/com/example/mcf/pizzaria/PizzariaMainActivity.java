package com.example.mcf.pizzaria;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class PizzariaMainActivity extends ActionBarActivity {

    TextView pedido;
    CheckBox mussarella;
    CheckBox presunto;
    CheckBox palmito;
    CheckBox bacon;
    CheckBox catupiry;
    CheckBox lombo;
    CheckBox atum;
    Button sendPed;
    EditText fone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzaria_main);

        pedido = (TextView) findViewById(R.id.ped);
        mussarella = (CheckBox)findViewById(R.id.mussarella);
        presunto = (CheckBox)findViewById(R.id.presunto);
        bacon = (CheckBox)findViewById(R.id.bacon);
        palmito = (CheckBox)findViewById(R.id.palmito);
        catupiry= (CheckBox)findViewById(R.id.catupiry);
        lombo = (CheckBox)findViewById(R.id.lombo);
        atum = (CheckBox)findViewById(R.id.atum);
        sendPed = (Button) findViewById(R.id.sendPed);
        fone = (EditText) findViewById(R.id.fone);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pizzaria_main, menu);
        return true;
    }

    public void arLombo(View v)
    {
        if(lombo.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Lombo adicionado!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Lombo removido!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arAtum(View v)
    {
        if(atum.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Atum adicionado!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Atum removido!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arBacon(View v)
    {
        if(bacon.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Bacon adicionado!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Bacon removido!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arCatupiry(View v)
    {
        if(catupiry.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Catupiry adicionado!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Catupiry removido!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arPresunto(View v)
    {
        if(presunto.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Presunto adicionado!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Presunto removido!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arMussarella(View v)
    {
        if(mussarella.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Mussarella adicionado!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Mussarella removido!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arPalmito(View v)
    {
        if(palmito.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Palmito adicionado!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Palmito removido!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arResultado(View v)
    {
        pedido.setText("");

        if(palmito.isChecked())
        {
            pedido.setText(pedido.getText().toString()+"Palmito, ");
        }

        if(mussarella.isChecked())
        {
            pedido.setText(pedido.getText().toString()+"Mussarella, ");
        }

        if(presunto.isChecked())
        {
            pedido.setText(pedido.getText().toString()+"Presunto, ");
        }

        if(bacon.isChecked())
        {
            pedido.setText(pedido.getText().toString()+"Bacon, ");
        }

        if(atum.isChecked())
        {
            pedido.setText(pedido.getText().toString()+"Atum, ");
        }

        if(lombo.isChecked())
        {
            pedido.setText(pedido.getText().toString()+"Lombo, ");
        }

        if(catupiry.isChecked())
        {
            pedido.setText(pedido.getText().toString()+"Catupiry, ");
        }

        if(pedido.getText().toString().isEmpty())
        {
            pedido.setText("Recheios");
        }
        else {
            String aux = pedido.getText().toString();
            String mod = aux.substring(0, aux.length() - 2);
            pedido.setText(mod + ".");
        }
    }

    public void mandaPed(View v)
    {
        if(pedido.getText().toString().equals("Recheios"))
        {
            Context context = getApplicationContext();
            CharSequence text = "Informe seu pedido!!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        if(fone.getText().toString().isEmpty())
        {
            Context context = getApplicationContext();
            CharSequence text = "Informe o telefone!!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else {
            //Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            //smsIntent.setType("vnd.android-dir/mms-sms");
            //smsIntent.putExtra("address", fone.getText().toString());
            //smsIntent.putExtra("sms_body",pedido.getText().toString());
            SmsManager smsManager = SmsManager.getDefault();//--------->Envia SMS direto da aplicação<----------
            smsManager.sendTextMessage(fone.getText().toString(), null, pedido.getText().toString(), null, null);
            //startActivity(smsIntent);

            Context context = getApplicationContext();
            CharSequence text = "Seu pedido foi enviado!!!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            pedido.setText("Recheios");
            fone.setText("");
            mussarella.setChecked(false);
            presunto.setChecked(false);
            palmito.setChecked(false);
            bacon.setChecked(false);
            atum.setChecked(false);
            lombo.setChecked(false);
            catupiry.setChecked(false);
        }

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
}
