package com.lerp.demo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import com.lerp.pano.ImagesStitch;
import com.shizhefei.view.largeimage.LargeImageView;
import com.shizhefei.view.largeimage.factory.FileBitmapDecoderFactory;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.large_view);

        final LargeImageView largeImageView = findViewById(R.id.activity_layout);
        final View progressBar = findViewById(R.id.progress_bar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //示例图片便宜比较大，这里用6张就够了
                Bitmap[] bitmaps = new Bitmap[6];
                bitmaps[0] = BitmapUtils.getBitmap(ActivityNine.this, "PANO0012.JPG");
                bitmaps[1] = BitmapUtils.getBitmap(ActivityNine.this, "PANO0013.JPG");
                bitmaps[2] = BitmapUtils.getBitmap(ActivityNine.this, "PANO0014.JPG");
                bitmaps[3] = BitmapUtils.getBitmap(ActivityNine.this, "PANO0015.JPG");
                bitmaps[4] = BitmapUtils.getBitmap(ActivityNine.this, "PANO0019.JPG");
                bitmaps[5] = BitmapUtils.getBitmap(ActivityNine.this, "PANO0020.JPG");

                final String result = ActivityMain.DIR + "nine.jpg";
                int[] ints = ImagesStitch.stitchImagesFromBitmaps(bitmaps, result,
                        ImagesStitch.TYPE_SPHERICAL, ImagesStitch.CORRECTION_DEFAULT,
                        0.16f, 0.16f, 200, 1f);

                if (ints[0] == 0 && !ActivityNine.this.isDestroyed()) {
                    ActivityNine.this.runOnUiThread(new Runnable() {
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
