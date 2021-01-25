package com.komal.recycleviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextInputLayout TIUser,TIPass;
    EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TIUser=findViewById(R.id.txtinputUser);
        TIPass=findViewById(R.id.txtinputPass);

        user=findViewById(R.id.user);
        pass=findViewById(R.id.Pass);

    }
}