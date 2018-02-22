package us.bojie.latte.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import us.bojie.latte.delegates.bottom.BottomItemDelegate;
import us.bojie.latte.ec.R;

/**
 * Created by bojiejiang on 2/21/18.
 */

public class SortDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
