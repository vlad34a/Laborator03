package com.example.vlad.phonedialer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneDialerActivity extends AppCompatActivity {

    int[] ids;
    StringBuilder phoneNumber;
    Button[] buttons;
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        Button callButton = (Button)findViewById(R.id.imageButton4);
        Button backspace = (Button)findViewById(R.id.imageButton3);
        EditText number = (EditText)findViewById(R.id.editText);
        phoneNumber = new StringBuilder(number.getText().toString());

        buttons = new Button[10];
        ids = new int[10];
        ids[0] = R.id.button;
        ids[1] = R.id.button2;
        ids[2] = R.id.button2;
        ids[3] = R.id.button3;
        ids[4] = R.id.button4;
        ids[5] = R.id.button5;
        ids[6] = R.id.button6;
        ids[7] = R.id.button7;
        ids[8] = R.id.button8;
        ids[9] = R.id.button9;

        int id;
        StringBuilder numbers;
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = (Button)findViewById(ids[i]);
        }

        for(int i = 0; i < buttons.length; i++){
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    phoneNumber = phoneNumber.append(findViewById(ids[index++]).toString());
                }
            });
        }
        index = 0;

        backspace.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                phoneNumber = phoneNumber.deleteCharAt(phoneNumber.length()-1);
            }
        });


    }
}
