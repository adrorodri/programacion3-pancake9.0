package com.example.andres.mundial.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.andres.mundial.R;

public class TablaPartidosActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla_partidos);
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
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
