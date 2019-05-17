package com.corposaude;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SobreCorpoEndo extends Activity{
	
	Button bt1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sobrecorpo_endo);
		
			bt1 = (Button) findViewById(R.id.button1);
		
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(SobreCorpoEndo.this, SobreCorpo.class);

				startActivity(intent);

				finish();
			}
		});
		
	}

}
