package com.example.kuby.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kuby.myapplication.R;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends Activity {

    @ViewInject(value = R.id.btn_show_tips)
    private Button btn_show_tips;

    @ViewInject(value = R.id.btn_next_activity)
    private Button btn_next_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);

    }


    @Event(value = {R.id.btn_show_tips,R.id.btn_next_activity})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_tips:
                Toast.makeText(MainActivity.this, "click this button", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_next_activity:
//                Toast.makeText(MainActivity.this, "click this button", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,Next1Activity.class));
                break;
        }
    }
}
