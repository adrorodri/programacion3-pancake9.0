package com.example.andres.mundial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "SignUpActivity";
    EditText correo;
    String correoE;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private Button btnSignUp;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up); // TODO: Change ConstraintLayout to another Layout

        correo = findViewById(R.id.correoElectronico);
        password = findViewById(R.id.contrasenaA);
        btnSignUp = findViewById(R.id.singUpConfirm);
        initialize();
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp(correo.getText().toString(), password.getText().toString());
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
                   // Log.w(TAG,"onAuthStateChanged - signed out" + firebaseUser.getUid());
                }
            }
        };
    }

    // TODO: Optimize.. Can be a lot simpler
    boolean verificarCorre(String correo) {
        String correoCopia = "";
        int pos = correo.length() - 1;
        while (pos > -1 && correo.charAt(pos) != '@') {
            correoCopia = correo.charAt(pos) + correoCopia;
            pos--;
        }
        if ((correoCopia.equals("gmail.com") || correoCopia.equals("hotmail.com")) && (correo.charAt(0) != '@' &&
                (correo.length() - 9 != 0 || correo.charAt(0) != 'g') && (correo.length() - 11 != 0 || correo.charAt(0) != 'h')))

            return true;
        else
            return false;
    }

    public void click(View view) {

        correoE = String.valueOf(correo.getText());
        if (verificarCorre(correoE)) {
            Intent i;
            i = new Intent(this, Usuario.class);
            startActivity(i);
        } else
            Toast.makeText(this, "Escriba un correo valido", Toast.LENGTH_SHORT).show();
    }

    private void signUp(String email, String password){
        final Intent i = new Intent(this, Usuario.class);
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, "Creación de cuenta correcta", Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }else{
                    Toast.makeText(SignUpActivity.this, "Creación de cuenta incorrecta", Toast.LENGTH_SHORT).show();
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

