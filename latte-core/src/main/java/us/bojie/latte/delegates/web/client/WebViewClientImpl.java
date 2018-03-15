package us.bojie.latte.delegates.web.client;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import us.bojie.latte.delegates.web.WebDelegate;
import us.bojie.latte.util.log.LatteLogger;

/**
 * Created by bojiejiang on 3/14/18.
 */

public class WebViewClientImpl extends WebViewClient {

    private WebDelegate mDelegate;

    public WebViewClientImpl(WebDelegate delegate) {
        mDelegate = delegate;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        LatteLogger.d("shouldOverrideUrlLoading", url);
        return super.shouldOverrideUrlLoading(view, url);
    }
}
