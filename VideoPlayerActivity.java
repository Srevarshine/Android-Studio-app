package com.example.videobrowserapp;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class VideoPlayerActivity extends AppCompatActivity {
    private SimpleExoPlayer player;
    private PlayerView playerView;
    private String videoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        playerView = findViewById(R.id.player_view);
        videoUrl = getIntent().getStringExtra("videoUrl");

        // Initialize ExoPlayer.
        player = new SimpleExoPlayer.Builder(this).build();
        playerView.setPlayer(player);

        // Prepare the media source.
        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(videoUrl));
        player.setMediaItem(mediaItem);
        player.prepare();

        // Auto-play on ready.
        player.setPlayWhenReady(true);
    }

    @Override
    protected void onPause(){
        super.onPause();
        if (player != null) {
            player.setPlayWhenReady(false);
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (player != null) {
            player.release();
            player = null;
        }
    }
}
