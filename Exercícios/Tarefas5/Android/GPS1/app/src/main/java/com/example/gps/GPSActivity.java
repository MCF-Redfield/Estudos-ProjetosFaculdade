package com.example.gps;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GPSActivity extends ActionBarActivity implements LocationListener {

	private double latitude;
	private double longitude;
    private AlertDialog confereGps;
	private LocationManager locationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps);
		locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);

        String provider = Settings.Secure.getString(getContentResolver(),
        Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
        //Se vier null ou length == 0   é por que o GPS esta desabilitado.
        //Para abrir a tela do menu pode fazer assim:

        if(provider.length()==0 || provider==null)
        {
            informaGps();
        }


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.g, menu);
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

	public void setLocation(View view) {

		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
				0, this);
	}

	@Override
	public void onLocationChanged(Location location) {

		latitude = location.getLatitude();
		longitude = location.getLongitude();
		TextView text_view_latitude = (TextView) findViewById(R.id.text_view_latitude);
		TextView text_view_longitude = (TextView) findViewById(R.id.text_view_longitude);
		text_view_latitude.setText(/*text_view_latitude.getText() + */" " + latitude);
		text_view_longitude.setText(/*text_view_longitude.getText() + */" " + longitude);
	}

	@Override
	public void onProviderDisabled(String provider){
		
		
	}
	
	@Override
	public void onProviderEnabled(String provider){
		
		
	}
	
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras){
		
		
		
	}

    private void informaGps()
    {
    //Cria o gerador do AlertDialog
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    //define o titulo
    builder.setTitle("Gps Desabled");
    // define a mensagem
    builder.setMessage("GPS está desativado,\ndeseja ativé-lo?");
     //define um botão como positivo
     builder.setPositiveButton("Ativar", new DialogInterface.OnClickListener()
                                               {
                                                public void onClick(DialogInterface arg0, int arg1)
                                                {
                                                    //Toast.makeText(GPSActivity.this, "ativar=" + arg1, Toast.LENGTH_LONG).show();
                                                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                                    startActivityForResult(intent, 1);
                                                }
                                               });
    //define um botão como negativo.
    builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener()
                                              {
                                               public void onClick(DialogInterface arg0, int arg1)
                                               {
                                                   Toast.makeText(GPSActivity.this, "cancelar=" + arg1, Toast.LENGTH_LONG).show();
                                               }
                                              });
    //cria o AlertDialog
    confereGps = builder.create();
    //Exibe
    confereGps.show();

    }

    String linkante = "<a href=https://maps.google.com.br/maps?q=" + latitude + "," + longitude
    text_
}
