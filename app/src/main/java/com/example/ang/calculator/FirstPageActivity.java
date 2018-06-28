package com.example.ang.calculator;


/**
 * Created by Ranu Agrawal on 6/22/2017.
 */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FirstPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);

        ImageButton simpleCalc = (ImageButton)findViewById(R.id.simple_scientific);

        simpleCalc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(FirstPageActivity.this, MainActivity.class);
            startActivity(intent);


               }
        });

        ImageButton SimpleIntCalc = (ImageButton)findViewById(R.id.simpleInterest);
        SimpleIntCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstPageActivity.this, SimpeinterestActivity.class);
                startActivity(intent);
            }
        });

        ImageButton EqCalc= (ImageButton)findViewById(R.id.equation);
        EqCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstPageActivity.this, QuadraticActivity.class);
                startActivity(intent);
            }
        });
        }
}
