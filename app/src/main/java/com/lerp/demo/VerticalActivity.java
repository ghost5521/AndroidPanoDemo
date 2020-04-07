package com.lerp.demo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lerp.pano.ImagesStitch;
import com.shizhefei.view.largeimage.LargeImageView;
import com.shizhefei.view.largeimage.factory.FileBitmapDecoderFactory;

import androidx.appcompat.app.AppCompatActivity;

public class VerticalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.large_view);

        final LargeImageView largeImageView = findViewById(R.id.activity_layout);
        final View progressBar = findViewById(R.id.progress_bar);
        TextView tvMessage = findViewById(R.id.tv_message);
        tvMessage.setText("将竖直拍摄的几张照片拼接成一张");


        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap[] bitmaps = new Bitmap[4];
                bitmaps[0] = BitmapUtils.getBitmap(VerticalActivity.this, "medium10.jpg");
                bitmaps[1] = BitmapUtils.getBitmap(VerticalActivity.this, "medium11.jpg");
                bitmaps[2] = BitmapUtils.getBitmap(VerticalActivity.this, "medium12.jpg");
                bitmaps[3] = BitmapUtils.getBitmap(VerticalActivity.this, "medium19.jpg");

                final String result = ActivityMain.DIR + "vertical.jpg";
                int[] ints = ImagesStitch.stitchImagesFromBitmaps(bitmaps, result,
                        ImagesStitch.TYPE_SPHERICAL, ImagesStitch.CORRECTION_VERT,
                        0.2f, 0.03f, 100, 1f);

                if (ints[0] == 0 && !VerticalActivity.this.isDestroyed()) {
                    VerticalActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            largeImageView.setImage(new FileBitmapDecoderFactory(result));
                        }
                    });
                }
            }
        }).start();

    }
}
