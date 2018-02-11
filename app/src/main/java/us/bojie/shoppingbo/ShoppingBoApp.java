package us.bojie.shoppingbo;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;

import us.bojie.latte.app.Latte;
import us.bojie.latte.ec.icon.FontEcModule;
import us.bojie.latte.net.interceptors.DebugInterceptor;

/**
 * Created by bojiejiang on 1/24/18.
 */

public class ShoppingBoApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configure();
    }
}
