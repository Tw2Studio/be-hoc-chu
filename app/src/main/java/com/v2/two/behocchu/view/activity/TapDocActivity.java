package com.v2.two.behocchu.view.activity;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.widget.LinearLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.v2.two.behocchu.R;
import com.v2.two.behocchu.adapter.ChuCaiAdapter;
import com.v2.two.behocchu.model.ChuCai;
import com.v2.two.behocchu.model.Utility;

import java.util.ArrayList;
import java.util.List;

public class TapDocActivity extends AppCompatActivity {
    private List<ChuCai> list;
    private RecyclerView recyclerView;
    private ChuCaiAdapter adapter;
    private DatabaseReference mReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_doc);
        mReference = FirebaseDatabase.getInstance().getReference();
        initView();
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        mReference.child("bangchucai").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChuCai chuCai = dataSnapshot.getValue(ChuCai.class);
                list.add(chuCai);
                adapter = new ChuCaiAdapter(list, TapDocActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle_abc);
        recyclerView.setHasFixedSize(true);
        Display display = this.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        /*GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);

        if (width>height) {
            manager = new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false);
        }*/

        int mNoOfColumns = Utility.calculateNoOfColumns(getApplicationContext());
        GridLayoutManager manager = new GridLayoutManager(this, mNoOfColumns+1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }
}
