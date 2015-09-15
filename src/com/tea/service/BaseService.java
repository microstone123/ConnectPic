package com.tea.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BaseService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}



	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}
	
	
}
