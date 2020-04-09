## 主要特点：
1. 合成照片质量可自由设置，可以做到分辨率无损失合成
2. 不需要后期电脑端处理，全部合成动作都在手机端完成
3. SDK集成步骤简单，API极度精简

## 集成步骤：
1. 将pano Module导入到你的项目
2. 在application里添加SDK初始化代码：
```
    public void onCreate() {
        super.onCreate();
        
        ImagesStitch.init(this);
    }
```
3. 混淆代码
-keep public class com.lerp.pano.ImagesStitch { *; }

## API使用说明
```
    /**
     * @param path           输入图片路径
     * @param outPath        输出图片路径
     * @param panoType       全景类型，0球面，1圆柱，2立体，3三明治
     * @param waveCorrection 波段修正，水平或垂直
     * @param widthRatio     宽度最多裁掉的比例，为0表示宽度不需要裁剪
     * @param heightRatio    高度最多裁掉的比例,为0表示高度不需要裁剪
     * @param length         裁剪系数，值越大裁减的越少，参考值300，单位是pixel
     * @return 返回长度为3的字节数组
     * [0]合成结果状态码
     * [1]合成后宽度
     * [2]合成后的高度
     */
   public native static int[] stitchImages(String path[], String outPath,
                                            int panoType, int waveCorrection,
                                            float widthRatio, float heightRatio,
                                            int length, float scale);
```

## 合成示例
1. 2x3合成结果
![测试](/result/2x3.jpg)
