package restaurante11.tchunaisoft.com.br;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class FechaCaixaActivity extends ActionBarActivity
{
    TextView totalFinal;
    TextView precoFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fecha_caixa);

        totalFinal = (TextView) findViewById(R.id.totalFinal);
        precoFinal = (TextView) findViewById(R.id.precoFinal);

        Intent intent = getIntent();

        if(intent != null)
        {
            Bundle areceber = intent.getExtras();
            if (areceber != null)
            {
                totalFinal.setText(areceber.getString("pedido"));
                precoFinal.setText("Total Caixa do dia: R$" + areceber.getDouble("preco"));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fecha_caixa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void paraPedido(View v)
    {
        Intent intent = new Intent(this,RestauranteMainActivity.class);
        startActivity(intent);
        FechaCaixaActivity.this.finish();
    }

    public void finalizar(View v)
    {
        finish();
    }

}
