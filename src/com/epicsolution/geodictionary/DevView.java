package com.epicsolution.geodictionary;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class DevView extends Activity {
		Button btngitButton;
		ImageView imgandroid;
		Button btnfblike;
		
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_devportfolio);

		final Animation rotator= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
		
		rotator.setRepeatCount(Animation.INFINITE);
		
		
		btngitButton=(Button)findViewById(R.id.btngit);
		imgandroid=(ImageView)findViewById(R.id.imgandroid);
		btnfblike=(Button)findViewById(R.id.btnfblike);
		
		controller(btngitButton);
		controller(btnfblike);
		
		btngitButton.startAnimation(rotator);
		btnfblike.startAnimation(rotator);

			
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public void controller(final Button b)
	{
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				switch(b.getId()){
					case R.id.btngit:{
						Toast.makeText(getApplicationContext(), "go to git", Toast.LENGTH_SHORT).show();
						
						Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse("https://github.com/winhtaikaung/Geodictionary") );

					    startActivity( browse );
					};break;
					case R.id.btnfblike:{
						Toast.makeText(getApplicationContext(), "go to fb", Toast.LENGTH_SHORT).show();
						
						Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse("https://m.facebook.epicmyanmar") );

					    startActivity( browse );
					};break;
					
					
					
				}
				
			}
		});
	}
		
	
}
