package com.example.salutaci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        greet();
    }

    public void change(){
        Button bt1 = (Button) this.findViewById(R.id.bt1);
        Button bt2 = (Button) this.findViewById(R.id.bt2);
        Button bt3 = (Button) this.findViewById(R.id.bt3);
        Button bt4 = (Button) this.findViewById(R.id.bt4);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                greet();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                factorial();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headstails();
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rockpapersissors();
            }
        });
    }


    public void greet(){

        setContentView(R.layout.activity_main);
        change();
        Button btGreet = (Button) this.findViewById(R.id.btSaludo);
        EditText txName = (EditText) this.findViewById(R.id.etv1);
        EditText txSurname = (EditText) this.findViewById(R.id.etv2);


        btGreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "Hello " + txName.getText() + " " + txSurname.getText();
                txName.setText("");
                txSurname.setText("");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void factorial(){
        setContentView(R.layout.factorial);
        change();
        Button bt = (Button) this.findViewById(R.id.bt21);
        EditText tx = (EditText) this.findViewById(R.id.et2);
        TextView tv = (TextView) this.findViewById(R.id.tv2result);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = Integer.parseInt(String.valueOf(tx.getText()));
                int result = 1;
                for(int j = i; j > 0; j--){
                    result = result * j;
                }
                tx.setText("");
                String print = String.valueOf(result);
                tv.setText(print);
            }
        });
    }

    public void headstails(){
        setContentView(R.layout.headstails);
        change();
        boolean result = false;
        Button heads = (Button) this.findViewById(R.id.bt3heads);
        Button tails = (Button) this.findViewById(R.id.bt3tails);
        TextView tv = (TextView) this.findViewById(R.id.tv3result);

        heads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(headsTailsChoice(false))
                    tv.setText("Has Ganado");
                else
                    tv.setText("Has Perdido");
            }
        });
        tails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(headsTailsChoice(true))
                    tv.setText("Has Ganado");
                else
                    tv.setText("Has Perdido");
            }
        });

    }
    public boolean headsTailsChoice(boolean choice){
        ImageView img = (ImageView) this.findViewById(R.id.img3);

        boolean result = false;
        Random rd = new Random();
        int i = rd.nextInt(2 - 1 +1) + 1;
        if(i == 1){
            img.setImageResource(R.drawable.euro_cara);
            result = false;
        }
        if(i == 2){
            img.setImageResource(R.drawable.euro_cruz);
            result = true;
        }
        Toast.makeText(MainActivity.this, "Fin", Toast.LENGTH_SHORT).show();
        return result == choice;
    }

    private int playerPoint;
    private int cpuPoint;
    int result;
    public void rockpapersissors(){
        setContentView(R.layout.rockpapersissors);
        change();
        playerPoint = 0;
        cpuPoint = 0;
        result = 0;
        ProgressBar pbc = (ProgressBar) this.findViewById(R.id.pb4c);
        ProgressBar pbp = (ProgressBar) this.findViewById(R.id.pb4p);
        ImageButton rock = (ImageButton) this.findViewById(R.id.ib4rock);
        ImageButton paper = (ImageButton) this.findViewById(R.id.ib4paper);
        ImageButton sissors = (ImageButton) this.findViewById(R.id.ib4sissors);
        TextView tv = (TextView) this.findViewById(R.id.tv3result);
        ImageView img = (ImageView) this.findViewById(R.id.iv4c);



        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = playRPS(1);
                if(result == 1)
                    playerPoint++;
                else if(result == -1)
                    cpuPoint++;
                pbc.setProgress(cpuPoint);
                pbp.setProgress(playerPoint);
                if(playerPoint >= 3){
                    resultRPS(true);
                }
                if(cpuPoint >= 3){
                    resultRPS(false);
                }
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = playRPS(2);
                if(result == 1)
                    playerPoint++;
                else if(result == -1)
                    cpuPoint++;
                pbc.setProgress(cpuPoint);
                pbp.setProgress(playerPoint);
                if(playerPoint >= 3){
                    resultRPS(true);
                }
                if(cpuPoint >= 3){
                    resultRPS(false);
                }
            }
        });
        sissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = playRPS(3);
                if(result == 1)
                    playerPoint++;
                else if(result == -1)
                    cpuPoint++;
                pbc.setProgress(cpuPoint);
                pbp.setProgress(playerPoint);
                if(playerPoint >= 3){
                    resultRPS(true);
                }
                if(cpuPoint >= 3){
                    resultRPS(false);
                }
            }
        });


    }

    public int playRPS(int i){
        ConstraintLayout cl = (ConstraintLayout) this.findViewById(R.id.cl4);
        cl.setVisibility(View.VISIBLE);
        ImageButton ib = (ImageButton) this.findViewById(R.id.ib4cont);
        ImageView img = (ImageView) this.findViewById(R.id.iv4c);
        TextView tv = (TextView) this.findViewById(R.id.tvResult);
        TextView tv2 = (TextView) this.findViewById(R.id.tvResult2);
        Random rd = new Random();
        int result = 0;
        int j = rd.nextInt(3 - 1 +1) + 1;
        if(j == 1){
            img.setImageResource(R.drawable.rock);
            if(i == 1){
                tv.setText("Draw");
                tv2.setText("Two Rocks");
                result = 0;
            }
            else if(i == 2){
                tv.setText("Win");
                tv2.setText("Paper envelops Rock");
                result = 1;
            }
            else if(i == 3){
                tv.setText("Lose");
                tv2.setText("Rock beats Sissors");
                result = -1;
            }
            else
                tv.setText("ERROR");
        }

        else if(j == 2){
            img.setImageResource(R.drawable.paper);
            if(i == 1){
                tv.setText("Lose");
                tv2.setText("Paper envelops Rocks");
                result = -1;
            }
            else if(i == 2){
                tv.setText("Draw");
                tv2.setText("Two Papers");
                result = 0;
            }
            else if(i == 3){
                tv.setText("Win");
                tv2.setText("Sissors cut Paper");
                result = 1;
            }
            else
                tv.setText("ERROR");
        }
        else if(j == 3){
            img.setImageResource(R.drawable.sissors);
            if(i == 1){
                tv.setText("Win");
                tv2.setText("Rocks beats Sissors");
                result = 1;
            }
            else if(i == 2){
                tv.setText("Lose");
                tv2.setText("Sissors cut Paper");
                result = -1;
            }
            else if(i == 3){
                tv.setText("Draw");
                tv2.setText("Two Sissors");
                result = 0;
            }
            else
                tv.setText("ERROR");
        }
        else
            return 0;

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cl.setVisibility(View.GONE);

            }
        });
        return result;
    }

    public void resultRPS(boolean result){
        setContentView(R.layout.rpsresult);
        playerPoint = 0;
        cpuPoint = 0;
        ImageButton ib = (ImageButton) this.findViewById(R.id.ib4rest);
        ImageView img = (ImageView) this.findViewById(R.id.iv4l);

        if(result == false){
            img.setVisibility(View.VISIBLE);
        }
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setVisibility(View.INVISIBLE);
                rockpapersissors();
            }
        });
    }
}