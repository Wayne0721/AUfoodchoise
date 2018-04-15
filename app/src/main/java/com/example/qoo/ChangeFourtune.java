package com.example.qoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChangeFourtune extends AppCompatActivity {

    Button btn8;
    Button btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_fourtune);

        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
    }

    public void gotoFourtunemyself(View v){
        startActivity(new Intent(this, Fourtunemyself.class));
    }
    public void gotoFourtunetogether(View v){
        startActivity(new Intent(this, Fourtunetogether.class));
    }
}
