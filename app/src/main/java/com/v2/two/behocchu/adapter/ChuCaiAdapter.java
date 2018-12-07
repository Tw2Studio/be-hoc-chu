package com.v2.two.behocchu.adapter;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
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

import java.util.List;

public class ChuCaiAdapter extends RecyclerView.Adapter<ChuCaiAdapter.MyViewHolder> {
    private List<ChuCai> list;
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

    public ChuCaiAdapter(List<ChuCai> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ChuCaiAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_abc, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ChuCai chuCai = list.get(position);

        Display display = ((AppCompatActivity) context).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        /*if (width<height) {
            holder.linearLayout.setLayoutParams(new LinearLayout.LayoutParams(width / 3 - 60, width / 2 -90));
        } else {
            holder.linearLayout.setLayoutParams(new LinearLayout.LayoutParams(width / 4 - 90, width *3 / 8 - 135));
        }*/
        //GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) holder.linearLayout.getLayoutParams();

        if (chuCai.getImage() != null) {
            Picasso.get().load(chuCai.getImage()).into(holder.imageView);
        }

        holder.linearLayout.setBackgroundResource(R.drawable.bg_abc_1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
