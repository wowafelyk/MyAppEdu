package com.example.fenix.fortest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.fenix.fortest.DotView;

import java.util.Random;

/**
 * Демонстрационная версия пользовательского интерфейса Android.
 */
//TouchMe -> TEST
public class TEST extends Activity {
    public static final int DOT_DIAMETER = 6;
    private final Random rand = new Random();
    final Dots dotModel = new Dots();
    DotView dotView;

    /**
     * Вызывается при первом создании активности.
     */
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        dotView = new DotView(this, dotModel);

        dotView.setOnTouchListener(new View.OnTouchListener() {
            @Override public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN != event.getAction()) {
                    return false;
                }
                dots.addDot(event.getX(
                ), event.getY(), Color.CYAN, DOT_DIAMETER);
                return true;
            } });


// установка вида View
        setContentView(R.layout.main);
        ((LinearLayout) findViewById(R.id.root)).addView(dotView, 0);
// подключение контроллера Controller
        ((Button) findViewById(R.id.button1)).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        makeDot(dots, dotView, Color.RED);
                    }
                });
        ((Button) findViewById(R.id.button2)).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        makeDot(dots, dotView, Color.GREEN);
                    }
                });
        final EditText tb1 = (EditText) findViewById(R.id.text1);
        final EditText tb2 = (EditText) findViewById(R.id.text2);
        dots.setDotsChangeListener(new Dots.DotsChangeListener() {
            @Override
            public void onDotsChange(Dots d) {
                Dot d = dots.getLastDot();
                tb1.setText((null == d) ? "" : String.valueOf(d.getX()));
                tb2.setText((null == d) ? "" : String.valueOf(d.getY()));
                dotView.invalidate();
            }
        });
    }

    /**
     * @param dots  точки, которые мы рисуем
     * @param view  вид, в котором мы рисуем точки
     * @param color цвет точки
     */
    void makeDot(Dots dots, DotView view, int color) {
        int pad = (DOT_DIAMETER + 2) * 2;
        dots.addDot(
                DOT_DIAMETER + (rand.nextFloat() * (view.getWidth() - pad)),
                DOT_DIAMETER + (rand.nextFloat() * (view.getHeight() - pad)),
                color,
                DOT_DIAMETER);
    }
}