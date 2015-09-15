package com.tea.ui.aci;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.tea.R;
import com.tea.communication.http.HttpCommt;
import com.tea.notification.NotificationComm;
import com.tea.utils.ToastUtil;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseAcitivity {

	private NotificationComm notificationManager;
	private HttpCommt httpCommt;

	private DownLoad mDownLoad;
	Bitmap bitmap;
	@ViewInject(R.id.add_bar)
	private ProgressBar add_bar;
	@ViewInject(R.id.add_pic)
	private Button add_pic;

	@ViewInject(R.id.img)
	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		notificationManager = new NotificationComm(this);
		httpCommt = new HttpCommt(this);
		mDownLoad = new DownLoad();
	}

	@Override
	protected void getData() {

	}

	@OnClick(R.id.add_pic)
	public void getNoticifition(View v) {
		// httpCommt.getPic(imageUrl, path);
		mDownLoad.execute("http://pic.desk.chinaz.com/file/10.11.10/7/jillxs40.jpg");
	}

	@Override
	protected void initView() {

	}

	private class DownLoad extends AsyncTask<String, Integer, String> {
		// onPreExecute方法在execute()后执行
		@Override
		protected void onPreExecute() {
			add_bar.setVisibility(View.VISIBLE);
			add_pic.setVisibility(View.GONE);
		}

		// doInBackground方法内部执行后台任务,不能在里面更新UI，否则有异常。
		@Override
		protected String doInBackground(String... params) {
			return httpCommt.getPic("http://www.oschina.net/img/logo_s2.png");
//			return null;
		}

		// onProgressUpdate方法用于更新进度信息
		@Override
		protected void onProgressUpdate(Integer... progresses) {
			// mShowLogTextView.setText("onProgressUpdate Downloading...");
		}

		// onPostExecute用于doInBackground执行完后，更新界面UI。
		// result是doInBackground返回的结果
		@Override
		protected void onPostExecute(String result) {
			add_bar.setVisibility(View.GONE);
			if (result != null) {
//				img.setImageBitmap(bitmap);
				ToastUtil.show(MainActivity.this, "图片已下载    "+result);
				notificationManager.showNotification(0, "图片已下载", "图片已下载", result);
			} else {
				ToastUtil.show(MainActivity.this, "图片下载失败"+result);
				notificationManager.showNotification(0, "图片下载失败", "图片下载失败", result);
			}
		}

		// onCancelled方法用于取消Task执行，更新UI
		@Override
		protected void onCancelled() {
		}
	}

}