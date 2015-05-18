package com.example.practice.sendemail;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SendEmail extends Activity implements OnClickListener {

	private EditText emailTo, emailSubject, emailMessage;
	private Button sendBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_email);
		initialize();
	}

	protected void initialize() {
		emailTo = (EditText) findViewById(R.id.emailTo);
		emailSubject = (EditText) findViewById(R.id.emailSubject);
		emailMessage = (EditText) findViewById(R.id.emailMessage);
		sendBtn = (Button) findViewById(R.id.sendBtn);

		sendBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailTo
				.getText().toString());

		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, emailSubject
				.getText().toString());

		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, emailMessage
				.getText().toString());
		startActivity(emailIntent);
		


	}

}
