package com.example.mxandroid;




import android.support.v4.app.NotificationCompat;

import android.support.v7.app.ActionBarActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	TextView aux;
	EditText x, y;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		aux = (TextView) findViewById(R.id.textView1);
		x = (EditText) findViewById(R.id.Text1);
		y = (EditText) findViewById(R.id.Text2);

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

	

	public void Somar(View view) {
		Double result;

		Double x1 = Double.parseDouble(x.getText().toString());
		Double y1 = Double.parseDouble(y.getText().toString());
		result = x1 + y1;

		aux.setText(" " + result);

		Context context = getApplicationContext();
		CharSequence text = "Somou 2 números!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();

	}

	public void Subtrair(View view) {
		Double result;

		Double x1 = Double.parseDouble(x.getText().toString());
		Double y1 = Double.parseDouble(y.getText().toString());
		result = x1 - y1;

		aux.setText(" " + result);

		Context context = getApplicationContext();
		CharSequence text = "Subtraiu 2 números!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();

	}

	public void Multiplicar(View view) {
		Double result;

		Double x1 = Double.parseDouble(x.getText().toString());
		Double y1 = Double.parseDouble(y.getText().toString());
		result = (x1 * y1);

		aux.setText(" " + result);

		Context context = getApplicationContext();
		CharSequence text = "Multiplicou 2 números!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();

	}

	public void Dividir(View view) {
		Double result;

		Double x1 = Double.parseDouble(x.getText().toString());
		Double y1 = Double.parseDouble(y.getText().toString());
		result = x1 / y1;

		aux.setText(" " + result);

		Context context = getApplicationContext();
		CharSequence text = "Dividiu 2 números!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();

	}
	
	public void gerarNotificacao(View view){
		
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		PendingIntent p = PendingIntent.getActivity(this,0 , new Intent(this, Activity2.class), 0);
		
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setTicker("Notificacao sucesso!");
		builder.setContentTitle("TopicosI");
		builder.setContentText("Teste Notificacao");
		builder.setSmallIcon(R.drawable.ic_launcher);
		
		
		Notification n = builder.build();
		n.vibrate = new long[]{150, 300, 150, 600};
		n.flags = Notification.FLAG_AUTO_CANCEL;
		nm.notify(R.drawable.ic_launcher, n);
		
		try{
			
		Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		Ringtone toque = RingtoneManager.getRingtone(this, som);
		toque.play();
		
		
		}catch(Exception e){}
		
		
		
	}
	
}
