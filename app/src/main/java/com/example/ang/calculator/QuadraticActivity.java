package com.example.ang.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuadraticActivity extends AppCompatActivity {

    EditText et1 ,et2,et3;
    Button bt1;
    TextView txt;
    double a , b, c, d, x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quadraticeqn);

        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        et3 = (EditText)findViewById(R.id.editText3);

        bt1 = (Button) findViewById(R.id.button);
        txt = (TextView) findViewById(R.id.textView1);

      bt1.setOnClickListener(new View.OnClickListener(){
          @Override
          public void onClick(View v){
              if(!et1.getText().toString().equals("") && !et2.getText().toString().equals("")
                                      && !et3.getText().toString().equals("")) {
                  a = Double.parseDouble(et1.getText().toString());
                  b = Double.parseDouble(et2.getText().toString());
                  c = Double.parseDouble(et3.getText().toString());
                  d = Math.pow(b, 2) - 4*a*c;
                  x1 = -b / (2*a);
                  txt.setText("d = " + d + "\nx = " + x1);

              }else if (d < 0){
                  txt.setText("No roots");
              }else if(d > 0){
                  x1 = (-b + Math.sqrt(d))/(2 * a);
                  x2 = (-b + Math.sqrt(d))/(2 * a);
                  txt.setText("d = " + d + "\nx1 = " + x1 + "\nx2 = " + x2 );
              }
          }}
      );
    }
}
