package com.example.practice.externaldata;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;
import com.example.practice.R.raw;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ExternalData extends Activity implements OnItemSelectedListener,
		OnClickListener {

	TextView read, write;
	String state;
	Boolean canW, canR;
	Spinner spinner;
	String paths[] = { "Music", "Pictures", "Downloads" };
	File path = null;
	File file = null;
	Button etSave;
	EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.external_data);
		read = (TextView) findViewById(R.id.textView1);
		write = (TextView) findViewById(R.id.textView2);
		Button etConfirm = (Button) findViewById(R.id.etConfirm);
		etSave = (Button) findViewById(R.id.etSave);
		editText = (EditText) findViewById(R.id.editText1);

		etConfirm.setOnClickListener(this);
		etSave.setOnClickListener(this);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, paths);
		spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);

		checkState();

	}

	private void checkState() {
		// TODO Auto-generated method stub
		state = Environment.getExternalStorageState();

		if (state.equals(Environment.MEDIA_MOUNTED)) {
			read.setText("true");
			write.setText("true");
			canW = canR = true;
		} else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
			read.setText("true");
			write.setText("false");
			canW = true;
			canR = false;
		} else {
			read.setText("false");
			write.setText("false");
			canW = canR = false;
		}

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		// int position = spinner.getSelectedItemPosition();
		switch (arg2) {
		case 0:
			path = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			break;
		case 1:
			path = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

			break;
		case 2:
			path = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

			break;
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.etConfirm:

			etSave.setVisibility(View.VISIBLE);

			break;
		case R.id.etSave:
			String fname = editText.getText().toString();
			file = new File(path, fname +".mp3");
			checkState();
			if (canW = canR = true) {
				path.mkdirs();
				try {
					InputStream is = getResources().openRawResource(
							R.raw.splash_sound);
					OutputStream os = new FileOutputStream(file);
					byte[] data = new byte[is.available()];
					is.read(data);
					os.write(data);
					is.close();
					os.close();
					
					Toast t = Toast.makeText(this, "File has been saved", Toast.LENGTH_SHORT);
					t.show();
					//update files for the user to use
					MediaScannerConnection.scanFile(this, new String[] {file.toString()}, null, new MediaScannerConnection.OnScanCompletedListener() {
						
						@Override
						public void onScanCompleted(String arg0, Uri arg1) {
							// TODO Auto-generated method stub
							Toast.makeText(ExternalData.this, "scan complete", Toast.LENGTH_SHORT).show();
						}
					});
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			break;
		}

	}

}
