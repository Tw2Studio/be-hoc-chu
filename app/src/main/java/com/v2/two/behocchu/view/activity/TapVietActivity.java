package com.v2.two.behocchu.view.activity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.byox.drawview.views.DrawView;
import com.v2.two.behocchu.R;
import com.v2.two.behocchu.view.CanvasView;

public class TapVietActivity extends AppCompatActivity {
    private CanvasView canvas;
    private DrawView drawView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_viet);
        initView();
    }

    private void initView() {
        /*canvas = (CanvasView) findViewById(R.id.canvas);
        //this.canvas.redo();
        canvas.setMode(CanvasView.Mode.TEXT);
        canvas.setDrawer(CanvasView.Drawer.PEN);
        canvas.setBaseColor(Color.WHITE);
        canvas.setPaintStyle(Paint.Style.STROKE);
        canvas.setPaintStrokeColor(Color.RED);
        canvas.setPaintStrokeWidth(2F);
        canvas.setOpacity(128);
        canvas.setBlur(5F);
        canvas.setLineCap(Paint.Cap.BUTT);
        this.canvas.setText("A");
        canvas.setFontFamily(Typeface.DEFAULT);*/

        drawView = (DrawView) findViewById(R.id.draw_view);
    }

    public CanvasView getCanvas() {
        return this.canvas;
    }
}
