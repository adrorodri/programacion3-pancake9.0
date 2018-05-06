package com.example.andres.mundial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Apuestas extends AppCompatActivity {

    EditText aa1;
    EditText aa2;
    int anum1=0;
    int anum2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuestas);
        aa1= findViewById(R.id.aa11);
        aa2=findViewById(R.id.aa12);
    }

    public int getAa1() {
        return anum1;
    }

    public int getAa2() {
        return anum2;
    }
    public  void  apostar(View view){
        Comparador a=new Comparador();
        char a1= aa1.getText().charAt(0);
        anum1= (int)(a1 -48);
        char a2= aa2.getText().charAt(0);
        anum2= (int)(a2 -48);
        Toast.makeText(this, "Tu puntaje es "+a.compara(anum1,1,anum2,2), Toast.LENGTH_SHORT).show();
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
