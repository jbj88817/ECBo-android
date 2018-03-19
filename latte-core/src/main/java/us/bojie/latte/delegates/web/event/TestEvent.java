package us.bojie.latte.delegates.web.event;

import android.widget.Toast;

/**
 * Created by bojiejiang on 3/18/18.
 */

public class TestEvent extends Event {
    @Override
    public String execute(String params) {
        Toast.makeText(getContext(), params, Toast.LENGTH_SHORT).show();
        return null;
    }
}
