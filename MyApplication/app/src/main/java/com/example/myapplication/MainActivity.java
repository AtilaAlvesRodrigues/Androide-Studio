package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private Button buttonCalculadoraIMC;
    private Button buttonCalculadoraPesoIdeal;
    private Button buttonCalculadoraAlturaIdeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        buttonCalculadoraIMC = findViewById(R.id.buttonCalculadoraIMC);
        buttonCalculadoraPesoIdeal = findViewById(R.id.buttonCalculadoraPesoIdeal);
        buttonCalculadoraAlturaIdeal = findViewById(R.id.buttonCalculadoraAlturaIdeal);

        // Botão para a Calculadora de IMC
        buttonCalculadoraIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculadoraIMCActivity.class);
                startActivity(intent);
            }
        });


        // Botão para a Calculadora de Peso Ideal
        buttonCalculadoraPesoIdeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.calculadoras.CalculadoraPesoIdealActivity.class);
                startActivity(intent);
            }
        });

        // Botão para a Calculadora de Altura Ideal
        buttonCalculadoraAlturaIdeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculadoraAlturaIdealActivity.class);
                startActivity(intent);
            }
        });
    }
}
