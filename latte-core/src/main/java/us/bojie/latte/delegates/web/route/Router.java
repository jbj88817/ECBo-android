package us.bojie.latte.delegates.web.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.webkit.URLUtil;
import android.webkit.WebView;

import us.bojie.latte.delegates.LatteDelegate;
import us.bojie.latte.delegates.web.WebDelegate;
import us.bojie.latte.delegates.web.WebDelegateImpl;

/**
 * Created by bojiejiang on 3/15/18.
 */

public class Router {

    private Router() {
    }

    private static class Holder {
        private static final Router INSTANCE = new Router();
    }

    public static Router getInstance() {
        return Holder.INSTANCE;
    }

    public final boolean handleWebUrl(WebDelegate delegate, String url) {
        if (url.contains("tel:")) {
            callPhone(delegate.getContext(), url);
            return true;
        }

        final LatteDelegate parentDelegate = delegate.getParentDelegate();
        final WebDelegateImpl webDelegate = WebDelegateImpl.create(url);
        if (parentDelegate == null) {
            delegate.start(webDelegate);
        } else {
            parentDelegate.start(webDelegate);
        }
        return true;
    }

    private void loadWebPage(WebView webView, String url) {
        if (webView != null) {
            webView.loadUrl(url);
        } else {
            throw new NullPointerException("WebView is null");
        }
    }

    private void loadLocalPage(WebView webView, String url) {
        loadWebPage(webView, "file:///android_asset/" + url);
    }

    public void loadPage(WebView webView, String url) {
        if (URLUtil.isNetworkUrl(url) || URLUtil.isAssetUrl(url)) {
            loadWebPage(webView, url);
        } else {
            loadLocalPage(webView, url);
        }
    }

    private void callPhone(Context context, String url) {
        final Intent intent = new Intent(Intent.ACTION_DIAL);
        final Uri data = Uri.parse(url);
        intent.setData(data);
        ContextCompat.startActivity(context, intent, null);
    }
}
