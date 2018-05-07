package com.example.andres.mundial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        setContentView(R.layout.activity_main);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

    public void click(View view) {
        Intent i;
        if (view.getId() == R.id.signUp)
            i = new Intent(this, SignUpActivity.class);
        else
            i = new Intent(this, LogInActivity.class);

        startActivity(i);
    }
}
