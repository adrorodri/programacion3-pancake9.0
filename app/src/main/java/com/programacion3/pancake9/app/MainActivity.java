package com.programacion3.pancake9.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickbuttonL(View view ){
        Intent     i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
    }
}
