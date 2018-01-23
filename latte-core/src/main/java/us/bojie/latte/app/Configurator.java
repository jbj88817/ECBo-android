package us.bojie.latte.app;

import java.util.WeakHashMap;

/**
 * Created by bojiejiang on 1/22/18.
 */

public class Configurator {

    private static final WeakHashMap<String, Object> LATTE_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    // 静态内部类单例模式的初始化
    private static class Holder {
        public static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }
}
