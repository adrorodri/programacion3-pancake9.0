package com.example.andres.mundial.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.andres.mundial.R;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ApuestasActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";
    EditText [][]apostar = new EditText[2][6];
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuestas);
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        initialize();
        firebaseUser.getUid();
        apostar[0][0] = findViewById(R.id.al1);
        apostar[1][0] = findViewById(R.id.av1);
        apostar[0][1] = findViewById(R.id.al2);
        apostar[1][1] = findViewById(R.id.av2);
        apostar[0][2] = findViewById(R.id.al3);
        apostar[1][2] = findViewById(R.id.av3);
        apostar[0][3] = findViewById(R.id.al4);
        apostar[1][3] = findViewById(R.id.av4);
        apostar[0][4] = findViewById(R.id.al5);
        apostar[1][4] = findViewById(R.id.av5);
        apostar[0][5] = findViewById(R.id.al6);
        apostar[1][5] = findViewById(R.id.av6);
    }
    public void initialize() {
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                firebaseUser = firebaseAuth.getCurrentUser();
            }
        };
    }


    public void apostar(View view) {
        Comparador a = new Comparador();
        if (grupoAVacio()) {
            Toast.makeText(this, "Llene el grupo A", Toast.LENGTH_SHORT).show();
        } else {
            int[][] apuestasn = new int[2][6];
            for (int i = 0; i < 6; i++) {
                apuestasn[0][i] = (int) (apostar[0][i].getText().charAt(0) - 48);
                apuestasn[1][i] = (int) (apostar[1][i].getText().charAt(0) - 48);
            }

            for (int i = 0; i < 6; i++) {
                a.compara(apuestasn[0][i], 2, apuestasn[1][i], 1);
            }
            bloquearGrupoA();
            Toast.makeText(this, "Tu puntaje es " + a.getContador(), Toast.LENGTH_SHORT).show();
        }
    }

    public void bloquearGrupoA() {
        for (int i = 0; i < 6; i++) {
            apostar[0][i].setEnabled(false);
            apostar[1][i].setEnabled(false);
        }
    }

    public boolean grupoAVacio() {
        for (int i = 0; i < 6; i++) {
            if(apostar[0][i].getText().toString().isEmpty() || apostar[1][i].getText().toString().isEmpty())
                return true;
        }
        return false;
    }

    public void setSharedPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_USERNAME, false);
        editor.apply();
    }
    public void clickDraw(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.perfil:{
                intent = new Intent(this, UsuarioActivity.class);
                break;
            }
            case R.id.tablas:{
                intent = new Intent(this,PosicionesActivity.class);
                break;
            }
            case R.id.partidos:{
                intent = new Intent(this, TablaPartidosActivity.class);
                break;
            }
            case R.id.apuestas:{
                intent = new Intent(this, ApuestasActivity.class);
                break;
            }
            case R.id.resultados:{
                intent = new Intent(this, ResultadosActivity.class);
                break;
            }
            case R.id.logout:{
                setSharedPreferences();
                intent = new Intent(this, MainActivity.class);
                break;
            }
            default:{
                intent = new Intent(this, UsuarioActivity.class);
                break;
            }
        }
        startActivity(intent);
    }
}
