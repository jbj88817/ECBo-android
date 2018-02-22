package us.bojie.latte.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import us.bojie.latte.delegates.bottom.BottomItemDelegate;
import us.bojie.latte.ec.R;

/**
 * Created by bojiejiang on 2/21/18.
 */

public class IndexDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
