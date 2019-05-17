package com.matheus.projetofinalmatheuscorreiaflorencio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


//******************************************************
//Instituto Federal de São Paulo - Campus Sertãozinho
//Disciplina......: M4DADM
//Programação de Computadores e Dispositivos Móveis
//Aluno...........: Matheus Correia Florêncio
//******************************************************

public class ProjFinalMainActivity extends AppCompatActivity {

    Button buttonInserir;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proj_final_main);
        buttonInserir = (Button) findViewById(R.id.buttonInserir);

    }

    /*método que leva até a activity de cadastro e listagem*/
    public void toCadastro(View view)
    {
        startActivity( new Intent(ProjFinalMainActivity.this, CadastroActivity.class));
    }

}
