package com.v2.two.behocchu.adapter;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.v2.two.behocchu.R;
import com.v2.two.behocchu.model.ChuCai;
import com.v2.two.behocchu.model.So;

import java.util.List;

public class SoAdapter extends RecyclerView.Adapter<SoAdapter.MyViewHolder> {
    private List<So> list;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvVitri;
        private ImageView imageView;
        private LinearLayout linearLayout;

        public MyViewHolder(View v) {
            super(v);
            //tvVitri = (TextView) v.findViewById(R.id.tv_vitri);
            imageView = (ImageView) v.findViewById(R.id.img_item_abc);
            linearLayout = (LinearLayout) v.findViewById(R.id.linear_abc);
        }
    }

    public SoAdapter(List<So> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_abc, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        So so = list.get(position);

        if (so.getImage() != null) {
            Picasso.get().load(so.getImage()).into(holder.imageView);
        }

        holder.linearLayout.setBackgroundResource(R.drawable.bg_abc_1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
