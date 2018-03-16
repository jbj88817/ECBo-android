package us.bojie.latte.delegates.web.route;

import us.bojie.latte.delegates.web.WebDelegate;

/**
 * Created by bojiejiang on 3/15/18.
 */

public class Router {

    private Router() {
    }

    private static class Holder {
        private static final Router INSTANCE = new Router();
    }

    public static Router getInstance() {
        return Holder.INSTANCE;
    }

    public final boolean handleWebUrl(WebDelegate delegate, String url) {
        return true;
    }

}
