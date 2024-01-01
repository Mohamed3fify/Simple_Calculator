package com.example.routeseesion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.routeseesion.databinding.ActivityCalculatorBinding;
import com.example.routeseesion.databinding.ActivitySplachBinding;

public class Calculator extends AppCompatActivity {

    TextView resultTV;
    String savedNum = "";
    String savedOperator = "";
    String currentText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultTV = findViewById(R.id.tv_view);

    }

    public void onDigitClick(View view) {
        Button btn = ((Button) view);
        resultTV.append(btn.getText());
        btn.getText();

    }

    private String calculate(String lhs, String operator, String rhs) {
        double num1 = Double.parseDouble(lhs);
        double num2 = Double.parseDouble(rhs);
        double result = 0;

        switch (operator) {
            case "^":
                result = Math.pow(num1, num2);
                break;

            case "√":
                result = Math.pow(num1, .5);
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":
                result = num1 / num2;
                break;

            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            default:
                return "Error";
        }


        return String.valueOf(result);
    }

    public void onOperatorClick(View view) {
        Button clickOperator = ((Button) view);
        if (savedOperator.isEmpty()) {
            savedNum = resultTV.getText().toString();

        } else {
            String rhs = resultTV.getText().toString();
            savedNum = calculate(savedNum, savedOperator, rhs);

        }
        savedOperator = clickOperator.getText().toString();
        resultTV.setText("");
    }

    public void onEqualClick(View view) {
        String rhs = resultTV.getText().toString();
        String res = calculate(savedNum, savedOperator, rhs);
        resultTV.setText(res);
        savedOperator = "";
        savedNum = "";
    }

    public void clearResult(View view) {
        resultTV.setText("");
        savedNum = "";
        savedOperator = "";
    }

    public void backSpace(View view) {
        currentText = resultTV.getText().toString();
        if (!currentText.isEmpty()) {
            resultTV.setText(currentText.substring(0, currentText.length() - 1));
        }
    }
}
