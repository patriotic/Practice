package com.example.practice.browser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewClient extends WebViewClient {

	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// TODO Auto-generated method stub
		super.shouldOverrideUrlLoading(view, url);
		view.loadUrl(url);
		return true;
	}
	

}
