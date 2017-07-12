package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice5DrawOvalView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public Practice5DrawOvalView(Context context) {
        super(context);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆
        mPaint.setStyle(Paint.Style.FILL);
        int rectWidth = 400;
        int rectHeight = 200;
        int left = (getWidth() - rectWidth) / 2;
        int top = (getHeight() - rectHeight) / 2;
        int right = left + rectWidth;
        int bottom = top + rectHeight;
        canvas.drawOval(new RectF(left, top, right, bottom), mPaint);
    }
}
