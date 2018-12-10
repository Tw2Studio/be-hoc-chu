package com.v2.two.behocchu.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.v2.two.behocchu.R;
import com.v2.two.behocchu.adapter.DoiSongAdapter;
import com.v2.two.behocchu.adapter.SoAdapter;
import com.v2.two.behocchu.model.ChuCai;
import com.v2.two.behocchu.model.So;

import java.util.ArrayList;
import java.util.List;

public class ChiTietDoiSongActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<ChuCai> list;
    private DoiSongAdapter adapter;
    private String type;
    private DatabaseReference mReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_doi_song);
        mReference = FirebaseDatabase.getInstance().getReference();
        Intent intent = getIntent();
        type = intent.getStringExtra("TYPE_DOISONG");
        initView();
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        mReference.child("doisong").child(type).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChuCai ds = dataSnapshot.getValue(ChuCai.class);
                list.add(ds);
                adapter = new DoiSongAdapter(list, ChiTietDoiSongActivity.this);
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
        recyclerView = (RecyclerView) findViewById(R.id.recycle_doisong);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ChiTietDoiSongActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }
}
