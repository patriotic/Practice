package com.example.practice.maps;

import com.example.practice.R;
import com.example.practice.R.layout;

import android.app.Activity;
import android.os.Bundle;

public class Maps extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maps);
	}
}



//************ Code from TheNewBoston for google maps v1 *******************//



// public class Maps extends MapActivity {
//
// MapView mv;
// long start, stop;
//
// @Override
// protected void onCreate(Bundle savedInstanceState) {
// // TODO Auto-generated method stub
// super.onCreate(savedInstanceState);
// setContentView(R.layout.maps);
// mv = (MapView) findViewById(R.id.map);
// // mv.setBuiltInZoomControls(true);
//
// // Touchy t = new Touchy();
// // List<Overlay> overlayList = mv.getOverlays();
// // overlayList.add(t);
//
// }
//
// @Override
// protected boolean isRouteDisplayed() {
// // TODO Auto-generated method stub
// return false;
// }
//
// class Touchy extends Overlay {
//
// @SuppressWarnings("deprecation")
// @Override
// public boolean onTouchEvent(MotionEvent arg0, MapView arg1) {
// // TODO Auto-generated method stub
// if (arg0.getAction() == MotionEvent.ACTION_DOWN) {
// start = arg0.getEventTime();
// }
// if (arg0.getAction() == MotionEvent.ACTION_UP) {
// stop = arg0.getEventTime();
// }
// if (start - stop > 1500) {
// AlertDialog alert = new AlertDialog.Builder(Maps.this).create();
// alert.setTitle("OPTION");
// alert.setMessage("Choose an option ! ");
// alert.setButton("option 1",
// new DialogInterface.OnClickListener() {
//
// @Override
// public void onClick(DialogInterface dialog,
// int which) {
// // TODO Auto-generated method stub
//
// }
// });
// alert.setButton2("option 2",
// new DialogInterface.OnClickListener() {
//
// @Override
// public void onClick(DialogInterface dialog,
// int which) {
// // TODO Auto-generated method stub
//
// }
// });
// alert.setButton2("option 3",
// new DialogInterface.OnClickListener() {
//
// @Override
// public void onClick(DialogInterface dialog,
// int which) {
// // TODO Auto-generated method stub
//
// }
// });
// alert.show();
// return true;
// }
//
// return false;
// }
//
// }
//
// }
