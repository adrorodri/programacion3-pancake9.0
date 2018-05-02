package com.example.andres.mundial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Usuario extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);

    }
    public void clickL(View view){
        setSharedPreferences();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
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
                intent = new Intent(this, Usuario.class);
                break;
            }
            case R.id.tablas:{
                intent = new Intent(this,Posiciones.class);
                break;
            }
            case R.id.partidos:{
                intent = new Intent(this, TablaPartidos.class);
                break;
            }
            case R.id.apuestas:{
                intent = new Intent(this, Apuestas.class);
                break;
            }
            case R.id.resultados:{
                intent = new Intent(this, Resultados.class);
                break;
            }
            default:{
                intent = new Intent(this, Usuario.class);
                break;
            }
        }
        startActivity(intent);
    }
}
