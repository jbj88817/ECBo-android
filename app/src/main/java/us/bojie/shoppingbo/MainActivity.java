package us.bojie.shoppingbo;

import us.bojie.latte.actvities.ProxyActivity;
import us.bojie.latte.delegates.LatteDelegate;
import us.bojie.latte.ec.launcher.LauncherScrollDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherScrollDelegate();
    }
}
