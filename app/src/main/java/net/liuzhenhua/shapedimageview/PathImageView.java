package net.liuzhenhua.shapedimageview;

import android.content.Context;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * Created by liuzhenhua on 2017/4/17.
 */

public class PathImageView extends BasePathImageView {
    private Path mPath;

    public PathImageView(Context context) {
        super(context);
    }

    public PathImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PathImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPath(Path mPath) {
        this.mPath = mPath;
        invalidate();
    }

    @Override
    protected void buildPath(Path roundPath, RectF imageRectF) {
        roundPath.addPath(mPath);
    }
}
