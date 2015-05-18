package com.example.practice.playingwithtext;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.view.Gravity;
import android.view.View;

public class PlayingWithText extends Activity implements View.OnClickListener {

	private EditText woym;
	private Button ok_btn;
	private ToggleButton tg_btn;
	private TextView comments_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playing_with_text);
		initialize();
	}

	protected void initialize() {
		woym = (EditText) findViewById(R.id.editText);
		ok_btn = (Button) findViewById(R.id.okButton);
		tg_btn = (ToggleButton) findViewById(R.id.toggleButton);
		comments_tv = (TextView) findViewById(R.id.comments);

		woym.setOnClickListener(this);
		ok_btn.setOnClickListener(this);

		tg_btn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.okButton:
			if (tg_btn.isChecked()) {
				comments_tv
						.setText("You are now able to deliver your status !");

				if (woym.getText() != null) {
					comments_tv.setText("STATUS : " + woym.getText());
					comments_tv.setGravity(Gravity.CENTER);
					comments_tv.setTextColor(Color.CYAN);
				}
			} else {
				comments_tv
						.setText("You are not able to deliver your status !");

			}
			woym.setText(null);

			break;
		case R.id.toggleButton:
			if (tg_btn.isChecked()) {
				comments_tv
						.setText("You are now able to deliver your status !");
				woym.setEnabled(true);
			} else {
				comments_tv
						.setText("You are not able to deliver your status !");
				woym.setEnabled(false);
			}
			break;
		}
	}
}
