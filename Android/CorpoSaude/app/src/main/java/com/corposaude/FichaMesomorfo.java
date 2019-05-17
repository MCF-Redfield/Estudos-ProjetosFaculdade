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
 
public class FichaMesomorfo extends Activity {
 
    public ListView list;
    Button voltar;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_mesomorfo);

        	voltar = (Button) findViewById(R.id.button1);

             List<Map<String, String>> l = getExampleList();

             voltar.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent();
	                intent.setClass(FichaMesomorfo.this,
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
                    m.put("Dias de Atividade","Segunda-Feira(Peito)");
                    m.put("Exercicios","Supino Inclinado 3x10 - 90 seg. intervalo"+"\n"+"Rosca Direta 3x8 - 90 seg. intervalo"+
                    "Supino Declinado 3x10 - 60 seg. intervalo");
                    l.add(m);
                    Map<String, String> p = new HashMap<String, String>();
                    p.put("Dias de Atividade","Segunda-Feira(Perna)");
                    p.put("Exercicios","Croos Over 3x8 - 90 seg. intervalo"+"\n"+"Agachamento 3x8 - 90 seg. intervalo"+
                    "Extensora 7x8 - 30 seg. intervalo");
                    l.add(p);
                    
                    Map<String, String> qq = new HashMap<String, String>();
                    qq.put("Dias de Atividade","Terça-Feira(Bíceps)");
                    qq.put("Exercicios","Bicéps na Barra 3x10 - 90 seg. intervalo"+"\n"+"Rosca Concentrada 3x10 - 30 seg. intervalo"+
                    "Rosca Scott 7x10 - 90 seg. intervalo");
                    l.add(qq);
                    Map<String, String> qp = new HashMap<String, String>();
                    qp.put("Dias de Atividade","Terça-Feira(Antibraço)");
                    qp.put("Exercicios","Rosca Inversa 3x10 - 90 seg. intervalo"+"\n"+"Rosca de Punho 7x12 - 30 seg. intervalo"+
                    "\n"+"Rosca de Punho Inverso 5x10 30 seg. intervalo");
                    l.add(qp);
                   
                    Map<String, String> w = new HashMap<String, String>();
                    w.put("Dias de Atividade","Quarta-Feira");
                    w.put("Exercicios","Descanso");
                    l.add(w);
                   
                    Map<String, String> e = new HashMap<String, String>();
                    e.put("Dias de Atividade","Quinta-Feira(Trapézio)");
                    e.put("Exercicios","Encolhimento de Ombro  3x10 - 90 seg. intervalo"+"\n"+"Rotação Externa de Ombro - 90 seg. intervalo");
                    l.add(e);
                    Map<String, String>c = new HashMap<String, String>();
                    c.put("Dias de Atividade","Quinta-Feira(Perna)");
                    c.put("Exercicios","Agachamento 3x8 - 90 seg. intervalo"+"\n"+ "Flexora 7x8 - 30 seg. intervalo"+"\n"+"Panturrilha 5x12 25 seg. intervalo");
                    l.add(c);
                    
                    Map<String, String> sex = new HashMap<String, String>();
                    sex.put("Dias de Atividade","Sexta-Feira(Tríceps)");
                    sex.put("Exercicios","Tríceps Concentrado 3x8 - 90 seg. intervalo"+"\n"+"Tríceps Francês 3x8 - 90 seg. intervalo"
                    +"\n"+"Tríceps Unilateral 7x8 - 30 seg. intervalo");
                    l.add(sex);
                    Map<String, String> mn = new HashMap<String, String>();
                    mn.put("Dias de Atividade","Sexta-Feira(Peito)");
                    mn.put("Exercicios","Supino com Halteres 3x10 - 90 seg. intervalo"+"\n"+"Pulõver 3x8 - 90 seg. intervalo"+"\n"+
                    "Supino Inclinado 3x10 - 60 seg. intervalo");
                    l.add(mn);
                   
                    Map<String, String> mnv = new HashMap<String, String>();
                    mnv.put("Dias de Atividade","Sabado(Abdominal)");
                    mnv.put("Exercicios","Abdominal Inclinado 5x10 - 20 seg. intervalo"+"\n"+"Abdominal 7x8 - 90 seg. intervalo"+"\n"+
                    "Elevação de Pernas 3x10 - 60 seg. intervalo");
                    l.add(mnv);
           
                }
                return l;
                
                
            }

        }