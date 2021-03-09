package com.simple.calculator;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.String;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variables
    public long firstNum = 0;
    public long secondNum = 0;
    public enum operations {
        plus,
        minus,
        devide,
        multiply,
        noop    // no operation
    };
    public operations operation = operations.noop;


    //controls
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning controls
        txt = (EditText)findViewById(R.id.txt);
    }

    void updateText()
    {
        if(operation == operations.noop)
        {
            txt.setText(String.valueOf(firstNum));
            return;
        }

        txt.setText(String.valueOf(firstNum) + getOperationString() + String.valueOf(secondNum));
    }
    void resetValues()
    {
        firstNum = secondNum = 0;
        operation = operations.noop;
    }
    private String getOperationString()
    {
        switch (operation)
        {
            case plus:
                return " + ";
            case minus:
                return " - ";
            case multiply:
                return " x ";
            case devide:
                return " ÷ ";
        }
        return " ";
    }

    //actions
    public void btnNumClick(View view)
    {
        if(operation == operations.noop)
            firstNum = firstNum*10 + Integer.parseInt(((Button)view).getText().toString());
        else
            secondNum = secondNum*10 + Integer.parseInt(((Button)view).getText().toString());

        updateText();
    }
    public void btnClear(View view)
    {
        resetValues();
        updateText();
    }
    public void btnOperationClick(View view)
    {
        CharSequence text = ((Button) view).getText();
        if ("+".equals(text)) {
            operation = operations.plus;
        } else if ("-".equals(text)) {
            operation = operations.minus;
        } else if ("x".equals(text)) {
            operation = operations.multiply;
        } else if ("÷".equals(text)) {
            operation = operations.devide;
        }
        updateText();
    }
    public void btnCalculateClick(View view)
    {
        long resault = 0;
        switch (operation)
        {
            case plus:
                resault = firstNum + secondNum;
                break;
            case minus:
                resault = firstNum - secondNum;
                break;
            case multiply:
                resault = firstNum * secondNum;
                break;
            case devide:
                resault = firstNum / secondNum;
                break;
            case noop:
                Toast.makeText(this, "No more operations to do !", Toast.LENGTH_SHORT).show();
                return;
        }

        txt.setText(txt.getText() + " = " + String.valueOf(resault));
        resetValues();
        firstNum = resault;
    }
}