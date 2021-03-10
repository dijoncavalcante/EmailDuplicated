package com.dijon.emailduplicated;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class EmailService extends Service {
    static final String TAG = "EmailService";
    //LinkedList linkedList;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate() ");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        //linkedList = new LinkedList();
        //if (intent.getExtras()) {
        Bundle bundle = intent.getExtras();
        Log.d(TAG, "onStartCommand: " + bundle.toString());
        LinkedList linkedList = (LinkedList) bundle.getSerializable("email_list_bundle");


        linkedList = processEmailDuplicated(linkedList);

        Intent intentBroadcast = new Intent("ACTION_UPDATE_EMAIL_LIST");
        intentBroadcast.putExtra("ACTION", " -Answer Broadcast Rreceive -");
        intentBroadcast.putExtra("email_answer", linkedList);
        sendBroadcast(intentBroadcast);
        Log.d(TAG, "onStartCommand() intentBroadcast ACTION_UPDATE_EMAIL_LIST");

        //stopSelf();
//        } else {
//            Log.d(TAG, "onStartCommand() intent.hasExtra(email_list_bundle) is null");
//        }
        return START_NOT_STICKY;
    }

    //LinkedList -> first[Node] | last [Node]
// -> Node[Person, next[Node]
// -> Person[email]]
    public LinkedList processEmailDuplicated(LinkedList list) {
        Log.d(TAG, "processEmailDuplicated");

        if ((list != null) && (list.getQuantity() > 0)) {
            Log.d(TAG, "list.getQuantity(): " + list.getQuantity());
            Node currentNode = list.getFirst();
            Node nextNode = list.getLast();
            int count = 0;

            while ((currentNode != null) && (currentNode.getPerson().getEmail().equals(nextNode.getPerson().getEmail()))) {
                count++;
                list.removeNo(nextNode.getPerson().getEmail());
            }

        } else {
            Log.d(TAG, "list is null");
        }

        return list;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy() ");
        super.onDestroy();
    }
}
