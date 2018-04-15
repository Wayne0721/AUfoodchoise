package com.example.qoo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class Fourtunemyself extends AppCompatActivity {
    Spinner forms, forms2;
    TextView txv, txv2;
    Button btn12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourtunemyself);

        TextView txv = (TextView) findViewById(R.id.txv);
        final TextView txv2 = (TextView) findViewById(R.id.txv2);
        final Spinner forms = (Spinner) findViewById(R.id.forms);
        final Spinner forms2 = (Spinner) findViewById(R.id.forms2);
        final Button btn12 = (Button) findViewById(R.id.btn12);

        forms.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] formset;
                if (position == 0) {
                    formset = getResources().getStringArray((R.array.form2set1));
                    //txv2.setText(forms.getSelectedItem().toString() + "," + forms2.getSelectedItem().toString());
                } else if (position == 1) {
                    formset = getResources().getStringArray((R.array.form2set2));
                    //txv2.setText(forms.getSelectedItem().toString() + "," + forms2.getSelectedItem().toString());
                } else {
                    formset = getResources().getStringArray((R.array.form2set3));
                    //txv2.setText(forms.getSelectedItem().toString() + "," + forms2.getSelectedItem().toString());
                }
                ArrayAdapter forms2Ad =
                        new ArrayAdapter<>(Fourtunemyself.this, android.R.layout.simple_spinner_item, formset);
                forms2Ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                forms2.setAdapter(forms2Ad);
                //txv2.setText((forms.getSelectedItem().toString() + "," + forms2.getSelectedItem().toString()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn12.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder AD = new AlertDialog.Builder(Fourtunemyself.this);
                        AD.setTitle("您篩選的條件是:");
                        AD.setCancelable(true);
                        AD.setIcon(android.R.drawable.ic_menu_edit);
                        AD.setMessage((forms.getSelectedItem().toString() + "," + forms2.getSelectedItem().toString()));
                        AD.setPositiveButton("確定",new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int which) {
                                        if(which == DialogInterface.BUTTON_POSITIVE)
                                            startActivity(new Intent(Fourtunemyself.this, Fourtunemyselfresult.class));
                                    }});
                                AD.show();
            }
        });

    }
}
