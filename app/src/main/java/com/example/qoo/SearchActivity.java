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

public class SearchActivity extends AppCompatActivity {
    Spinner search, search1;
    Button btn13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final Spinner search = (Spinner) findViewById(R.id.search);
        final Spinner search1 = (Spinner) findViewById(R.id.search1);
        final Button btn13 = (Button) findViewById(R.id.btn13);

        search.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] searchset = new String[0];
                if (position == 0) {
                    searchset = getResources().getStringArray((R.array.searchset1));
                    //txv2.setText(forms.getSelectedItem().toString() + "," + forms2.getSelectedItem().toString());
                }
                /* else if (position == 1) {
                    formset = getResources().getStringArray((R.array.form2set2));
                    //txv2.setText(forms.getSelectedItem().toString() + "," + forms2.getSelectedItem().toString());
                } else {
                    formset = getResources().getStringArray((R.array.form2set3));
                    //txv2.setText(forms.getSelectedItem().toString() + "," + forms2.getSelectedItem().toString());
                }*/
                ArrayAdapter search2Ad =
                        new ArrayAdapter<>(SearchActivity.this, android.R.layout.simple_spinner_item, searchset);
                search2Ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                search1.setAdapter(search2Ad);
                //txv2.setText((forms.getSelectedItem().toString() + "," + forms2.getSelectedItem().toString()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn13.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder AD = new AlertDialog.Builder(SearchActivity.this);
                AD.setTitle("您篩選的條件是:");
                AD.setCancelable(true);
                AD.setIcon(android.R.drawable.ic_menu_edit);
                AD.setMessage((search.getSelectedItem().toString() + "," + search1.getSelectedItem().toString()));
                AD.setPositiveButton("確定",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        if(which == DialogInterface.BUTTON_POSITIVE)
                            startActivity(new Intent(SearchActivity.this, Searchresult.class));
                    }});
                AD.show();
            }
        });
    }
}
