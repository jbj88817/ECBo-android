package us.bojie.latte.ec.main.sort.list;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

import us.bojie.latte.ui.recycler.DataConverter;
import us.bojie.latte.ui.recycler.ItemType;
import us.bojie.latte.ui.recycler.MultipleFields;
import us.bojie.latte.ui.recycler.MultipleItemEntity;

/**
 * Created by bojiejiang on 3/5/18.
 */

public final class VerticalListDataConverter extends DataConverter {

    @Override
    public ArrayList<MultipleItemEntity> convert() {
        final JSONArray dataArray = JSON
                .parseObject(getJsonData())
                .getJSONObject("data")
                .getJSONArray("list");
        int size = dataArray.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = dataArray.getJSONObject(i);
            final int id = data.getInteger("id");
            final String name = data.getString("name");

            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleFields.ITEM_TYPE, ItemType.VERTICAL_MENU_LIST)
                    .setField(MultipleFields.ID, id)
                    .setField(MultipleFields.TEXT, name)
                    .setField(MultipleFields.TAG, false)
                    .build();

            mEntities.add(entity);
            // Set first one is selected
            mEntities.get(0).setField(MultipleFields.TAG, true);

        }
        return mEntities;
    }
}
