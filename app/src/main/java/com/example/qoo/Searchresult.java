package com.example.qoo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Searchresult extends AppCompatActivity {
    private ArrayList<Data> database = new ArrayList<>();
    RecyclerView recyclerView;
    private dataAdapter dAdapter;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);
        recyclerView = (RecyclerView) findViewById(R.id.rec);

        //RecyclerView.LayoutManager dLayoutmanager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        dataAdapter dAdapter = new dataAdapter(database);
        recyclerView.setAdapter(dAdapter);
        Firebase.setAndroidContext(this);
        DatabaseReference reference_contacts = FirebaseDatabase.getInstance().getReference("meanu1");
        reference_contacts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren() ){
                    Data data = ds.getValue(Data.class);
                    database.add(data);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        dAdapter.notifyDataSetChanged();
    }

}

