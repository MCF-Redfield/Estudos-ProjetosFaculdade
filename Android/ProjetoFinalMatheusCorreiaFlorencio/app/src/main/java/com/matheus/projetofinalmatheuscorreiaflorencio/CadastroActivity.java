package com.matheus.projetofinalmatheuscorreiaflorencio;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Matheus Correia Florêncio
//******************************************************
public class CadastroActivity extends AppCompatActivity
{
    private DBHelper dbHelper;
    Button buttonCadastrar, buttonListar, buttonVoltar;
    EditText editTextNome, editTextFone, editTextCPF, editTextEmail, editTextIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        /*Referenciando objeto do layout*/
        buttonCadastrar = (Button) findViewById(R.id.buttonCadastrar);
        buttonListar= (Button) findViewById(R.id.buttonListar);
        buttonVoltar = (Button) findViewById(R.id.buttonVoltar);
        editTextCPF = (EditText) findViewById(R.id.editTextCPF);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextFone = (EditText) findViewById(R.id.editTextFone);
        editTextIdade = (EditText) findViewById(R.id.editTextIdade);
        editTextNome = (EditText) findViewById(R.id.editTextNome);

        this.dbHelper = new DBHelper(this);

    }

    /*método para voltar*/
    public void toVoltar(View view)
    {
        finish();
    }
    /*método para cadastrar CPFs*/
    public void cadastrar(View view)
    {
        /*Verifica se todos campos foram corretamente preenchidos:
         SIM = cadastra
         NÃO = emite mensagem ao uruário*/
        if(!editTextNome.getText().toString().equals("") &&
           !editTextCPF.getText().toString().equals("") &&
           !editTextIdade.getText().toString().equals("") &&
           !editTextEmail.getText().toString().equals("") &&
           !editTextFone.getText().toString().equals(""))

        {
            /*chama o método que insere no BD, passando os dados*/
            dbHelper.insert(editTextCPF.getText().toString(),editTextEmail.getText().toString(),
                    editTextFone.getText().toString(), Integer.parseInt(editTextIdade.getText().toString()),
                    editTextNome.getText().toString());

            AlertDialog.Builder alerta = new AlertDialog.Builder(CadastroActivity.this);
            alerta.setMessage("Dados salvos!!");
            alerta.setTitle("Sucesso");
            alerta.setPositiveButton("OK", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.dismiss();
                }
            });
            AlertDialog desparaAlerta = alerta.create();
            desparaAlerta.show();
            /*limpa os campos após serem inseridos no BD*/
            editTextCPF.setText(null);
            editTextFone.setText(null);
            editTextNome.setText(null);
            editTextIdade.setText(null);
            editTextEmail.setText(null);
        }
        else
        {
            /*informa erro no preenchimento dos campos*/
            AlertDialog.Builder alerta = new AlertDialog.Builder(CadastroActivity.this);
            alerta.setMessage("Preencha corretamente todos os campos!");
            alerta.setTitle("Erro");
            alerta.setPositiveButton("OK", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.dismiss();
                }
            });
            AlertDialog desparaAlerta = alerta.create();
            desparaAlerta.show();
        }
    }

    /*método para listar CPFs cadastrados*/
    public void listar(View view)
    {
        List<PessoaFisica> listaPFisica = dbHelper.queryGetAll();
        /*Verifica se há dados cadastrados:
         SIM = lista
         NÃO = emite mensagem ao uruário*/
        if(listaPFisica == null)
        {
            /*informa que não há dados cadatrados*/
            AlertDialog.Builder alerta = new AlertDialog.Builder(CadastroActivity.this);
            alerta.setMessage("Não há dados cadastrados!!");
            alerta.setTitle("Mensagem");
            AlertDialog desparaAlerta = alerta.create();
            desparaAlerta.show();
        }
        else
        {
            /*exibe dados cadastrados através de um loop*/
            for(int i=listaPFisica.size()-1; i>=0;i--)
            {
                AlertDialog.Builder alerta = new AlertDialog.Builder(CadastroActivity.this);
                alerta.setTitle("Registro " + i);
                alerta.setMessage("Nome: " + listaPFisica.get(i).getNome()
                        + "\nCPF: " + listaPFisica.get(i).getCpf()
                        + "\nIdade: " + listaPFisica.get(i).getIdade()
                        + " anos\nFone: " + listaPFisica.get(i).getFone()
                        + "\nE-mail: " + listaPFisica.get(i).getEmail());
                alerta.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.dismiss();
                    }
                });
                AlertDialog desparaAlerta = alerta.create();
                desparaAlerta.show();
            }
        }
    }

}
