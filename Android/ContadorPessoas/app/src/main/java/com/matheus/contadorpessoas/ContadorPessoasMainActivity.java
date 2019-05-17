package com.matheus.contadorpessoas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import static com.matheus.contadorpessoas.R.id.buttonMan;

public class ContadorPessoasMainActivity extends AppCompatActivity {

    Button buttonMan;
    Button buttonWoman;
    Button buttonReset;
    TextView textViewPessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_pessoas_main);

        buttonMan = (Button) findViewById(R.id.buttonMan);
        buttonWoman = (Button) findViewById(R.id.buttonWoman);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        textViewPessoas = (TextView) findViewById(R.id.textViewPessoas);
    }



    public void addMan(View view)
    {
        buttonMan.setText("" + (Integer.parseInt(buttonMan.getText().toString())+1));
        textViewPessoas.setText("Total: " + (Integer.parseInt(buttonMan.getText().toString()) +
                                             Integer.parseInt(buttonWoman.getText().toString())));

    }

    public void addWoman(View view)
    {
        buttonWoman.setText("" + (Integer.parseInt(buttonWoman.getText().toString())+1));
        textViewPessoas.setText("Total: " + (Integer.parseInt(buttonMan.getText().toString()) +
                Integer.parseInt(buttonWoman.getText().toString())));

    }

    public void resetPessoas(View view)
    {
        buttonWoman.setText("0");
        buttonMan.setText("0");
        textViewPessoas.setText("Total: " + (Integer.parseInt(buttonMan.getText().toString()) +
                Integer.parseInt(buttonWoman.getText().toString())));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contador_pessoas_main, menu);
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
