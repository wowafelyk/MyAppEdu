package com.example.fenix.p0141_menuadv;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private static final String Tag = "My log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public ArrayList<String> prefixList(String prefix, ArrayList<String> strs) {
        ArrayList<String> ret
                = new ArrayList<String>(strs.size());
        for (String s : strs) {
            ret.add(prefix + s);
        }
        return ret;
    }

    public void onClick(View v) {
        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<String> full;
        arr.add("my list");
        arr.add("three object");
        arr.add("last object");
        full = prefixList("___", arr);
        TextView t = (TextView) findViewById(R.id.editText);

        for (String str : full) {
            Log.d(Tag, "Write text on screen");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.append(str + "\n");
        }
    }

    public void onClickReset(View v) {

        TextView t = (TextView) findViewById(R.id.editText);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.setText(R.string.reset);
    }

    public void onClickWait(View v) {

        Thread a = new Thread() {
            public void  run() {
                TextView t = (TextView) findViewById(R.id.editText);
                synchronized (this) {

                    Log.d(Tag,"Start waiting1");
                    try {
                        Thread.sleep(3000);
                        Log.d(Tag,"wait2");
                        wait(5000);
                        Log.d(Tag," Wait Done!!!");
                        //t.append("\n Wait Done!!!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Log.d(Tag,"Stop waiting");
                }
                //notify();
            }
        };
        a.start();
        synchronized(a) {
            try {
                Log.d(Tag,"wait");
                //wait(5000);
                TextView t = (TextView) findViewById(R.id.editText);
                t.append("\n Wait skipped!!!");
                Log.d(Tag,"Done!!!");
            } catch (Exception e) {
                Log.d(Tag,"Ja tja kyrwa zaperdoljy");
                e.printStackTrace();
            }
        }
    }

}
