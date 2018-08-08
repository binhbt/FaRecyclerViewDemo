package com.fa.demo.viewmodel;

import android.view.View;
import android.widget.ImageView;

import com.fa.demo.R;
import com.fa.demo.model.PhotoItem;
import com.vn.fa.adapter.multipleviewtype.BinderViewHolder;
import com.vn.fa.adapter.multipleviewtype.VegaDataBinder;


/**
 * Created by binhbt on 7/22/2016.
 */
public class PhotoItemView extends VegaDataBinder<PhotoItem> {
    public PhotoItemView(PhotoItem data){
        super(data);
    }
    @Override
    public void bindViewHolder(BinderViewHolder holder, int position) {
        PhotoViewHolder holder1 = (PhotoViewHolder)holder;
//        Picasso.with(holder1.mImageView.getContext())
//                .load(data.getUrl())
//                .into(holder1.mImageView);

    }

    @Override
    public BinderViewHolder newHolder(View parent) {
        return new PhotoViewHolder(parent);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.item_photo;
    }

    static class PhotoViewHolder extends BinderViewHolder {
//        @Bind(R.id.photo)
//        ImageView mImageView;
        public PhotoViewHolder(View view) {
            super(view);
        }
    }
}
