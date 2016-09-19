package com.example.kuby.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.kuby.myapplication.R;

import org.xutils.x;

public class Next1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next1);
        x.view().inject(this);
    }
}
