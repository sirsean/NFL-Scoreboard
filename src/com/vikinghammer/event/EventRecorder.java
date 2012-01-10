package com.vikinghammer.event;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;

public class EventRecorder {
	
	private static String API_ENDPOINT = "http://10.0.2.2:4567/event/";

	public static void record(Context context, String eventName) {
		record(context, eventName, "");
	}
	
	public static void record(Context context, String eventName, String detail) {
		ApplicationInfo applicationInfo = context.getApplicationInfo();
		Log.i("Event", String.format("App: %s, User: %s, Class: %s, Event: %s, Detail: %s", 
				applicationInfo.packageName, Installation.id(context), context.getClass().getName(), eventName, detail));
//		send(new Date(), applicationInfo.packageName, Installation.id(context), context.getClass().getName(), eventName, detail);
	}
	
//	private static void send(Date time, String appId, String userId, String activityName, String eventName, String detail) {
//		final List<NameValuePair> params = Arrays.asList(new NameValuePair[] { 
//				new BasicNameValuePair("time", Long.toString(time.getTime())),
//				new BasicNameValuePair("appId", appId),
//				new BasicNameValuePair("userId", userId),
//				new BasicNameValuePair("activity", activityName),
//				new BasicNameValuePair("eventName", eventName),
//				new BasicNameValuePair("detail", detail)
//		});
//		Thread thread = new Thread(new Runnable() {
//			public void run() {
//				HttpClient httpClient = new DefaultHttpClient();
//				HttpPost httpPost = new HttpPost(API_ENDPOINT);
//				
//				try {
//					httpPost.setEntity(new UrlEncodedFormEntity(params));
//					
//					httpClient.execute(httpPost);
//					Log.i("AddCredentialsReceiver", "Saved to server");
//				} catch (Exception e) {
//					Log.e("AddCredentialsReceiver", e.getMessage());
//				}
//			}
//		});
//		thread.start();
//	}
	
}
