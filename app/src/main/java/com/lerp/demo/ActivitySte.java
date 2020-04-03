package com.lerp.demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.lerp.pano.ImagesStitch;
import com.shizhefei.view.largeimage.LargeImageView;
import com.shizhefei.view.largeimage.factory.FileBitmapDecoderFactory;

import androidx.appcompat.app.AppCompatActivity;

import static com.lerp.pano.ImagesStitch.TYPE_CYLINDRICAL;
import static com.lerp.pano.ImagesStitch.TYPE_PANINI;

public class ActivitySte extends AppCompatActivity {

    private FrameLayout mViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.large_view);

        final LargeImageView largeImageView = findViewById(R.id.activity_layout);
        final View progressBar = findViewById(R.id.progress_bar);
        mViewGroup = findViewById(R.id.root_view);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap[] bitmaps = new Bitmap[4];
                bitmaps[0] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0001.JPG");
                bitmaps[1] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0002.JPG");
                bitmaps[2] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0003.JPG");
                bitmaps[3] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0004.JPG");

                final String image_1 = ActivityMain.DIR + "image_1.jpg";
                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_1,
                        TYPE_CYLINDRICAL, ImagesStitch.CORRECTION_VERT,
                        0.18f, 0, 300, 0.5f);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_1));
                    }
                });

                bitmaps = new Bitmap[3];
                bitmaps[0] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0005.JPG");
                bitmaps[1] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0006.JPG");
                bitmaps[2] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0007.JPG");
                final String image_2 = ActivityMain.DIR + "image_2.jpg";

                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_2,
                        TYPE_PANINI, ImagesStitch.CORRECTION_VERT,
                        0.18f, 0, 300, 0.5f);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_2));
                    }
                });

                bitmaps[0] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0008.JPG");
                bitmaps[1] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0009.JPG");
                bitmaps[2] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0010.JPG");
                final String image_3 = ActivityMain.DIR + "image_3.jpg";

                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_3,
                        TYPE_PANINI, ImagesStitch.CORRECTION_VERT,
                        0.18f, 0, 300, 0.5f);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_3));
                    }
                });

                bitmaps[0] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0011.JPG");
                bitmaps[1] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0012.JPG");
                bitmaps[2] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0013.JPG");
                final String image_4 = ActivityMain.DIR + "image_4.jpg";

                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_4,
                        TYPE_PANINI, ImagesStitch.CORRECTION_VERT,
                        0.18f, 0, 300, 0.5f);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_4));
                    }
                });

                bitmaps = new Bitmap[4];
                bitmaps[0] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0014.JPG");
                bitmaps[1] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0015.JPG");
                bitmaps[2] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0016.JPG");
                bitmaps[3] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0017.JPG");
                final String image_5 = ActivityMain.DIR + "image_5.jpg";

                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_5,
                        TYPE_CYLINDRICAL, ImagesStitch.CORRECTION_VERT,
                        0.18f, 0, 300, 0.5f);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_5));
                    }
                });

                bitmaps = new Bitmap[3];
                bitmaps[0] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0018.JPG");
                bitmaps[1] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0019.JPG");
                bitmaps[2] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0020.JPG");
                final String image_6 = ActivityMain.DIR + "image_6.jpg";

                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_6,
                        TYPE_PANINI, ImagesStitch.CORRECTION_VERT,
                        0.18f, 0, 300, 0.5f);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_6));
                    }
                });

                bitmaps[0] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0021.JPG");
                bitmaps[1] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0022.JPG");
                bitmaps[2] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0023.JPG");
                final String image_7 = ActivityMain.DIR + "image_7.jpg";

                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_7,
                        TYPE_PANINI, ImagesStitch.CORRECTION_VERT,
                        0.18f, 0, 300, 0.5f);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_7));
                    }
                });

                bitmaps[0] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0024.JPG");
                bitmaps[1] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0025.JPG");
                bitmaps[2] = BitmapUtils.getBitmap(ActivitySte.this, "PANO0026.JPG");
                final String image_8 = ActivityMain.DIR + "image_8.jpg";

                ImagesStitch.stitchImagesFromBitmaps(bitmaps, image_8,
                        TYPE_PANINI, ImagesStitch.CORRECTION_VERT,
                        0.18f, 0, 300, 0.5f);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        largeImageView.setImage(new FileBitmapDecoderFactory(image_8));
                    }
                });

                bitmaps = new Bitmap[8];
                bitmaps[0] = BitmapFactory.decodeFile(image_1);
                bitmaps[1] = BitmapFactory.decodeFile(image_2);
                bitmaps[2] = BitmapFactory.decodeFile(image_3);
                bitmaps[3] = BitmapFactory.decodeFile(image_4);
                bitmaps[4] = BitmapFactory.decodeFile(image_5);
                bitmaps[5] = BitmapFactory.decodeFile(image_6);
                bitmaps[6] = BitmapFactory.decodeFile(image_7);
                bitmaps[7] = BitmapFactory.decodeFile(image_8);

                final String result = ActivityMain.DIR + "result.jpg";
                ImagesStitch.stitchImagesFromBitmaps(bitmaps, result,
                        ImagesStitch.TYPE_STEREOGRAPHIC, ImagesStitch.CORRECTION_DEFAULT,
                        0.2f, 0.2f, 300, 1f);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        largeImageView.setImage(new FileBitmapDecoderFactory(result));
                    }
                });
            }
        }).start();

    }
}
