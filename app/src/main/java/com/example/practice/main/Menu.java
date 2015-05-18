package com.example.practice.main;

import com.example.practice.R;
 
import com.example.practice.R.id;
import com.example.practice.R.menu;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	private String[] classes = { "StartingPoint", "PlayingWithText",
			"SendEmail", "Camera", "Animation", "AnimationSurface",
			"PlayingWithSound", "SlidingDrawerExample", "Tabs", "Browser",
			"Flipper","SharedPrefs","InternalData","ExternalData","Accelerate",
			"Maps","HttpExample","Fragment","FragmentLayout","Swiper","SwiperG","Transition" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		try {
			@SuppressWarnings("rawtypes")
			Class myClass = Class.forName("com.example.practice."+ classes[position].toLowerCase() +"."
					+ classes[position]);
			Intent myIntent = new Intent(Menu.this, myClass);
			startActivity(myIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater show_menu = getMenuInflater();
		show_menu.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent("com.example.practice.AboutUs");
			startActivity(i);
			break;
		case R.id.preferences:
			Intent p = new Intent("com.example.practice.Prefs");
			startActivity(p);
			break;
		case R.id.exit:
			finish();
			break;
		}
		return false;

	}

}
