package tchunaisoft.com.br.betweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Tela2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();

        if(intent != null)
        {
            Bundle parametros = intent.getExtras();
            if(parametros != null)
            {
                EditText nome = (EditText) findViewById(R.id.nome);
                EditText email = (EditText) findViewById(R.id.email);

                nome.setText(parametros.getString("nome"));
                email.setText(parametros.getString("email"));
            }
        }
    }

    public void aceitar(View view)
    {
        Intent intent = new Intent();
        intent.putExtra("msg","Aceitou!");

        setResult(1, intent);
        finish();
    }

    public void recusar(View view)
    {
        Intent intent = new Intent();
        intent.putExtra("msg","Recusou!");

        setResult(0, intent);
        finish();
    }

}
