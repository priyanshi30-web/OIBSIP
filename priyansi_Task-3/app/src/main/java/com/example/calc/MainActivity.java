package com.example.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView resultText;
    private Button addButton, subtractButton, multiplyButton, divideButton, equalButton, clearButton;
    private Button num1Button, num2Button, num3Button, num4Button;
    private Button num5Button, num6Button, num7Button, num8Button, num9Button, zeroButton, dotButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText2);
        resultText = findViewById(R.id.resultText);
        clearButton = findViewById(R.id.clear_text);


        addButton = findViewById(R.id.add);
        subtractButton = findViewById(R.id.sub);
        multiplyButton = findViewById(R.id.mul);
        divideButton = findViewById(R.id.div);
        equalButton = findViewById(R.id.submit);

        num1Button = findViewById(R.id.num1);
        num2Button = findViewById(R.id.num2);
        num3Button = findViewById(R.id.num3);
        num4Button = findViewById(R.id.num4);
        num5Button = findViewById(R.id.num5);
        num6Button = findViewById(R.id.num6);
        num7Button = findViewById(R.id.num7);
        num8Button = findViewById(R.id.num8);
        num9Button = findViewById(R.id.num9);
        zeroButton = findViewById(R.id.zero);
        dotButton = findViewById(R.id.dot);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
                String expression = editText.getText().toString();
            if (!expression.contains("+") &&
                    !expression.contains("-") &&
                    !expression.contains("*") &&
                    !expression.contains("/")) {

                expression += "+";
                editText.setText(expression);

            }
            else {

                Toast.makeText(MainActivity.this,
                        "Only one operator allowed",
                        Toast.LENGTH_SHORT).show();
            }
        }
    });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = editText.getText().toString();
                if (!expression.contains("+") &&
                        !expression.contains("-") &&
                        !expression.contains("*") &&
                        !expression.contains("/")) {

                    expression += "-";
                    editText.setText(expression);
                }
                else {

                    Toast.makeText(MainActivity.this,
                            "Only one operator allowed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String expression = editText.getText().toString();
                if (!expression.contains("+") &&
                        !expression.contains("-") &&
                        !expression.contains("*") &&
                        !expression.contains("/")) {

                    expression += "*";
                    editText.setText(expression);
                }
                else {

                    Toast.makeText(MainActivity.this,
                            "Only one operator allowed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = editText.getText().toString();
                if (!expression.contains("+") &&
                        !expression.contains("-") &&
                        !expression.contains("*") &&
                        !expression.contains("/")) {

                    expression += "/";
                    editText.setText(expression);
                }
                else {

                    Toast.makeText(MainActivity.this,
                            "Only one operator allowed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
                resultText.setText("0");
            }
        });

        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String expression = editText.getText().toString();

                try {

                    if (expression.contains("+")) {

                        String[] parts = expression.split("\\+");

                        double num1 = Double.parseDouble(parts[0]);
                        double num2 = Double.parseDouble(parts[1]);

                        resultText.setText(String.valueOf(num1 + num2));

                    } else if (expression.contains("-")) {

                        String[] parts = expression.split("-");

                        double num1 = Double.parseDouble(parts[0]);
                        double num2 = Double.parseDouble(parts[1]);

                        resultText.setText(String.valueOf(num1 - num2));

                    } else if (expression.contains("*")) {

                        String[] parts = expression.split("\\*");

                        double num1 = Double.parseDouble(parts[0]);
                        double num2 = Double.parseDouble(parts[1]);

                        resultText.setText(String.valueOf(num1 * num2));

                    } else if (expression.contains("/")) {

                        String[] parts = expression.split("/");

                        double num1 = Double.parseDouble(parts[0]);
                        double num2 = Double.parseDouble(parts[1]);

                        if (num2 == 0) {
                            resultText.setText("Cannot divide by zero");
                        } else {
                            resultText.setText(String.valueOf(num1 / num2));
                        }

                    }

                } catch (Exception e) {
                    resultText.setText("Invalid Input");
                }
            }
        });

        num1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "1");
            }
        });

        num2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "2");
            }
        });

        num3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "3");
            }
        });

        num4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "4");
            }
        });

        num5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "5");
            }
        });

        num6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "6");
            }
        });

        num7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "7");
            }
        });

        num8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "8");
            }
        });

        num9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "9");
            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "0");
            }
        });

        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String expression = editText.getText().toString();

                String lastNumber = expression;

                if (expression.contains("+"))
                    lastNumber = expression.substring(expression.lastIndexOf("+") + 1);
                else if (expression.contains("-"))
                    lastNumber = expression.substring(expression.lastIndexOf("-") + 1);
                else if (expression.contains("*"))
                    lastNumber = expression.substring(expression.lastIndexOf("*") + 1);
                else if (expression.contains("/"))
                    lastNumber = expression.substring(expression.lastIndexOf("/") + 1);

                if (!lastNumber.contains(".")) {
                    editText.append(".");
                }
            }
        });
    }
}