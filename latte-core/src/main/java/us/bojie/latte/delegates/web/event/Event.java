package us.bojie.latte.delegates.web.event;

import android.content.Context;
import android.webkit.WebView;

import us.bojie.latte.delegates.web.WebDelegate;

/**
 * Created by bojiejiang on 3/18/18.
 */

public abstract class Event implements IEvent {
    private Context mContext;
    private String mAction;
    private WebDelegate mDelegate;
    private String mUrl;
    private WebView mWebView;

    public Context getContext() {
        return mContext;
    }

    public WebView getWebView() {
        return mDelegate.getWebView();
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

    public WebDelegate getDelegate() {
        return mDelegate;
    }

    public void setDelegate(WebDelegate delegate) {
        mDelegate = delegate;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }
}
