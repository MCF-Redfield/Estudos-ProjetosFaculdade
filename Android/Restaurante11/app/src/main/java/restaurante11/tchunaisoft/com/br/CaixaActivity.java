package restaurante11.tchunaisoft.com.br;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class CaixaActivity extends ActionBarActivity
{
    TextView preco;
    TextView desc;
    TextView pedido;
    static String totalPed="";
    Pedido pedidos;
    static double total;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caixa);

        preco = (TextView) findViewById(R.id.preco);
        desc = (TextView) findViewById(R.id.desc);
        pedido = (TextView) findViewById(R.id.pedido);



        Intent intent = getIntent();
        if(intent != null)
        {
            Bundle areceber = intent.getExtras();
            if (areceber != null)
            {
                pedidos = new Pedido(areceber.getString("pedido"), areceber.getString("descricao"),areceber.getDouble("total"));
                pedido.setText(pedidos.getCodPed());
                desc.setText(pedidos.getDescrPed());
                preco.setText("R$" + pedidos.getTotalPed() + "");

                total+=areceber.getDouble("preco");
                totalPed = totalPed + pedidos.getCodPed().toString()+"        R$"+pedidos.getTotalPed()+"\n";
            }
        }
    }

    public void fechaCaixa(View v)
    {

        Intent intent = new Intent(this, FechaCaixaActivity.class);
        Bundle apassar = new Bundle();
        apassar.putString("pedido", totalPed);
        apassar.putDouble("preco", total);
        intent.putExtras(apassar);
        this.startActivity(intent);
        CaixaActivity.this.finish();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_caixa, menu);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void paraPedido(View v)
    {
        Intent intent = new Intent(this,RestauranteMainActivity.class);
        startActivity(intent);
        CaixaActivity.this.finish();
    }

}
