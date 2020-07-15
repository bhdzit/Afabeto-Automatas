package com.devmictlan.alfabeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity  {
    private LinearLayout ContenoedorDeCadenas;
    private  TextInputEditText alfabeto;
    private final String TAG =this.getClass().getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ContenoedorDeCadenas=findViewById(R.id.cadenas_container);
        alfabeto=findViewById(R.id.tietAlfabeto);
    }

    public void addCadena(View v){
        TextInputLayout cadenalayout =(TextInputLayout) getLayoutInflater().inflate(R.layout.cadena_layout, null);
        TextInputEditText cadenainput=cadenalayout.findViewById(R.id.cadena);
        cadenainput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String []caracterDeAlfabeto=alfabeto.getText().toString().split(",");
                String cadena=cadenainput.getText().toString();
                for(String caracter:caracterDeAlfabeto){
                    cadena=cadena.replace(caracter,"");
                }

                    if(cadena.length()!=0){
                        cadenalayout.setHint("|W|=N/A");
                        cadenalayout.setError("La Cadena no se puede formar con el alfabeto");
                    }
                    else{
                        cadenalayout.setHint("|W|="+s.length());
                        cadenalayout.setError("");
                    }

            }
        });
        ContenoedorDeCadenas.addView(cadenalayout);

    }

}
