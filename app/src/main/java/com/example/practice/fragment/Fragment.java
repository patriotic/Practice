package com.example.practice.fragment;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Fragment extends Activity {

	FragmentManager fm;
	FragmentTransaction ft;
	ListNews ln;
	SingleNews sn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment);

		LinearLayout layout = (LinearLayout) findViewById(R.id.fg_container);

		Configuration config = getResources().getConfiguration();

		fm = getFragmentManager();
		ft = fm.beginTransaction();
		ln = new ListNews();
		sn = new SingleNews();

		if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
			layout.setOrientation(LinearLayout.VERTICAL);

		} else {
			layout.setOrientation(LinearLayout.HORIZONTAL);
		}

		
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ft.replace(R.id.fg_container1, ln);
		ft.replace(R.id.fg_container2, sn);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		ft.commit();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
	}

}
