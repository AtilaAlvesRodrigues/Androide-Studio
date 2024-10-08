package com.example.calculadoras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class CalculadoraPesoIdealActivity extends AppCompatActivity {

    private EditText editAlturaPesoIdeal;
    private RadioGroup radioGroupSexoPesoIdeal;
    private TextView textResultadoPesoIdeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora_peso_ideal);

        editAlturaPesoIdeal = findViewById(R.id.editAlturaPesoIdeal);
        radioGroupSexoPesoIdeal = findViewById(R.id.radioGroupSexoPesoIdeal);
        textResultadoPesoIdeal = findViewById(R.id.textResultadoPesoIdeal);
        Button buttonCalcularPesoIdeal = findViewById(R.id.buttonCalcularPesoIdeal);

        buttonCalcularPesoIdeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPesoIdeal();
            }
        });
    }

    private void calcularPesoIdeal() {
        String alturaStr = editAlturaPesoIdeal.getText().toString();
        if (alturaStr.isEmpty()) {
            textResultadoPesoIdeal.setText("Por favor, preencha todos os campos.");
            return;
        }

        double altura = Double.parseDouble(alturaStr);
        int sexoId = radioGroupSexoPesoIdeal.getCheckedRadioButtonId();
        double pesoIdeal;

        if (sexoId == R.id.radioMasculinoPesoIdeal) {
            pesoIdeal = (72.7 * altura) - 58; // Fórmula para homens
        } else {
            pesoIdeal = (62.1 * altura) - 44.7; // Fórmula para mulheres
        }

        String resultado = String.format("Seu peso ideal é: %.2f kg", pesoIdeal);
        textResultadoPesoIdeal.setText(resultado);
    }
}
