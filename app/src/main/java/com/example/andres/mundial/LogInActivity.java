package com.example.andres.mundial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    EditText usuario;
    EditText password;
    String usuarioV;
    String passwordV;
    Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in); // TODO: Change ConstraintLayout to another Layout
    }

    public void logClick(View view){

        // TODO: Move findViewByIds to onCreate
        usuario = findViewById(R.id.usuario);
        password = findViewById(R.id.password);
        usuarioV = String.valueOf(usuario.getText());
        passwordV = String.valueOf(password.getText());
        Intent i;
        if (passwordV.equals("123") && usuarioV.equals("Pan")) {
            i = new Intent(this, Usuario.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Usuario o cotraseña equivocado", Toast.LENGTH_SHORT).show();
        }



    }


}
