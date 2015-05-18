package com.example.practice.camera;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Camera extends Activity implements OnClickListener{

	private ImageView iv_pic;
	private Button btn_pic;
	final static int camera_data = 0;
	private Bitmap bmp;
	private TextView tv_welcome;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera);
		init();
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		tv_welcome.setText("Welcome, "+getPrefs.getString("name", "")+". you are ready to capture.");
	}

	protected void init() {
		iv_pic = (ImageView) findViewById(R.id.imageView);
		btn_pic = (Button) findViewById(R.id.takePic);
		tv_welcome = (TextView) findViewById(R.id.welcome);
		btn_pic.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()== R.id.takePic){
			Intent pic_intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(pic_intent,camera_data);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == RESULT_OK){
			Bundle extras = data.getExtras();
			bmp =(Bitmap) extras.get("data");
			iv_pic.setImageBitmap(bmp);
			iv_pic.setVisibility(View.VISIBLE);
			iv_pic.getLayoutParams().height=800;
			iv_pic.getLayoutParams().width=800;
		}
	}
	

}
