package com.marakana;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.omadm.IOmadmManager;

/**
 * This class exposes the remote service to the client
 */
public class AdditionService extends Service {
  private static final String TAG = "AdditionService";
  
  @Override
  public void onCreate() {
    super.onCreate();
    Log.d(TAG, "onCreate()");
  }
  
  @Override
  public IBinder onBind(Intent intent) {
      return new OmadmService(getApplicationContext());
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "onDestroy()");
  }
}
