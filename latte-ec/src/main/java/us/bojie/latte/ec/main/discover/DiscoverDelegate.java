package us.bojie.latte.ec.main.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import us.bojie.latte.delegates.bottom.BottomItemDelegate;
import us.bojie.latte.delegates.web.WebDelegateImpl;
import us.bojie.latte.ec.R;

/**
 * Created by bojiejiang on 3/7/18.
 */

public class DiscoverDelegate extends BottomItemDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_discover;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final WebDelegateImpl delegate = WebDelegateImpl.create("index.html");
        loadRootFragment(R.id.web_discovery_container, delegate);
    }
}
