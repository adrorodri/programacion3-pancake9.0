package com.example.andres.mundial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {
    private static final String TAG = "LogInActivity";
    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";
    EditText editTextUsername;
    EditText usuario;
    EditText password;
    String usuarioV;
    String passwordV;
    Button btnLogIn;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        usuario = findViewById(R.id.usuario);
        password = findViewById(R.id.password);
        btnLogIn = findViewById(R.id.botLog);
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        if(sharedPreferences.getBoolean(KEY_USERNAME,false)) {
            Intent i = new Intent(this, Usuario.class);
            startActivity(i);
        }
        initialize();

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn(usuario.getText().toString(), password.getText().toString());
            }
        });
    }
    public void initialize() {
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    Log.w(TAG,"onAuthStateChanged - signed up" + firebaseUser.getUid() );
                    Log.w(TAG,"onAuthStateChanged - signed up" + firebaseUser.getEmail());
                }else{
                    //Log.w(TAG,"onAuthStateChanged - signed out" + firebaseUser.getUid());
                }
            }
        };
    }

    public void logClick(View view){

        usuarioV = String.valueOf(usuario.getText());
        passwordV = String.valueOf(password.getText());
        Intent i;
        if (password.getText().toString().isEmpty()) {
            password.setHint("Llene este campo");
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
            Toast.makeText(this, "Usuario o cotraseña equivocado", Toast.LENGTH_SHORT).show();
        }
    }

    private void logIn(String usuario, String password){
        final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        final Intent i = new Intent(this, Usuario.class);
        firebaseAuth.signInWithEmailAndPassword(usuario, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(LogInActivity.this, "Validación correcta", Toast.LENGTH_SHORT).show();
                    if(firebaseUser.isEmailVerified()){
                    startActivity(i);}

                }else{
                    Toast.makeText(LogInActivity.this, "Error en la validación", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(authStateListener);
    }




}
