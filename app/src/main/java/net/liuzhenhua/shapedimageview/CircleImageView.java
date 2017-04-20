package net.liuzhenhua.shapedimageview;

import android.content.Context;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * Created by liuzhenhua on 2017/4/17.
 */

public class CircleImageView extends BasePathImageView {
    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int shortEdge = Math.min(getMeasuredWidth(),getMeasuredHeight());
        setMeasuredDimension(shortEdge, shortEdge);
    }

    @Override
    protected void buildPath(Path roundPath, RectF imageRectF) {
        roundPath.addRoundRect(imageRectF, imageRectF.width() / 2, imageRectF.height() / 2, Path.Direction.CW);
    }
}
