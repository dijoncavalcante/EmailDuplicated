package com.dijon.emailduplicated;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

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
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        //register my broadcastReceiver
        registerReceiver(emailBroadcastReceiver, new IntentFilter("ACTION_UPDATE_EMAIL_LIST"));

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "btnStart onClick()");

                Intent intent = new Intent("SERVICE_EMAIL");
                intent.setPackage("com.dijon.serviceremoveduplicateditens");
                startService(intent);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "btnStop onClick()");
                Intent intent = new Intent("SERVICE_EMAIL");
                intent.setPackage("com.dijon.serviceremoveduplicateditens");
                stopService(intent);
            }
        });
    }

    private BroadcastReceiver emailBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "emailBroadcastReceiver onReceive()");
            int count = new Random().nextInt();
            String message = intent.getAction();
             message = message + intent.getStringExtra("ACTION");
            Toast.makeText(MainActivity.this, message +" - "+ count, Toast.LENGTH_SHORT).show();
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