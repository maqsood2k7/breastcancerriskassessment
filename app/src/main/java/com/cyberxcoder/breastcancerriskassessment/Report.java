package com.cyberxcoder.breastcancerriskassessment;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class Report extends AppCompatActivity {

    RecyclerView dataList;
    String whatsAppMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_report);

        Intent i = getIntent();
        long id = i.getLongExtra("id", 0);
        String reportType = i.getStringExtra("reportType");

        DBHandler dbHandler = new DBHandler(Report.this);
        String[] data = dbHandler.selectPatientRecord(id, reportType);

        if(reportType.equals("half"))
        {
            String name = String.format("%-25s: %s", "Name", data[0]);
            String age = String.format("%-25s: %s", "Age", data[1]);
            String gender = String.format("%-25s: %s", "Gender", data[2].equals("M")? "Male" : "Female");
            String phone = String.format("%-25s: %s", "Phone Number", data[3]);

            String temp = null;
            if(data[4].equals("Y")){
                if(data[5].equals("Y"))
                    temp = "Maternal/Paternal Grand Mother/Aunt";
                else if(data[6].equals("Y"))
                    temp = "Mother/Sister";
                else if(data[7].equals("Y"))
                    temp = "Mother and Sister";
                else if(data[8].equals("Y"))
                    temp = "Mother and two Sisters";
            }

            String hasAnyoneInFamily = String.format("My %s has got Cancer", temp);
            String didYouHaveBreastCancer = String.format("%-27s%s", "Had breast cancer? ", data[9].equals("Y")? "Yes" : "No");
            String ageOfGivingBirth = String.format("%-25s: %s", "Age of giving birth", data[10]);
            String mensturationAge = String.format("%-25s: %s", "Mensturation age", data[11]);
            String menopauseAge = String.format("%-25s: %s", "Menopause age", data[12]);
            String bodyStructure = String.format("%-25s: %s", "Body structure", data[13]);
            String doYouBreastFeed = String.format("%-27s%s", "Do you breast feed? ", data[14].equals("Y")? "Yes" : "No");

            String[] newData = {name, age, gender, phone, hasAnyoneInFamily, didYouHaveBreastCancer, ageOfGivingBirth, mensturationAge, menopauseAge, bodyStructure, doYouBreastFeed};
            dataList = findViewById(R.id.dataList);
            dataList.setLayoutManager(new LinearLayoutManager(this));
            AdapterForRecyclerView adapter = new AdapterForRecyclerView(this, newData);
            dataList.setAdapter(adapter);

            whatsAppMsg = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", name, age, gender, phone, hasAnyoneInFamily, didYouHaveBreastCancer, ageOfGivingBirth, mensturationAge, menopauseAge, bodyStructure, doYouBreastFeed);
        } else {
            String name = String.format("%-25s: %s", "Name", data[0]);
            String age = String.format("%-25s: %s", "Age", data[1]);
            String gender = String.format("%-25s: %s", "Gender", data[2].equals("M")? "Male" : "Female");
            String phone = String.format("%-25s: %s", "Phone Number", data[3]);

            String temp = null;
            if(data[4].equals("Y")){
                if(data[5].equals("Y"))
                    temp = "Maternal/Paternal Grand Mother/Aunt";
                else if(data[6].equals("Y"))
                    temp = "Mother/Sister";
                else if(data[7].equals("Y"))
                    temp = "Mother and Sister";
                else if(data[8].equals("Y"))
                    temp = "Mother and two Sisters";
            }

            String hasAnyoneInFamily = String.format("My %s has got Cancer", temp);
            String didYouHaveBreastCancer = String.format("%-27s%s", "Had breast cancer? ", data[9].equals("Y")? "Yes" : "No");
            String ageOfGivingBirth = String.format("%-25s: %s", "Age of giving birth", data[10]);
            String mensturationAge = String.format("%-25s: %s", "Mensturation age", data[11]);
            String menopauseAge = String.format("%-25s: %s", "Menopause age", data[12]);
            String bodyStructure = String.format("%-25s: %s", "Body structure", data[13]);
            String doYouBreastFeed = String.format("%-27s%s", "Do you breast feed? ", data[14].equals("Y")? "Yes" : "No");
            String lumps = String.format("%-27s%s", "Having lumps in breast? ", data[15].equals("Y")? "Yes" : "No");
            String nippledischarge = String.format("%-27s%s", "Having nipple discharge? ", data[16].equals("Y")? "Yes" : "No");
            String priorbreastinjury = String.format("%-27s%s", "Having prior breast injury? ", data[17].equals("Y")? "Yes" : "No");
            String rednessorswelling = String.format("%-27s%s", "Having redness/swelling? ", data[18].equals("Y")? "Yes" : "No");
            String tendernessorpain = String.format("%-27s%s", "Having tenderness/pain? ", data[19].equals("Y")? "Yes" : "No");
            String contraceptives = String.format("%-27s%s", "Do you use contraceptive? ", data[20].equals("Y")? "Yes" : "No");
            String largebreasts = String.format("%-27s%s", "Having large breast? ", data[21].equals("Y")? "Yes" : "No");
            String others = String.format("%s", data[22]==null? "No additional info provided" : "");

            String[] newData = {name, age, gender, phone, hasAnyoneInFamily, didYouHaveBreastCancer, ageOfGivingBirth, mensturationAge, menopauseAge, bodyStructure, doYouBreastFeed, lumps, nippledischarge, priorbreastinjury, rednessorswelling, tendernessorpain, contraceptives, largebreasts, others};
            dataList = findViewById(R.id.dataList);
            dataList.setLayoutManager(new LinearLayoutManager(this));
            AdapterForRecyclerView adapter = new AdapterForRecyclerView(this, newData);
            dataList.setAdapter(adapter);

            whatsAppMsg = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", name, age, gender, phone, hasAnyoneInFamily, didYouHaveBreastCancer, ageOfGivingBirth, mensturationAge, menopauseAge, bodyStructure, doYouBreastFeed, lumps, nippledischarge, priorbreastinjury, rednessorswelling, tendernessorpain, contraceptives, largebreasts, others);
        }

        FloatingActionButton sendToWhatsApp = findViewById(R.id.sendToWhatsApp);
        sendToWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWhatsApp("9014016100", whatsAppMsg);
            }
        });
    }
    private void openWhatsApp(String phoneNumber, String msg) {
        String smsNumber = "91"+phoneNumber; // E164 format without '+' sign
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
        sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
        sendIntent.setPackage("com.whatsapp");
        if (sendIntent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(this, "Error: WhatsApp isn't installed", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(sendIntent);
    }

}