package com.example.qoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

        Button btn2;
        Button btn3;
        Button btn4;
        Button btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
    }

    public void gotoLoginAccount(View v){
        startActivity(new Intent(this, LoginAccount.class));
    }
    public void gotoChangeFourtune(View v){
        startActivity(new Intent(this, ChangeFourtune.class));
    }
    public void gotoSearchActivity(View v) {
        startActivity(new Intent(this, SearchActivity.class));
    }
}
