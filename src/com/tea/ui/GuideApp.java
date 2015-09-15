package com.tea.ui;

import android.app.Application;

import com.tea.communication.http.RequestManager;

public class GuideApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		init();
	}

	private void init() {
		RequestManager.init(this);
	}

}
