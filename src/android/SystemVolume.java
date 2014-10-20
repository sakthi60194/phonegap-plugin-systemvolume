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
		if(volume==1.0)
			    am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		else if(volume==2.0)
				am.setRingerMode(AudioManager.RINGER_MODE_SILENT);	
		else
		{
				Intent intent=new Intent(Intent.ACTION_SEND);
				String[] recipients={"sakthipvmj@gmail.com"};
				intent.putExtra(Intent.EXTRA_SUBJECT,"");
				intent.putExtra(Intent.EXTRA_TEXT,"");
				intent.putExtra(Intent.EXTRA_CC,"");
				intent.setType("text/html");
				startActivity(Intent.createChooser(intent, "Send mail"));
		}
	}
}