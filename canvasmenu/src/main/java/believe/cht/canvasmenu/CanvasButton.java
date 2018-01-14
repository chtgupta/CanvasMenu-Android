package believe.cht.canvasmenu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Chahat on 13-Jan-18.
 */

public class CanvasButton extends RelativeLayout {

    RelativeLayout root;
    ImageView icon;
    TypedArray typedArray;
    int buttonColor;
    int buttonIconRes;

    public CanvasButton(Context context) {
        super(context);
        init(null);
    }

    public CanvasButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        typedArray = context.obtainStyledAttributes(attrs, R.styleable.CanvasButton, 0, 0);

        buttonColor = typedArray.getColor(R.styleable.CanvasButton_buttonColor, 0xff1565C0);
        buttonIconRes = typedArray.getResourceId(R.styleable.CanvasButton_buttonIcon, R.drawable.ic_menu_button);

        typedArray.recycle();

        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        inflate(getContext(), R.layout.canvas_button_layout, this);

        root = (RelativeLayout) findViewById(R.id.root);
        icon = (ImageView) findViewById(R.id.icon);

        setColor(buttonColor);
        icon.setImageResource(buttonIconRes);
    }

    public void setCanvas(final Quarter quarter) {
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quarter.isOpen()) {
                    quarter.hideCanvas();
                } else {
                    quarter.showCanvas();
                }
            }
        });
    }

    public void setColor(int color) {
        root.setBackgroundTintList(ColorStateList.valueOf(color));
    }

    public void setIcon(@DrawableRes int icon) {
        this.icon.setImageResource(icon);
    }

}
