package us.bojie.latte.ec.main.cart;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

import us.bojie.latte.ui.recycler.DataConverter;
import us.bojie.latte.ui.recycler.MultipleFields;
import us.bojie.latte.ui.recycler.MultipleItemEntity;

public class ShoppingCartDataConverter extends DataConverter {

    @Override
    public ArrayList<MultipleItemEntity> convert() {
        final ArrayList<MultipleItemEntity> dataList = new ArrayList<>();
        final JSONArray dataArray = JSON.parseObject(getJsonData()).getJSONArray("data");

        final int size = dataArray.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = dataArray.getJSONObject(i);
            final String thumb = data.getString("thumb");
            final String desc = data.getString("desc");
            final String title = data.getString("title");
            final int id = data.getInteger("id");
            final int count = data.getInteger("count");
            final double price = data.getDouble("price");

            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleFields.ITEM_TYPE, ShoppingCartItemType.SHOP_CART_ITEM)
                    .setField(MultipleFields.ID, id)
                    .setField(MultipleFields.IMAGE_URL, thumb)
                    .setField(ShoppingCartItemFields.TITLE, title)
                    .setField(ShoppingCartItemFields.DESC, desc)
                    .setField(ShoppingCartItemFields.COUNT, count)
                    .setField(ShoppingCartItemFields.PRICE, price)
                    .setField(ShoppingCartItemFields.IS_SELECTED, false)
                    .setField(ShoppingCartItemFields.POSITION, i)
                    .build();

            dataList.add(entity);
        }

        return dataList;
    }
}
