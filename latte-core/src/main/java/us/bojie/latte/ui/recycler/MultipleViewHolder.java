package us.bojie.latte.ui.recycler;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by bojiejiang on 3/1/18.
 */

public class MultipleViewHolder extends BaseViewHolder {

    public MultipleViewHolder(View view) {
        super(view);
    }

    public static MultipleViewHolder create(View view) {
        return new MultipleViewHolder(view);
    }

}
