package com.epicsolution.geodictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import comm.comfunction;

import dbassist.dbhelp;
import entity.Word;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainView extends Activity {
	
	EditText txtinput;
	ListView lstword;
	TextView txtwatermark;
	ArrayAdapter<String> adapter;
	final Context context=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_view);
		
		String sql="SELECT word,desc,type FROM A WHERE word = 'aa'";
		final dbhelp db=new dbhelp(getApplicationContext());
		db.MakeDB();
		
		txtinput=(EditText)findViewById(R.id.txt_autocomplete);
		lstword=(ListView)findViewById(R.id.wordlist);
		txtwatermark=(TextView)findViewById(R.id.textView1);
		
		BindingListeners();
		
		
		
		
	}
	
	protected void BindingListeners(){
		
		txtinput.addTextChangedListener(txtwatch);
		lstword.setOnItemClickListener(OnitmclkListner);
	}
	//############ declaring Listeners ############################
	
	private TextWatcher txtwatch=new TextWatcher(){
		Character firstchar;
		Word w=new Word();
		String tablename;
		ArrayList<String> tmplist=new ArrayList<String>();
	@Override
	public void afterTextChanged(Editable arg0) {
		// TODO Auto-generated method stub
		if(txtinput.getText().length()!=0)
		{
					firstchar=txtinput.getText().charAt(0);
					comfunction com=new comfunction();
					tablename=com.gettableName(firstchar);
					w.setWord(txtinput.getText().toString());
					tmplist= getLikelywords(w, tablename);
					//check wordlist is empty or not
					if(!tmplist.isEmpty()){
						txtwatermark.setText("");
						adapter=new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_dropdown_item_1line,tmplist);
						lstword.setAdapter(adapter);
						
					}else{
						txtwatermark.setText("No Result");
						adapter=new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_dropdown_item_1line,tmplist);
						lstword.setAdapter(adapter);
						
					}
		}
		
	}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	// item click listener
	private OnItemClickListener OnitmclkListner=new OnItemClickListener() {
		
		public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
			
			String item = (String) lstword.getItemAtPosition(position);
			  
			//Going To detail view
			
			Intent intent=new Intent(context, DetailView.class);			
			intent.putExtra("word",item);
			startActivity(intent);
			
			
			}
	};
	
	
	
	
	
	

	//---------------------- Listener End Region -----------------------------------------------
	
	//###################### Data ACCESS region ###############################################
	public ArrayList<String> getLikelywords(Word o,String TableName){
		dbhelp db=new dbhelp(getApplicationContext());
		String comma=",";
		String sql="SELECT word,desc,type FROM "+TableName +" WHERE word LIKE '"+o.getWord().toString()+"%'";
		ArrayList alist=new ArrayList();
		ArrayList<String> wordlist=new ArrayList<String>();
		try{
			
			alist=db.getDataTable(sql);
			for(int i=0;i<alist.size();i++){
				HashMap tablerow=new HashMap();
				tablerow=(HashMap)alist.get(i);
				Word w=new Word();				
				 w.setWord(tablerow.get("word").toString().toLowerCase());
				 w.setDesc(tablerow.get("desc").toString().toLowerCase());
				 if(!w.getDesc().equals(null)){
					 
				
					 wordlist.add(w.getWord());
				 }else{
					 
				 }
				
			} 
			return wordlist;
		}catch(Exception e){
			return wordlist;
			
		}
		
		
	}
	
	//###################### Data Access region Ends ##########################################
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_view,menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected (MenuItem item){
		switch(item.getItemId())
		{
		case R.id.about:
			Intent intent=new Intent(context, DevView.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);			
		}
		
		
	}

}
