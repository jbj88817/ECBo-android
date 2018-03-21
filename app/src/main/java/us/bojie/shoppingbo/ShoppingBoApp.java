package us.bojie.shoppingbo;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import us.bojie.latte.app.Latte;
import us.bojie.shoppingbo.event.TestEvent;
import us.bojie.latte.ec.database.DatabaseManager;
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
                .withApiHost("http://192.168.1.20:8080/RestServer/api/")
                .withInterceptor(new DebugInterceptor("haha", R.raw.test))
                .withWeChatAppID("wxfcdcecd9df8e0faa")
                .withWeChatAppSecret("a0560f75335b06e3ebea70f29ff219bf")
                .withJavascriptInterface("latte")
                .withWebEvent("test", new TestEvent())
                .configure();

        //Initialize logger
        Logger.addLogAdapter(new AndroidLogAdapter());

        // Database
        DatabaseManager.getInstance().init(this);

        initStetho();
    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build()
        );
    }
}
