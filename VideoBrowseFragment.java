package com.example.videobrowserapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Row;
import java.util.ArrayList;
import java.util.List;

public class VideoBrowerFragment extends BrowseSupportFragment {
    private ArrayObjectAdapter mRowsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUIElements();
        loadRows();
        setOnItemViewClickedListener(new ItemViewClickedListener());
    }

    private void setupUIElements() {
        setTitle("Video Streaming App");
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
    }

    private void loadRows() {
        // Create a Presenter for video items.
        VideoItemPresenter videoPresenter = new VideoItemPresenter();
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        // Create a row ("Popular Videos") with six video items.
        List<VideoItem> videoList = createVideoList();
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(videoPresenter);
        for (VideoItem video : videoList) {
            listRowAdapter.add(video);
        }

        HeaderItem header = new HeaderItem(0, "Popular Videos");
        mRowsAdapter.add(new ListRow(header, listRowAdapter));
        setAdapter(mRowsAdapter);
    }

    // Hard-coded video items for demonstration.
    private List<VideoItem> createVideoList() {
        List<VideoItem> videos = new ArrayList<>();
        videos.add(new VideoItem("Video 1", "An amazing adventure",
                "https://path.to/video1.mp4", "https://path.to/thumbnail1.jpg"));
        videos.add(new VideoItem("Video 2", "Explore the unknown",
                "https://path.to/video2.mp4", "https://path.to/thumbnail2.jpg"));
        videos.add(new VideoItem("Video 3", "The epic journey",
                "https://path.to/video3.mp4", "https://path.to/thumbnail3.jpg"));
        videos.add(new VideoItem("Video 4", "Mystery unfolds",
                "https://path.to/video4.mp4", "https://path.to/thumbnail4.jpg"));
        videos.add(new VideoItem("Video 5", "Incredible science",
                "https://path.to/video5.mp4", "https://path.to/thumbnail5.jpg"));
        videos.add(new VideoItem("Video 6", "Stunning visuals",
                "https://path.to/video6.mp4", "https://path.to/thumbnail6.jpg"));
        return videos;
    }

    // When a video item is clicked, open the VideoPlayerActivity.
    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        @Override
        public void onItemClicked(androidx.leanback.widget.Presenter.ViewHolder itemViewHolder, Object item,
                                  androidx.leanback.widget.RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof VideoItem) {
                VideoItem video = (VideoItem) item;
                Intent intent = new Intent(getActivity(), VideoPlayerActivity.class);
                intent.putExtra("videoUrl", video.getVideoUrl()); // Ensure this is correctly set
                startActivity(intent);
            }
        }
    }
}
