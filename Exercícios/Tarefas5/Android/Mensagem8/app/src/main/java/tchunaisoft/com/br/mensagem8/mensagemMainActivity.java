package tchunaisoft.com.br.mensagem8;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class mensagemMainActivity extends ActionBarActivity {

    TextView fone;
    TextView mens;
    Button sendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem_main);

        fone = (TextView) findViewById(R.id.fone);
        mens = (TextView) findViewById(R.id.mens);
        sendar = (Button) findViewById(R.id.sendar);
    }


    public void enviaMens(View v)
    {
        if(mens.getText().toString().isEmpty())
        {
            Context context = getApplicationContext();
            CharSequence text = "Digite a mensagem!!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else
        if(fone.getText().toString().isEmpty())
        {
            Context context = getApplicationContext();
            CharSequence text = "Informe o telefone!!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else {
            //Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            //smsIntent.setType("vnd.android-dir/mms-sms");
            //smsIntent.putExtra("address", fone.getText().toString());
            //smsIntent.putExtra("sms_body",pedido.getText().toString());
            SmsManager smsManager = SmsManager.getDefault();//--------->Envia SMS direto da aplicação<----------
            smsManager.sendTextMessage(fone.getText().toString(), null, mens.getText().toString(), null, null);
            //startActivity(smsIntent);

            Context context = getApplicationContext();
            CharSequence text = "Mensagem enviada!!!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            mens.setText("");
            fone.setText("");

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mensagem_main, menu);
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
