package us.bojie.latte.ui.recycler;

import java.util.ArrayList;

/**
 * Created by bojiejiang on 2/21/18.
 */

public abstract class DataConverter {

    protected ArrayList<MultipleItemEntity> mEntities = new ArrayList<>();
    private String mJsonData;

    public abstract ArrayList<MultipleItemEntity> convert();

    public DataConverter setJsonData(String jsonData) {
        mJsonData = jsonData;
        return this;
    }

}
