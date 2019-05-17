package com.example.usuario.tutorial1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivityTutorial1 extends ActionBarActivity {

    EditText aux;
    EditText aux2;
    Button copia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_tutorial1);

        copia = (Button) findViewById(R.id.copiar);
        aux = (EditText) findViewById(R.id.envia);
        aux2 = (EditText) findViewById(R.id.recebe);

        copia.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View v)
             {

                 aux2.setText(aux.getText().toString());

                 Context context = getApplicationContext();
                 CharSequence text = "Texto copiado!!";
                 int duration = Toast.LENGTH_LONG;

                 Toast toast = Toast.makeText(context, text, duration);
                 toast.show();
             }
         }
        );


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_tutorial1, menu);
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
