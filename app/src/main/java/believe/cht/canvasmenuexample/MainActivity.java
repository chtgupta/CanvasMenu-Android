package believe.cht.canvasmenuexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import believe.cht.canvasmenu.CanvasButton;
import believe.cht.canvasmenu.Quarter;

public class MainActivity extends AppCompatActivity {

    Quarter quarter;
    CanvasButton canvasButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quarter = (Quarter) findViewById(R.id.quarter);
        canvasButton = (CanvasButton) findViewById(R.id.canvas_button);
        canvasButton.setCanvas(quarter);

    }
}
