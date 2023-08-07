package com.cyberxcoder.breastcancerriskassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity3 extends AppCompatActivity {

    boolean isAllFieldsChecked;
    EditText name, phone, age;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);

        Button mainToSecond = findViewById(R.id.fifthToSixth);

        mainToSecond.setOnClickListener(view -> {
            name = findViewById(R.id.name);
            age = findViewById(R.id.age);
            gender = findViewById(R.id.lumps);
            phone = findViewById(R.id.phone);

            isAllFieldsChecked = CheckAllFields();

            if(isAllFieldsChecked) {
                Intent i = new Intent(getApplicationContext(), MainActivity4.class);
                i.putExtra("name", name.getText().toString());
                i.putExtra("age", age.getText().toString());
                i.putExtra("gender", gender.isChecked()? gender.getTextOn() : gender.getTextOff());
                i.putExtra("phone", phone.getText().toString());

//            Toast tst = Toast.makeText(this, gender.isChecked()? gender.getTextOn() : gender.getTextOff(), Toast.LENGTH_LONG);
//            tst.show();
                startActivity(i);
            }
        });
    }

    private boolean CheckAllFields() {
        boolean isChecked = true;
        if (name.length() == 0) {
            name.setError("This field is required");
            isChecked = false;
        }

        if (age.length() == 0) {
            age.setError("This field is required");
            isChecked = false;
        } else if(age.length()>3) {
            age.setError("Age must not be more than 3 digits");
            isChecked = false;
        }

        if (phone.length() == 0) {
            phone.setError("This field is required");
            isChecked = false;
        } else if(phone.length()<10 || phone.length()>10) {
            phone.setError("Phone number must be 10 digits");
            isChecked = false;
        }

        // after all validation return true.
        return isChecked;
    }
}