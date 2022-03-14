package com.example.clicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int btc = 0;
    int initialFactor = 1;
    int goalBtc=100;
    int addingAMultiplier = initialFactor;
    double factor = 1;

    Button addCoin;
    TextView TabloСoins, Xfactor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCoin = (Button)findViewById(R.id.addCoin);
        TabloСoins = (TextView)findViewById(R.id.TabloСoins);
        Xfactor = (TextView)findViewById(R.id.xfactor);
        addCoin();
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    void addCoin(){
        addCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btc == goalBtc) {
                    factor += 0.5;
                    goalBtc*=5;
                    addingAMultiplier += 0.01;
                }
                btc += addingAMultiplier;
                TabloСoins.setText("BTC: "+btc);
                Xfactor.setText("Множитель: "+factor);
            }});
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", (int) btc);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        btc = savedInstanceState.getInt("count");
    }
}
