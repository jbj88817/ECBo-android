package us.bojie.latte.ec.main.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import us.bojie.latte.delegates.bottom.BottomItemDelegate;
import us.bojie.latte.ec.R;
import us.bojie.latte.ec.R2;
import us.bojie.latte.net.RestClient;
import us.bojie.latte.net.callback.ISuccess;
import us.bojie.latte.ui.recycler.MultipleItemEntity;

/**
 * Created by bojiejiang on 3/22/18.
 */

public class ShoppingCartDelegate extends BottomItemDelegate implements ISuccess {

    @BindView(R2.id.rv_shopping_cart)
    RecyclerView mRecyclerView;

    private ShoppingCartAdapter mAdapter;

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
        final ArrayList<MultipleItemEntity> data =
                new ShoppingCartDataConverter()
                        .setJsonData(response)
                        .convert();
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new ShoppingCartAdapter(data);
        mRecyclerView.setAdapter(mAdapter);
    }
}
