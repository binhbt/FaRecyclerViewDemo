package com.fa.demo.viewmodel;

import android.view.View;

import com.fa.demo.R;
import com.fa.demo.model.TextItem;
import com.vn.fa.adapter.multipleviewtype.BinderViewHolder;
import com.vn.fa.adapter.multipleviewtype.FaDataBinder;

/**
 * Created by binhbt on 7/22/2016.
 */
public class TextItemView extends FaDataBinder<TextItem> {
    public TextItemView(TextItem data){
        super(data);
    }
    @Override
    public void bindViewHolder(BinderViewHolder holder, int position) {
//        TextViewHolder holder1 = (TextViewHolder)holder;
//        holder1.mTxt.setText(data.getText());
    }

    @Override
    public BinderViewHolder newHolder(View parent) {
        return new TextViewHolder(parent);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.item_text;
    }

    static class TextViewHolder extends BinderViewHolder {
//        @Bind(R.id.text)
//        TextView mTxt;
        public TextViewHolder(View view) {
            super(view);
        }
    }
}
