package com.epicsolution.geodictionary;



import java.util.ArrayList;
import java.util.HashMap;

import comm.comfunction;

import dbassist.dbhelp;
import entity.Word;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DetailView extends Activity {
	TextView txtword;
	TextView txtype;
	TextView txtdesc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.avtivity_detail_view);
		
		Intent intent=getIntent();
		String word= intent.getStringExtra("word");
		
		txtword=(TextView)findViewById(R.id.txtword);
		txtype=(TextView)findViewById(R.id.txttype);
		txtdesc=(TextView)findViewById(R.id.txtdesc);
		txtdesc.setMovementMethod(new ScrollingMovementMethod());
		Displaydetail(word);
		
		
		
	}
	void Displaydetail(String word){
		
		Word w=new Word();	
		w=(Word)getSingleWord(word);
		String sss= w.getWord();
		txtword.setText(w.getWord());
		
		txtype.setText("( "+w.getWtype()+" )");
		
		txtdesc.setText(Html.fromHtml(w.getDesc()));
	}
	
	
	
	protected Word getSingleWord(String inputword){
		Character firstcharCharacter=0;
		ArrayList alist=new ArrayList();
		dbhelp db=new dbhelp(getApplicationContext());
		
		firstcharCharacter=inputword.charAt(0);
		comfunction com=new comfunction();
		String tablename=com.gettableName(firstcharCharacter);
		
		String sql="SELECT word,type,desc FROM "+tablename+" where word='"+inputword+"'";
		
			alist=db.getDataRow(sql);
			HashMap tablerow=new HashMap();
			tablerow=(HashMap)alist.get(0);
			Word w=new Word();
			if(tablerow.size()!=0){
								
				w.setWord(tablerow.get("word").toString().toLowerCase());
				w.setDesc(tablerow.get("desc").toString());
				w.setWtype(tablerow.get("type").toString().toLowerCase());
				return w;
			}else{	 
		
				return w;
			}
		
	}
}
