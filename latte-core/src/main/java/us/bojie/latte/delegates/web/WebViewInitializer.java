package us.bojie.latte.delegates.web;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by bojiejiang on 3/17/18.
 */

public class WebViewInitializer {
    public WebView createWebView(WebView webView) {
        WebView.setWebContentsDebuggingEnabled(true);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        // Allow screenshot
        webView.setDrawingCacheEnabled(true);
        // No longClick
        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });

        // Init settings
        final WebSettings settings = webView.getSettings();
        final String ua = settings.getUserAgentString();
        settings.setUserAgentString(ua + "Latte");

        // Hide zoom controls
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        // Don't allow zoom
        settings.setSupportZoom(false);
        // File permission
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowContentAccess(true);
        // Cache
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        return webView;
    }
}
