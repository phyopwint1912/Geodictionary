package com.epicsolution.geodictionary;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashView extends Activity {
	final Context context=this;
	private static int SPLASH_TIME_OUT=5000;
	
		//ImageView logo;
		
		View splashview;
	@Override
	protected void onCreate(Bundle savedInstancestate){
			super.onCreate(savedInstancestate);
			setContentView(R.layout.activity_splash);
			//logo=(ImageView)findViewById(R.id.imglogo);
			
			
			
			Animation rotateanimation=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);	
			
			//logo.startAnimation(rotateanimation);
			
			
			
			new Handler().postDelayed(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Intent i=new Intent(SplashView.this,MainView.class);
					startActivity(i);
					
					finish();
					
					
				}
			}, SPLASH_TIME_OUT);
			
			
			
			
			
			
			
			
	}
}
