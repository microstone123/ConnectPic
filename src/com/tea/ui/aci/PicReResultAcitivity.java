package com.tea.ui.aci;

import android.os.Bundle;

import com.android.volley.toolbox.NetworkImageView;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.tea.R;
import com.tea.communication.http.RequestManager;

@ContentView(R.layout.pic_result)
public class PicReResultAcitivity extends BaseAcitivity {

	@ViewInject(R.id.pic)
	private NetworkImageView pic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void initView() {
		pic.setErrorImageResId(R.drawable.ic_launcher);
		pic.setDefaultImageResId(R.drawable.ic_launcher);
		pic.setImageUrl("http://www.oschina.net/img/logo_s2.png", RequestManager.getImageLoader());
	}

	@Override
	protected void getData() {
		// TODO Auto-generated method stub

	}

}
