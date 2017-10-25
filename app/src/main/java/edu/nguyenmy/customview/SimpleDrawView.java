package edu.nguyenmy.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by DELL on 10/24/2017.
 */

public class SimpleDrawView extends View {
    private final int mPaintColor = Color.BLUE;
    private Paint mDrawPaint;
    private Path mPath = new Path();
    public SimpleDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setupPaint();
    }

    private void setupPaint() {
        mDrawPaint = new Paint();
        mDrawPaint.setColor(mPaintColor);
        mDrawPaint.setAntiAlias(true);
        mDrawPaint.setStrokeWidth(5);
        mDrawPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(mPath, mDrawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();
        //kiem tra su kien cham man hinh
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(pointX,pointY);
                return true;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(pointX,pointY);
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
    public void clear(){
        mPath.reset();
        invalidate();
    }
}
