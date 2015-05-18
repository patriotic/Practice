package com.example.practice.transition;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.practice.R;

public class Transition extends Activity {

	Scene a_scene,another_scene,ending_scene;
	ViewGroup root_scene;
	Fade fade_transition;
	Button fade_me;
	TransitionManager TM;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.transition);
		
		root_scene = (ViewGroup) findViewById(R.id.scene_root);
		
		a_scene = Scene.getSceneForLayout(root_scene, R.layout.a_scene, this);
		another_scene = Scene.getSceneForLayout(root_scene, R.layout.another_scene , this);
		
		ending_scene=another_scene;
		fade_transition = new Fade();
		fade_me = (Button) findViewById(R.id.fade_me);
		
//		fade_me.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				
//				TM.go(ending_scene, fade_transition);
//			}
//			
//		});
		
		
		
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
}
