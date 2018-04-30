                                                         package com.example.andres.mundial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
        EditText correo;
        String correoE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up); // TODO: Change ConstraintLayout to another Layout
    }

    // TODO: Optimize.. Can be a lot simpler
    boolean verificarCorre (String correo){
        String correoCopia="";
        int pos = correo.length()-1;
        while( pos>-1 && correo.charAt(pos) != '@'){
            correoCopia = correo.charAt(pos) + correoCopia;
            pos--;
        }
        if( (correoCopia.equals("gmail.com") ||correoCopia.equals("hotmail.com"))&& (correo.charAt(0)!='@' &&
                (correo.length()-9 != 0 || correo.charAt(0)!='g')&& (correo.length()-11 != 0 || correo.charAt(0)!='h') ))

            return true;
        else
            return false;
    }

    public void click(View view) {
        // TODO: Move findViewByIds to onCreate
        correo = findViewById(R.id.correoElectronico);
        correoE = String.valueOf(correo.getText());
        if(verificarCorre(correoE)) {
            Intent i;
            i = new Intent(this, Usuario.class);
            startActivity(i);
        }
        else
            Toast.makeText(this, "Escriba un correo valido", Toast.LENGTH_SHORT).show();
    }
}