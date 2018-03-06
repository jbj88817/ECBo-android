package us.bojie.latte.ec.main.sort.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import us.bojie.latte.delegates.LatteDelegate;
import us.bojie.latte.ec.R;

/**
 * Created by bojiejiang on 3/5/18.
 */

public class VerticalListDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_vertical_list;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
