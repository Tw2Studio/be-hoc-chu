package com.v2.two.behocchu.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.v2.two.behocchu.R;
import com.v2.two.behocchu.adapter.VideoAdapter;
import com.v2.two.behocchu.model.Utils;
import com.v2.two.behocchu.model.Video;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListVideoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Video> list;
    private VideoAdapter adapter;
    private String ID_PLAYLIST = "PLYLXC-cAzgsnKy105XaSlnS_C7xPYFHKJ";
    private String URL_PLAYLIST = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="
            +ID_PLAYLIST+"&key="+ Utils.KEY_API_YOUTUBE;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_video);
        Intent intent = getIntent();
        ID_PLAYLIST = intent.getStringExtra("ID_PLAYLIST");
        URL_PLAYLIST = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="
                +ID_PLAYLIST+"&key="+ Utils.KEY_API_YOUTUBE;
        initView();
        getJsonYouTube(URL_PLAYLIST);
    }

    private void getJsonYouTube(final String url){
        RequestQueue requestQueue = Volley.newRequestQueue(ListVideoActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject jsonMax = response.getJSONObject("pageInfo");
                            int maxItem = jsonMax.getInt("totalResults");
                            getDataYouTube(url+"&maxResults="+50);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue.add(jsonObjectRequest);
    }

    private void getDataYouTube(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(ListVideoActivity.this);
        list = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonItems = response.getJSONArray("items");
                            String name = "";
                            String image = "";
                            String idVideo = "";

                            for (int i=0; i<jsonItems.length();i++){
                                JSONObject jsonItem = jsonItems.getJSONObject(i);
                                JSONObject jsonSnippet  = jsonItem.getJSONObject("snippet");
                                JSONObject jsonThumbnail = jsonSnippet.getJSONObject("thumbnails");
                                JSONObject jsonMedium = jsonThumbnail.getJSONObject("medium");
                                name = jsonSnippet.getString("title");
                                image = jsonMedium.getString("url");

                                JSONObject jsonIdVideo = jsonSnippet.getJSONObject("resourceId");
                                idVideo = jsonIdVideo.getString("videoId");

                                Video video = new Video(name, image, idVideo, ID_PLAYLIST);
                                list.add(video);
                            }

                            adapter = new VideoAdapter(list, ListVideoActivity.this);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String name = "";
                    }
                });

        requestQueue.add(jsonObjectRequest);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle_list_video);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ListVideoActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
