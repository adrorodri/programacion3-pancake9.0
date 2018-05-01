package com.example.andres.mundial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";
    EditText editTextUsername;
    EditText usuario;
    EditText password;
    String usuarioV;
    String passwordV;
    Button logIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        if(sharedPreferences.getBoolean(KEY_USERNAME,false)) {
            Intent i = new Intent(this, Usuario.class);
            startActivity(i);
        }
    }
    public void logClick(View view){
        usuario = findViewById(R.id.usuario);
        password = findViewById(R.id.password);
        usuarioV = String.valueOf(usuario.getText());
        passwordV = String.valueOf(password.getText());
        Intent i;
        if (password.getText().toString().isEmpty()) {
            password.setHint("Llene este campo");
            password.setHintTextColor(Integer.parseInt("red"));
        }
        if (usuario.getText().toString().isEmpty()) {
            usuario.setHint("llene este campo");

        }
        if (passwordV.equals("123") && usuarioV.equals("Pan")) {
            i = new Intent(this, Usuario.class);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(KEY_USERNAME, true);
            editor.apply();
            startActivity(i);
        } else {
            if(){
            Toast.makeText(this, "Usuario o cotraseña equivocado", Toast.LENGTH_SHORT).show();
        }}
    }
}
