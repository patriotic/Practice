package com.example.practice.sharedprefs;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements OnClickListener {

	EditText et;
	TextView showResults;
	SharedPreferences someData;

	public final static String filename = "MySharedString";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shared_prefs);
		initialize();
		someData = getSharedPreferences(filename, 0);
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
			Editor edit = someData.edit();
			edit.putString("sharedData", etdata);
			edit.putString("scores", "12345");
			edit.commit();
			break;
		case R.id.bLoad:
			someData = getSharedPreferences(filename, 0);
			showResults.setText(someData.getString("sharedData", "No Entry!!")
					+ "\n"+someData.getString("scores", "No Entry!!"));

			break;
		}

	}
}
