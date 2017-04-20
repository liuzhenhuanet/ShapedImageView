package net.liuzhenhua.shapedimageview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * Created by liuzhenhua on 2017/4/17.
 */

public abstract class BasePathImageView extends BaseImageView {
    private final Path mPath = new Path();
    private final Paint mPaint = new Paint();

    public BasePathImageView(Context context) {
        super(context);
        init();
    }

    public BasePathImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BasePathImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setAntiAlias(true);
        mPaint.setXfermode(xfermode());
    }

    abstract protected void buildPath(Path roundPath, RectF imageRectF);

    @Override
    protected final void drawShape(Canvas canvas, RectF imageRectF) {
        mPath.reset();
        buildPath(mPath, imageRectF);
        canvas.drawPath(mPath, mPaint);
    }
}
