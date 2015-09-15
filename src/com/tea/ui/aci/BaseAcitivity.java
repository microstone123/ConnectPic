package com.tea.ui.aci;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.android.volley.Request;
import com.lidroid.xutils.ViewUtils;
import com.tea.communication.http.RequestManager;

public abstract class BaseAcitivity extends FragmentActivity {
	protected Object tag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this); // 注入view和事件
		initView();
	}

	protected void executeRequest(Object tag, Request<?> request) {
		RequestManager.addRequest(tag, request);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		RequestManager.cancelAll(tag);
	}

	protected abstract void initView();// 加载控件

	protected abstract void getData();// 加载数据
	
	public static class SimpleBaseActivity extends BaseAcitivity{

		@Override
		protected void initView() {
			
		}

		@Override
		protected void getData() {
			
		}
		
	}

}
