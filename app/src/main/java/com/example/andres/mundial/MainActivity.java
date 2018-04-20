package com.example.andres.mundial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click(View view){
        Intent i;

        switch (view.getId()){
            case R.id.logIn:{
                i = new Intent(this, LogInActivity.class);
                break;
            }
            case R.id.signUp:{
                i = new Intent(this, SignUpActivity.class);
                break;
            }
            default:{
                i=new Intent(this,LogInActivity.class);

            }
        }
        startActivity(i);

    }
}
