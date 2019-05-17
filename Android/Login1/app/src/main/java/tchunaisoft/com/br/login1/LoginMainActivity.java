package tchunaisoft.com.br.login1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginMainActivity extends ActionBarActivity {

    Button cancel;
    Button login;
    EditText nome;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        cancel = (Button) findViewById(R.id.cancel);
        login = (Button) findViewById(R.id.login);
        senha = (EditText) findViewById(R.id.senha);
        nome = (EditText) findViewById(R.id.nome);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_main, menu);
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

    public void logar (View v) {
        if(nome.getText().toString().isEmpty())
        {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Informe o usuario", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(senha.getText().toString().isEmpty())
        {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Informe a senha", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (nome.getText().toString().equalsIgnoreCase("usuario") && senha.getText().toString().equals("123"))
        {
            Intent intent = new Intent(LoginMainActivity.this, WelcomeActivity.class);
            startActivity(intent);
        }
        else
        {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Usuario ou senha incorreto", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void cancelar (View v)
    {
        if(!nome.getText().toString().isEmpty() || !senha.getText().toString().isEmpty())
        {
            nome.setText("");
            senha.setText("");
        }
        else
        {
            finish();
        }
    }
}
