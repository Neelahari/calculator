package com.example.ang.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SimpeinterestActivity extends AppCompatActivity {

    Button btn;
    EditText etxt1, etxt2, etxt3;
    TextView txt1;
    Double principle, rate, time, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleinterest);

         btn = (Button) findViewById(R.id.calculate);
         etxt1 = (EditText) findViewById(R.id.principle);
         etxt2 = (EditText) findViewById(R.id.rate);
         etxt3 = (EditText) findViewById(R.id.time);
        txt1 = (TextView) findViewById(R.id.result);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etxt1.getText().toString().equals("") && !etxt2.getText().toString().equals("")
                        && !etxt3.getText().toString().equals("")) {
                    principle = Double.parseDouble(etxt1.getText().toString());
                    rate = Double.parseDouble(etxt2.getText().toString());
                    time = Double.parseDouble(etxt3.getText().toString());
                    res = (principle * rate * time) / 100;
                    txt1.setText("");
                    txt1.setText("Simple Interest = " + res + "\nx = " + res);
                }

                else {
                    if (res < 0) {
                        txt1.setText("");
                    }
                }


            }

        });
    }
}
