package com.example.practice.fragment;

import com.example.practice.R;
import com.example.practice.R.layout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;

public class ListNews extends Fragment {
	public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bdl) {

		return li.inflate(R.layout.list_news, vg , false);

	}
}
