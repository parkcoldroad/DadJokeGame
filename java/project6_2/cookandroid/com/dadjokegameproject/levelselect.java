package project6_2.cookandroid.com.dadjokegameproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class levelselect extends AppCompatActivity {

    ImageButton level1Btn, level2Btn, level3Btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levelselect);


        level1Btn = (ImageButton) findViewById(R.id.level1btn);
        level2Btn = (ImageButton) findViewById(R.id.level2btn);
        level3Btn = (ImageButton) findViewById(R.id.level3btn);


        level1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), level1.class);
                startActivity(intent);
            }
        });

        level2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), level2.class);
                startActivity(intent);
            }
        });

        level3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), level3.class);
                startActivity(intent);
            }
        });

    }
}
