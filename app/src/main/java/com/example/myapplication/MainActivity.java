package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText massa;
    private EditText altura;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        massa = (EditText) findViewById(R.id.massa);
        altura = (EditText) findViewById(R.id.altura);
        result = (TextView) findViewById(R.id.result);
    }

    public void calcIMC(View v) {
        String alturaStr = altura.getText().toString();
        String massaStr = massa.getText().toString();

        if (alturaStr != null && !"".equals(alturaStr)
                && massaStr != null  &&  !"".equals(massaStr)) {
            float alturaValue = Float.parseFloat(alturaStr) / 100;
            float massaValue = Float.parseFloat(massaStr);

            float imc = massaValue / (alturaValue * alturaValue);

            displayIMC(imc);
        }
    }

    private void displayIMC(float imc) {
        String imcLabel = "";

        if (Float.compare(imc, 17f) <= 0) {
            imcLabel = getString(R.string.mapeso);
        } else if (Float.compare(imc, 17f) > 0  &&  Float.compare(imc, 18.48f) <= 0) {
            imcLabel = getString(R.string.apeso);
        } else if (Float.compare(imc, 18.5f) > 0  &&  Float.compare(imc, 24.99f) <= 0) {
            imcLabel = getString(R.string.normal);
        } else if (Float.compare(imc, 25f) > 0  &&  Float.compare(imc, 29.99f) <= 0) {
            imcLabel = getString(R.string.speso);
        } else if (Float.compare(imc, 30f) > 0  &&  Float.compare(imc, 34.99f) <= 0) {
            imcLabel = getString(R.string.oipeso);
        } else if (Float.compare(imc, 35f) > 0  &&  Float.compare(imc, 39.99f) <= 0) {
            imcLabel = getString(R.string.oiipeso);
        } else {
            imcLabel = getString(R.string.oiiipeso);
        }

        imcLabel = imc + "\n\n" + imcLabel;
        result.setText(imcLabel);
    }
}