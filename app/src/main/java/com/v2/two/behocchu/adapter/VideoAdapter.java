package com.v2.two.behocchu.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.v2.two.behocchu.model.Video;
import com.v2.two.behocchu.view.activity.PlayVideoActivity;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {
    private List<Video> list;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvVitri;
        private ImageView imageView;
        private LinearLayout linearLayout;

        public MyViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.img_video);
            tvName = (TextView) v.findViewById(R.id.tv_name_video);
            linearLayout = (LinearLayout) v.findViewById(R.id.linear_video);
        }
    }

    public VideoAdapter(List<Video> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public VideoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_video, parent, false);
        VideoAdapter.MyViewHolder vh = new VideoAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(VideoAdapter.MyViewHolder holder, int position) {
        Video video = list.get(position);
        holder.tvName.setText(video.getName());
        Picasso.get().load(video.getImage()).into(holder.imageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayVideoActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
