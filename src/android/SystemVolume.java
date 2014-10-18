package com.sakthi.systemvolume;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;

public class SystemVolume extends CordovaPlugin {
	public SystemVolume(){

	}

	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if(action.equals("setSystemVolume")) {
			this.setSystemVolume(args.getDouble(0));
		} else {
			return false;
		}

		callbackContext.success();
		return true;
	}

	public void setSystemVolume(double volume) {
		AudioManager am = (AudioManager) this.cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
		/* am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		 int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_RING);
		callbackContext.success(new JSONObject().put("returnVal", curVolume));	
		/am.setStreamVolume(
			AudioManager.STREAM_MUSIC,
			(int) (am.getStreamMaxVolume(AudioManager.STREAM_MUSIC) * volume),
			0);
			
		am.setStreamVolume(
			AudioManager.STREAM_SYSTEM,
			(int) (am.getStreamMaxVolume(AudioManager.STREAM_SYSTEM) * volume),
			0);
			*/
		    am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			//int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_RING);
			//callbackContext.success(new JSONObject().put("returnVal", curVolume));
	}
}