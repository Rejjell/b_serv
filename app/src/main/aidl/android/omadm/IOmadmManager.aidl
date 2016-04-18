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
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.omadm;

/** @hide */
interface IOmadmManager {
    String getDeviceId();
    boolean setWifiEnabled(boolean enable);
    boolean sendNotification(String title, String message);
    String pal_system_dev_id_get();
    int pal_test_get_int();
    double pal_system_dmv_get();
    String concat(String v1, String v2);
}

