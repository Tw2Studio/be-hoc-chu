package com.v2.two.behocchu.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.v2.two.behocchu.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_tap_doc).setOnClickListener(this);
        findViewById(R.id.btn_tap_viet).setOnClickListener(this);
        findViewById(R.id.btn_giai_tri).setOnClickListener(this);
        findViewById(R.id.btn_tap_doc_so).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tap_doc:
                Intent intent = new Intent(MainActivity.this, HocChuActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_tap_viet:
                Intent intent1 = new Intent(MainActivity.this, HocVeActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_giai_tri:
                Intent intent2 = new Intent(MainActivity.this, GiaiTriActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_tap_doc_so:
                Intent intent3 = new Intent(MainActivity.this, HocSoActivity.class);
                startActivity(intent3);
                break;


        }
    }
}
