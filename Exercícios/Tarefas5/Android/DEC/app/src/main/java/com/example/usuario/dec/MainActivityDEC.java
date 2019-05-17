package com.example.usuario.dec;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivityDEC extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_dec);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.asd, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/
        switch (item.getItemId())
        {
            case R.id.action_settings:
                Toast.makeText(this, "Você clicou em Configurações!", Toast.LENGTH_LONG).show();
                break;

            case R.id.item1:
                Toast.makeText(this, "Você clicou na Calculadora", Toast.LENGTH_LONG).show();

                final Intent intent = new Intent(Intent.ACTION_MAIN, null);

                intent.addCategory(Intent.CATEGORY_LAUNCHER);

                final ComponentName cn = new ComponentName(
                        "com.example.mxandroid",
                        "com.example.mxandroid.MainActivity");

                intent.setComponent(cn);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
                break;
01
            case R.id.item2:
                Toast.makeText(this, "Você clicou no Copiar Texto", Toast.LENGTH_LONG).show();
                break;

            case R.id.item3:
                Toast.makeText(this, "Você clicou in Unknown", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
