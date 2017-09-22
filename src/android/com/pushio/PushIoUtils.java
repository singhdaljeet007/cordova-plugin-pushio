package com.pushio;

import android.content.Context;
import android.util.Log;


import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import com.pushio.manager.PushIOManager;
import com.pushio.manager.preferences.PushIOPreference;
import com.BajajServiceApp.VikramUAT.NotificationBroadcastReceiver;


public class PushIoUtils extends CordovaPlugin {
  

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    //Log.d(TAG, "Initializing PushIoPlugin");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if (action.equals("register")) {
      try {
            PushIOManager pushIOManager = PushIOManager.getInstance(cordova.getActivity().getWindow().getContext());
             String userId;
      try {
        userId = args.getString(0);
      } catch (JSONException ex) {
        callbackContext.error("userId does not appear to be a valid String");
        return true;
      }
            pushIOManager.registerUserId(userId);
            pushIOManager.ensureRegistration();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    } else if(action.equals("init")){
          PushIOManager pushIOManager = PushIOManager.getInstance(cordova.getActivity().getWindow().getContext());
        try {
              String str = "";
              try {
              str = args.getString(0);
            } catch (JSONException ex) {
              callbackContext.error("userId does not appear to be a valid String");
              return true;
            }
              pushIOManager.declarePreference("IMEI_NUMBER", "NA", PushIOPreference.Type.STRING);
              if (str != null || str.length() > 0) {
                  pushIOManager.setPreference("IMEI_NUMBER", str);
              }
        } catch (Exception ex) {
            //Log.d("Push Io", "Preferences in not set " + ex.getMessage());
        }
    } else if(action.equals("getNotificationData")){
		final PluginResult result = new PluginResult(PluginResult.Status.OK, NotificationBroadcastReceiver.getPreference(cordova.getActivity().getWindow().getContext(), "NotificationData", ""));
        callbackContext.sendPluginResult(result);
	}
    return true;
  }

}