package us.bojie.latte.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;

import us.bojie.latte.app.Latte;
import us.bojie.latte.net.RestClient;
import us.bojie.latte.net.callback.ISuccess;
import us.bojie.latte.ui.recycler.DataConverter;
import us.bojie.latte.ui.recycler.MultipleRecyclerViewAdapter;

/**
 * Created by bojiejiang on 2/21/18.
 */

public class RefreshHandler implements
        SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.RequestLoadMoreListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private PagingBean mPagingBean;
    private RecyclerView mRecyclerView;
    private MultipleRecyclerViewAdapter mAdapter;
    private DataConverter mDataConverter;

    private RefreshHandler(SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView,
                           DataConverter dataConverter, PagingBean pagingBean) {
        mSwipeRefreshLayout = swipeRefreshLayout;
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mPagingBean = pagingBean;
        mRecyclerView = recyclerView;
        mDataConverter = dataConverter;
    }

    public static RefreshHandler create(SwipeRefreshLayout swipeRefreshLayout,
                                        RecyclerView recyclerView, DataConverter dataConverter) {
        return new RefreshHandler(swipeRefreshLayout, recyclerView, dataConverter, new PagingBean());
    }

    private void refresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Call server
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }

    public void firstPage(String url) {
        mPagingBean.setDelayed(1000);
        RestClient.builder()
                .url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final JSONObject object = JSON.parseObject(response);
                        mPagingBean.setTotal(object.getInteger("total"))
                                .setPageSize(object.getInteger("page_size"));
                        mAdapter = MultipleRecyclerViewAdapter.create(mDataConverter.setJsonData(response));
                        mAdapter.setOnLoadMoreListener(RefreshHandler.this, mRecyclerView);
                        mRecyclerView.setAdapter(mAdapter);
                        mPagingBean.addIndex();
                    }
                })
                .build()
                .get();
    }

    @Override
    public void onRefresh() {
        refresh();
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
