package com.v2.two.behocchu.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.v2.two.behocchu.R;

public class DoiSongActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_doi_song);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_dong_vat).setOnClickListener(this);
        findViewById(R.id.btn_do_vat).setOnClickListener(this);
        findViewById(R.id.btn_mau_sac).setOnClickListener(this);
        findViewById(R.id.btn_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_dong_vat:
                intent = new Intent(DoiSongActivity.this, ChiTietDoiSongActivity.class);
                intent.putExtra("TYPE_DOISONG", "dongvat");
                startActivity(intent);
                break;
            case R.id.btn_do_vat:
                intent = new Intent(DoiSongActivity.this, ChiTietDoiSongActivity.class);
                intent.putExtra("TYPE_DOISONG", "dovat");
                startActivity(intent);
                break;
            case R.id.btn_mau_sac:
                intent = new Intent(DoiSongActivity.this, ChiTietDoiSongActivity.class);
                intent.putExtra("TYPE_DOISONG", "mausac");
                startActivity(intent);
                break;

        }
    }
}
