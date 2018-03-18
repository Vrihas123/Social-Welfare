package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand;

import android.content.Context;
import android.content.Intent;

import com.ibm.mobilefirstplatform.clientsdk.android.push.api.MFPPush;
import com.ibm.mobilefirstplatform.clientsdk.android.push.api.MFPPushNotificationDismissHandler;
import com.ibm.mobilefirstplatform.clientsdk.android.push.api.MFPPushNotificationStatus;
import com.ibm.mobilefirstplatform.clientsdk.android.push.api.MFPPushNotificationStatusListener;

/**
 * Created by samveg on 18/3/18.
 */

public class NotificationHandler extends MFPPushNotificationDismissHandler {

    @Override
    public void onReceive(Context context, Intent intent) {
        MFPPush.getInstance().setNotificationStatusListener(new MFPPushNotificationStatusListener() {
            @Override
            public void onStatusChange(String messageId, MFPPushNotificationStatus status) {
                // Handle status change
            }
        });
        super.onReceive(context, intent);
    }
}
