package com.tea.communication.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tea.utils.DateUtils;
import com.tea.utils.FileUtils;

public class HttpCommt {

	private Context mContext;

	public HttpCommt(Context mContext) {
		super();
		this.mContext = mContext;
	}

	public String getPic(String imageUrl) {
		Bitmap bitmap = null;
		String str = null;
		// httpGet连接对象

		HttpGet httpRequest = new HttpGet(imageUrl);
		// 取得HttpClient 对象
		HttpClient httpclient = new DefaultHttpClient();
		try {
			// 请求httpClient ，取得HttpRestponse
			HttpResponse httpResponse = httpclient.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 取得相关信息 取得HttpEntiy
				HttpEntity httpEntity = httpResponse.getEntity();
				// 获得一个输入流
				InputStream is = httpEntity.getContent();
				bitmap = BitmapFactory.decodeStream(is);
				is.close();
				str = saveBitmap(DateUtils.getSysDate(DateUtils.TIME_DEF)+".png", bitmap);
			}

		} catch (Exception e) {
			str = "iinnn";
			bitmap = null;
			e.printStackTrace();
		}
		return str;
	}

	/** 保存方法 */
	public String saveBitmap(String name, Bitmap bm) {
		String str = null;
		File f = new File(FileUtils.getRootPath(mContext, "img"), name);
		if (f.exists()) {
			f.delete();
		}
		String dirPath = f.getPath();
		try {
			FileOutputStream out = new FileOutputStream(f);
			bm.compress(Bitmap.CompressFormat.PNG, 90, out);
			out.flush();
			out.close();
			str = dirPath;
		} catch (Exception e) {
			e.printStackTrace();
			str = "nnn";
		}
		return str;
	}

}
