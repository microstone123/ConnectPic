package com.tea.db;

import java.io.File;

import android.content.Context;
import android.util.Log;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.DbUtils.DbUpgradeListener;
import com.tea.utils.FileUtils;

public class DbHelper {
	public final static boolean IS_TEST = false;
	private final static int DB_VERSION = 3;
	private final static String DB_NAME = "exploration.db";

	public static DbUtils createDb(Context context) {
		DbUtils db = null;
		if (IS_TEST) {
			String dbPath = FileUtils.getRootPathById(context, "db");
			checkPath(dbPath);
			db = DbUtils.create(context, dbPath, DB_NAME, DB_VERSION, null);
		} else {
			db = DbUtils.create(context, DB_NAME, DB_VERSION, updateListener);
		}
		return db;
	}

	private static void checkPath(String dbPath) {
		File dir = new File(dbPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
	}

	private static DbUpgradeListener updateListener = new DbUpgradeListener() {

		@Override
		public void onUpgrade(DbUtils db, int oldVersion, int newVersion) {
			Log.i("", "dbVersion:" + oldVersion + " new:" + newVersion);
			if (newVersion > oldVersion) {
			}

		}
	};
}
