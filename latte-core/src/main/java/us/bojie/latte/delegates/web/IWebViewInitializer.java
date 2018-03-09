package us.bojie.latte.delegates.web;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by bojiejiang on 3/7/18.
 */

public interface IWebViewInitializer {

    WebView initWebView(WebView webView);

    WebViewClient initWebViewClient();

    WebChromeClient initWebChromeClient();
}
