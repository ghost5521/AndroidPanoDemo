package com.lerp.pano;

import android.content.Context;
import android.graphics.Bitmap;

public class ImagesStitch {
    public final static int OK = 0;
    public final static int ERR_NEED_MORE_IMGS = 1;
    public final static int ERR_HOMOGRAPHY_EST_FAIL = 2;
    public final static int ERR_CAMERA_PARAMS_ADJUST_FAIL = 3;

    public final static int TYPE_SPHERICAL = 0;
    public final static int TYPE_CYLINDRICAL = 1;
    public final static int TYPE_STEREOGRAPHIC = 2;
    public final static int TYPE_LINEAR = 3;

    public final static int CORRECTION_DEFAULT = 0;
    public final static int CORRECTION_HORI = 1;
    public final static int CORRECTION_VERT = 2;

    static {
        System.loadLibrary("libstitch");
    }

    public native static boolean init(Context context);

    /**
     * @param path           输入图片路径
     * @param outPath        输出图片路径
     * @param panoType       全景类型，0球面，1圆柱，2小行星
     * @param correction     波段修正，水平或垂直
     * @param widthRatio     宽度最多裁掉的比例，为0表示宽度不需要裁剪
     * @param heightRatio    高度最多裁掉的比例,为0表示高度不需要裁剪
     * @param length         裁剪参数，值越大裁的比例越小，默认500
     * @return [0] 状态码
     * [1]拼接后宽度
     * [2]拼接后的高度
     */
    public native static int[] stitchImages(String path[], String outPath,
                                            int panoType, int correction,
                                            float widthRatio, float heightRatio,
                                            int length, float scale);

    public native static int[] stitchImagesFromBitmaps(Bitmap bitmaps[], String outPath,
                                                       int panoType, int correction,
                                                       float widthRatio, float heightRatio,
                                                       int length, float scale);

    /**
     * 将合成好的全景照片转换成2:1
     *
     * @param input
     * @param output
     * @param mode   BORDER_CONSTANT    = 0, //!< `iiiiii|abcdefgh|iiiiiii`  with some specified `i`
     *               BORDER_REPLICATE   = 1, //!< `aaaaaa|abcdefgh|hhhhhhh`
     *               BORDER_REFLECT     = 2, //!< `fedcba|abcdefgh|hgfedcb`
     *               BORDER_WRAP        = 3, //!< `cdefgh|abcdefgh|abcdefg`
     *               BORDER_REFLECT_101 = 4, //!< `gfedcb|abcdefgh|gfedcba`
     *               BORDER_TRANSPARENT = 5, //!< `uvwxyz|absdefgh|ijklmno`
     */
    public native static void toPano360(String input, String output, float topRatio, int mode);
}
