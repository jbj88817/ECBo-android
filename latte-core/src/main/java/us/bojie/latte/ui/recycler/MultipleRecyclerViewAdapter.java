package us.bojie.latte.ui.recycler;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;

import java.util.List;

/**
 * Created by bojiejiang on 3/1/18.
 */

public class MultipleRecyclerViewAdapter extends
        BaseMultiItemQuickAdapter<MultipleItemEntity, MultipleViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultipleRecyclerViewAdapter(List<MultipleItemEntity> data) {
        super(data);
    }

    @Override
    protected void convert(MultipleViewHolder helper, MultipleItemEntity item) {

    }
}
