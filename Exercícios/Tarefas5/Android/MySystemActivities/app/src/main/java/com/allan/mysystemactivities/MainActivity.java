package com.allan.mysystemactivities;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void startCam(View view)
	{
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivity(intent);
	}
	
	public void startConfig(View view)
	{
		Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
		startActivity(intent);
	}
	
	public void startSMS(View view)
	{		
		Intent intent = new Intent();
		intent.setComponent(new ComponentName("com.android.mms",
 "com.android.mms.ui.ConversationList"));
		startActivity(intent);
	}
	
	public void startActivityInexistente(View view)
	{
		Intent intent = new Intent("NomeDeUmaClasseJavaQueNaoExiste");
		startActivity(intent);
	}

}
