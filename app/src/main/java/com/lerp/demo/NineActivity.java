package com.lerp.demo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lerp.pano.ImagesStitch;
import com.shizhefei.view.largeimage.LargeImageView;
import com.shizhefei.view.largeimage.factory.FileBitmapDecoderFactory;

import androidx.appcompat.app.AppCompatActivity;

public class NineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.large_view);

        final LargeImageView largeImageView = findViewById(R.id.activity_layout);
        final View progressBar = findViewById(R.id.progress_bar);
        TextView tvMessage = findViewById(R.id.tv_message);
        tvMessage.setText("合成一张2*3的照片");

        new Thread(new Runnable() {
            @Override
            public void run() {
                //示例图片便宜比较大，这里用6张就够了
                Bitmap[] bitmaps = new Bitmap[6];
                bitmaps[0] = BitmapUtils.getBitmap(NineActivity.this, "medium04.jpg");
                bitmaps[1] = BitmapUtils.getBitmap(NineActivity.this, "medium05.jpg");
                bitmaps[2] = BitmapUtils.getBitmap(NineActivity.this, "medium07.jpg");
                bitmaps[3] = BitmapUtils.getBitmap(NineActivity.this, "medium08.jpg");
                bitmaps[4] = BitmapUtils.getBitmap(NineActivity.this, "medium10.jpg");
                bitmaps[5] = BitmapUtils.getBitmap(NineActivity.this, "medium11.jpg");

                final String result = ActivityMain.DIR + "nine.jpg";
                int[] ints = ImagesStitch.stitchImagesFromBitmaps(bitmaps, result,
                        ImagesStitch.TYPE_SPHERICAL, ImagesStitch.CORRECTION_DEFAULT,
                        0.16f, 0.16f, 200, 1f);

                if (ints[0] == 0 && !NineActivity.this.isDestroyed()) {
                    NineActivity.this.runOnUiThread(new Runnable() {
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
