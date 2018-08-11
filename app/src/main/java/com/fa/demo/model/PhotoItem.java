package com.fa.demo.model;


import com.fa.demo.holder.PhotoItemView;
import com.vn.fa.adapter.multipleviewtype.DataBinder;
import com.vn.fa.adapter.multipleviewtype.IViewBinder;

/**
 * Created by binhbt on 7/22/2016.
 */
public class PhotoItem implements IViewBinder {
    private String url = "https://thumb1.shutterstock.com/display_pic_with_logo/298234/128696450/stock-photo-two-pink-flowers-128696450.jpg";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public DataBinder getViewBinder() {
        return new PhotoItemView(this);
    }
}
