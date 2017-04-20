package net.liuzhenhua.shapedimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * Created by liuzhenhua on 2017/4/17.
 */

public class ShapedImageView extends BaseImageView {
    private BitmapDrawable mShapedDrawable;

    public ShapedImageView(Context context) {
        super(context);
        init(context, null);
    }

    public ShapedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ShapedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ShapedImageView);
            Drawable drawable = typedArray.getDrawable(R.styleable.ShapedImageView_bitmapDrawable);
            typedArray.recycle();
            if (drawable instanceof BitmapDrawable) {
                mShapedDrawable = (BitmapDrawable) drawable;
                Paint paint = mShapedDrawable.getPaint();
                paint.setAntiAlias(true);
                paint.setXfermode(xfermode());

            }
        }

    }

    @Override
    protected void drawShape(Canvas canvas, RectF imageRectF) {
        if (mShapedDrawable != null) {
            mShapedDrawable.setBounds((int) imageRectF.left, (int) imageRectF.top, (int) imageRectF.right, (int) imageRectF.bottom);
            mShapedDrawable.draw(canvas);
        }
    }
}
