package com.lerp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class Ball implements Renderer {
    Context mContext;
    private int mProgram;
    private int mAPositionHandler;
    private int mUProjectMatrixHandler;
    private int mATextureCoordHandler;
    private final float[] projectMatrix = new float[16];
    private int mSize;
    private FloatBuffer vertexBuff;
    private FloatBuffer textureBuff;
    private int textrueID;
    private int mImgId = -1;
    private Bitmap mBitmap;
    public float xAngle = 0.0F;
    public float yAngle = 90.0F;
    public float zAngle;
    final float[] mCurrMatrix = new float[16];
    final float[] mMVPMatrix = new float[16];

    public Ball(Context context, int drawableId) {
        this.mContext = context;
        this.mImgId = drawableId;
        this.init();
    }

    public Ball(Context context, Bitmap bitmap) {
        this.mContext = context;
        this.mBitmap = bitmap;
        this.init();
    }

    public void init() {
        int perVertex = 36;
        double perRadius = 6.283185307179586D / (double) ((float) perVertex);
        double perW = (double) (1.0F / (float) perVertex);
        double perH = (double) (1.0F / (float) perVertex);
        ArrayList<Float> vetexList = new ArrayList();
        ArrayList<Float> textureList = new ArrayList();

        int i;
        for (int a = 0; a < perVertex; ++a) {
            for (i = 0; i < perVertex; ++i) {
                float w1 = (float) ((double) a * perH);
                float h1 = (float) ((double) i * perW);
                float w2 = (float) ((double) (a + 1) * perH);
                float h2 = (float) ((double) i * perW);
                float w3 = (float) ((double) (a + 1) * perH);
                float h3 = (float) ((double) (i + 1) * perW);
                float w4 = (float) ((double) a * perH);
                float h4 = (float) ((double) (i + 1) * perW);
                textureList.add(h1);
                textureList.add(w1);
                textureList.add(h2);
                textureList.add(w2);
                textureList.add(h3);
                textureList.add(w3);
                textureList.add(h3);
                textureList.add(w3);
                textureList.add(h4);
                textureList.add(w4);
                textureList.add(h1);
                textureList.add(w1);
                float x1 = (float) (Math.sin((double) a * perRadius / 2.0D) * Math.cos((double) i * perRadius));
                float z1 = (float) (Math.sin((double) a * perRadius / 2.0D) * Math.sin((double) i * perRadius));
                float y1 = (float) Math.cos((double) a * perRadius / 2.0D);
                float x2 = (float) (Math.sin((double) (a + 1) * perRadius / 2.0D) * Math.cos((double) i * perRadius));
                float z2 = (float) (Math.sin((double) (a + 1) * perRadius / 2.0D) * Math.sin((double) i * perRadius));
                float y2 = (float) Math.cos((double) (a + 1) * perRadius / 2.0D);
                float x3 = (float) (Math.sin((double) (a + 1) * perRadius / 2.0D) * Math.cos((double) (i + 1) * perRadius));
                float z3 = (float) (Math.sin((double) (a + 1) * perRadius / 2.0D) * Math.sin((double) (i + 1) * perRadius));
                float y3 = (float) Math.cos((double) (a + 1) * perRadius / 2.0D);
                float x4 = (float) (Math.sin((double) a * perRadius / 2.0D) * Math.cos((double) (i + 1) * perRadius));
                float z4 = (float) (Math.sin((double) a * perRadius / 2.0D) * Math.sin((double) (i + 1) * perRadius));
                float y4 = (float) Math.cos((double) a * perRadius / 2.0D);
                vetexList.add(x1);
                vetexList.add(y1);
                vetexList.add(z1);
                vetexList.add(x2);
                vetexList.add(y2);
                vetexList.add(z2);
                vetexList.add(x3);
                vetexList.add(y3);
                vetexList.add(z3);
                vetexList.add(x3);
                vetexList.add(y3);
                vetexList.add(z3);
                vetexList.add(x4);
                vetexList.add(y4);
                vetexList.add(z4);
                vetexList.add(x1);
                vetexList.add(y1);
                vetexList.add(z1);
            }
        }

        this.mSize = vetexList.size() / 3;
        float[] texture = new float[this.mSize * 2];

        for (i = 0; i < texture.length; ++i) {
            texture[i] = (Float) textureList.get(i);
        }

        this.textureBuff = ByteBuffer.allocateDirect(texture.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.textureBuff.put(texture);
        this.textureBuff.position(0);
        float[] vetex = new float[this.mSize * 3];

        for (i = 0; i < vetex.length; ++i) {
            vetex[i] = (Float) vetexList.get(i);
        }

        this.vertexBuff = ByteBuffer.allocateDirect(vetex.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.vertexBuff.put(vetex);
        this.vertexBuff.position(0);
    }

    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        Matrix.rotateM(this.mCurrMatrix, 0, -this.xAngle, 1.0F, 0.0F, 0.0F);
        Matrix.rotateM(this.mCurrMatrix, 0, -this.yAngle, 0.0F, 1.0F, 0.0F);
        Matrix.rotateM(this.mCurrMatrix, 0, -this.zAngle, 0.0F, 0.0F, 1.0F);
        GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
        GLES20.glClear(16640);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.textrueID);
        GLES20.glUniformMatrix4fv(this.mUProjectMatrixHandler, 1, false, this.getfinalMVPMatrix(), 0);
        GLES20.glDrawArrays(4, 0, this.mSize);
    }

    public float[] getfinalMVPMatrix() {
        Matrix.multiplyMM(this.mMVPMatrix, 0, this.projectMatrix, 0, this.mCurrMatrix, 0);
        Matrix.setIdentityM(this.mCurrMatrix, 0);
        return this.mMVPMatrix;
    }

    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        GLES20.glEnable(2884);
        float ratio = (float) width / (float) height;
        Matrix.frustumM(this.projectMatrix, 0, -ratio, ratio, -1.0F, 1.0F, 1.0F, 20.0F);
        Matrix.setIdentityM(this.mCurrMatrix, 0);
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        Matrix.translateM(this.projectMatrix, 0, 0.0F, 0.0F, -2.0F);
        Matrix.scaleM(this.projectMatrix, 0, 4.0F, 4.0F, 4.0F);
        this.mProgram = OGLUtils.getProgram();
        GLES20.glUseProgram(this.mProgram);
        this.mAPositionHandler = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
        this.mUProjectMatrixHandler = GLES20.glGetUniformLocation(this.mProgram, "uProjectMatrix");
        this.mATextureCoordHandler = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        if (mImgId != -1) {
            this.textrueID = OGLUtils.initTexture(this.mContext, this.mImgId);
        } else {
            this.textrueID = OGLUtils.initTexture(this.mContext, mBitmap);
        }
        GLES20.glVertexAttribPointer(this.mAPositionHandler, 3, 5126, false, 0, this.vertexBuff);
        GLES20.glVertexAttribPointer(this.mATextureCoordHandler, 2, 5126, false, 0, this.textureBuff);
        GLES20.glEnableVertexAttribArray(this.mAPositionHandler);
        GLES20.glEnableVertexAttribArray(this.mATextureCoordHandler);
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
    }
}
