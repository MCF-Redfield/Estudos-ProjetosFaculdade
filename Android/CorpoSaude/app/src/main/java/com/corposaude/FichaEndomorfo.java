package com.corposaude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
 
public class FichaEndomorfo extends Activity {
 
    public ListView list;
    Button voltar;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_endomorfo);

        	voltar = (Button) findViewById(R.id.button1);

             List<Map<String, String>> l = getExampleList();

             voltar.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent();
	                intent.setClass(FichaEndomorfo.this,
	                        Fichas.class);

	                startActivity(intent);

	                finish();
					
				}
			});
            
                String[] from = { "Dias de Atividade", "Exercicios" };
                int[] to = { android.R.id.text1, android.R.id.text2 };
         
                SimpleAdapter ad = new SimpleAdapter(this, l, android.R.layout.simple_list_item_2, from, to);
                ListView lv = (ListView) findViewById(R.id.list);
                lv.setAdapter(ad);
            
         
            
	}

			/**
             * Fill a list object
             *
             * @return List<String>
             */
    
            private List<Map<String, String>> getExampleList() {
                List<Map<String, String>> l = new ArrayList<Map<String, String>>();
                for (int i = 0; i < 1; i++) {
                    Map<String, String> m = new HashMap<String, String>();
                    m.put("Dias de Atividade","Segunda-Feira");
                    m.put("Exercicios","PullDown Aberto 5x12 - 60 seg. intervalo"+"\n"+"Pulldown nuca 4x10 - 90 seg. intervalo"+"\n"+
                    "Pulldown Supino 3x10 - 60 seg. intervalo"+"\n"+"Rosca Martelo Sentado 3x10 - 30 seg. intervalo");
                    l.add(m);
               
                    Map<String, String> qq = new HashMap<String, String>();
                    qq.put("Dias de Atividade","Terça-Feira");
                    qq.put("Exercicios","Supino Plano com Halteres 3x10 - 90 seg. intervalo"+"\n"+"Supino Inclinado com Barra 3x15 - 30 seg. intervalo"+
                    		"\n"+"Supino Declinado com Barro 4x10 - 90 seg. intervalo"+"\n"+"Crucifixo reto 4x12 - 45 seg. intervalo");
                    l.add(qq);
                
                    Map<String, String> w = new HashMap<String, String>();
                    w.put("Dias de Atividade","Quarta-Feira");
                    w.put("Exercicios","30 min de caminhada moderadamente rápida"+"\n"+"25 min de bike moderadamente rápida"+"\n"+"25 min de transport pesado");
                    l.add(w);
                  
                    Map<String, String> e = new HashMap<String, String>();
                    e.put("Dias de Atividade","Quinta-Feira");
                    e.put("Exercicios","Cadeira Extensora 3x10 - 90 seg. intervalo"+"\n"+"Agachamento Livre 5x20 - 90 seg. intervalo"+"\n"+
                    "Leg Press 2x25 90 seg. intervalo"+"\n"+"Gêmeos em pé 4x Falha para cada um");
                    l.add(e);
               
                    Map<String, String> sex = new HashMap<String, String>();
                    sex.put("Dias de Atividade","Sexta-Feira");
                    sex.put("Exercicios","Desenv. com Barra Livre 3x8 - 90 seg. intervalo"+"\n"+"Elevação Lateral 3x8 - 90 seg. intervalo"
                    +"\n"+"Encolhimento com barra 7x8 - 30 seg. intervalo"+"\n"+"Crucifixo inverso na máquina 4x8 30 seg. intervalo");
                    l.add(sex);
                    
                    Map<String, String> mnv = new HashMap<String, String>();
                    mnv.put("Dias de Atividade","Sabado");
                    mnv.put("Exercicios","45 min de esteira moderadamente rápido"+"\n"+"10 min de transport pesado"+"\n"+
                    "15 min de bicicleta sem carga");
                    l.add(mnv);
           
                }
                return l;
                
                
            }

        }