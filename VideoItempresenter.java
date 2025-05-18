package com.example.videobrowserapp;

import android.content.Context;
import android.view.ViewGroup;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.bumptech.glide.Glide;

public class VideoItemPresenter extends Presenter {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        Context context = parent.getContext();

        // Create a TV-friendly ImageCardView.
        ImageCardView cardView = new ImageCardView(context);
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        cardView.setMainImageDimensions(300, 200); // Adjust as needed

        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        VideoItem video = (VideoItem) item;
        ImageCardView cardView = (ImageCardView) viewHolder.view;

        cardView.setTitleText(video.getTitle());
        cardView.setContentText(video.getDescription());

        // Load thumbnail image dynamically using Glide.
        Glide.with(cardView.getContext())
                .load(video.getThumbnailUrl())
                .centerCrop()
                .into(cardView.getMainImageView());
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        // Clean up resources if necessary.
    }
}
