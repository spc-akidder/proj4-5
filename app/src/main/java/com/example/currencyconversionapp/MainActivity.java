package com.example.currencyconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double eurosConvert = 0.920686; //EUR
    double pesosConvert = 24.0870; //MXN
    double cadConvert = 1.40750; //CAD
    double input;
    double converted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText userInput = (EditText) findViewById(R.id.userInput);
        final RadioButton radEuros = (RadioButton) findViewById(R.id.radEuros);
        final RadioButton radPesos = (RadioButton) findViewById(R.id.radPesos);
        final RadioButton radCAD = (RadioButton) findViewById(R.id.radCanadian);
        final TextView result = (TextView) findViewById(R.id.result);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = Double.parseDouble(userInput.getText().toString());
                DecimalFormat money = new DecimalFormat("#.##");
                if (input >= 100000) {
                    result.setText("This program only converts values below $100,000 U.S. dollars.");
                }
                else {
                    if (radEuros.isChecked()) {
                        converted = input * eurosConvert;
                        result.setText("$" + money.format(input) + " USD is equal to " + money.format(converted) + " EUR");
                    }
                    else if (radPesos.isChecked()) {
                        converted = input * pesosConvert;
                        result.setText("$" + money.format(input) + " USD is equal to " + money.format(converted) + " MXN");
                    }
                    else {
                        converted = input * cadConvert;
                        result.setText("$" + money.format(input) + " USD is equal to " + money.format(converted) + " CAD");
                    }
                }
            }
        });
    }
}
