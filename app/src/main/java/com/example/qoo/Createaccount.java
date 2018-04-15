package com.example.qoo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Createaccount extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    private String userUID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
        Button btn1 = (Button) findViewById(R.id.btn1);
        auth = FirebaseAuth.getInstance();
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d("onAuthStateChanged", "登入:" + user.getUid());
                    userUID = user.getUid();
                }
                else {
                    Log.d("onAuthStateChanged", "已登出");
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        auth.removeAuthStateListener(authListener);
    }

    public void login(View v) {
        final String email = ((EditText) findViewById(R.id.edEmail)).getText().toString();
        final String password = ((EditText) findViewById(R.id.edPassword)).getText().toString();
        Log.d("AUTH", email + "/" + password);
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Log.d("onComplete", "登入失敗");
                            register(email, password);
                        }
                    }
                });
    }
    private void register(final String email,final  String password) {
        AlertDialog.Builder AD = new AlertDialog.Builder(Createaccount.this);
        AD.setTitle("登入問題");
        AD.setMessage("無此帳號,是否要以此帳號與密碼註冊?");
        AD.setPositiveButton("註冊", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                createUser(email, password);
            }
        });
        AD.setNeutralButton("取消",null);
        AD.show();
    }

    private void createUser(String email,String password) {
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                String message = task.isComplete() ? "註冊成功":"註冊失敗";
                                new AlertDialog.Builder(Createaccount.this)
                                        .setMessage(message)
                                        .setPositiveButton("OK",null)
                                        .show();
                            }
                        });
    }

}
