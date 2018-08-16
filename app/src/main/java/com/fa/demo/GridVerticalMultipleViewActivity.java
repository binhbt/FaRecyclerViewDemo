package com.fa.demo;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class GridVerticalMultipleViewActivity extends FaBaseMultipleViewActivity{
    @Override
    protected int getLayoutId() {
        return R.layout.activity_grid_vertical;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //use for grid loading. If dont use Grid manager >> remove it
        mRecycler.setLoadingSpanCount(3);
    }
}
