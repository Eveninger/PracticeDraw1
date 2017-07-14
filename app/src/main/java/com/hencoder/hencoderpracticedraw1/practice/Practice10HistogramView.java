package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.utils.DisplayUtils;

public class Practice10HistogramView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Point[] mAxis;
    private int mHistogramWidth;

    private static final String[] TITLES = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    private Point[] mAxisTitlePos;
    private static final int[] HISTOGRAM_HEIGHT = {1, 5, 5, 70, 130, 170, 70};
    private Rect[] mHistogram;
    private Point mTitlePos;

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mAxis = new Point[3];
        mAxis[0] = new Point(DisplayUtils.dp2px(getContext(), 40), DisplayUtils.dp2px(getContext(), 200));
        mAxis[1] = new Point(DisplayUtils.dp2px(getContext(), 320), DisplayUtils.dp2px(getContext(), 200));
        mAxis[2] = new Point(DisplayUtils.dp2px(getContext(), 40), DisplayUtils.dp2px(getContext(), 20));

        mHistogramWidth = DisplayUtils.dp2px(getContext(), 35);

        mAxisTitlePos = new Point[TITLES.length];
        mAxisTitlePos[0] = new Point(mAxis[0].x + DisplayUtils.dp2px(getContext(), 10), mAxis[0].y + DisplayUtils.dp2px(getContext(), 10));
        mAxisTitlePos[1] = new Point(mAxis[0].x + DisplayUtils.dp2px(getContext(), 55), mAxis[0].y + DisplayUtils.dp2px(getContext(), 10));
        mAxisTitlePos[2] = new Point(mAxis[0].x + DisplayUtils.dp2px(getContext(), 95), mAxis[0].y + DisplayUtils.dp2px(getContext(), 10));
        mAxisTitlePos[3] = new Point(mAxis[0].x + DisplayUtils.dp2px(getContext(), 135), mAxis[0].y + DisplayUtils.dp2px(getContext(), 10));
        mAxisTitlePos[4] = new Point(mAxis[0].x + DisplayUtils.dp2px(getContext(), 170), mAxis[0].y + DisplayUtils.dp2px(getContext(), 10));
        mAxisTitlePos[5] = new Point(mAxis[0].x + DisplayUtils.dp2px(getContext(), 220), mAxis[0].y + DisplayUtils.dp2px(getContext(), 10));
        mAxisTitlePos[6] = new Point(mAxis[0].x + DisplayUtils.dp2px(getContext(), 260), mAxis[0].y + DisplayUtils.dp2px(getContext(), 10));

        mHistogram = new Rect[TITLES.length];
        int histogramPosX = mAxis[0].x;
        int histogramPosY = mAxis[0].y;
        for (int i = 0; i < mHistogram.length; i++) {
            int left = histogramPosX + DisplayUtils.dp2px(getContext(), 3);
            int top = histogramPosY - DisplayUtils.dp2px(getContext(), HISTOGRAM_HEIGHT[i]);
            int right = left + mHistogramWidth;
            int bottom = histogramPosY;
            mHistogram[i] = new Rect(left, top, right, bottom);
            histogramPosX += DisplayUtils.dp2px(getContext(), 5) + mHistogramWidth;
        }

        post(new Runnable() {
            @Override
            public void run() {
                mTitlePos = new Point(getWidth() / 2 - DisplayUtils.dp2px(getContext(), 20), getHeight() - DisplayUtils.dp2px(getContext(), 10));
            }
        });

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        drawAxises(canvas);
        drawAxisTitles(canvas);
        drawHistogram(canvas);
        drawTitle(canvas);
    }

    private void drawAxises(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        //draw X axis
        canvas.drawLine(mAxis[0].x, mAxis[0].y, mAxis[1].x, mAxis[1].y, mPaint);

        //draw Y axis
        canvas.drawLine(mAxis[0].x, mAxis[0].y, mAxis[2].x, mAxis[2].y, mPaint);
    }

    private void drawAxisTitles(Canvas canvas) {
        mPaint.setTextSize(DisplayUtils.dp2px(getContext(), 10));
        for (int i = 0; i < TITLES.length; i++) {
            canvas.drawText(TITLES[i], mAxisTitlePos[i].x, mAxisTitlePos[i].y, mPaint);
        }
    }

    private void drawHistogram(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GREEN);

        for (int i = 0; i < TITLES.length; i++) {
            canvas.drawRect(mHistogram[i], mPaint);
        }
    }

    private void drawTitle(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(DisplayUtils.dp2px(getContext(), 18));
        canvas.drawText("直方图", mTitlePos.x, mTitlePos.y, mPaint);
    }

}
