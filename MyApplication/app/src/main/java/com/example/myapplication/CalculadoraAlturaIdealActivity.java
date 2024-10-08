package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class CalculadoraAlturaIdealActivity extends AppCompatActivity {

    private EditText editPesoAlturaIdeal;
    private RadioGroup radioGroupSexoAlturaIdeal;
    private TextView textResultadoAlturaIdeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora_altura_ideal);

        editPesoAlturaIdeal = findViewById(R.id.editPesoAlturaIdeal);
        radioGroupSexoAlturaIdeal = findViewById(R.id.radioGroupSexoAlturaIdeal);
        textResultadoAlturaIdeal = findViewById(R.id.textResultadoAlturaIdeal);
        Button buttonCalcularAlturaIdeal = findViewById(R.id.buttonCalcularAlturaIdeal);

        buttonCalcularAlturaIdeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularAlturaIdeal();
            }
        });
    }

    private void calcularAlturaIdeal() {
        String pesoStr = editPesoAlturaIdeal.getText().toString();
        if (pesoStr.isEmpty()) {
            textResultadoAlturaIdeal.setText("Por favor, preencha todos os campos.");
            return;
        }

        double peso = Double.parseDouble(pesoStr);
        int sexoId = radioGroupSexoAlturaIdeal.getCheckedRadioButtonId();
        double alturaIdeal;

        if (sexoId == R.id.radioMasculinoAlturaIdeal) {
            alturaIdeal = (peso + 100) - (peso * 0.1); // Fórmula para homens
        } else {
            alturaIdeal = (peso + 100) - (peso * 0.15); // Fórmula para mulheres
        }

        String resultado = String.format("Sua altura ideal é: %.2f m", alturaIdeal);
        textResultadoAlturaIdeal.setText(resultado);
    }
}
