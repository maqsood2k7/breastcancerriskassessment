package com.cyberxcoder.breastcancerriskassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main8);

        TextView msgOneTV = findViewById(R.id.msgOneTV);
        TextView msgTwoTV = findViewById(R.id.msgTwoTV);
        Button showFullReport = findViewById(R.id.showFullReport);

        Intent i = getIntent();

        long id = i.getLongExtra("id", 0);
        ArrayList<Integer> colorCode = i.getIntegerArrayListExtra("colorCode");
        String msg1 = i.getStringExtra("msg1");
        String msg2 = i.getStringExtra("msg2");

        msgOneTV.setTextColor(Color.rgb(colorCode.get(0), colorCode.get(1), colorCode.get(2)));
        msgOneTV.setText(msg1);
        msgTwoTV.setText(msg2);

        showFullReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Report.class);
                i.putExtra("id", id);
                i.putExtra("reportType", "full");

                startActivity(i);
            }
        });

    }
}