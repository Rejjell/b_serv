/*
 * Copyright (C) 2011 The Android Open Source Project
 * Copyright (C) 2016 Verizon
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions an
 * limitations under the License.
 */

package com.marakana;

import android.content.Context;
import android.omadm.IOmadmManager;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.os.Binder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import java.lang.IllegalStateException;
import android.os.Build;
import java.util.Locale;

/* OMADM System Service. Helper service for OMADM Client */

public class OmadmService extends IOmadmManager.Stub {

    //Creation
    //omadm_service = new OmadmService(context);
    //ServiceManager.addService(Context.OMADM_SERVICE, omadm_service);

    private final static String TAG = "OmadmService";
    private final Context mContext;

    public OmadmService(Context context) {
        mContext = context;
    }

    /**
     * This method returns device IMEI.
     * Requires OMADMACCESS or system permission.
     * @param none
     * @return device IMEI
     */
    @Override
    public String getDeviceId() throws RemoteException {
        //mContext.enforcePermission(android.Manifest.permission.OMADMACCESS,
        //Binder.getCallingPid(), Binder.getCallingUid(), "Permission Denied");

        TelephonyManager manager = (TelephonyManager)mContext.getSystemService(Context.TELEPHONY_SERVICE);
        String str = manager.getDeviceId();

        if(str != null) {
            return str;
        } else {
            Log.w(TAG, "TelephonyManager is not ready");
            throw new IllegalStateException("TelephonyManager is not ready");
        }
    }

    /**
     * This method turns WiFi On and Off.
     * Requires OMADMACCESS or system permission.
     * @param enable or disable WiFi
     * @return execution status: true on success
     */
    @Override
    public boolean setWifiEnabled(boolean enable) throws RemoteException {
        //mContext.enforcePermission(android.Manifest.permission.OMADMACCESS,
        //Binder.getCallingPid(), Binder.getCallingUid(), "Permission Denied");

        WifiManager manager = (WifiManager)mContext.getSystemService(Context.WIFI_SERVICE);
        return manager.setWifiEnabled(enable);
    }

    /**
     * This method sends user notification.
     * Requires OMADMACCESS or system permission.
     * @param notification title
     * @param notification body
     * @return execution status: true on success
     */
    @Override
    public boolean sendNotification(String title, String message) throws RemoteException {
        //mContext.enforcePermission(android.Manifest.permission.OMADMACCESS,
        //Binder.getCallingPid(), Binder.getCallingUid(), "Permission Denied");

        buildNotification(title, message, true);
        return true;
    }

    /**
     * Add your methods here
     */

    public String pal_system_dev_id_get() {
        TelephonyManager manager = (TelephonyManager) (TelephonyManager)mContext.getSystemService(Context.TELEPHONY_SERVICE);
        String str = manager.getDeviceId();
        if (str != null) {
            return str;
        } else {
            Log.w(TAG, "TelephonyManager is not ready");
            throw new IllegalStateException("TelephonyManager is not ready");
        }
    }

    public String pal_system_man_get() {
        return Build.MANUFACTURER;
    }

    public String pal_system_mod_get() {
        return Build.MODEL;
    }
    public String pal_system_lang_get() {
        return Locale.getDefault().toString();
    }

    public String pal_system_ext_get() {
        return "./DevInfo/Ext/ConfigurationVer";
    }

    public double pal_system_dmv_get() {
        Log.d("test", "Service wants to return 1.2");
        return 1.2;
    }

    @Override
    public String concat(String v1, String v2) throws RemoteException {
        return null;
    }

    public int pal_test_get_int() {
        Log.d("Test", "Server wants to return 9");
        return 9;
    }

    /**
     * Builds a simple notification.
     * TODO:
     * Example only. Please modify for your own needs.
     */
    private void buildNotification(String title, String content, boolean dissmis) {
        Notification.Builder builder = new Notification.Builder(mContext)
                .setContentTitle(title)
                .setContentText(content);

        ((NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE))
                .notify(2, builder.build());
    }

}
