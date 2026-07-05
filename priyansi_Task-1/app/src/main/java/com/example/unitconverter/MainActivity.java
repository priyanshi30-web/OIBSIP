package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner spCategory, spFrom, spTo;
    EditText etValue;
    Button btnConvert;
    TextView tvResult;

    HashMap<String, Double> lengthMap = new HashMap<>();
    HashMap<String, Double> weightMap = new HashMap<>();
    HashMap<String, Double> timeMap = new HashMap<>();
    HashMap<String, Double> speedMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        initializeMaps();
        loadCategories();

        spCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loadUnits(spCategory.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnConvert.setOnClickListener(v -> convertValue());
    }

    private void initializeViews() {

        spCategory = findViewById(R.id.spCategory);
        spFrom = findViewById(R.id.spFrom);
        spTo = findViewById(R.id.spTo);

        etValue = findViewById(R.id.etValue);

        btnConvert = findViewById(R.id.btnConvert);

        tvResult = findViewById(R.id.tvResult);
    }

    private void loadCategories() {

        String[] categories = {
                "Length",
                "Weight",
                "Temperature",
                "Time",
                "Speed"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        categories);

        spCategory.setAdapter(adapter);
    }

    private void loadUnits(String category) {

        String[] units;

        switch (category) {

            case "Weight":

                units = new String[]{
                        "Milligram",
                        "Gram",
                        "Kilogram"
                };
                break;

            case "Temperature":

                units = new String[]{
                        "Second",
                        "Minute",
                        "Hour"
                };
                break;

            case "Speed":

                units = new String[]{
                        "m/s",
                        "km/h"
                };
                break;

            default:

                units = new String[]{
                        "Millimeter",
                        "Centimeter",
                        "Meter",
                        "Kilometer"
                };
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        units);

        spFrom.setAdapter(adapter);
        spTo.setAdapter(adapter);
    }

    private void initializeMaps() {

        // Length (Base = Meter)

        lengthMap.put("Millimeter", 0.001);
        lengthMap.put("Centimeter", 0.01);
        lengthMap.put("Meter", 1.0);
        lengthMap.put("Kilometer", 1000.0);

        // Weight (Base = Kilogram)

        weightMap.put("Milligram", 0.000001);
        weightMap.put("Gram", 0.001);
        weightMap.put("Kilogram", 1.0);

        // Time (Base = Second)

        timeMap.put("Second", 1.0);
        timeMap.put("Minute", 60.0);
        timeMap.put("Hour", 3600.0);

        // Speed (Base = m/s)

        speedMap.put("m/s", 1.0);
        speedMap.put("km/h", 0.277778);
    }

    private void convertValue() {

        String input = etValue.getText().toString().trim();

        if (input.isEmpty()) {
            tvResult.setText("Please enter a value");
            return;
        }

        double value = Double.parseDouble(input);

        String category = spCategory.getSelectedItem().toString();
        String from = spFrom.getSelectedItem().toString();
        String to = spTo.getSelectedItem().toString();

        double result = 0;

        switch (category) {

            case "Length":
                result = convertUsingMap(value, from, to, lengthMap);
                break;

            case "Weight":
                result = convertUsingMap(value, from, to, weightMap);
                break;

            case "Time":
                result = convertUsingMap(value, from, to, timeMap);
                break;

            case "Speed":
                result = convertUsingMap(value, from, to, speedMap);
                break;

            case "Temperature":
                result = convertTemperature(value, from, to);
                break;
        }

        tvResult.setText(
                String.format(Locale.getDefault(),
                        "%.2f %s",
                        result,
                        to)
        );
    }

    private double convertUsingMap(double value,
                                   String from,
                                   String to,
                                   HashMap<String, Double> map) {

        double baseValue = value * map.get(from);

        return baseValue / map.get(to);
    }

    private double convertTemperature(double value,
                                      String from,
                                      String to) {

        double celsius;

        if (from.equals("Celsius")) {

            celsius = value;

        } else if (from.equals("Fahrenheit")) {

            celsius = (value - 32) * 5 / 9;

        } else {

            celsius = value - 273.15;

        }

        if (to.equals("Celsius")) {

            return celsius;

        } else if (to.equals("Fahrenheit")) {

            return (celsius * 9 / 5) + 32;

        } else {

            return celsius + 273.15;

        }
    }
}