package com.example.dwayne.project_i;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudyActivity extends AppCompatActivity {

    private Button b1;
    private Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        b1 = (Button) findViewById(R.id.nihonbutton);
        b2 = (Button) findViewById(R.id.hangukbutton);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                launchCard(0);
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                launchCard(1);
            }
        });

    }


    private void launchCard(int x){
        if(x==0) {
            Intent intent = new Intent(this, CardActivity.class);
            startActivity(intent);
        }

        else {
            Intent intent = new Intent(this, CardActivity.class);
            startActivity(intent);
        }
    }

}
