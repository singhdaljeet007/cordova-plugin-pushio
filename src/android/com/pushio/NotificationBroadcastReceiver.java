package com.BajajServiceApp.VikramUAT;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.database.Cursor;
import org.json.JSONArray;
import org.json.JSONObject;
import android.widget.Toast;
/**
 * Created by aashish (a629249) on 14-09-2017.
 */

public class NotificationBroadcastReceiver extends BroadcastReceiver {
	public static SharedPreferences mAppPreferences;
	public static SharedPreferences.Editor mEditor;
  
    @Override
    public void onReceive(Context context, Intent intent) {
      
        if (intent != null) {
         try {
          System.out.println("Message received");
         // Toast.makeText(context,name,7).show();
          // JSONArray array;
          // JSONObject obj = new JSONObject();
          // obj.put("TimeStamp", intent.getLongExtra("google.sent_time",0));
          // obj.put("message", intent.getStringExtra("alert"));

          String messageId="";
          String title=intent.getStringExtra("alert").toString();
          String message=intent.getStringExtra("body").toString();
          //intent.getStringExtra("message").toString();
          Long tmp=intent.getLongExtra("google.sent_time",0);
          String timeStamp = tmp.toString();

          DBHelper dbHelper=new DBHelper(context);
          // Cursor res=dbHelper.getData(1);
          // res.moveToFirst();
          // String name = res.getString(res.getColumnIndex("customerName"));
          // Toast.makeText(context,name,7).show();

          if(dbHelper.insertNotification(messageId,title,message,timeStamp)){
              //insertion done
           }else{
             
           }
          // if (!"".equalsIgnoreCase(getPreference(context, "NotificationData", ""))) {
          //   array = new JSONArray(getPreference(context, "NotificationData", ""));
          // } else {
          //   array = new JSONArray();
          // }
          // array.put(obj);
          // addPreference(context, "NotificationData", array.toString());
        } catch (Exception e) {
          Log.d("class", "Not a string", e);
        }
      }
    }
	public static String addPreference(Context context, String pref_field,
                                     String pref_value) {
    mAppPreferences = PreferenceManager
      .getDefaultSharedPreferences(context);
    mEditor = mAppPreferences.edit();
    mEditor.putString(pref_field, pref_value);
    mEditor.commit();
    return mAppPreferences.getString(pref_field, null);
  }

  public static String getPreference(Context context, String pref_field,
                                     String def_value) {
    mAppPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    return mAppPreferences.getString(pref_field, def_value);
  }
}