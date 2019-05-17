package com.corposaude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
 

public class FichaEctomorfo extends Activity {
 
    public ListView list;
    Button voltar;
 
 
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_ectomorfo);

        
        	voltar = (Button) findViewById(R.id.button1);

             List<Map<String, String>> l = getExampleList();

             voltar.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent();
	                intent.setClass(FichaEctomorfo.this,
	                        Fichas.class);

	                startActivity(intent);

	                finish();
					
				}
			});
             
                String[] from = { "Dias de Atividade", "Exercicios","Tipo" };
                int[] to = { android.R.id.text1, android.R.id.text2 };
         
                SimpleAdapter ad = new SimpleAdapter(this, l, android.R.layout.simple_list_item_2, from, to);
                ListView lv = (ListView) findViewById(R.id.list);
                lv.setAdapter(ad);
         
          
	}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        }
        return super.onOptionsItemSelected(item);
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
                    m.put("Dias de Atividade","Segunda-Feira(Bíceps)");
                    m.put("Exercicios","Rosca Scott 3x10 - 90 seg. intervalo"+"\n"+"Barra Fixa 3x8 - 90 seg. intervalo"+
                    "Rosca Fixa Sulpinada 3x10 - 60 seg. intervalo");
                    l.add(m);
                    Map<String, String> p = new HashMap<String, String>();
                    p.put("Dias de Atividade","Segunda-Feira(Tríceps)");
                    p.put("Exercicios","Paralelas 3x8 - 90 seg. intervalo"+"\n"+"Trípes Testa 3x8 - 90 seg. intervalo"+
                    "Tríps Corda 7x8 - 30 seg. intervalo");
                    l.add(p);
                    Map<String, String> q = new HashMap<String, String>();
                    q.put("Dias de Atividade","Segunda-Feira(Panturrilha)");
                    q.put("Exercicios","Panturrilha Sentado 3x10 - 90 seg. intervalo"+"\n"+"Panturrilha em Pé 7x12 - 30 seg. intervalo");
                    l.add(q);
                    Map<String, String> qq = new HashMap<String, String>();
                    qq.put("Dias de Atividade","Terça-Feira(Quadríceps)");
                    qq.put("Exercicios","Agachamento Livre 3x10 - 90 seg. intervalo"+"\n"+"Leg Press 3x10 - 30 seg. intervalo"+
                    "Mesa Extensora 7x10 - 90 seg. intervalo");
                    l.add(qq);
                    Map<String, String> qp = new HashMap<String, String>();
                    qp.put("Dias de Atividade","Terça-Feira(Femural)");
                    qp.put("Exercicios","Stiff  3x10 - 90 seg. intervalo"+"\n"+"Mesa Flexora 7x12 - 30 seg. intervalo");
                    l.add(qp);

                    Map<String, String> w = new HashMap<String, String>();
                    w.put("Dias de Atividade","Quarta-Feira");
                    w.put("Exercicios","Descanso");
                    l.add(w);
                 
                    Map<String, String> e = new HashMap<String, String>();
                    e.put("Dias de Atividade","Quinta-Feira(Peitoral)");
                    e.put("Exercicios","Supino Inclinado(Halteres)  3x10 - 90 seg. intervalo"+"\n"+"Sulpino Reto - 90 seg. intervalo"+
                    "Crussifixo no Peck Deck 7x10 - 30 seg. intervalo");
                    l.add(e);
                    Map<String, String>c = new HashMap<String, String>();
                    c.put("Dias de Atividade","Quinta-Feira(Tríceps)");
                    c.put("Exercicios","Trípes Testa 3x8 - 90 seg. intervalo"+"\n"+ "Tríps Corda 7x8 - 30 seg. intervalo");
                    l.add(c);
                  
                    Map<String, String> sex = new HashMap<String, String>();
                    sex.put("Dias de Atividade","Sexta-Feira(Ombro)");
                    sex.put("Exercicios","Desenvolvimento Frente 3x8 - 90 seg. intervalo"+"\n"+"Remada Alta 3x8 - 90 seg. intervalo"+
                    "Crucifixo Inverso 3x10 - 60 seg. intervalo"+"\n"+"Elevação Lateral 7x8 - 30 seg. intervalo");
                    l.add(sex);
                    Map<String, String> mn = new HashMap<String, String>();
                    mn.put("Dias de Atividade","Sexta-Feira(Costas)");
                    mn.put("Exercicios","Puxador Frente 3x10 - 90 seg. intervalo"+"\n"+"Remada Curvada 3x8 - 90 seg. intervalo"+"\n"+
                    "Remada Fechada 3x10 - 60 seg. intervalo");
                    l.add(mn);
                   
           
                }
                return l;
                
                
            }

        }