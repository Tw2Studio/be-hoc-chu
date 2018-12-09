package com.v2.two.behocchu.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.byox.drawview.views.DrawView;
import com.v2.two.behocchu.R;

public class HocVeActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawView drawView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_ve);
        initView();
    }

    private void initView() {
        drawView = (DrawView) findViewById(R.id.draw_view);
        drawView.setZoomEnabled(true);
        findViewById(R.id.btn_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
        }
    }
}
