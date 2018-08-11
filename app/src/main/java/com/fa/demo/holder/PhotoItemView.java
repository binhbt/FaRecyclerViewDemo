package com.fa.demo.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fa.demo.R;
import com.fa.demo.model.PhotoItem;
import com.squareup.picasso.Picasso;
import com.vn.fa.adapter.multipleviewtype.BinderViewHolder;
import com.vn.fa.adapter.multipleviewtype.FaDataBinder;


/**
 * Created by binhbt on 7/22/2016.
 */
public class PhotoItemView extends FaDataBinder<PhotoItem> {
    public PhotoItemView(PhotoItem data){
        super(data);
    }
    @Override
    public void bindViewHolder(BinderViewHolder holder, int position) {
        PhotoViewHolder holder1 = (PhotoViewHolder)holder;
        Picasso.get()
                .load(data.getUrl())
                .into(holder1.mImageView);
        holder1.txtTitle.setText("Photo "+ position);
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
        ImageView mImageView;
        TextView txtTitle;
        public PhotoViewHolder(View view) {
            super(view);
            mImageView = view.findViewById(R.id.photo);
            txtTitle = view.findViewById(R.id.txt_title);
        }
    }
}
