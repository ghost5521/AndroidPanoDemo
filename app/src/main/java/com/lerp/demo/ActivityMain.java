package com.lerp.demo;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.lerp.pano.ImagesStitch;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;
import kr.co.namee.permissiongen.PermissionGen;

public class ActivityMain extends AppCompatActivity {

    public static final String DIR = Environment.getExternalStorageDirectory().getPath() + "/360pano/";

    private String[] permissions = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file = new File(DIR);
        if (!file.exists()) file.mkdirs();

        ImagesStitch.init(this);

        if (Build.VERSION.SDK_INT >= 23) {
            PermissionGen.with(this)
                    .addRequestCode(200)
                    .permissions(permissions)
                    .request();
        }


        findViewById(R.id.btn_vertical).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, VerticalActivity.class));
            }
        });

        findViewById(R.id.btn_3x3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, NineActivity.class));
            }
        });

        findViewById(R.id.btn_360).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, PanoramaActivity.class));
            }
        });

        findViewById(R.id.btn_ste).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMain.this.startActivity(new Intent(ActivityMain.this, StereographicActivity.class));
            }
        });
    }
}
