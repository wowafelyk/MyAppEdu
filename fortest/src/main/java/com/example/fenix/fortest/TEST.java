package com.example.fenix.fortest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class TEST extends Activity {
    private LinearLayout root;

    @Override
     public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_test);
        root = (LinearLayout) findViewById(R.id.root);
    }
}