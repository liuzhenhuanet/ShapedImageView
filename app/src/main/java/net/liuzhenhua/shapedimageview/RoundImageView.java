package net.liuzhenhua.shapedimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * Created by liuzhenhua on 2017/4/17.
 */

public class RoundImageView extends BasePathImageView {
    private float mTopLeftRadius;
    private float mTopRightRadius;
    private float mBottomRightRadius;
    private float mBottomLeftRadius;
    private float mRadius;
    private final float[] mRadii = new float[8];

    public RoundImageView(Context context) {
        super(context);
        init(context, null);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundImageView);
            mRadius = typedArray.getDimension(R.styleable.RoundImageView_radius, 0);
            mTopLeftRadius = typedArray.getDimension(R.styleable.RoundImageView_topLeftRadius, -1);
            mTopRightRadius = typedArray.getDimension(R.styleable.RoundImageView_topRightRadius, -1);
            mBottomRightRadius = typedArray.getDimension(R.styleable.RoundImageView_bottomRightRadius, -1);
            mBottomLeftRadius = typedArray.getDimension(R.styleable.RoundImageView_bottomLeftRadius, -1);
            typedArray.recycle();
        }
        updateRadii();
    }

    private void updateRadii() {
        mRadius = Math.max(0, mRadius);
        mRadii[0] = mRadii[1] = mTopLeftRadius >= 0 ? mTopLeftRadius : mRadius;
        mRadii[2] = mRadii[3] = mTopRightRadius >= 0 ? mTopRightRadius : mRadius;
        mRadii[4] = mRadii[5] = mBottomRightRadius >= 0 ? mBottomRightRadius : mRadius;
        mRadii[6] = mRadii[7] = mBottomLeftRadius >= 0 ? mBottomLeftRadius : mRadius;
    }

    @Override
    protected void buildPath(Path roundPath, RectF imageRectF) {
        roundPath.addRoundRect(imageRectF, mRadii, Path.Direction.CW);
    }
}
