package status7.tchunaisoft.com.br;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class Status7MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status7_main);

        TextView estado = (TextView) findViewById(R.id.estado);

        if (verificaEstado(this))
            estado.setText("Você está conetado!!");
        else
            estado.setText("Você não está conetado!!");
    }


    public static boolean verificaEstado(Context context)
    {
        ConnectivityManager cmannager = (ConnectivityManager)
        context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cmannager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected())
            return true;

        else if(cmannager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected())
            return true;

        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_status7_main, menu);
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
}
