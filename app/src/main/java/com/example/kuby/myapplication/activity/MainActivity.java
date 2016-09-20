package com.example.kuby.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kuby.myapplication.R;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends Activity {

    @ViewInject(value = R.id.textView)
    private TextView textView;

    @ViewInject(value = R.id.btn_show_tips)
    private Button btn_show_tips;

    @ViewInject(value = R.id.btn_next_activity)
    private Button btn_next_activity;

    @ViewInject(value = R.id.btn_culculate)
    private Button btn_culculate;

    @ViewInject(value = R.id.et_number)
    private EditText et_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);

    }


    @Event(value = {R.id.btn_show_tips,R.id.btn_next_activity,R.id.btn_culculate})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_tips:
                Toast.makeText(MainActivity.this, "click this button", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_next_activity:
//                Toast.makeText(MainActivity.this, "click this button", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,Next1Activity.class));
                break;

            case R.id.btn_culculate:
                String value = et_number.getText().toString();
                if (value.equals("")){
                    Toast.makeText(MainActivity.this, "please input number!", Toast.LENGTH_SHORT).show();
                }else{
                    if(value.length() > 2 && value.substring(0,2).equals("0x")){
                        //16进制---->10进制
                        value = value.replace("0x", "");
                        int result = Integer.parseInt(value, 16);
                        textView.setText(""+result);
                    }else{
                        //10进制---->16进制
                        String result = calculateNum(value);
                        textView.setText("0x"+result);
                    }
                }
                break;
        }
    }

    private String calculateNum(String s){
        int num = Integer.parseInt(s);
        String result = Integer.toHexString(num);
        return result;
    }
}
