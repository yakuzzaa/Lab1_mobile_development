package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    EditText n1;
    EditText n2;
    Button sumbtn;
    Button subbtn;
    Button multiplybtn;
    Button divbtn;

    public void buttonActions(String button_id) {
        try{
            float num1 = Float.parseFloat(n1.getText().toString());
            float num2 = Float.parseFloat(n2.getText().toString());
            Intent i = new Intent(MainActivity.this, ResultActivity.class);
            if (Objects.equals(button_id, "sumbtn")){
                i.putExtra("Result", num1+num2);
            }
            else if (Objects.equals(button_id, "subbtn")){
                i.putExtra("Result", num1-num2);
            }
            else if (Objects.equals(button_id, "multiplybtn")){
                i.putExtra("Result", num1*num2);
            }
            else if (Objects.equals(button_id, "divbtn")){
                i.putExtra("Result", num1/num2);
            }
            else{
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.inputError),
                        Toast.LENGTH_LONG).show();
            }
            startActivity(i);
        } catch (Exception e){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.inputError),
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        sumbtn = findViewById(R.id.sumbtn);
        subbtn = findViewById(R.id.subbtn);
        multiplybtn = findViewById(R.id.multiplybtn);
        divbtn = findViewById(R.id.divbtn);

        sumbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonActions("sumbtn");
            }
        });
        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonActions("subbtn");
            }
        });
        multiplybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonActions("multiplybtn");
            }
        });
        divbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonActions("divbtn");
            }
        });
    }
}