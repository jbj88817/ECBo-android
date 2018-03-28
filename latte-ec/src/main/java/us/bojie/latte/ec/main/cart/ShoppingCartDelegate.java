package us.bojie.latte.ec.main.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import us.bojie.latte.delegates.bottom.BottomItemDelegate;
import us.bojie.latte.ec.R;
import us.bojie.latte.net.RestClient;
import us.bojie.latte.net.callback.ISuccess;

/**
 * Created by bojiejiang on 3/22/18.
 */

public class ShoppingCartDelegate extends BottomItemDelegate implements ISuccess {

    @Override
    public Object setLayout() {
        return R.layout.delegate_shopping_cart;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder()
                .url("shop_cart.php")
                .loader(getContext())
                .success(this)
                .build()
                .get();
    }

    @Override
    public void onSuccess(String response) {
        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
    }
}
