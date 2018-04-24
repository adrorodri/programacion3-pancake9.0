package com.example.andres.mundial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Posiciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posiciones);
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
