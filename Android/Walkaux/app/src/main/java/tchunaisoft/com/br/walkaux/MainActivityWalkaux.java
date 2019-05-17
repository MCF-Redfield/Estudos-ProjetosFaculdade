package tchunaisoft.com.br.walkaux;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;


public class MainActivityWalkaux extends ActionBarActivity implements LocationListener
{
    private double latitude;
    private double longitude;
    private double lastLatitude;
    private double lastLongitude;
    private AlertDialog confereGps;
    private LocationManager locationMannager;
    double distancia = 0;
    Button btstart, btpause;
    boolean Click;
    private Chronometer ch;
    private long milliseconds;
    private long millisecondsStop;

    String horario;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_walkaux);




        /*----posicionamento-----*/
        posicionar();

        /*------cronometrar-----*/
        cronometrar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_walkaux, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.listWalk:
                Intent intent = new Intent(MainActivityWalkaux.this, ListaCaminhadaActivity.class);
                startActivity(intent);
                break;

            /*case R.id.deletar:
                WalkDAO walkDAO = new WalkDAO(getApplication());
                walkDAO.deletar();
                Toast.makeText(this, "Dados deletados!", Toast.LENGTH_LONG).show();
                break;
            */
            case R.id.graficar:
                Intent intent2 = new Intent(MainActivityWalkaux.this, GraficoWalkActivity.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void setLocation(View view)
    {

        String provider = Settings.Secure.getString(getContentResolver(),Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
        if (provider.length() == 0 || provider == null)
        {
            Toast.makeText(this, "GPS está desativado\nUtilize o menu para ativá-lo!!", Toast.LENGTH_LONG).show();
        }
        else
            locationMannager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 0, this);

        if(Click == false)
        {
            startChronometer(getCurrentFocus());
            Click = true;
            Date data = new Date();
            horario = data + "";
        }
    }

    @Override
    public void onLocationChanged(Location location)
    {
        TextView tvDistancia = (TextView) findViewById(R.id.distancia);

        if (tvDistancia.getText().toString().equals(""))
        {
            lastLatitude = location.getLatitude();
            lastLongitude = location.getLongitude();
            tvDistancia.setText("0");

        }

        latitude = location.getLatitude();
        longitude = location.getLongitude();
        BigDecimal bd = new BigDecimal((GeoUtils.geoDistanceInKm(latitude,longitude,lastLatitude,lastLongitude) * 1000)).setScale(2, RoundingMode.HALF_EVEN);
        distancia = Double.parseDouble(tvDistancia.getText().toString()) + Double.parseDouble(bd+"");
        BigDecimal bd2 = new BigDecimal(distancia + 0.0000000001).setScale(2, RoundingMode.HALF_EVEN);
        //TextView text_view_latitude = (TextView) findViewById(R.id.text_view_latitude);
        //TextView text_view_longitude = (TextView) findViewById(R.id.text_view_longitude);
        //text_view_latitude.setText("Lat: " + latitude);
        //text_view_longitude.setText("Lon: " + longitude);
        tvDistancia.setText("" + bd2);
        lastLatitude = latitude;
        lastLongitude = longitude;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {

    }

    @Override
    public void onProviderEnabled(String provider)
    {

    }

    @Override
    public void onProviderDisabled(String provider)
    {

    }

    private void informaGps()
    {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Gps Desabled");
        // define a mensagem
        builder.setMessage("GPS está desativado,\ndeseja ativá-lo?");
        //define um botão como positivo
        builder.setPositiveButton("Ativar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(intent, 1);
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivityWalkaux.this, "Não é possível obter posição!", Toast.LENGTH_LONG).show();
            }
        });
        //cria o AlertDialog
        confereGps = builder.create();
        //Exibe
        confereGps.show();

    }

    public void startChronometer(View view)
    {
        millisecondsStop = millisecondsStop > 0 ? System.currentTimeMillis() - millisecondsStop : 0;
        ch.setBase(SystemClock.elapsedRealtime() - (milliseconds + millisecondsStop));
        ch.start();
        millisecondsStop = 0;
        //TextView test = (TextView) findViewById(R.id.test);
        //test.setText(ch.getText().toString());

    }

    public void cronometrar()
    {
        milliseconds = 0;
        millisecondsStop = 0;
        btstart = (Button) findViewById(R.id.btstart);
        btpause = (Button) findViewById(R.id.btpause);
        ch = (Chronometer) findViewById(R.id.chronometer);
        ch.setText("00" + (DateFormat.format("kk:mm:ss", 0)).subSequence(2,8));
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener()
                                        {
                                            @Override
                                            public void onChronometerTick(Chronometer chronometer)
                                            {
                                                long aux = SystemClock.elapsedRealtime() - (chronometer.getBase()+75600000);
                                                chronometer.setText(/*"00"+(*/DateFormat.format("kk:mm:ss", aux))/*.subSequence(2,8))*/;
                                            }
                                        }
        );
    }

    public void posicionar()
    {
        locationMannager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        String provider = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
        //Se vier null ou length == 0   é por que o GPS esta desabilitado.
        //Para abrir a tela do menu pode fazer assim:
        if (provider.length() == 0 || provider == null)
        {
            informaGps();
        }
    }

    public void mandaWalk(View view)
    {
        TextView tvDistancia = (TextView) findViewById(R.id.distancia);

        if(tvDistancia.getText().toString().equals(""))
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Corrida não foi inicializada", Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Intent intent = new Intent(this, SalvarActivity.class);
            Bundle apassar = new Bundle();
            apassar.putString("tempo", ch.getText().toString());
            apassar.putString("distancia", distancia + "");
            apassar.putString("horario", horario);

            intent.putExtras(apassar);
            this.startActivity(intent);
            locationMannager.removeUpdates(this);
            tvDistancia.setText("");
            ch.stop();
            ch.refreshDrawableState();
            Click = false;
            ch.setText("00:00:00");
            //MainActivityWalkaux.this.finish();
        }


    }


}
