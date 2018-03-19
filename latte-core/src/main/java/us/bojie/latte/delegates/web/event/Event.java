package us.bojie.latte.delegates.web.event;

import android.content.Context;

import us.bojie.latte.delegates.LatteDelegate;

/**
 * Created by bojiejiang on 3/18/18.
 */

public abstract class Event implements IEvent {
    private Context mContext;
    private String mAction;
    private LatteDelegate mDelegate;
    private String mUrl;

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public String getAction() {
        return mAction;
    }

    public void setAction(String action) {
        mAction = action;
    }

    public LatteDelegate getDelegate() {
        return mDelegate;
    }

    public void setDelegate(LatteDelegate delegate) {
        mDelegate = delegate;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
