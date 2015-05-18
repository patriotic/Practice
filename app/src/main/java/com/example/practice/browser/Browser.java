package com.example.practice.browser;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends Activity implements OnClickListener {

	WebView wv;
	EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);

		wv = (WebView) findViewById(R.id.bView);

		wv.getSettings().setJavaScriptEnabled(true);
		wv.getSettings().setLoadWithOverviewMode(true);
		wv.getSettings().setUseWideViewPort(true);

		wv.setWebViewClient(new ViewClient());
		
		try{
		wv.loadUrl("http://www.google.com");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		et = (EditText) findViewById(R.id.bEditText);
		Button bGo = (Button) findViewById(R.id.bGo);
		Button bBack = (Button) findViewById(R.id.bBack);
		Button bForward = (Button) findViewById(R.id.bForward);
		Button bRefresh = (Button) findViewById(R.id.bRefresh);
		Button bHistory = (Button) findViewById(R.id.bHistory);

		bGo.setOnClickListener(this);
		bBack.setOnClickListener(this);
		bForward.setOnClickListener(this);
		bRefresh.setOnClickListener(this);
		bHistory.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bGo:
			wv.loadUrl(et.getText().toString());
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(et.getWindowToken(),0);
			break;
		case R.id.bBack:
			if (wv.canGoBack()) {
				wv.goBack();
			}
			break;
		case R.id.bForward:
			if (wv.canGoForward()) {
				wv.goForward();
			}
			break;
		case R.id.bRefresh:
			wv.reload();
			break;
		case R.id.bHistory:
			wv.clearHistory();
			break;
		}
	}

}
