package com.kaique.calculadoradetroco;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView desconto, total, porcentagem;
    private TextInputEditText valor;
    private SeekBar progresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        desconto = findViewById(R.id.idTroco);
        total = findViewById(R.id.idTotal);
        valor = findViewById(R.id.idvalor);
        porcentagem = findViewById(R.id.idPorcentagem);
        progresso = findViewById(R.id.idseekBar);
        calculo();


    }

    public void calculo() {
        progresso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem.setText(i + "%");
                Float resultado = Float.parseFloat(String.valueOf(valor.getText()));
                Float desc = (resultado * i) / 100;
                DecimalFormat decimal= new DecimalFormat("0.00");
                desconto.setText("R$ " + decimal.format(desc));
                total.setText("R$ " + decimal.format((resultado - desc)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    ;
}