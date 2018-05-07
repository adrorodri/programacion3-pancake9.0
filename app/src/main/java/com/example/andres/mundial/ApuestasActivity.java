package com.example.andres.mundial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ApuestasActivity extends AppCompatActivity {

    EditText av1;
    EditText al1;
    EditText av2;
    EditText al2;
    EditText av3;
    EditText al3;
    EditText av4;
    EditText al4;
    EditText av5;
    EditText al5;
    EditText av6;
    EditText al6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apuestas);
        al1 = findViewById(R.id.al1);
        av1 = findViewById(R.id.av1);
        al2 = findViewById(R.id.al2);
        av2 = findViewById(R.id.av2);
        al3 = findViewById(R.id.al3);
        av3 = findViewById(R.id.av3);
        al4 = findViewById(R.id.al4);
        av4 = findViewById(R.id.av4);
        al5 = findViewById(R.id.al5);
        av5 = findViewById(R.id.av5);
        al6 = findViewById(R.id.al6);
        av6 = findViewById(R.id.av6);
    }


    public void apostar(View view) {
        Comparador a = new Comparador();
        if (grupoAVacio()) {
            Toast.makeText(this, "Llene el grupo A", Toast.LENGTH_SHORT).show();
        } else {
            char[][] apuestas = new char[2][6];
            apuestas[0][0] = av1.getText().charAt(0);
            apuestas[1][0] = al1.getText().charAt(0);
            apuestas[0][1] = av2.getText().charAt(0);
            apuestas[1][1] = al2.getText().charAt(0);
            apuestas[0][2] = av3.getText().charAt(0);
            apuestas[1][2] = al3.getText().charAt(0);
            apuestas[0][3] = av4.getText().charAt(0);
            apuestas[1][3] = al4.getText().charAt(0);
            apuestas[0][4] = av5.getText().charAt(0);
            apuestas[1][4] = al5.getText().charAt(0);
            apuestas[0][5] = av6.getText().charAt(0);
            apuestas[1][5] = al6.getText().charAt(0);

            int[][] apuestasn = new int[2][6];
            for (int i = 0; i < 6; i++) {
                apuestasn[0][i] = (int) (apuestas[0][i] - 48);
                apuestasn[1][i] = (int) (apuestas[1][i] - 48);
            }
            for (int i = 0; i < 6; i++) {
                a.compara(apuestasn[0][i], 2, apuestasn[1][i], 1);
            }
            bloquearGrupoA();
            Toast.makeText(this, "Tu puntaje es " + a.getContador(), Toast.LENGTH_SHORT).show();
        }
    }

    public void bloquearGrupoA() {
        al1.setEnabled(false);
        av1.setEnabled(false);
        al2.setEnabled(false);
        av2.setEnabled(false);
        al3.setEnabled(false);
        av3.setEnabled(false);
        al4.setEnabled(false);
        av4.setEnabled(false);
        al5.setEnabled(false);
        av5.setEnabled(false);
        al6.setEnabled(false);
        av6.setEnabled(false);
    }

    public boolean grupoAVacio() {
        if (av1.getText().toString().isEmpty() || al1.getText().toString().isEmpty() ||
                av2.getText().toString().isEmpty() || al2.getText().toString().isEmpty() ||
                av3.getText().toString().isEmpty() || al3.getText().toString().isEmpty() ||
                av4.getText().toString().isEmpty() || al4.getText().toString().isEmpty() ||
                av5.getText().toString().isEmpty() || al5.getText().toString().isEmpty() ||
                av6.getText().toString().isEmpty() || al6.getText().toString().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void clickDraw(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.perfil: {
                intent = new Intent(this, UsuarioActivity.class);
                break;
            }
            case R.id.tablas: {
                intent = new Intent(this, PosicionesActivity.class);
                break;
            }
            case R.id.partidos: {
                intent = new Intent(this, TablaPartidosActivity.class);
                break;
            }
            case R.id.apuestas: {
                intent = new Intent(this, ApuestasActivity.class);
                break;
            }
            case R.id.resultados: {
                intent = new Intent(this, ResultadosActivity.class);
                break;
            }
            default: {
                intent = new Intent(this, UsuarioActivity.class);
                break;
            }
        }
        startActivity(intent);
    }
}
