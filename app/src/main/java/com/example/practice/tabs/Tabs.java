package com.example.practice.tabs;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener {

	TabHost th;
	TabSpec ts;
	TextView tv1;
	long start = 0, stop = 0, time = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		Button addTab = (Button) findViewById(R.id.addTab);
		Button startWatch = (Button) findViewById(R.id.startWatch);
		Button stopWatch = (Button) findViewById(R.id.stopWatch);
		startWatch.setOnClickListener(this);
		stopWatch.setOnClickListener(this);
		addTab.setOnClickListener(this);

		tv1 = (TextView) findViewById(R.id.showResult);

		th = (TabHost) findViewById(R.id.tabhost);
		th.setup();

		ts = th.newTabSpec("tag1");
		ts.setContent(R.id.tab1);
		ts.setIndicator("Tab 1");
		th.addTab(ts);

		ts = th.newTabSpec("tag2");
		ts.setContent(R.id.tab2);
		ts.setIndicator("Tab 2");
		th.addTab(ts);

		ts = th.newTabSpec("tag3");
		ts.setContent(R.id.tab3);
		ts.setIndicator("Tab 3");
		th.addTab(ts);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.addTab:
			ts = th.newTabSpec("new tag");
			ts.setContent(new TabHost.TabContentFactory() {

				@Override
				public View createTabContent(String arg0) {
					// TODO Auto-generated method stub
					TextView tv = new TextView(Tabs.this);
					tv.setText("This is a new tab!!!!");
					return tv;
				}
			});
			ts.setIndicator("New Tab");
			th.addTab(ts);
			break;
		case R.id.startWatch:
			start = System.currentTimeMillis();
			break;
		case R.id.stopWatch:
			if (start != 0) {
				stop = System.currentTimeMillis();
				time = (stop - start);

				int millis = (int) time;
				int secs = millis / 1000;
				int mins = secs / 60;

				millis = millis % 100;
				secs = secs%60;
				mins = mins%60;
				
				tv1.setText(String.format("%02d:%02d:%02d", mins,secs,millis));
			}
			break;
		}

	}

}
