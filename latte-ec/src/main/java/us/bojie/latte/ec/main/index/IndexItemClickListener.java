package us.bojie.latte.ec.main.index;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;

import us.bojie.latte.delegates.LatteDelegate;
import us.bojie.latte.ec.detail.GoodsDetailDelegate;

/**
 * Created by bojiejiang on 3/4/18.
 */

public class IndexItemClickListener extends SimpleClickListener {

    private LatteDelegate mLatteDelegate;

    private IndexItemClickListener(LatteDelegate latteDelegate) {
        mLatteDelegate = latteDelegate;
    }

    public static SimpleClickListener create(LatteDelegate delegate) {
        return new IndexItemClickListener(delegate);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final GoodsDetailDelegate DELEGATE = GoodsDetailDelegate.create();
        mLatteDelegate.start(DELEGATE);
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
