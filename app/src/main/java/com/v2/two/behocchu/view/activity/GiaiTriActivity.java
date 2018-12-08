package com.v2.two.behocchu.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.v2.two.behocchu.R;

public class GiaiTriActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_tri);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_back).setOnClickListener(this);
        findViewById(R.id.btn_video).setOnClickListener(this);
        findViewById(R.id.btn_nhac).setOnClickListener(this);
        findViewById(R.id.btn_phim).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_video:
                intent = new Intent(GiaiTriActivity.this, ListVideoActivity.class);
                intent.putExtra("ID_PLAYLIST","PLYLXC-cAzgsnKy105XaSlnS_C7xPYFHKJ");
                startActivity(intent);
                break;
            case R.id.btn_nhac:
                intent = new Intent(GiaiTriActivity.this, ListVideoActivity.class);
                intent.putExtra("ID_PLAYLIST","PLzrVYRai0riQ7M7Okd_BRpYu_ka-sHylU");
                startActivity(intent);
                break;
            case R.id.btn_phim:
                intent = new Intent(GiaiTriActivity.this, ListVideoActivity.class);
                intent.putExtra("ID_PLAYLIST","PLdJUy4apatGiu3vrN_NqPB63gc9ceoTSC");
                startActivity(intent);
                break;

        }
    }
}
