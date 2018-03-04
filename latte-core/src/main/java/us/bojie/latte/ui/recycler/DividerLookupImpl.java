package us.bojie.latte.ui.recycler;

import com.choices.divider.Divider;
import com.choices.divider.DividerItemDecoration;

/**
 * Created by bojiejiang on 3/4/18.
 */

public class DividerLookupImpl implements DividerItemDecoration.DividerLookup {

    private int mColor;
    private int mSize;

    public DividerLookupImpl(int color, int size) {
        mColor = color;
        mSize = size;
    }

    @Override
    public Divider getVerticalDivider(int position) {
        return new Divider.Builder()
                .size(mSize)
                .color(mColor)
                .build();
    }

    @Override
    public Divider getHorizontalDivider(int position) {
        return new Divider.Builder()
                .size(mSize)
                .color(mColor)
                .build();
    }
}
