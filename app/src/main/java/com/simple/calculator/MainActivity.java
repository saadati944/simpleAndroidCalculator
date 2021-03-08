package com.simple.calculator;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.String;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //variables
    public float firstNum = 0;
    public float secondNum = 0;
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
}