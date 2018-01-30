package us.bojie.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by bojiejiang on 1/22/18.
 */

public final class Latte {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigKeys.APPLICATION_CONTENT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplicationContext() {
        return (Context) getConfigurations().get(ConfigKeys.APPLICATION_CONTENT.name());
    }
}
