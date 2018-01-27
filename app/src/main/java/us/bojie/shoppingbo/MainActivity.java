package us.bojie.shoppingbo;

import us.bojie.latte.actvities.ProxyActivity;
import us.bojie.latte.delegates.LatteDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
