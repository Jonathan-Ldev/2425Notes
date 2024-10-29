package com.example.intentpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button screen2BTN;
    private EditText userInputEDT;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        screen2BTN = findViewById(R.id.screen2BTN);
        userInputEDT = findViewById(R.id.userInputEDT);

        screen2BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this,ThirdActivity.class);

                //step 4.5
                //intentObj.putExtra("keyword",value)
                i.putExtra("Second Page Info",String.valueOf(userInputEDT.getText()));
                //You can have as many as you want

                startActivity(i);
            }
        });

    }
}
