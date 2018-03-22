package us.bojie.latte.delegates.web.client;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import us.bojie.latte.delegates.web.WebDelegate;
import us.bojie.latte.delegates.web.route.Router;
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
        return Router.getInstance().handleWebUrl(mDelegate, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }
}
