package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        int rectWidth = 400;
        int rectHeight = 300;
        int left = (getWidth() - rectWidth) / 2;
        int top = (getHeight() - rectHeight) / 2;
        int right = left + rectWidth;
        int bottom = top + rectHeight;

        RectF rectF = new RectF(left, top, right, bottom);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, -10, -110, true, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, -130, -50, false, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        rectF.top += 100;
        rectF.bottom += 100;
        canvas.drawArc(rectF, 20, 140, false, mPaint);
    }
}
