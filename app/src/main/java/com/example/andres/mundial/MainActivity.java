package com.example.andres.mundial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
