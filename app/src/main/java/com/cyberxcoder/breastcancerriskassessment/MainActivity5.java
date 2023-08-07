package com.cyberxcoder.breastcancerriskassessment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    String name, age, gender, phone, hasAnyoneInFamily, maternalOrPaternalGrandMotherOrAunt, motherOrSister, motherAndSister, motherAndTwoSisters;
    String bodyStructure, didYouHaveBreastCancer, ageOfGivingBirth, mensturationAge, menopauseAge, doYouBreastFeed;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch didYouHaveBreastCancerObj, doYouBreastFeedObj;
    Button thirdToFourth;
    AutoCompleteTextView ageOfGivingBirthObj, bodyStructureObj, mensturationAgeObj, menopauseAgeObj;

    boolean hasItemSelectedBodyStructure, hasItemSelectedAgeOfGivingBirth, isAllFieldsChecked;
    boolean hasItemSelectedMensturationAge, hasItemSelectedMenopauseAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main5);

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

        ageOfGivingBirthObj = findViewById(R.id.ageOfGivingBirth);
        bodyStructureObj = findViewById(R.id.bodyStructure);
        mensturationAgeObj = findViewById(R.id.mensturationAge);
        menopauseAgeObj = findViewById(R.id.menopauseAge);
        thirdToFourth = findViewById(R.id.thirdToFourth);


        String[] bodyStructureItems = {"Underweight", "Normal", "Overweight"};
        ArrayAdapter<String> adapterBodyStructure = new ArrayAdapter<>(this, R.layout.body_structure_items, bodyStructureItems);
        bodyStructureObj.setAdapter(adapterBodyStructure);

        bodyStructureObj.setOnItemClickListener((adapterView, view, i1, l) -> {
            if(i1 >=0) {
                hasItemSelectedBodyStructure = true;
                bodyStructure = adapterBodyStructure.getItem(i1);
                bodyStructureObj.setError(null);
            }
        });

        String[] ageOfGivingBirthItems = {"Before age of 30", "After age of 30", "No children"};
        ArrayAdapter<String> adapterAgeOfGivingBirth = new ArrayAdapter<>(this, R.layout.age_of_giving_birth_items, ageOfGivingBirthItems);
        ageOfGivingBirthObj.setAdapter(adapterAgeOfGivingBirth);

        ageOfGivingBirthObj.setOnItemClickListener((adapterView, view, i1, l) -> {
            if(i1 >=0) {
                hasItemSelectedAgeOfGivingBirth = true;
                ageOfGivingBirth = adapterAgeOfGivingBirth.getItem(i1);
                ageOfGivingBirthObj.setError(null);
            }
        });

        String[] mensturationAgeItems = {"Above age 14", "Between age of 12 and 14", "Below age 12"};
        ArrayAdapter<String> adapterMensturationAge = new ArrayAdapter<>(this, R.layout.mensturation_age_items, mensturationAgeItems);
        mensturationAgeObj.setAdapter(adapterMensturationAge);

        mensturationAgeObj.setOnItemClickListener((adapterView, view, i1, l) -> {
            if(i1 >=0) {
                hasItemSelectedMensturationAge = true;
                mensturationAge = adapterMensturationAge.getItem(i1);
                mensturationAgeObj.setError(null);
            }
        });

        String[] menopauseAgeItems = {"Not applicable", "Below age 50", "Above age 50"};
        ArrayAdapter<String> adapterMenopauseAge = new ArrayAdapter<>(this, R.layout.menopause_age_items, menopauseAgeItems);
        menopauseAgeObj.setAdapter(adapterMenopauseAge);

        menopauseAgeObj.setOnItemClickListener((adapterView, view, i1, l) -> {
            if(i1 >=0) {
                hasItemSelectedMenopauseAge = true;
                menopauseAge = adapterMenopauseAge.getItem(i1);
                menopauseAgeObj.setError(null);
            }
        });

        thirdToFourth.setOnClickListener(view -> {
            didYouHaveBreastCancerObj = findViewById(R.id.didYouHaveBreastCancer);
            doYouBreastFeedObj = findViewById(R.id.doYouBreastFeed);

            isAllFieldsChecked = CheckAllFields();
            if(isAllFieldsChecked) {
                didYouHaveBreastCancer = didYouHaveBreastCancerObj.isChecked()? didYouHaveBreastCancerObj.getTextOn().toString() : didYouHaveBreastCancerObj.getTextOff().toString();
                doYouBreastFeed = doYouBreastFeedObj.isChecked()? doYouBreastFeedObj.getTextOn().toString() : doYouBreastFeedObj.getTextOff().toString();

                Intent i12 = new Intent(getApplicationContext(), MainActivity6.class);
                i12.putExtra("name", name);
                i12.putExtra("age", age);
                i12.putExtra("gender", gender);
                i12.putExtra("phone", phone);

                i12.putExtra("hasAnyoneInFamily", hasAnyoneInFamily);
                i12.putExtra("maternalOrPaternalGrandMotherOrAunt", maternalOrPaternalGrandMotherOrAunt);
                i12.putExtra("motherOrSister", motherOrSister);
                i12.putExtra("motherAndSister", motherAndSister);
                i12.putExtra("motherAndTwoSisters", motherAndTwoSisters);

                i12.putExtra("didYouHaveBreastCancer", didYouHaveBreastCancer);
                i12.putExtra("ageOfGivingBirth", ageOfGivingBirth);
                i12.putExtra("mensturationAge", mensturationAge);
                i12.putExtra("menopauseAge", menopauseAge);
                i12.putExtra("bodyStructure", bodyStructure);
                i12.putExtra("doYouBreastFeed", doYouBreastFeed);

                startActivity(i12);
            }
        });
    }

    private boolean CheckAllFields() {
        boolean isChecked = true;

        if(!hasItemSelectedBodyStructure) {
            bodyStructureObj.setError("Must select an item");
            isChecked = false;
        }

        if(!hasItemSelectedAgeOfGivingBirth) {
            ageOfGivingBirthObj.setError("Must select an item");
            isChecked = false;
        }

        if(!hasItemSelectedMensturationAge) {
            mensturationAgeObj.setError("Must select an item");
            isChecked = false;
        }

        if(!hasItemSelectedMenopauseAge) {
            menopauseAgeObj.setError("Must select an item");
            isChecked = false;
        }
        // after all validation return true.
        return isChecked;
    }
}