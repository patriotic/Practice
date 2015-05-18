package com.example.practice.startingpoint;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class StartingPoint extends Activity implements View.OnClickListener {

	private Button add_btn, sub_btn;
	private TextView int_tv;
	private int counter = 0; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.main);
		initialize();
	}

	protected void initialize() {
		add_btn = (Button) findViewById(R.id.addInt);
		sub_btn = (Button) findViewById(R.id.subInt);
		int_tv = (TextView) findViewById(R.id.totalInt);

		add_btn.setOnClickListener(this);
		sub_btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.addInt:
			int_tv.setText(""+(++counter));
			break;
		case R.id.subInt:
			int_tv.setText(""+(--counter));
			break;
		}
	}

}
