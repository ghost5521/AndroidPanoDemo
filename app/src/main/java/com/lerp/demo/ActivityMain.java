package com.lerp.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.lerp.pano.ImagesStitch;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMain extends AppCompatActivity {

    public static final String DIR = Environment.getExternalStorageDirectory().getPath() + "/360pano/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file = new File(DIR);
        if (!file.exists()) file.mkdirs();

        ImagesStitch.init(this);


        findViewById(R.id.btn_vertical).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, VerticalActivity.class));
            }
        });

        findViewById(R.id.btn_3x3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, ActivityNine.class));
            }
        });

        findViewById(R.id.btn_360).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, Activity360.class));
            }
        });

        findViewById(R.id.btn_ste).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, ActivitySte.class));
            }
        });
    }
}
