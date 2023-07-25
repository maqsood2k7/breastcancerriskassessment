package com.cyberxcoder.breastcancerriskassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

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

//        if(Integer.parseInt(ageOfGivingBirth))



        dbHandler = new DBHandler(MainActivity6.this);
        dbHandler.addPatientRecord(name, age, gender, phone, hasAnyoneInFamily, maternalOrPaternalGrandMotherOrAunt, motherOrSister, motherAndSister, motherAndTwoSisters, didYouHaveBreastCancer, ageOfGivingBirth, mensturationAge, menopauseAge, bodyStructure, doYouBreastFeed);
    }
}