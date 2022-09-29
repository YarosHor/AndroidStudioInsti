package com.example.guessnumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private int number;
    private boolean result;
    private Button one = (Button) this.findViewById(R.id.button1);
    private Button two = (Button) this.findViewById(R.id.button1);
    private Button three = (Button) this.findViewById(R.id.button1);
    private Button four = (Button) this.findViewById(R.id.button1);
    private Button five = (Button) this.findViewById(R.id.button1);
    private Button six = (Button) this.findViewById(R.id.button1);
    private Button seven = (Button) this.findViewById(R.id.button1);
    private Button eight = (Button) this.findViewById(R.id.button1);
    private Button nine = (Button) this.findViewById(R.id.button1);
    private Button ten = (Button) this.findViewById(R.id.button1);

    private TextView[] tx = new TextView[10];
    private TextView textView = (TextView) this.findViewById(R.id.tx);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx[0] = (TextView) this.findViewById(R.id.tx1);
        tx[1] = (TextView) this.findViewById(R.id.tx2);
        tx[2] = (TextView) this.findViewById(R.id.tx3);
        tx[3] = (TextView) this.findViewById(R.id.tx4);
        tx[4] = (TextView) this.findViewById(R.id.tx5);
        tx[5] = (TextView) this.findViewById(R.id.tx6);
        tx[6] = (TextView) this.findViewById(R.id.tx7);
        tx[7] = (TextView) this.findViewById(R.id.tx8);
        tx[8] = (TextView) this.findViewById(R.id.tx9);
        tx[9] = (TextView) this.findViewById(R.id.tx10);


        result = false;
        Random rd = new Random();
        number = rd.nextInt(10 - 1 +1) + 1;
        textView.setText("3");
        one.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                selectNumber(1);
            }
        });
    }

    public void selectNumber(int num){
        if(num == number){
            result = true;
            createNewContactDialog();
            return;
        }
        if(num > number){
            for(int i = num - 1; i < 10; i++){
                tx[i].setTextColor(00000);
            }
        }
        else if(num < number){
            for(int i = 0; i < num; i++){
                tx[i].setTextColor(00000);
            }
        }
        int i = Integer.parseInt(textView.getText().toString());
        i = i - 1;
        textView.setText(String.valueOf(i));
        if(i <= 0){
            createNewContactDialog();
        }
    }

    public void createNewContactDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popup, null);
        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();


    }
}