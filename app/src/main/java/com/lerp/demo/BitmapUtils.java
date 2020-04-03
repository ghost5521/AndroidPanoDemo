package com.lerp.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO
 * version: V1.0 <描述当前版本功能>
 * fileName: com.lerp.demo.BitmapUtils
 * author: liuping
 * date: 2020/4/2 16:56
 */
public class BitmapUtils {

    public static Bitmap getBitmap(final Context context, final String name) {
        try {
            InputStream inputStream = context.getAssets().open(name);
            return BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
