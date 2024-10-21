package com.example.pizzaplanet;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //link a Java object to your widgets
        CheckBox cheese = findViewById(R.id.cheeseCB);
        CheckBox pepperoni = findViewById(R.id.pepperoniCB);
        CheckBox sausage = findViewById(R.id.sausageCB);

        RadioGroup sizeRG = findViewById(R.id.radioGroup);
        RadioButton small = findViewById(R.id.smallRB);
        RadioButton medium = findViewById(R.id.mediumRB);
        RadioButton large = findViewById(R.id.largeRB);

        Button submit = findViewById(R.id.submitBTN);

        //set any onclick listeners
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String order = "";
                String topping = "";
                if(cheese.isChecked()){
                    topping += "cheese";
                }
                if(pepperoni.isChecked()){
                    topping += "\npepperoni";
                }
                if(sausage.isChecked()){
                    topping += "\nsausage";
                }
                if(small.isChecked()){
                    order = "small "+topping+" pizza";
                }
                if(medium.isChecked()){
                    order = "medium "+topping+" pizza";
                }
                if(large.isChecked()){
                    order = "large "+topping+" pizza";
                }

                Toast.makeText(MainActivity.this,order,Toast.LENGTH_LONG).show();
                //Log.debug("Tag to help find",message)
                Log.d("Pizza Order",order);

            }
        });


    }
}