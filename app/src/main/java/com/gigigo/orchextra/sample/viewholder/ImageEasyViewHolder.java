/*
 * Created by Orchextra
 *
 * Copyright (C) 2016 Gigigo Mobile Services SL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
