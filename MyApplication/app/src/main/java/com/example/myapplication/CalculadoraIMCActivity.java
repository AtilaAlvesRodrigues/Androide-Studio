package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class CalculadoraIMCActivity extends AppCompatActivity {

    private EditText editAlturaIMC;
    private EditText editPesoIMC;
    private RadioGroup radioGroupSexoIMC;
    private TextView textResultadoIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora_imc);

        editAlturaIMC = findViewById(R.id.editAlturaIMC);
        editPesoIMC = findViewById(R.id.editPesoIMC);
        radioGroupSexoIMC = findViewById(R.id.radioGroupSexo);
        textResultadoIMC = findViewById(R.id.textResultadoIMC);
        Button buttonCalcularIMC = findViewById(R.id.buttonCalcularIMC);

        buttonCalcularIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        String alturaStr = editAlturaIMC.getText().toString();
        String pesoStr = editPesoIMC.getText().toString();

        if (alturaStr.isEmpty() || pesoStr.isEmpty()) {
            textResultadoIMC.setText("Por favor, preencha todos os campos.");
            return;
        }

        double altura = Double.parseDouble(alturaStr);
        double peso = Double.parseDouble(pesoStr);

        double imc = peso / (altura * altura);
        String resultado = String.format("Seu IMC é: %.2f", imc);
        textResultadoIMC.setText(resultado);
    }
}
