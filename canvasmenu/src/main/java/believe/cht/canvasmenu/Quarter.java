package believe.cht.canvasmenu;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Chahat on 12-Jan-18.
 */

public class Quarter extends RelativeLayout {

    Quarter quarter;
    FrameLayout menu;
    ImageView closeIcon;
    TypedArray typedArray;
    int canvasColor;
    int canvasOpeningSpeed = 400;
    int canvasClosingSpeed = 400;
    int closeIconRes;
    CanvasButton canvasButton;

    public Quarter(Context context) {
        super(context);
        init(null);
    }

    public Quarter(Context context, AttributeSet attrs) {
        super(context, attrs);

        typedArray = context.obtainStyledAttributes(attrs, R.styleable.Quarter, 0, 0);
        canvasColor = typedArray.getColor(R.styleable.Quarter_canvasColor, 0xff1565C0);
        canvasOpeningSpeed = typedArray.getInt(R.styleable.Quarter_canvasOpeningSpeed, 400);
        canvasClosingSpeed = typedArray.getInt(R.styleable.Quarter_canvasClosingSpeed, 400);
        closeIconRes = typedArray.getResourceId(R.styleable.Quarter_closeIcon, R.drawable.ic_cross);

        typedArray.recycle();

        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {

        inflate(getContext(), R.layout.quarter_layout, this);
        canvasButton = new CanvasButton(getContext());
        quarter = this;
        closeIcon = (ImageView) findViewById(R.id.cross);
        menu = (FrameLayout) findViewById(R.id.menu);
        setColor(canvasColor);
        setCanvasOpeningSpeed(canvasOpeningSpeed);
        setCanvasClosingSpeed(canvasClosingSpeed);
        closeIcon.setImageResource(closeIconRes);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do nothing
                // just to prevent clicks from penetrating the Quarter
            }
        });

        closeIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                hideCanvas();
            }
        });

    }

    public void showCanvas() {

        if (!isOpen()) {

            int x = (int) closeIcon.getX() + closeIcon.getWidth() / 2;
            int y = (int) closeIcon.getY() + closeIcon.getHeight() / 2;

            int startRadius = 0;
            int endRadius = menu.getHeight();

            Animator anim = ViewAnimationUtils.createCircularReveal(quarter, x, y, startRadius, endRadius);
            anim.setDuration(canvasOpeningSpeed);

            anim.start();
            quarter.setVisibility(View.VISIBLE);

        }

    }

    public void setCloseIcon(@DrawableRes int closeIcon) {
        this.closeIcon.setImageResource(closeIcon);
    }

    public void setCanvasOpeningSpeed(int openingSpeed) {
        canvasOpeningSpeed = openingSpeed;
    }

    public void setCanvasClosingSpeed(int closingSpeed) {
        canvasClosingSpeed = closingSpeed;
    }

    public boolean isOpen() {
        return quarter.getVisibility() == VISIBLE;
    }

    public void setColor(int color) {
        menu.setBackgroundTintList(ColorStateList.valueOf(color));
    }


    public void hideCanvas() {

        if (isOpen()) {

            int x = (int) closeIcon.getX() + closeIcon.getWidth() / 2;
            int y = (int) closeIcon.getY() + closeIcon.getHeight() / 2;

            int startRadius = menu.getHeight();
            int endRadius = 0;

            Animator anim = ViewAnimationUtils.createCircularReveal(quarter, x, y, startRadius, endRadius);
            anim.setDuration(canvasClosingSpeed);

            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {

                    quarter.setVisibility(View.INVISIBLE);

                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });

            anim.start();
        }

    }

}