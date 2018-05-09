package com.example.andres.mundial.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.andres.mundial.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PosicionesActivity extends AppCompatActivity {
    //ListView listView;
    //String[] posiciones = new String[]{"primero","segundo","tercero","cuarto"};

    private DatabaseReference databaseReference;
    SharedPreferences sharedPreferences;

    /*static final String SHARED_PREFERENCES = "MySharedPreferences";
    static final String KEY_USERNAME = "username";
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posiciones);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        //sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        // listView=(ListView) findViewById(R.id.listView);
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,posiciones);

        // listView.setAdapter(adapter);

        final ListView lv = (ListView) findViewById(R.id.lv);


        String[] fruits = new String[]{
                "1º " + " Franco Carrilo " + "5" + "pts",
                "2º " + " Gurka " + "4" + "pts",
                "3º " + " Mango peinado " + "3" + "pts",
                "4º " + " Lennynson " + "1" + "pts",
                "5º " + " El Yegua " + "1" + "pts"
        };

        List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, fruits_list) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                tv.setTextColor(Color.WHITE);
                tv.setTextSize(26);

                return view;
            }
        };
        lv.setAdapter(arrayAdapter);
    }


    /*public void setSharedPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_USERNAME, false);
        editor.apply();
    }*/

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
            case R.id.logout: {
                //setSharedPreferences();
                intent = new Intent(this, MainActivity.class);
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
