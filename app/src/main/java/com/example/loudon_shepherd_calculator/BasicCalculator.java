package com.example.loudon_shepherd_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.*;

public class BasicCalculator extends AppCompatActivity implements View.OnClickListener {

    Button[] numbers;
    Button[] functions;
    Button decimal;
    Button equal;
    Button clearButton;
    Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);
        // instantiate the number buttons
        numbers = new Button[10];
        numbers[0] = (Button) findViewById(R.id.Zero);
        numbers[1] = (Button) findViewById(R.id.One);
        numbers[2] = (Button) findViewById(R.id.Two);
        numbers[3] = (Button) findViewById(R.id.Three);
        numbers[4] = (Button) findViewById(R.id.Four);
        numbers[5] = (Button) findViewById(R.id.Five);
        numbers[6] = (Button) findViewById(R.id.Six);
        numbers[7] = (Button) findViewById(R.id.Seven);
        numbers[8] = (Button) findViewById(R.id.Eight);
        numbers[9] = (Button) findViewById(R.id.Nine);
        for(int i = 0; i < numbers.length; i++) {
            numbers[i].setOnClickListener(BasicCalculator.this);
        }
        // instantiate function buttons
        functions = new Button[4];
        functions[0] = (Button) findViewById(R.id.Add);
        functions[1] = (Button) findViewById(R.id.Subtract);
        functions[2] = (Button) findViewById(R.id.Multiply);
        functions[3] = (Button) findViewById(R.id.Divide);
        for(int i = 0; i < functions.length; i++) {
            functions[i].setOnClickListener(BasicCalculator.this);
        }
        //instantiate decimal button
        decimal = (Button) findViewById(R.id.Decimal);
        decimal.setOnClickListener(BasicCalculator.this);
        // instantiate equals button
        equal = (Button) findViewById(R.id.Equal);
        equal.setOnClickListener(BasicCalculator.this);
        // instantiate clear button
        clearButton = (Button) findViewById(R.id.Clear);
        clearButton.setOnClickListener(BasicCalculator.this);
        // instantiate delete button
        deleteButton = (Button) findViewById(R.id.Delete);
        deleteButton.setOnClickListener(BasicCalculator.this);
    }

    @Override
    public void onClick(View v) {
        BigDecimal result;
        TextView output = (TextView) findViewById(R.id.calculation);
        String outputText = (String) output.getText();
        Button clicked = (Button) v;
        String buttonText = (String)((Button) v).getText();

        if(v instanceof Button) {
            if(buttonText.equals("=") && outputText != null && !outputText.equals("")) {
                Expression expression = new Expression(outputText);
                result = expression.eval();
                output.setText((CharSequence) result.toString());
            }

            else if(buttonText.equals("Clear")) {
                output.setText((CharSequence) "");
            }

            else if(buttonText.equals("Delete")) {
                if(outputText != null && !outputText.equals("")) {
                    outputText = outputText.substring(0, outputText.length()-1);
                    output.setText((CharSequence) outputText);
                }
            }

            else {
                output.setText((CharSequence) outputText + buttonText);
            }
        }
    }

}
