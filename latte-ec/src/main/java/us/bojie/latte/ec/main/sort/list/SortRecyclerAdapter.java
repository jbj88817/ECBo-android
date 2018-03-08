package us.bojie.latte.ec.main.sort.list;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import java.util.List;

import us.bojie.latte.delegates.LatteDelegate;
import us.bojie.latte.ec.R;
import us.bojie.latte.ec.main.sort.SortDelegate;
import us.bojie.latte.ec.main.sort.content.ContentDelegate;
import us.bojie.latte.ui.recycler.ItemType;
import us.bojie.latte.ui.recycler.MultipleFields;
import us.bojie.latte.ui.recycler.MultipleItemEntity;
import us.bojie.latte.ui.recycler.MultipleRecyclerViewAdapter;
import us.bojie.latte.ui.recycler.MultipleViewHolder;

/**
 * Created by bojiejiang on 3/5/18.
 */

public class SortRecyclerAdapter extends MultipleRecyclerViewAdapter {

    private SortDelegate mSortDelegate;
    private int mPrePosition;

    protected SortRecyclerAdapter(List<MultipleItemEntity> data, SortDelegate delegate) {
        super(data);
        mSortDelegate = delegate;

        addItemType(ItemType.VERTICAL_MENU_LIST, R.layout.item_vertical_menu_list);
    }

    @Override
    protected void convert(final MultipleViewHolder holder, final MultipleItemEntity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case ItemType.VERTICAL_MENU_LIST:
                final String text = entity.getField(MultipleFields.TEXT);
                final boolean isClicked = entity.getField(MultipleFields.TAG);
                final AppCompatTextView name = holder.getView(R.id.tv_vertical_item_name);
                final View line = holder.getView(R.id.view_line);
                final View itemView = holder.itemView;
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final int currentPosition = holder.getAdapterPosition();
                        if (mPrePosition != currentPosition) {
                            // Restore previous one
                            getData().get(mPrePosition).setField(MultipleFields.TAG, false);
                            notifyItemChanged(mPrePosition);

                            // Refresh selected item
                            entity.setField(MultipleFields.TAG, true);
                            notifyItemChanged(currentPosition);
                            mPrePosition = currentPosition;

                            final int contentId = getData().get(currentPosition).getField(MultipleFields.ID);
                            showContent(contentId);
                        }
                    }
                });

                if (!isClicked) {
                    line.setVisibility(View.GONE);
                    name.setTextColor(ContextCompat.getColor(mContext, R.color.we_chat_black));
                    itemView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.item_background));
                } else {
                    line.setVisibility(View.VISIBLE);
                    name.setTextColor(ContextCompat.getColor(mContext, R.color.app_main));
                    line.setBackgroundColor(ContextCompat.getColor(mContext, R.color.app_main));
                    itemView.setBackgroundColor(Color.WHITE);
                }

                holder.setText(R.id.tv_vertical_item_name, text);
                break;
            default:
                break;
        }
    }

    private void showContent(int contentId) {
        final ContentDelegate delegate = ContentDelegate.newInstance(contentId);
        switchContent(delegate);
    }

    private void switchContent(ContentDelegate delegate) {
        final LatteDelegate contentDelegate = mSortDelegate.findChildFragment(ContentDelegate.class);
        if (contentDelegate != null) {
            contentDelegate.replaceFragment(delegate, false);
        }
    }
}
