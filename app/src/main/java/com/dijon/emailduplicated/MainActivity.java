package com.dijon.emailduplicated;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/***
 * /*
 * Escreva dois aplicativos Android,
 * no primeiro,
 * você deve criar um serviço(sem atividades) que recebem solicitações de outros aplicativos com um tópico de e-mail (como
 * uma lista vinculada, não use nenhuma lista fornecida por Java ou Kotlin que você deveria
 * crie sua própria lista vinculada),
 *
 * escreva uma função que remova itens duplicados e
 * retornar um tópico de e-mail limpo.
 *
 * No segundo,
 * você deve criar uma atividade para mostrar um tópico de e-mail com itens duplicados
 * e chamar o primeiro aplicativo para limpa-lo
 * e atualize a atividade com o thread de email retornado do serviço.
 *  */
//APP 2
public class MainActivity extends AppCompatActivity {
    static final String TAG = "MainActivity";
    static final String ACTION_SERVICE_EMAIL = "SERVICE_EMAIL";
    static final String PACKAGE_SERVICE_EMAIL = "com.dijon.serviceremoveduplicateditens";
    static final String ACTION_UPDATE_EMAIL_LIST = "ACTION_UPDATE_EMAIL_LIST";
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        //register my broadcastReceiver
        registerReceiver(emailBroadcastReceiver, new IntentFilter(ACTION_UPDATE_EMAIL_LIST));
        Log.d(TAG, "register my broadcastReceiver ACTION_UPDATE_EMAIL_LIST");

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "btnStart onClick()");

                Intent intent = new Intent("SERVICE_EMAIL_TEST");
                intent.setPackage("com.dijon.serviceemailupdate");

                try {
                    getApplicationContext().startService(intent);
                    Log.d(TAG, "btnStart onClick() getApplicationContext().startService(intent)");
                } catch (Exception e) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        getApplicationContext().startForegroundService(intent);
                        Log.d(TAG, "btnStart onClick() startForegroundService(intent)");
                    } else {
                        startService(intent);
                        Log.d(TAG, "btnStart onClick() startService(intent);");
                    }
                }

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "btnStop onClick()");
            }
        });
    }

    private BroadcastReceiver emailBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "emailBroadcastReceiver onReceive()");

            String message = intent.getAction();
            message = message + intent.getStringExtra("ACTION");
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

            Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            long milliseconds = 2000;
            vibrator.vibrate(milliseconds);

            Intent in = new Intent("SERVICE_EMAIL_TEST");
            in.setPackage("com.dijon.serviceemailupdate");
            stopService(in);

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(emailBroadcastReceiver);
        Log.d(TAG, "onDestroy() - unregisterReceiver");
    }
}