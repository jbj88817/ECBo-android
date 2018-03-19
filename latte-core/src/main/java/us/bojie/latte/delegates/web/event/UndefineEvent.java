package us.bojie.latte.delegates.web.event;

import us.bojie.latte.util.log.LatteLogger;

/**
 * Created by bojiejiang on 3/18/18.
 */

public class UndefineEvent extends Event {
    @Override
    public String execute(String params) {
        LatteLogger.e("UndefineEvent", params);
        return null;
    }
}
