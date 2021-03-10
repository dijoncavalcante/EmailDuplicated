package com.dijon.emailduplicated;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class RecebendoListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebendo_lista);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        LinkedList a = (LinkedList) bundle.getSerializable("email_list_bundle");
    }
}