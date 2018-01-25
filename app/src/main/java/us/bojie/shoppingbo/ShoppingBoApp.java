package us.bojie.shoppingbo;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;

import us.bojie.latte.app.Latte;

/**
 * Created by bojiejiang on 1/24/18.
 */

public class ShoppingBoApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
