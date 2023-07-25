package com.cyberxcoder.breastcancerriskassessment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    String name, age, gender, phone, hasAnyoneInFamily, maternalOrPaternalGrandMotherOrAunt, motherOrSister, motherAndSister, motherAndTwoSisters;
    String bodyStructure, didYouHaveBreastCancer, ageOfGivingBirth, mensturationAge, menopauseAge, doYouBreastFeed;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch didYouHaveBreastCancerObj, doYouBreastFeedObj;
    EditText ageOfGivingBirthObj, mensturationAgeObj, menopauseAgeObj;
    Button thirdToFourth;
    AutoCompleteTextView bodyStructureObj;

    boolean hasItemSelected = false, isAllFieldsChecked;

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

        bodyStructureObj = findViewById(R.id.bodyStructure);
        thirdToFourth = findViewById(R.id.thirdToFourth);

        String[] bodyStructureItems = {"Underweight", "Normal", "Overweight"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.body_structure_items, bodyStructureItems);
        bodyStructureObj.setAdapter(adapter);

        bodyStructureObj.setOnItemClickListener((adapterView, view, i1, l) -> {
            if(i1 >=0) {
                hasItemSelected = true;
                bodyStructure = adapter.getItem(i1);
                bodyStructureObj.setError(null);
                Toast.makeText(getApplicationContext(), bodyStructure + " " + i1, Toast.LENGTH_LONG).show();
            }
        });

        thirdToFourth.setOnClickListener(view -> {
            didYouHaveBreastCancerObj = findViewById(R.id.didYouHaveBreastCancer);
            ageOfGivingBirthObj = findViewById(R.id.ageOfGivingBirth);
            mensturationAgeObj = findViewById(R.id.mensturationAge);
            menopauseAgeObj = findViewById(R.id.menopauseAge);
            doYouBreastFeedObj = findViewById(R.id.doYouBreastFeed);

            isAllFieldsChecked = CheckAllFields();
            if(isAllFieldsChecked) {
                didYouHaveBreastCancer = didYouHaveBreastCancerObj.isChecked()? didYouHaveBreastCancerObj.getTextOn().toString() : didYouHaveBreastCancerObj.getTextOff().toString();
                ageOfGivingBirth = ageOfGivingBirthObj.getText().toString();
                mensturationAge = mensturationAgeObj.getText().toString();
                menopauseAge = menopauseAgeObj.getText().toString();
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
        if (ageOfGivingBirthObj.length() == 0) {
            ageOfGivingBirthObj.setError("This field is required");
            isChecked = false;
        } else if(ageOfGivingBirthObj.length()>3) {
            ageOfGivingBirthObj.setError("Must not be more than 3 digits");
            isChecked = false;
        }

        if (mensturationAgeObj.length() == 0) {
            mensturationAgeObj.setError("This field is required");
            isChecked = false;
        } else if(mensturationAgeObj.length()>3) {
            mensturationAgeObj.setError("Must not be more than 3 digits");
            isChecked = false;
        }

        if (menopauseAgeObj.length() == 0) {
            menopauseAgeObj.setText("0");
        } else if(menopauseAgeObj.length()>3) {
            menopauseAgeObj.setError("Must not be more than 3 digits");
            isChecked = false;
        }

        if(!hasItemSelected) {
            bodyStructureObj.setError("Must select an item");
            isChecked = false;
        }
        // after all validation return true.
        return isChecked;
    }
}