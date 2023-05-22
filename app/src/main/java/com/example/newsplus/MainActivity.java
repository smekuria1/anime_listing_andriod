package com.example.newsplus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView googleBtn;
    EditText username;
    EditText password;
    Button login;
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        login = findViewById(R.id.loginbtn);
        username = findViewById(R.id.usernameEdit);
        password = findViewById(R.id.passwordEdit);
        progressDialog = new ProgressDialog(this);
        googleBtn = findViewById(R.id.googleButton);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });

    }

    public void performLogin() {

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if(user.isEmpty()){
            username.setError("Enter correct Email");
        } else if (pass.isEmpty()) {
            password.setError("Enter Correct Password");
        } else{
            progressDialog.setMessage("Logging In");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    } else if (task.getException().toString().contains("There is no user record")) {
                        progressDialog.setMessage("New User Detected....Registering");
                        progressDialog.setTitle("Register");
                        progressDialog.setCanceledOnTouchOutside(false);
                        progressDialog.show();

                        mAuth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    sendUserToNextActivity();
                                    Toast.makeText(MainActivity.this, "Registering  Successful Logging in", Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                }
                                else{
                                    progressDialog.dismiss();
                                    Toast.makeText(MainActivity.this,""+task.getException(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    } else{
                        progressDialog.dismiss();
                        Log.d("DEBUG", ""+task.getException().getMessage()+user+pass);
                        Toast.makeText(MainActivity.this,""+task.getException(), Toast.LENGTH_LONG).show();
                    }
                }
            });

        }

    }

    public void sendUserToNextActivity() {
        Intent intent = new Intent(MainActivity.this, Home.class);
        startActivity(intent);
    }
}