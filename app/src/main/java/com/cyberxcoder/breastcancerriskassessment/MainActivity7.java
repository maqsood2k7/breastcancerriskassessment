package com.cyberxcoder.breastcancerriskassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity7 extends AppCompatActivity {

    String lumps;
    String nippledischarge;
    String priorbreastinjury;
    String rednessorswelling;
    String tendernessorpain;
    String contraceptives;
    String largebreasts;
    String others;

    Switch lumpsInBreast, nippleDischarge, priorBreastInjury, breastRednessOrSwelling;
    Switch breastTendernessOrPain, useOfOralContraceptives, largeBreasts;

    int advancedScore = 0;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main7);

        Intent i = getIntent();
        long id = i.getLongExtra("id", 0);

        lumpsInBreast = findViewById(R.id.lumps);
        nippleDischarge = findViewById(R.id.nippleDischarge);
        priorBreastInjury = findViewById(R.id.priorBreastInjury);
        breastRednessOrSwelling = findViewById(R.id.breastRednessOrSwelling);
        breastTendernessOrPain = findViewById(R.id.breastTendernessOrPain);
        useOfOralContraceptives = findViewById(R.id.useOfOralContraceptives);
        largeBreasts = findViewById(R.id.largeBreasts);

        Button fifthToSixth = findViewById(R.id.fifthToSixth);
        dbHandler = new DBHandler(MainActivity7.this);
        fifthToSixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lumps = (String) (lumpsInBreast.isChecked() ? lumpsInBreast.getTextOn() : lumpsInBreast.getTextOff());
                nippledischarge = (String) (nippleDischarge.isChecked()? nippleDischarge.getTextOn() : nippleDischarge.getTextOff());
                priorbreastinjury = (String) (priorBreastInjury.isChecked() ? priorBreastInjury.getTextOn() : priorBreastInjury.getTextOff());
                rednessorswelling = (String) (breastRednessOrSwelling.isChecked() ? breastRednessOrSwelling.getTextOn() : breastRednessOrSwelling.getTextOff());
                tendernessorpain = (String) (breastTendernessOrPain.isChecked() ? breastTendernessOrPain.getTextOn() : breastTendernessOrPain.getTextOff());
                contraceptives = (String) (useOfOralContraceptives.isChecked() ? useOfOralContraceptives.getTextOn() : useOfOralContraceptives.getTextOff());
                largebreasts = (String) (largeBreasts.isChecked() ? largeBreasts.getTextOn() : largeBreasts.getTextOff());

                advancedScore += lumps.equals("Y") ? 10 : 0;
                advancedScore += nippledischarge.equals("Y") ? 10 : 0;
                advancedScore += priorbreastinjury.equals("Y") ? 10 : 0;
                advancedScore += rednessorswelling.equals("Y") ? 10 : 0;
                advancedScore += tendernessorpain.equals("Y") ? 10 : 0;
                advancedScore += contraceptives.equals("Y") ? 10 : 0;
                advancedScore += largebreasts.equals("Y") ? 10 : 0;

                String msg1, msg2;
                ArrayList<Integer> colorCode = new ArrayList<>();

                if(advancedScore>=10){
                    msg1 = "On High Risk";
                    msg2 = "Visiting a doctor is highly recommended";
                    colorCode.add(255);
                    colorCode.add(0);
                    colorCode.add(0);
                } else {
                    msg1 = "Caution!";
                    msg2 = "Be cautious and perform BSE as\nyou already fall under risk category";
                    colorCode.add(255);
                    colorCode.add(87);
                    colorCode.add(51);
                }

                Intent i = new Intent(getApplicationContext(), MainActivity8.class);
                i.putExtra("id", id);
                i.putExtra("msg1", msg1);
                i.putExtra("msg2", msg2);
                i.putIntegerArrayListExtra("colorCode", colorCode);
                dbHandler.updatePatientRecord(id, lumps, nippledischarge, priorbreastinjury, rednessorswelling, tendernessorpain, contraceptives, largebreasts, null);

                startActivity(i);
            }
        });

    }
}