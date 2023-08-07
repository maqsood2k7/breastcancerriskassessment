package com.cyberxcoder.breastcancerriskassessment;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    String name;
    String age;
    String gender;
    String phone;
    String hasAnyoneInFamily;
    String maternalOrPaternalGrandMotherOrAunt;
    String motherOrSister;
    String motherAndSister;
    String motherAndTwoSisters;
    String didYouHaveBreastCancer;
    String ageOfGivingBirth;
    String mensturationAge;
    String menopauseAge;
    String bodyStructure;
    String doYouBreastFeed;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main6);

        int totalScore = 0;

        Intent i = getIntent();
        name = i.getStringExtra("name");
        age = i.getStringExtra("age");
        gender = i.getStringExtra("gender");
        phone = i.getStringExtra("phone");

        hasAnyoneInFamily = i.getStringExtra("hasAnyoneInFamily");
        maternalOrPaternalGrandMotherOrAunt = i.getStringExtra("maternalOrPaternalGrandMotherOrAunt");
        motherOrSister = i.getStringExtra("motherOrSister");
        motherAndSister = i.getStringExtra("motherAndSister");
        motherAndTwoSisters = i.getStringExtra("motherAndTwoSisters");

        didYouHaveBreastCancer = i.getStringExtra("didYouHaveBreastCancer");
        ageOfGivingBirth = i.getStringExtra("ageOfGivingBirth");
        mensturationAge = i.getStringExtra("mensturationAge");
        menopauseAge = i.getStringExtra("menopauseAge");
        bodyStructure = i.getStringExtra("bodyStructure");
        doYouBreastFeed = i.getStringExtra("doYouBreastFeed");

        if(Integer.parseInt(age)<30) {
            totalScore += 2;
        } else if(Integer.parseInt(age)>=30 && Integer.parseInt(age)<40) {
            totalScore += 5;
        } else if(Integer.parseInt(age)>=40 && Integer.parseInt(age)<60) {
            totalScore += 8;
        } else {
            totalScore += 10;
        }

        if(hasAnyoneInFamily.equals("Y")) {
            if(maternalOrPaternalGrandMotherOrAunt.equals("Y")) {
                totalScore += 5;
            } else if(motherOrSister.equals("Y")) {
                totalScore += 10;
            } else if(motherAndSister.equals("Y")) {
                totalScore += 15;
            } else if(motherAndTwoSisters.equals("Y")) {
                totalScore += 20;
            }
        }

        if(didYouHaveBreastCancer.equals("Y")) {
            totalScore += 10;
        }

        if(ageOfGivingBirth.equals("After Age Of 30"))
            totalScore += 5;
        else if(ageOfGivingBirth.equals("No Children"))
            totalScore += 10;

        if(mensturationAge.equals("Above age 14"))
            totalScore += 5;
        else if(mensturationAge.equals("Between age of 12 and 14"))
            totalScore += 10;
        else
            totalScore += 15;

        if(menopauseAge.equals("Below age 50"))
            totalScore += 5;
        else if(menopauseAge.equals("Above age 50"))
            totalScore += 10;

        if(bodyStructure.equals("Underweight"))
            totalScore += 5;
        else if(bodyStructure.equals("Normal"))
            totalScore += 10;
        else
            totalScore += 15;


        if(doYouBreastFeed.equals("Y"))
            totalScore += 5;
        else
            totalScore += 10;

        dbHandler = new DBHandler(MainActivity6.this);
        long id = dbHandler.addPatientRecord(name, age, gender, phone, hasAnyoneInFamily, maternalOrPaternalGrandMotherOrAunt, motherOrSister, motherAndSister, motherAndTwoSisters, didYouHaveBreastCancer, ageOfGivingBirth, mensturationAge, menopauseAge, bodyStructure, doYouBreastFeed);

        String msg1 = "";
        String msg2 = "";
        TextView msgOneTV = findViewById(R.id.msgOneTV);
        TextView msgTwoTV = findViewById(R.id.msgTwoTV);
        Button showFullReport = findViewById(R.id.showFullReport);
        Button fourthToFifth = findViewById(R.id.fourthToFifth);

        if(totalScore>=80){
            msg1 = "High Risk";
            msg2 = "Immediate Screening Required";
            msgOneTV.setTextColor(Color.rgb(255, 0, 0));
            fourthToFifth.setEnabled(true);
        }
        else if(totalScore>=60) {
            msg1 = "Moderate Risk";
            msg2 = "Recommended to assess further";
            msgOneTV.setTextColor(Color.rgb(255, 87, 51));
            fourthToFifth.setEnabled(true);
        }
        else if(totalScore>=40) {
            msg1 = "Low Risk";
            msg2 = "No further assessment is required";
            msgOneTV.setTextColor(Color.rgb(255, 254, 0));
            fourthToFifth.setEnabled(false);
        }
        else {
            msg1 = "No Risk";
            msg2 = "No further assessment is required";
            msgOneTV.setTextColor(Color.rgb(0, 216, 2));
            fourthToFifth.setEnabled(false);
        }

        msgOneTV.setText(msg1);
        msgTwoTV.setText(msg2);

        fourthToFifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity7.class);
                i.putExtra("id", id);

                startActivity(i);
            }
        });

        showFullReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Report.class);
                i.putExtra("id", id);
                i.putExtra("reportType", "half");

                startActivity(i);
            }
        });
    }
}

