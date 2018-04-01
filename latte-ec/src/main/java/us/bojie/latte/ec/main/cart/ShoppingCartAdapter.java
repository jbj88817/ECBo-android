package us.bojie.latte.ec.main.cart;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.List;

import us.bojie.latte.app.Latte;
import us.bojie.latte.ec.R;
import us.bojie.latte.ui.recycler.MultipleFields;
import us.bojie.latte.ui.recycler.MultipleItemEntity;
import us.bojie.latte.ui.recycler.MultipleRecyclerViewAdapter;
import us.bojie.latte.ui.recycler.MultipleViewHolder;

public class ShoppingCartAdapter extends MultipleRecyclerViewAdapter {

    private boolean mIsSelectedAll = false;
    private double mTotalPrice = 0.00;

    private static final RequestOptions OPTIONS = new RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .dontAnimate();

    protected ShoppingCartAdapter(List<MultipleItemEntity> data) {
        super(data);

        // Init total price
        for (MultipleItemEntity entity : data) {
            final double price = entity.getField(ShoppingCartItemFields.PRICE);
            final int count = entity.getField(ShoppingCartItemFields.COUNT);
            final double total = price * count;
            mTotalPrice = mTotalPrice + total;
        }

        addItemType(ShoppingCartItemType.SHOP_CART_ITEM, R.layout.item_shopping_cart);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {
        super.convert(holder, entity);
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case ShoppingCartItemType.SHOP_CART_ITEM:
                //Get all values
                final int id = entity.getField(MultipleFields.ID);
                final String thumb = entity.getField(MultipleFields.IMAGE_URL);
                final String title = entity.getField(ShoppingCartItemFields.TITLE);
                final String desc = entity.getField(ShoppingCartItemFields.DESC);
                final int count = entity.getField(ShoppingCartItemFields.COUNT);
                final double price = entity.getField(ShoppingCartItemFields.PRICE);
                //Get all widgets
                final AppCompatImageView imgThumb = holder.getView(R.id.image_item_shopping_cart);
                final AppCompatTextView tvTitle = holder.getView(R.id.tv_item_shopping_cart_title);
                final AppCompatTextView tvDesc = holder.getView(R.id.tv_item_shopping_cart_desc);
                final AppCompatTextView tvPrice = holder.getView(R.id.tv_item_shopping_cart_price);
                final IconTextView iconMinus = holder.getView(R.id.icon_item_minus);
                final IconTextView iconPlus = holder.getView(R.id.icon_item_plus);
                final AppCompatTextView tvCount = holder.getView(R.id.tv_item_shopping_cart_count);
                final IconTextView iconIsSelected = holder.getView(R.id.icon_item_shopping_cart);

                //Set the value
                tvTitle.setText(title);
                tvDesc.setText(desc);
                tvPrice.setText(String.valueOf(price));
                tvCount.setText(String.valueOf(count));
                Glide.with(mContext)
                        .load(thumb)
                        .apply(OPTIONS)
                        .into(imgThumb);

                //Selection
                entity.setField(ShoppingCartItemFields.IS_SELECTED, mIsSelectedAll);
                final boolean isSelected = entity.getField(ShoppingCartItemFields.IS_SELECTED);

                if (isSelected) {
                    iconIsSelected.setTextColor
                            (ContextCompat.getColor(Latte.getApplicationContext(), R.color.app_main));
                } else {
                    iconIsSelected.setTextColor(Color.GRAY);
                }
                break;
            default:
                break;
        }
    }
}
