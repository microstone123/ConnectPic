package com.tea.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author linhs
 * @date: 2015年9月6日 下午5:36:36
 * @Description: TODO(SharedPreferences工具类)
 */
public class SharedPreferencesHelper {
	SharedPreferences sp;
	SharedPreferences.Editor editor;

	Context context;

	@SuppressLint("CommitPrefEdits")
	public SharedPreferencesHelper(Context c, String name) {
		context = c;
		sp = context.getSharedPreferences(name, 0);
		editor = sp.edit();
	}

	public void putIntValue(String key, int value) {
		editor = sp.edit();
		editor.putInt(key, value);
		editor.commit();
		// Common.month_total = value;
	}

	public void putStrValue(String key, String value) {
		editor = sp.edit();
		// editor.remove(key);
		editor.putString(key, value);
		editor.commit();
	}

	public void removeKey(String key) {
		editor.clear();
		editor.commit();
	}

	public String getValue(String key) {
		return getDefValue(key, "");
	}

	public String getDefValue(String key, String defValue) {
		if ((defValue == null) || (defValue.length() == 0)) {
			return sp.getString(key, "");
		} else {
			return sp.getString(key, defValue);
		}
	}

	public boolean getBooleanValue(String key, boolean defValue) {
		return sp.getBoolean(key, defValue);
	}

	public void putUserValue(String nameKey, String nameValue, String passWKey, String passWValue) {
		editor = sp.edit();
		editor.putString(nameKey, nameValue);
		editor.putString(passWKey, passWValue);
		editor.commit();
	}
}
