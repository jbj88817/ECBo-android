package us.bojie.latte.delegates.web.event;

import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by bojiejiang on 3/18/18.
 */

public class TestEvent extends Event {
    @Override
    public String execute(String params) {
        Toast.makeText(getContext(), params, Toast.LENGTH_SHORT).show();
        if (getAction().equals("test")) {
            final WebView webView = getWebView();
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.evaluateJavascript("nativecall();", null);
                }
            });
        }
        return null;
    }
}
