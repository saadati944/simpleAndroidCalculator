package com.simple.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //variables
    public int firstNum = 0;
    public int secondNum = 0;
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
    public void btnNumClick(View view)
    {
        txt.setText(((Button)view).getText());
    }
}