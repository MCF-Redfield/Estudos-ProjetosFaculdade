package restaurante11.tchunaisoft.com.br;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class RestauranteMainActivity extends ActionBarActivity
{

    TextView pedido;
    TextView tot;
    CheckBox lasanha;
    CheckBox bobo;
    CheckBox picanha;
    CheckBox macarrao;
    CheckBox fille;
    CheckBox peixe;
    CheckBox omelete;
    Button sendPed;
    double total=0;
    static int indicePed = 1;
    static double totalPreco=0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_main);

        pedido = (TextView) findViewById(R.id.ped);
        tot = (TextView) findViewById(R.id.total);
        lasanha = (CheckBox)findViewById(R.id.lasanha);
        picanha = (CheckBox) findViewById(R.id.picanha);
        macarrao = (CheckBox) findViewById(R.id.macarrao);
        fille = (CheckBox) findViewById(R.id.fille);
        peixe = (CheckBox) findViewById(R.id.peixe);
        omelete = (CheckBox) findViewById(R.id.omelete);
        bobo = (CheckBox) findViewById(R.id.bobo);
        sendPed = (Button) findViewById(R.id.sendPed);

    }

    public void arLasanha(View v)
    {
        if(lasanha.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Lasanha adicionada!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Lasanha removida!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arBobo(View v)
    {
        if(bobo.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Bobó de Frango adicionado!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Bobó de Frango removido!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arPicanha(View v)
    {
        if(picanha.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Picanha adicionada!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Picanha removida!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arSpaghetti(View v)
    {
        if(macarrao.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Spaghetti adicionado!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Spaghetti removido!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arFille(View v)
    {
        if(fille.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Filé de Porco adicionado!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Filé de Porco removido!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arPeixe(View v)
    {
        if(peixe.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Peixe Grelhado adicionado!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Peixe Grelhado removido!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arOmelete(View v)
    {
        if(omelete.isChecked())
        {
            Context context = getApplicationContext();
            CharSequence text = "Omelete à Moda adicionado!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Omelete à Moda removido!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            arResultado(v);
        }
    }

    public void arResultado(View v)
    {
        pedido.setText("");
        total=0;
        if(lasanha.isChecked())
        {
            total+=35.49;
            pedido.setText(pedido.getText().toString()+"Lasanha, ");
        }

        if(bobo.isChecked())
        {
            total+=51.98;
            pedido.setText(pedido.getText().toString()+"Bobó de Frango, ");
        }

        if(picanha.isChecked())
        {
            total+=43.99;
            pedido.setText(pedido.getText().toString()+"Picanha, ");
        }

        if(macarrao.isChecked())
        {
            total+=21.49;
            pedido.setText(pedido.getText().toString()+"Spaghetti, ");
        }

        if(fille.isChecked())
        {
            total+=25.98;
            pedido.setText(pedido.getText().toString()+"Filé de Porco, ");
        }

        if(peixe.isChecked())
        {
            total+=27.99;
            pedido.setText(pedido.getText().toString()+"Peixe Grelhado, ");
        }

        if(omelete.isChecked())
        {
            total+=14.47;
            pedido.setText(pedido.getText().toString()+"Omelete à Moda, ");
        }

        if(pedido.getText().toString().isEmpty())
        {
            pedido.setText("");
        }
        else {
            String aux = pedido.getText().toString();
            String mod = aux.substring(0, aux.length() - 2);
            pedido.setText(mod + ".");
        }

        BigDecimal valorExato = new BigDecimal(total).setScale(2, RoundingMode.HALF_DOWN);
        String aux = ""+valorExato;
        total = Double.parseDouble(aux);

        tot.setText("Total a pagar: R$" + total);
    }

    public void mandaPed(View v)
    {
        if(pedido.getText().toString().equals(""))
        {
            Context context = getApplicationContext();
            CharSequence text = "Informe seu pedido!!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        {
            Pedido pedidos = new Pedido("Pedido " + indicePed, pedido.getText().toString(), total);
            Intent intent = new Intent(this, CaixaActivity.class);

            totalPreco = +pedidos.getTotalPed();

            Bundle apassar = new Bundle();
            apassar.putString("pedido", pedidos.getCodPed());
            apassar.putString("descricao", pedidos.getDescrPed());
            apassar.putDouble("total", pedidos.getTotalPed());
            apassar.putDouble("preco", totalPreco);

            Context context = getApplicationContext();
            CharSequence text = "Seu pedido foi enviado!!!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            intent.putExtras(apassar);
            this.startActivity(intent);

            pedido.setText("");
            lasanha.setChecked(false);
            bobo.setChecked(false);
            picanha.setChecked(false);
            macarrao.setChecked(false);
            fille.setChecked(false);
            peixe.setChecked(false);
            omelete.setChecked(false);
            tot.setText("Total a pagar: R$0,00");


            indicePed++;
            if(indicePed!=1)
            RestauranteMainActivity.this.finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurante_main, menu);
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

}
