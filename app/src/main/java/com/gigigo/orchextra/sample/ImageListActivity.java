package com.gigigo.orchextra.sample;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.carlosdelachica.easyrecycleradapters.adapter.EasyRecyclerAdapter;
import com.carlosdelachica.easyrecycleradapters.recycler_view_manager.EasyRecyclerViewManager;
import com.gigigo.orchextra.sample.entities.ImageData;
import com.gigigo.orchextra.sample.viewholder.ImageEasyViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageListActivity extends AppCompatActivity {

    private static final int MAX_STACK_ACTIVITIES = 10;
    private static final int MAX_IMAGES_PER_ACTIVITY = 10;

    private static final String EXTRA_INT = "EXTRA_INT";

    @Bind(R.id.detailActivityButton)
    Button detailActivityButton;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private int intExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list_layout);

        ButterKnife.bind(this);

        intExtra = getIntent().getIntExtra(EXTRA_INT, 0);

        detailActivityButton.setText("Go to Detail Activty - " + intExtra);
        detailActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(intExtra);
            }
        });

        EasyRecyclerAdapter adapter = new EasyRecyclerAdapter(this);
        adapter.bind(ImageData.class, ImageEasyViewHolder.class);

        EasyRecyclerViewManager easyRecyclerViewManager = new EasyRecyclerViewManager.Builder(recyclerView, adapter)
                .layoutManager(new GridLayoutManager(this, 2))
                .build();

        List<ImageData> urlList = generateList(MAX_IMAGES_PER_ACTIVITY, intExtra);
        easyRecyclerViewManager.addAll(urlList);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final boolean hasToInitNewActivity = (intExtra < MAX_STACK_ACTIVITIES) || Math.random() * 3 != 1;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (hasToInitNewActivity) {
                    startNewActivity(intExtra);
                } else {
                    finishActivity();
                }
            }
        }, 2500);
    }

    private void finishActivity() {
        finish();
    }

    public void startNewActivity(int intExtra) {
        Intent intent = new Intent(ImageListActivity.this, ImageListActivity.class);
        intent.putExtra(EXTRA_INT, intExtra + 1);
        startActivity(intent);
    }

    private List<ImageData> generateList(int maxItems, int intExtra) {
        List<ImageData> list = new ArrayList<>();
        for (int i = 0; i < maxItems; i++) {
            ImageData imageData = new ImageData();
            imageData.setUrl(generateUrlImage(i, intExtra));
            list.add(imageData);
        }

        return list;
    }

    private String generateUrlImage(int i, int intExtra) {
        String[] array = new String[]{"abstract", "animals", "business", "cats", "city", "food",
                "nightlife", "fashion", "people", "nature", "sports", "technics", "transport"};
        int index = (int) (Math.random() * array.length);

        return ("http://lorempixel.com/1920/500/" + array[index] + "/Dummy" + i + intExtra);
    }
}
