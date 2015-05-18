package com.example.practice.internaldata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener {

	EditText et;
	TextView showResults;

	public final static String filename = "MyFile";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shared_prefs);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		et = (EditText) findViewById(R.id.editText1);
		Button bSave = (Button) findViewById(R.id.bSave);
		Button bLoad = (Button) findViewById(R.id.bLoad);
		showResults = (TextView) findViewById(R.id.showResults);

		bSave.setOnClickListener(this);
		bLoad.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSave:
			String etdata = et.getText().toString();
			// Saving to file

			try {
				FileOutputStream fos = openFileOutput(filename,
						Context.MODE_PRIVATE);
				fos.write(etdata.getBytes());
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case R.id.bLoad:
			// Reading From File
			new loadSomeStuff().execute(filename);
			break;
		}

	}

	public class loadSomeStuff extends AsyncTask<String, Integer, String> {

		ProgressDialog dialog;
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			showResults.setText(result);
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog = new ProgressDialog(InternalData.this);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setMax(89);
			dialog.show();
			
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			dialog.incrementProgressBy(values[0]);
		}

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			for(int i=0;i<20;i++){
				publishProgress(5);
				try {
					Thread.sleep(88);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			dialog.dismiss();
			try {
				FileInputStream fis = openFileInput(filename);
				String res=null;
				byte[] getdata = new byte[fis.available()];
				while (fis.read(getdata) != -1) {
					res = new String(getdata);
				}
				fis.close();
				return res;
				// 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	}

}
