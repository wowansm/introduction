package com.rubengees.introduction.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.RestrictTo;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;

import com.rubengees.introduction.R;

/**
 * ImageButton subclass which sets the width based on the height and an configurable aspect.
 * Mostly used for squared buttons, when used with aspect of 1.
 *
 * @author Ruben Gees
 */
@RestrictTo(RestrictTo.Scope.LIBRARY)
public class HeightAspectImageButton extends AppCompatImageButton {

    private static final float DEFAULT_ASPECT = 1f;

    private final float aspect;

    public HeightAspectImageButton(Context context) {
        super(context);

        aspect = DEFAULT_ASPECT;
    }

    public HeightAspectImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.HeightAspectImageButton);
        aspect = attributes.getFloat(R.styleable.HeightAspectImageButton_aspect, DEFAULT_ASPECT);

        attributes.recycle();
    }

    public HeightAspectImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.HeightAspectImageButton);
        aspect = attributes.getFloat(R.styleable.HeightAspectImageButton_aspect, DEFAULT_ASPECT);

        attributes.recycle();
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension((int) (getMeasuredHeight() * aspect), getMeasuredHeight());
    }

    public float getAspect() {
        return aspect;
    }
}
