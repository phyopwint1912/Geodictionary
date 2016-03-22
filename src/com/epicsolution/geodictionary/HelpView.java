package com.epicsolution.geodictionary;

import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class HelpView extends Activity {
		TextView txthelp;
		
		protected void onCreate(Bundle savedInstanceState) {
				
				super.onCreate(savedInstanceState);
				
				setContentView(R.layout.activity_help);
				
				txthelp=(TextView)findViewById(R.id.txt_help_about);
				
				txthelp.setText("ဤ ေဆာ့ဖ္ဝဲလ္ၿဖစ္လာေစရန္ ပထမဦးစြာအၾကံဥာဏ္ေပးေသာကိုခင္ေဇာ္ဟိန္း(24 hourgeology) DataEntry တြင္ မအားလပ္သည့္ၾကားမွဝိုင္းဝန္းကူညီေပးၾကေသာ ကိုခ်စ္စမ္းေမာင္ ၊ ကိုၿဖိဳးဟန္ထက္ ၊ကိုခ်စ္မ်ိဳးလြင္ တို့အား အထူးေက်းဇူးတင္ရွိပါသည္။Geological Dictionary အမည္ၿဖင့္ Desktop application ထြက္ရွိၿပီးထားၿပီၿဖစ္သည္။သို ့ေသာ္လည္းယေန့ ေခတ္သည္မိုဘိုင္းဖုန္းမ်ားကိုသာအဓိကအားထားၾကသၿဖင့္ Mobile Application တခုအေနၿဖင့္လည္း Geologist မ်ား၏ လက္ထဲတြင္ အနီးဆံုးရွိေစရန္ရည္ရြယ္၍  Mobile app အေနၿဖင့္ထပ္မံထုတ္လုပ္လိုက္ၿခင္းၿဖစ္ပါသည္။ သံုးစြဲရာတြင္အခက္အခဲမ်ားရွိပါက khinzawhein24@gmail.com ႏွင့္ winhtaikaung@epicmyanmar.comသို့ ဆက္သြယ္နိုင္ပါသည္။Credit to collins Dictionary( Geology )");
				txthelp.setScrollbarFadingEnabled(true);
				txthelp.setMovementMethod(new ScrollingMovementMethod());
		}
}
