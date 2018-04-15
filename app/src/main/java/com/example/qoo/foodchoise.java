package com.example.qoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class foodchoise extends AppCompatActivity {
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodchoise);

        btn1 = (Button) findViewById(R.id.btn1);
    }

    public void gotoMemu(View v){
        Intent it = new Intent(this, Menu.class);
        startActivity(it);
    }
}
