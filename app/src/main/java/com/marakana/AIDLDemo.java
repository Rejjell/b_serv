package com.marakana;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.omadm.IOmadmManager;

public class AIDLDemo extends Activity {
  private static final String TAG = "AIDLDemo";
    IOmadmManager service;
  AdditionServiceConnection connection;

  /**
   * This class represents the actual service connection. It casts the bound
   * stub implementation of the service to the AIDL interface.
   */
  class AdditionServiceConnection implements ServiceConnection {

    public void onServiceConnected(ComponentName name, IBinder boundService) {
      service = IOmadmManager.Stub.asInterface((IBinder) boundService);
      Log.d(AIDLDemo.TAG, "onServiceConnected() connected");
      Toast.makeText(AIDLDemo.this, "Service connected", Toast.LENGTH_LONG)
          .show();
    }

    public void onServiceDisconnected(ComponentName name) {
      service = null;
      Log.d(AIDLDemo.TAG, "onServiceDisconnected() disconnected");
      Toast.makeText(AIDLDemo.this, "Service connected", Toast.LENGTH_LONG)
          .show();
    }
  }

  /** Binds this activity to the service. */
  private void initService() {
    connection = new AdditionServiceConnection();
    Intent i = new Intent();
    i.setClassName("com.marakana", com.marakana.AdditionService.class.getName());
    boolean ret = bindService(i, connection, Context.BIND_AUTO_CREATE);
    Log.d(TAG, "initService() bound with " + ret);
  }

  /** Unbinds this activity from the service. */
  private void releaseService() {
    unbindService(connection);
    connection = null;
    Log.d(TAG, "releaseService() unbound.");
  }

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    initService();

    // Setup the UI
    Button buttonCalc = (Button) findViewById(R.id.buttonCalc);

    buttonCalc.setOnClickListener(new OnClickListener() {
      TextView result = (TextView) findViewById(R.id.result);
      EditText value1 = (EditText) findViewById(R.id.value1);
      EditText value2 = (EditText) findViewById(R.id.value2);

      public void onClick(View v) {
        String v1, v2, res = "";
        v1 = value1.getText().toString();
        v2 = value2.getText().toString();

        try {
            res = service.concat(v1, v2);
            res = service.getDeviceId();
        } catch (RemoteException e) {
          Log.d(AIDLDemo.TAG, "onClick failed with: " + e);
          e.printStackTrace();
        }
        result.setText(res);
      }
    });
  }

  /** Called when the activity is about to be destroyed. */
  @Override
  protected void onDestroy() {
    super.onDestroy();
    releaseService();
  }
}