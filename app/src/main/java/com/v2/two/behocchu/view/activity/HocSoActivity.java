package com.v2.two.behocchu.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.v2.two.behocchu.R;
import com.v2.two.behocchu.adapter.ChuCaiAdapter;
import com.v2.two.behocchu.adapter.SoAdapter;
import com.v2.two.behocchu.model.ChuCai;
import com.v2.two.behocchu.model.So;
import com.v2.two.behocchu.model.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HocSoActivity extends AppCompatActivity implements View.OnClickListener {
    private List<So> list;
    private RecyclerView recyclerView;
    private SoAdapter adapter;
    private DatabaseReference mReference;
    private int index = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_so);
        mReference = FirebaseDatabase.getInstance().getReference();
        initView();
        initData(0);
    }

    private void initData(int index) {
        list = new ArrayList<>();
        this.index = index;
        mReference.child("chuso").child("" + index).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                So so = dataSnapshot.getValue(So.class);
                list.add(so);
                adapter = new SoAdapter(list, HocSoActivity.this);
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
        recyclerView = (RecyclerView) findViewById(R.id.recycle_so);
        recyclerView.setHasFixedSize(true);
        int mNoOfColumns = Utility.calculateNoOfColumns(getApplicationContext());
        GridLayoutManager manager = new GridLayoutManager(this, mNoOfColumns + 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        findViewById(R.id.btn_back).setOnClickListener(this);
        findViewById(R.id.btn_auto).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_auto:
                if (adapter!=null){
                    list.clear();
                    adapter.notifyDataSetChanged();
                    if (index==0){
                        initData(1);
                    } else {
                        initData(0);
                    }
                }
                break;

        }
    }
}
