package com.example.fenix.fortest;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Fenix on 27.05.2015.
 */
private static final class TrackingTouchListener
        implements View.OnTouchListener {
    private final Dots mDots;

    TrackingTouchListener(Dots dots) {
        mDots = dots;
    }

    @Override
    public boolean onTouch(View v, MotionEvent evt) {
        switch (evt.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                for (int i = 0, n = evt.getHistorySize(); i < n; i++) {
                    addDot(
                            mDots,
                            evt.getHistoricalX(i),
                            evt.getHistoricalY(i),
                            evt.getHistoricalPressure(i),
                            evt.getHistoricalSize(i));
                }
                break;
            default:
                return false;
        }
        addDot(
                mDots,
                evt.getX(),
                evt.getY(),
                evt.getPressure(),
                evt.getSize());
        return true;
    }

    private void addDot(Dots dots, float x, float y, float p, float s) {
        dots.addDot(
                x
                ,
                y
                ,
                Color.CYAN,
                (int) ((p * s * Dot.DIAMETER) + 1));
    }
}
