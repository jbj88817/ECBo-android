package us.bojie.latte.ec.main;

import android.graphics.Color;

import java.util.LinkedHashMap;

import us.bojie.latte.delegates.bottom.BaseBottomDelegate;
import us.bojie.latte.delegates.bottom.BottomItemDelegate;
import us.bojie.latte.delegates.bottom.BottomTabBean;
import us.bojie.latte.delegates.bottom.ItemBuilder;
import us.bojie.latte.ec.main.index.IndexDelegate;
import us.bojie.latte.ec.main.sort.SortDelegate;

/**
 * Created by bojiejiang on 2/21/18.
 */

public class EcBottomDelegate extends BaseBottomDelegate {


    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "Main"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "Category"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "Discover"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "Cart"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-user}", "Me"), new IndexDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#FFFF8800");
    }
}
