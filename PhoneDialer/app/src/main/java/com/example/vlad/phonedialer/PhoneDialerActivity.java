package com.example.vlad.phonedialer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends AppCompatActivity {

    int[] ids;
    StringBuilder phoneNumber;
    Button[] buttons;
    int index = 0;
    EditText number;
    ImageButton callButton;
    ImageButton backspace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        callButton = (ImageButton) findViewById(R.id.call_image_button);
        backspace = (ImageButton)findViewById(R.id.backspace_image_button);
        number = (EditText)findViewById(R.id.editText);
        phoneNumber = new StringBuilder(number.getText().toString());

        buttons = new Button[10];
        ids = new int[10];
        ids[0] = R.id.number_0_button;
        ids[1] = R.id.number_1_button;
        ids[2] = R.id.number_2_button;
        ids[3] = R.id.number_3_button;
        ids[4] = R.id.number_4_button;
        ids[5] = R.id.number_5_button;
        ids[6] = R.id.number_6_button;
        ids[7] = R.id.number_7_button;
        ids[8] = R.id.number_8_button;
        ids[9] = R.id.number_9_button;

        int id;
        StringBuilder numbers;
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = (Button)findViewById(ids[i]);
        }

        for(int i = 0; i < buttons.length; i++){
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    phoneNumber = phoneNumber.append(((Button)v).getText());
                    number.setText(phoneNumber);
                }
            });
        }

        backspace.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                if(phoneNumber.length() != 0) {
                    phoneNumber = phoneNumber.deleteCharAt(phoneNumber.length()-1);
                    number.setText(phoneNumber);
                }

            }
        });


    }
}
