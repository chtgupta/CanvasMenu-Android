package believe.cht.canvasmenu;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Chahat on 12-Jan-18.
 */

public class Quarter extends RelativeLayout {

    RelativeLayout overlay, menu;
    ImageView menu_button, cross;

    public Quarter(Context context) {
        super(context);
        init(null);
    }

    public Quarter(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public Quarter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public Quarter(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {

        inflate(getContext(), R.layout.quarter_layout, this);
        menu_button = (ImageView) findViewById(R.id.menu_button) ;
        overlay = (RelativeLayout) findViewById(R.id.overlay);
        menu = (RelativeLayout) findViewById(R.id.menu);
        cross = (ImageView) findViewById(R.id.cross);

        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int x = (int) menu_button.getX() + menu_button.getWidth()/2;
                int y = (int) menu_button.getY() + menu_button.getHeight()/2;

                int startRadius = 0;
                int endRadius = (int) Math.hypot(menu.getWidth(), menu.getHeight());

                Animator anim = ViewAnimationUtils.createCircularReveal(menu, x, y, startRadius, endRadius);
                anim.setDuration(400);

                overlay.setVisibility(View.VISIBLE);
                anim.start();
                menu.setVisibility(View.VISIBLE);

            }
        });

        overlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                hideMenu();
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do nothing
            }
        });

        cross.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                hideMenu();
            }
        });

    }

    private void hideMenu() {
        int x = (int) menu_button.getX() + menu_button.getWidth()/2;
        int y = (int) menu_button.getY() + menu_button.getHeight()/2;

        int startRadius = (int) Math.hypot(menu.getWidth(), menu.getHeight());
        int endRadius = 0;

        Animator anim = ViewAnimationUtils.createCircularReveal(menu, x, y, startRadius, endRadius);
        anim.setDuration(400);

        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

                overlay.setVisibility(View.GONE);
                menu.setVisibility(View.GONE);

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
