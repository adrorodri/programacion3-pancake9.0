package com.example.andres.mundial.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andres.mundial.R;

public class ResultadosActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";
    TextView ra1;
    TextView ra2;
    int rnum1=0;
    int rnum2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        ra1 = findViewById(R.id.ra11);
        ra2 = findViewById(R.id.ra12);
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
