package com.tea.notification;

import java.io.File;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.tea.R;

public class NotificationComm {

	private Context mContent;
	private NotificationManager nm;

	public NotificationComm(Context content) {
		this.mContent = content;
		nm = (NotificationManager) mContent.getSystemService(Context.NOTIFICATION_SERVICE);
	}

	@SuppressLint("InlinedApi")
	public void showNotification(int icon, String title, String content,String picPath) {
		// 构造通知，目前已经将直接使用构造方法的方式淘汰了
		NotificationCompat.Builder builder = new NotificationCompat.Builder(mContent);
		builder.setContentTitle(content);
		builder.setAutoCancel(true);
		builder.setSmallIcon(R.drawable.ic_launcher);
		
		Intent notifyIntent = new Intent(Intent.ACTION_VIEW);
		File filePic = new File(picPath);
		notifyIntent.setDataAndType(Uri.fromFile(filePic), "image/*");
		
		// Sets the Activity to start in a new, empty task
		notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		// Creates the PendingIntent
		PendingIntent contentIntent = PendingIntent.getActivity(mContent, 0, notifyIntent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		// Puts the PendingIntent into the notification builder
		builder.setContentIntent(contentIntent);

		// 最后完成通知发送
		NotificationManager mNotificationManager = (NotificationManager) mContent
				.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(1, builder.build());
	}

	public void showNotification(String tickertext, String title, String content) {

	}

	public PendingIntent getDefalutIntent(int flags) {
		PendingIntent pendingIntent = PendingIntent.getActivity(mContent, 1, new Intent(Intent.ACTION_PICK,
				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), flags);
		return pendingIntent;
	}
}
