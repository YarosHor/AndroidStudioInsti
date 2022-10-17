package com.yaros.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String[] buttons = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvBefore = (TextView) findViewById(R.id.tvBefore);


        Button bt0 = (Button) findViewById(R.id.bt0);
        bt0.setOnClickListener(this);
        Button bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        Button bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
        Button bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(this);
        Button bt4 = (Button) findViewById(R.id.bt4);
        bt4.setOnClickListener(this);
        Button bt5 = (Button) findViewById(R.id.bt5);
        bt5.setOnClickListener(this);
        Button bt6 = (Button) findViewById(R.id.bt6);
        bt6.setOnClickListener(this);
        Button bt7 = (Button) findViewById(R.id.bt7);
        bt7.setOnClickListener(this);
        Button bt8 = (Button) findViewById(R.id.bt8);
        bt8.setOnClickListener(this);
        Button bt9 = (Button) findViewById(R.id.bt9);
        bt9.setOnClickListener(this);
        Button btComma = (Button) findViewById(R.id.btPoint);
        btComma.setOnClickListener(this);
        Button btC = (Button) findViewById(R.id.btC);
        btC.setOnClickListener(this);
        Button btPer = (Button) findViewById(R.id.btPer);
        btPer.setOnClickListener(this);
        Button btDiv = (Button) findViewById(R.id.btDiv);
        btDiv.setOnClickListener(this);
        Button btMult = (Button) findViewById(R.id.btMult);
        btMult.setOnClickListener(this);
        Button btMinus = (Button) findViewById(R.id.btMinuis);
        btMinus.setOnClickListener(this);
        Button btPlus = (Button) findViewById(R.id.btPlus);
        btPlus.setOnClickListener(this);
        Button btEqual = (Button) findViewById(R.id.btEqual);
        btEqual.setOnClickListener(this);
        btEqual.getText().toString();
    }

    StringBuilder actual = new StringBuilder();
    String lastOperation = "";
    @Override
    public void onClick(View view) {
        boolean result = false;
        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        TextView tvBefore = (TextView) findViewById(R.id.tvBefore);
        tvBefore.setText(lastOperation);
        if(view.getId() == R.id.btC){
            if(actual.length() > 0)
                actual.deleteCharAt(actual.length() -1);
        }
        else if(view.getId() == R.id.btEqual){
            Calculate calculate = new Calculate();
            tvBefore.setText(actual + "=");
            result = true;
            try {
                lastOperation = "" + calculate.calculate(actual);
                tvResult.setText(lastOperation);
            } catch (Exception e) {
                tvResult.setText("Error");
                e.printStackTrace();
            }
            actual.delete(0, actual.length());

        }
        else {
            Button button = (Button) view;
            actual.append(button.getText().charAt(0));
        }
        if(result == false)
            tvResult.setText(actual);
    }
}