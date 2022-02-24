package com.example.tute02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_temp;
    RadioButton rb_btn_C;
    RadioButton rb_btn_F;
    Button btn_calculate;
    TextView tv_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_temp);
        rb_btn_C = findViewById(R.id.rb_btn_C);
        rb_btn_F = findViewById(R.id.rb_btn_F);
        btn_calculate = findViewById(R.id.btn_calculate);
        tv_answer = findViewById(R.id.tv_answer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caclulate();

            }
        });
    }
    public void caclulate(){
        Calculation cal = new Calculation(); //creating an obj from the calculation class

        String value = et_temp.getText().toString();
        if(TextUtils.isEmpty(value)) {
            Toast.makeText(this, "Enter the temperature", Toast.LENGTH_SHORT).show();
        }
            else{
            Float temp = Float.parseFloat(value);
                if(rb_btn_C.isChecked()){
                    temp = cal.convertFahrenheitToCelcius(temp);
                }
                else if(rb_btn_F.isChecked()){
                        cal.convertCelciusToFahrenheit(temp);
                }
                //in a case if user didn't select the radio btn
                    else {
                    Toast.makeText(this, "Select the Radio Button", Toast.LENGTH_SHORT).show();
                    temp = 0.0f;
                    }
                     //display the text in the text view
                    tv_answer.setText(new Float(temp).toString());
            }
        }//

    }
