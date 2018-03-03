package us.bojie.latte.ui.recycler;

import android.support.v7.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * Created by bojiejiang on 3/1/18.
 */

public class MultipleRecyclerViewAdapter extends
        BaseMultiItemQuickAdapter<MultipleItemEntity, MultipleViewHolder>
        implements BaseQuickAdapter.SpanSizeLookup {


    protected MultipleRecyclerViewAdapter(List<MultipleItemEntity> data) {
        super(data);
    }

    @Override
    protected void convert(MultipleViewHolder helper, MultipleItemEntity item) {

    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return 0;
    }

    public static MultipleRecyclerViewAdapter create(List<MultipleItemEntity> data) {
        return new MultipleRecyclerViewAdapter(data);
    }

    public static MultipleRecyclerViewAdapter create(DataConverter converter) {
        return new MultipleRecyclerViewAdapter(converter.convert());
    }
}
