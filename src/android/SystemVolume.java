package com.sakthi.systemvolume;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.media.AudioManager;
import android.os.Vibrator;

public class SystemVolume extends CordovaPlugin {
	AudioManager am;
	public SystemVolume(){
		am = (AudioManager) this.cordova.getActivity().getSystemService(Context.AUDIO_SERVICE);
	}

	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if(action.equals("setSystemVolume")) {
			this.setSystemVolume(args.getDouble(0));
		} 
		else if(action.equals("setNormalVolume")) {
			this.setNormalVolume(args.getDouble(0));
		}
		else {
			return false;
		}

		callbackContext.success();
		return true;
	}

	public void setSystemVolume(double volume) {
		am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
		
	}
	public void setNormalVolume(double volume)
	{
		
		am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
	}
}