package com.example.andres.mundial.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.andres.mundial.R;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UsuarioActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";
    private TextView nombreUsuario;
    private TextView puntaje;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser firebaseUser;
    private String userName="";
    private String puntajeUser= "0";
    private DatabaseReference databaseReference;
    private List<String> listUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        nombreUsuario = findViewById(R.id.nombreDeUsuario);
        puntaje = findViewById(R.id.puntajeUser);
        initialize();
        firebaseUser = firebaseAuth.getCurrentUser();
        String usuario = firebaseUser.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
//        databaseReference.child("Usuario").child(usuario).child("nombre").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//               String userNameB = dataSnapshot.getValue(String.class);
//               listUser.add(0,userNameB);
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        databaseReference.child("Usuario").child(usuario).child("puntaje").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//               String puntajeUserB = dataSnapshot.getValue(String.class);
//                listUser.add(1,puntajeUserB);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        userName = listUser.get(0);
//        puntajeUser = listUser.get(1);
        nombreUsuario.setText(userName);
        puntaje.setText(puntajeUser.toString());

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
