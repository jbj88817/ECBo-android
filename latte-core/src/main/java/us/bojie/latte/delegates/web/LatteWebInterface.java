package us.bojie.latte.delegates.web;

import com.alibaba.fastjson.JSON;

/**
 * Created by bojiejiang on 3/9/18.
 */

public class LatteWebInterface {
    private final WebDelegate mDelegate;

    public LatteWebInterface(WebDelegate delegate) {
        mDelegate = delegate;
    }

    static LatteWebInterface create(WebDelegate delegate) {
        return new LatteWebInterface(delegate);
    }

    public String event(String params){
        final String action = JSON.parseObject(params).getString("action");
        return action;
    }
}
