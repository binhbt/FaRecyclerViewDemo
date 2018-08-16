package com.fa.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.fa.demo.model.PhotoItem;
import com.fa.demo.model.TextItem;
import com.vn.fa.adapter.FaAdapter;
import com.vn.fa.adapter.infinite.InfiniteAdapter;
import com.vn.fa.adapter.multipleviewtype.IViewBinder;
import com.vn.fa.widget.FaRecyclerView;

import java.util.ArrayList;

/**
 * Created by binhbt on 7/22/2016.
 */
public abstract class FaBaseMultipleViewActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{

    protected FaRecyclerView mRecycler;
    private FaAdapter mAdapter;
    private Handler mHandler;
    private int pageCount =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        ArrayList<String> list = new ArrayList<>();
        mAdapter = new FaAdapter();

        mRecycler = (FaRecyclerView) findViewById(R.id.list);
        //mLayoutManager = getLayoutManager();
        //mRecycler.setLayoutManager(mLayoutManager);
        if (getLayoutManager() != null)
            mRecycler.setLayoutManager(getLayoutManager());
        mRecycler.addItemDecoration(new PaddingItemDecoration());


        mHandler = new Handler(Looper.getMainLooper());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mRecycler.setAdapter(mAdapter);
                        mRecycler.getProgressView().setVisibility(View.GONE);
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //mAdapter.addAll(new String[]{"More stuff", "More stuff", "More stuff", "More stuff", "More stuff", "More stuff", "More stuff", "More stuff", "More stuff"});
                        mAdapter.addBinder(new PhotoItem().getViewBinder());
                        mAdapter.addBinder(new TextItem().getViewBinder());
                        mAdapter.notifyDataSetChanged();
                    }
                });


            }
        });
        thread.start();

        mRecycler.setRefreshListener(this);
        mRecycler.setRefreshingColorResources(android.R.color.holo_orange_light, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_red_light);
        mAdapter.setOnLoadMoreListener(new InfiniteAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (pageCount <10) {
                    mHandler.postDelayed(new Runnable() {
                        public void run() {
                            ArrayList<IViewBinder> list = new ArrayList<IViewBinder>();
                            list.add(new PhotoItem());
                            list.add(new TextItem());
                            list.add(new PhotoItem());
                            list.add(new TextItem());
                            mAdapter.addAllDataObject(list);
                        }
                    }, 1000);
                    pageCount ++;
                }else{
                    mAdapter.setShouldLoadMore(false);
                }
            }
        });
    }

    protected abstract int getLayoutId();

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    @Override
    public void onRefresh() {
        pageCount =0;
        mAdapter.setShouldLoadMore(true);

        Toast.makeText(this, "Refresh", Toast.LENGTH_LONG).show();
        mHandler.postDelayed(new Runnable() {
            public void run() {
                mAdapter.addDataObject(new PhotoItem());
                mAdapter.addDataObject(new TextItem());
            }
        }, 2000);
        pageCount =0;
    }

}
