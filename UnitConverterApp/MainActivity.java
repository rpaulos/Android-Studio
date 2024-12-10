package com.example.unitconverterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //initialize Widgets
        EditText valueInput = findViewById(R.id.value_input);
        Spinner unitSpinner = findViewById(R.id.unit_spinner);
        Button convertButton = findViewById(R.id.convert_button);
        TextView resultText = findViewById(R.id.text_result);

        //Populate spinner with options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unit_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(adapter);

        //Button click listener
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = valueInput.getText().toString();

                if (!input.isEmpty()) {
                    double value = Double.parseDouble(input);
                    String selectedUnit = unitSpinner.getSelectedItem().toString();
                    double result;

                    //Conversion based on selected unit
                    switch (selectedUnit) {
                        case "Kilometers to Miles":
                            result = value * 0.621371;
                            resultText.setText(String.format("%.2f km = %2f miles", value, result));
                            break;
                        case "Celsius to Fahrenheit":
                            result = (value * 9 / 5) + 32;
                            resultText.setText(String.format("%2f C = %2f F", value, result));
                            break;
                        default:
                            resultText.setText("Invalid conversion selected");
                            break;
                    }
                }
            }
        });
    }
}