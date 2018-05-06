package com.example.andres.mundial;

import android.widget.Toast;

public class Comparador {

    int cont=0;


    public int compara (int Aa1, int Ra1, int Aa2, int Ra2){
        if (Aa1==Ra1 && Aa2==Ra2){
            cont=cont+5;
        }else if(Aa1> Aa2 && Ra1>Ra2){
            cont++;
        }else if(Aa2> Aa1 && Ra2>Ra1){
            cont++;
        }else if(Aa1== Aa2 && Ra1==Ra2){
            cont++;
        }
        return cont;
    }
    public  int resultado(){
        return  cont;
    }
}
