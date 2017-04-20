package net.liuzhenhua.shapedimageview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by liuzhenhua on 2017/4/17.
 */

public abstract class BaseImageView extends ImageView {
    private static final PorterDuffXfermode DUFF_MODE = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    private final RectF mRect = new RectF();

    public BaseImageView(Context context) {
        super(context);
    }

    public BaseImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        mRect.set(drawable.getBounds());
        getImageMatrix().mapRect(mRect);
        int saveCount = canvas.saveLayer(mRect, null,
                Canvas.MATRIX_SAVE_FLAG |
                        Canvas.CLIP_SAVE_FLAG |
                        Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                        Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                        Canvas.CLIP_TO_LAYER_SAVE_FLAG);
        super.onDraw(canvas);
        drawShape(canvas, mRect);
        canvas.restoreToCount(saveCount);
    }

    protected abstract void drawShape(Canvas canvas, RectF imageRectF);

    protected Xfermode xfermode() {
        return DUFF_MODE;
    }
}
