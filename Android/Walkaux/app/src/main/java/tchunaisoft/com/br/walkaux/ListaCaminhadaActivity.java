package tchunaisoft.com.br.walkaux;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;


public class ListaCaminhadaActivity extends ActionBarActivity {

    private static String listagem = "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_caminhada);
        TextView listaWalks = (TextView) findViewById(R.id.listaWalks);

        WalkDAO walkDAO = new WalkDAO(getApplication());
        List<Walk> listaWalk = walkDAO.buscar();
        int i=0;
        while(i<listaWalk.size())
        {
            listagem = listagem + "Horário: " + listaWalk.get(i).getHorario()
                                + "\nDistancia: " + listaWalk.get(i).getDistancia()
                                + "\nTempo: " + listaWalk.get(i).getTempo()
                                + "\nVelocidade: " + listaWalk.get(i).getVelocidade() + "\n\n";

            i++;
        }

        listaWalks.setText(listagem);
        listagem = "";

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_caminhada, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.graficar:
                Intent intent2 = new Intent(ListaCaminhadaActivity.this, GraficoWalkActivity.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
/*
    public void buscar()
    {
        WalkDAO walkDAO = new WalkDAO(getApplication());
        List<Walk> listaWalk = walkDAO.buscar();
        int i=0;
        getApplicationContext().
    }
*/
    public void setMes(View v)
    {



    }
}
