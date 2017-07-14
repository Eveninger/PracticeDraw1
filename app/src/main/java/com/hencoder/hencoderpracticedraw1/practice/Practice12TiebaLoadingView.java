package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Nighter on 17/7/14.
 */

public class Practice12TiebaLoadingView extends View {
    private static final String TAG = "Practice12TiebaLoadingV";
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private Path mWavePath = new Path();

    private int mPercent;

    public Practice12TiebaLoadingView(Context context) {
        this(context, null, 0);
    }

    public Practice12TiebaLoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice12TiebaLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        post(new Runnable() {
            @Override
            public void run() {
                mWidth = getWidth();
                mHeight = getHeight();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.FILL);
        mPercent = (mPercent + 5) % 101;
        calculateWavePath(mPercent / 100.0f);
        invalidate();
        canvas.drawPath(mWavePath, mPaint);
    }

    private void calculateWavePath(float percent) {
        mWavePath.reset();
        Log.d(TAG, "percent = " + percent);
        int start = (int) ((percent - 1) * mWidth);

        int quadWidth = (int) (mWidth / 4.0f);
        int quadHeight = (int) (mHeight / 20.0f * 3);

        mWavePath.moveTo(start, mHeight / 2);
        //第一个波形
        mWavePath.rQuadTo(quadWidth, quadHeight, quadWidth * 2, 0);
        mWavePath.rQuadTo(quadWidth, -quadHeight, quadWidth * 2, 0);
        //第二个波形
        mWavePath.rQuadTo(quadWidth, quadHeight, quadWidth * 2, 0);
        mWavePath.rQuadTo(quadWidth, -quadHeight, quadWidth * 2, 0);

        mWavePath.lineTo(mWidth, mHeight);
        mWavePath.lineTo(start, mHeight);
        mWavePath.close();
    }
}
