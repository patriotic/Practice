package com.example.practice.swiper;

import com.example.practice.R;
import com.example.practice.R.id;
import com.example.practice.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Swiper extends FragmentActivity {

	public static final String items[] = { "name1", "name2", "name3", "name4",
			"name5" };
	ArrayAdapter<String> list;
	static ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.v("trace : ", "onCreate");
		setContentView(R.layout.swiper);

		FragmentAdapter fa = new FragmentAdapter(getSupportFragmentManager());

		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(fa);
	}

	public static class FragmentAdapter extends FragmentStatePagerAdapter {

		int x;
		
		public FragmentAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
			Log.v("trace : ", "FragmentManager");
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			Log.v("trace : ", "getItem " + arg0);
			x = arg0;
			DemoFragment fragment = new DemoFragment();

			Bundle bdl = new Bundle();
			bdl.putString("keys", items[arg0]);
			bdl.putInt("key", arg0);
			// bdl.putString("keys", "name");
			fragment.setArguments(bdl);

			return fragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			Log.v("trace : ", "getCount");
			return 5;
		}

		// @Override
		// public void finishUpdate(ViewGroup container) {
		// // TODO Auto-generated method stub
		// super.finishUpdate(container);
		// if(x>0)
		// destroyItem(container,x-1,this);
		// }
		//
		//
		//
		 @Override
		 public void destroyItem(ViewGroup container, int position, Object
		 object) {
		 // TODO Auto-generated method stub
		 super.destroyItem(container, position, object);
		 Log.v("trace : ", "destroyItem : "+ position);
		 }
	}

	public static class DemoFragment extends Fragment {

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub

			View rootView = inflater.inflate(R.layout.swiper_fragment,
					container, false);
			Bundle args = getArguments();
			((TextView) rootView.findViewById(android.R.id.text1))
					.setText((args.getString("keys")));
			return rootView;
		}

	}
}
