package com.lerp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class GLPanorama extends RelativeLayout {
    private Context mContext;
    private GLSurfaceView mGlSurfaceView;
    private float mPreviousYs;
    private float mPreviousXs;
    private float predegrees = 0.0F;
    private Ball mBall;
    int yy;

    public GLPanorama(Context context) {
        super(context);
        this.yy = 0;
        this.mContext = context;
        this.initView();
    }

    public GLPanorama(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.yy = 0;
        this.mContext = context;
        this.initView();
    }

    public GLPanorama(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.yy = 0;
        this.mContext = context;
        this.initView();
    }

    private void initView() {
        mGlSurfaceView = new GLSurfaceView(mContext);
        addView(mGlSurfaceView);
    }

    public boolean onTouchEvent(MotionEvent event) {
        float y = event.getY();
        float x = event.getX();
        switch (event.getAction()) {
            case 2:
                float dy = y - this.mPreviousYs;
                float dx = x - this.mPreviousXs;
                Ball var10000 = this.mBall;
                var10000.yAngle += dx * 0.3F;
                var10000 = this.mBall;
                var10000.xAngle += dy * 0.3F;
                if (this.mBall.xAngle < -50.0F) {
                    this.mBall.xAngle = -50.0F;
                } else if (this.mBall.xAngle > 50.0F) {
                    this.mBall.xAngle = 50.0F;
                }

                this.rotate();
        }

        this.mPreviousYs = y;
        this.mPreviousXs = x;
        return true;
    }

    public void setGLDrawable(int pimgid) {
        this.mGlSurfaceView.setEGLContextClientVersion(2);
        this.mBall = new Ball(this.mContext, pimgid);
        this.mGlSurfaceView.setRenderer(this.mBall);
    }

    public void setGLBitmap(Bitmap bitmap) {
        this.mGlSurfaceView.setEGLContextClientVersion(2);
        this.mBall = new Ball(this.mContext, bitmap);
        this.mGlSurfaceView.setRenderer(this.mBall);
    }

    private void rotate() {
        RotateAnimation anim = new RotateAnimation(this.predegrees, -this.mBall.yAngle, 1, 0.5F, 1, 0.5F);
        anim.setDuration(200L);
        this.predegrees = -this.mBall.yAngle;
    }
}
