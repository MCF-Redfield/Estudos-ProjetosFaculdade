package tchunaisoft.com.br.walkaux;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class SalvarActivity extends ActionBarActivity
{

    Walk walk = new Walk();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar);

        Intent intent = getIntent();

        if(intent != null)
        {
            Bundle areceber = intent.getExtras();
            if (areceber != null)
            {
                walk.setTempo(areceber.getString("tempo"));
                walk.setDistancia(areceber.getString("distancia") + " metros");
                walk.setHorario(areceber.getString("horario"));
                Double tempo = praSegundo(walk.getTempo());
                Double dist = Double.parseDouble(areceber.getString("distancia"));
                BigDecimal bd = new BigDecimal( ((dist/1000) / (tempo/3600))+ 0.0000000001).setScale(2, RoundingMode.HALF_EVEN);

                walk.setVelocidade(bd + " Km/H");

                WalkDAO walkDAO = new WalkDAO(this);
                walkDAO.inserir(walk);
            }
        }

        TextView tempo = (TextView) findViewById(R.id.tempo);
        TextView distancia = (TextView) findViewById(R.id.distancia);
        TextView veloc = (TextView) findViewById(R.id.veloc);

        tempo.setText(tempo.getText().toString() + walk.getTempo());
        distancia.setText(distancia.getText().toString() + walk.getDistancia());
        veloc.setText(veloc.getText().toString() + walk.getVelocidade());

    }

    public Double praSegundo(String tempo)
    {
        Double segundo = Double.parseDouble(tempo.substring(6,8));
        Double minuto = Double.parseDouble(tempo.substring(3,5));
        Double hora = Double.parseDouble(tempo.substring(0,2));

        Double totalSegundo = segundo;
        totalSegundo+= minuto*60;
        totalSegundo+= hora*3600;
        //minutoo.setText(""+minuto);
        //segundoo.setText(""+segundo);
        //horaa.setText(""+horas);

        return totalSegundo;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_salvar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.graficar:
                Intent intent2 = new Intent(SalvarActivity.this, GraficoWalkActivity.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void praListar(View v)
    {
        Intent intent = new Intent(SalvarActivity.this, ListaCaminhadaActivity.class);
        startActivity(intent);
    }
}
