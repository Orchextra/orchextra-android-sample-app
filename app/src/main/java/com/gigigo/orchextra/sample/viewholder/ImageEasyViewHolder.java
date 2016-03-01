package com.gigigo.orchextra.sample.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;
import com.gigigo.orchextra.sample.entities.ImageData;
import com.gigigo.orchextra.sample.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageEasyViewHolder extends EasyViewHolder<ImageData> {

    private final Context context;

    @Bind(R.id.image)
    ImageView image;

    public ImageEasyViewHolder(Context context, ViewGroup parent) {
        super(context, parent, R.layout.image_item);
        this.context = context;

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindTo(ImageData item) {
        Glide.with(context)
                .load(item.getUrl())
                .centerCrop().into(image);
    }
}
