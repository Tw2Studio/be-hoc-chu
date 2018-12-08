package com.v2.two.behocchu.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.v2.two.behocchu.R;
import com.v2.two.behocchu.model.Utils;

public class PlayVideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private YouTubePlayerView youTubePlayerView;
    private int REQUEST_CODE = 123;
    private String idVideo;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_play_video);
        Intent intent = getIntent();
        idVideo = intent.getStringExtra("ID_VIDEO");
        initView();
    }

    private void initView() {
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);

        youTubePlayerView.initialize(Utils.KEY_API_YOUTUBE, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo(idVideo);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(PlayVideoActivity.this, REQUEST_CODE);
        } else {
            Toast.makeText(this, "Error !", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            youTubePlayerView.initialize(Utils.KEY_API_YOUTUBE, PlayVideoActivity.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
