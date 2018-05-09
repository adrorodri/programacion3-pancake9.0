package com.example.andres.mundial.Model;

/**
 * Created by Gabriel Torrico M on 9/5/2018.
 */

public class Bubble {
    public void bubbleSort(int[] puntajes) {
        int n = puntajes.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(puntajes[j-1] > puntajes[j]){
                    //swap elements
                    temp = puntajes[j-1];
                    puntajes[j-1] = puntajes[j];
                    puntajes[j] = temp;
                }

            }
        }

    }
}
