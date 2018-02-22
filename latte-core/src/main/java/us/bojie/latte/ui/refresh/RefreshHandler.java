package us.bojie.latte.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;

import us.bojie.latte.app.Latte;

/**
 * Created by bojiejiang on 2/21/18.
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;

    public RefreshHandler(SwipeRefreshLayout swipeRefreshLayout) {
        mSwipeRefreshLayout = swipeRefreshLayout;
        mSwipeRefreshLayout.setOnRefreshListener(this);
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

    @Override
    public void onRefresh() {
        refresh();
    }
}
