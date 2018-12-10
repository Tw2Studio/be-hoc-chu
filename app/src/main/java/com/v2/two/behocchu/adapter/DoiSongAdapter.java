package com.v2.two.behocchu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.v2.two.behocchu.R;
import com.v2.two.behocchu.model.ChuCai;

import java.util.List;

public class DoiSongAdapter extends RecyclerView.Adapter<DoiSongAdapter.MyViewHolder> {
    private List<ChuCai> list;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        private ImageView imageView;
        private LinearLayout linearLayout;

        public MyViewHolder(View v) {
            super(v);
            tvName = (TextView) v.findViewById(R.id.tv_name_doisong);
            imageView = (ImageView) v.findViewById(R.id.img_doisong);
            linearLayout = (LinearLayout) v.findViewById(R.id.linear_doisong);
        }
    }

    public DoiSongAdapter(List<ChuCai> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public DoiSongAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_doi_song, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ChuCai chuCai = list.get(position);
        if (chuCai.getImage() != null) {
            Picasso.get().load(chuCai.getImage()).into(holder.imageView);
        }

        holder.tvName.setText(chuCai.getChu());

        holder.linearLayout.setBackgroundResource(R.drawable.bg_abc_1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
