package us.bojie.latte.delegates.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;

import us.bojie.latte.delegates.web.event.Event;
import us.bojie.latte.delegates.web.event.EventManager;

/**
 * Created by bojiejiang on 3/9/18.
 */

final class LatteWebInterface {
    private final WebDelegate mDelegate;

    public LatteWebInterface(WebDelegate delegate) {
        mDelegate = delegate;
    }

    static LatteWebInterface create(WebDelegate delegate) {
        return new LatteWebInterface(delegate);
    }

    @JavascriptInterface
    public String event(String params){
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().crateEvent(action);
        if (event != null) {
            event.setAction(action);
            event.setDelegate(mDelegate);
            event.setContext(mDelegate.getContext());
            event.setUrl(mDelegate.getUrl());
            return event.execute(params);
        }
        return null;
    }
}
