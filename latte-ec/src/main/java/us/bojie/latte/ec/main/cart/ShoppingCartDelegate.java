package us.bojie.latte.ec.main.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import us.bojie.latte.delegates.bottom.BottomItemDelegate;
import us.bojie.latte.ec.R;

/**
 * Created by bojiejiang on 3/22/18.
 */

public class ShoppingCartDelegate extends BottomItemDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_shopping_cart;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
