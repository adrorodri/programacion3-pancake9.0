package com.example.andres.mundial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
                intent = new Intent(this, UsuarioActivity.class);
                break;
            }
            case R.id.resultados:{
                intent = new Intent(this, ResultadosActivity.class);
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
