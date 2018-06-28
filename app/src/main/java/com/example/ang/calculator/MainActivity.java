package com.example.ang.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextView dispScreen;
    private String display = "";
    private String currentOperator = "";
    private String result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dispScreen = (TextView)findViewById(R.id.text);
        dispScreen.setText(display);
    }

    private void updateScreen(){
        dispScreen.setText(display);
    }

    public void onClickNumber(View v){
        if(result != ""){
            clear();
            updateScreen();
        }
        Button b = (Button) v;
        display = display + b.getText();
        updateScreen();
    }

    private boolean isOperator(char op){
        switch (op){
            case '+': return true;
            case '-':return true;
            case '*':return true;
            case '÷':return true;
            case '.':return true;
            case '√':return true;
            default: return false;
        }
    }

    public void onClickOperator(View v) {

        if (display != "") {

            Button b = (Button) v;


            if (result != "") {
                String disp = result;
                clear();
                display = disp;
            }

            if (currentOperator != "") {

                if (isOperator(display.charAt(display.length() - 1))) {
                    display = display.replace(display.charAt(display.length() - 1), b.getText().charAt(0));
                    updateScreen();
                    return;
                } else {
                    fetchResult();
                    display = result;
                    result = "";
                }
                currentOperator = b.getText().toString();
            }
            display = display + b.getText();
            currentOperator = b.getText().toString();
            updateScreen();


        } else if (display == "") {
            Button b = (Button) v;


            if (result != "") {
                String disp = result;
                clear();
                display = disp;
            }

            if (currentOperator != "") {

                if (isOperator(display.charAt(display.length() - 1))) {
                    display = display.replace(display.charAt(display.length() - 1), b.getText().charAt(0));
                    updateScreen();
                    return;
                } else {
                    fetchResult();
                    display = result;
                    result = "";
                }
                currentOperator = b.getText().toString();
            }
            display = display + b.getText();
            currentOperator = b.getText().toString();
            updateScreen();
        }
    }
    private void clear(){
        display = "";
        currentOperator = "";
        result = "";
    }

    public void onClickClear(View v){
        clear();
        updateScreen();
    }

    public void onClickBackSpace(View v){

        String ch = dispScreen.getText().toString();
        if (ch.length() >=1 ) {
            ch = ch.substring(0, ch.length() - 1);
            dispScreen.setText(ch);
        } else if (ch.length() <=1 ) {
            dispScreen.setText("0");
        }

    }

    private double operate(String a, String b, String op){
        switch (op){
            case "+": return Double.valueOf(a) + Double.valueOf(b);
            case "-": return Double.valueOf(a) - Double.valueOf(b);
            case "*": return Double.valueOf(a) * Double.valueOf(b);
            case "÷": return Double.valueOf(a) / Double.valueOf(b);
            case "tan": return Math.tan(Math.toRadians(Double.valueOf(b)));
            case "cos": return Math.cos(Math.toRadians(Double.valueOf(b)));
            case "sin": return Math.sin(Math.toRadians(Double.valueOf(b)));
            case "√": return Math.sqrt(Double.valueOf(b));
            case "x^2":
                try{
                return Double.valueOf(b) * Double.valueOf(b);
            }catch (Exception e){

            }
            default: return -1;
        }
    }

    private boolean fetchResult(){
        if(currentOperator == "") return false;
        String[] operation = display.split(Pattern.quote(currentOperator));
        if(operation.length < 2) return false;
        result = String.valueOf(operate(operation[0], operation[1],currentOperator));
        return true;
    }

    public void onClickEqual(View v){
        if(display == "") return;
        if(!fetchResult()) return;
        dispScreen.setText(display + "\n" + String.valueOf(result));
    }
}
