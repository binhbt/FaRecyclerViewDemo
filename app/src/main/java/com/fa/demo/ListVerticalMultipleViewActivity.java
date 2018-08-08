package com.fa.demo;

import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by binhbt on 7/22/2016.
 */
public class ListVerticalMultipleViewActivity extends FaBaseMultipleViewActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_list_vertical;
    }

    @Override
    protected boolean isSwipeToDismissEnabled() {
        return false;
    }

    @Override
    protected LinearLayoutManager getLayoutManager() {
        return null;
    }
}
