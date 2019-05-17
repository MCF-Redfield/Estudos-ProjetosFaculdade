package br.com.example.questao07;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	 
		if (isOnline(this)) {
			Toast.makeText(getApplicationContext(), "Conectado", Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(getApplicationContext(), "Desconectado", Toast.LENGTH_LONG).show();
		}
	}
	
	public static boolean isOnline(Context context) {
		// Pego a conectividade do contexto
		//ConnectivityManager cm = (ConnectivityManager) contexto.getSystemService(Context.CONNECTIVITY_SERVICE);
		
		// Crio o objeto netInfo que recebe as informacoes da Network
		//NetworkInfo netInfo = cm.getActiveNetworkInfo();
		
		ConnectivityManager cm = (ConnectivityManager)
	    context.getSystemService(Context.CONNECTIVITY_SERVICE);
		//boolean netInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected();
		
		
		//if ((netInfo != null) && (netInfo.isConnectedOrConnecting()) && (netInfo.isAvailable()))
		if (cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected())
		{ 
			return true;
		}
		
		else if(cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected())
        {
			return true;
        }		
		
		// Se nao tem conectividade retorna falso
		return false;
	}
}
