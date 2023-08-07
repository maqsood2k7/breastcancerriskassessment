package com.cyberxcoder.breastcancerriskassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity4 extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch hasAnyoneInFamily, maternalOrPaternalGrandMotherOrAunt, motherOrSister, motherAndSister, motherAndTwoSisters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main4);

        String name, age, gender, phone;
        Intent i = getIntent();

        name = i.getStringExtra("name");
        age = i.getStringExtra("age");
        gender = i.getStringExtra("gender");
        phone = i.getStringExtra("phone");

        hasAnyoneInFamily = findViewById(R.id.lumps);
        maternalOrPaternalGrandMotherOrAunt = findViewById(R.id.nippleDischarge);
        motherOrSister = findViewById(R.id.priorBreastInjury);
        motherAndSister = findViewById(R.id.breastRednessOrSwelling);
        motherAndTwoSisters = findViewById(R.id.breastTendernessOrPain);

//        // To Enable/Disable Switches
//        if(hasAnyoneInFamily.isChecked()) {
//            maternalOrPaternalGrandMotherOrAunt.setEnabled(true);
//            motherOrSister.setEnabled(true);
//            motherAndSister.setEnabled(true);
//            motherAndTwoSisters.setEnabled(true);
//        } else {
//            maternalOrPaternalGrandMotherOrAunt.setEnabled(false);
//            motherOrSister.setEnabled(false);
//            motherAndSister.setEnabled(false);
//            motherAndTwoSisters.setEnabled(false);
//        }

        hasAnyoneInFamily.setOnCheckedChangeListener((compoundButton, b) -> {
            if(hasAnyoneInFamily.isChecked()) {
                maternalOrPaternalGrandMotherOrAunt.setChecked(true);
                maternalOrPaternalGrandMotherOrAunt.setEnabled(true);
                motherOrSister.setEnabled(true);
                motherAndSister.setEnabled(true);
                motherAndTwoSisters.setEnabled(true);
            } else {
                maternalOrPaternalGrandMotherOrAunt.setEnabled(false);
                motherOrSister.setEnabled(false);
                motherAndSister.setEnabled(false);
                motherAndTwoSisters.setEnabled(false);
                maternalOrPaternalGrandMotherOrAunt.setChecked(false);
                motherOrSister.setChecked(false);
                motherAndSister.setChecked(false);
                motherAndTwoSisters.setChecked(false);
            }
        });

        maternalOrPaternalGrandMotherOrAunt.setOnCheckedChangeListener((compoundButton, b) -> {
            if(maternalOrPaternalGrandMotherOrAunt.isChecked()) {
                motherOrSister.setChecked(false);
                motherAndSister.setChecked(false);
                motherAndTwoSisters.setChecked(false);
            }
        });

        motherOrSister.setOnCheckedChangeListener((compoundButton, b) -> {
            if(motherOrSister.isChecked()) {
                maternalOrPaternalGrandMotherOrAunt.setChecked(false);
                motherAndSister.setChecked(false);
                motherAndTwoSisters.setChecked(false);
            }
        });

        motherAndSister.setOnCheckedChangeListener((compoundButton, b) -> {
            if(motherAndSister.isChecked()) {
                maternalOrPaternalGrandMotherOrAunt.setChecked(false);
                motherOrSister.setChecked(false);
                motherAndTwoSisters.setChecked(false);
            }
        });

        motherAndTwoSisters.setOnCheckedChangeListener((compoundButton, b) -> {
            if(motherAndTwoSisters.isChecked()) {
                maternalOrPaternalGrandMotherOrAunt.setChecked(false);
                motherOrSister.setChecked(false);
                motherAndSister.setChecked(false);
            }
        });

        Button secondToThird = findViewById(R.id.fifthToSixth);
        secondToThird.setOnClickListener(view -> {
            Intent i1 = new Intent(getApplicationContext(), MainActivity5.class);
            i1.putExtra("name", name);
            i1.putExtra("age", age);
            i1.putExtra("gender", gender);
            i1.putExtra("phone", phone);

            i1.putExtra("hasAnyoneInFamily", hasAnyoneInFamily.isChecked()? hasAnyoneInFamily.getTextOn() : hasAnyoneInFamily.getTextOff());
            i1.putExtra("maternalOrPaternalGrandMotherOrAunt", maternalOrPaternalGrandMotherOrAunt.isChecked()? maternalOrPaternalGrandMotherOrAunt.getTextOn() : maternalOrPaternalGrandMotherOrAunt.getTextOff());
            i1.putExtra("motherOrSister", motherOrSister.isChecked()? motherOrSister.getTextOn() : motherOrSister.getTextOff());
            i1.putExtra("motherAndSister", motherAndSister.isChecked()? motherAndSister.getTextOn() : motherAndSister.getTextOff());
            i1.putExtra("motherAndTwoSisters", motherAndTwoSisters.isChecked()? motherAndTwoSisters.getTextOn() : motherAndTwoSisters.getTextOff());

            startActivity(i1);
        });
    }
}