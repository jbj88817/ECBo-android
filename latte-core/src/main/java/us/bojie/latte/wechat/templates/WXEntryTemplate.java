package us.bojie.latte.wechat.templates;

import us.bojie.latte.wechat.BaseWXEntryActivity;
import us.bojie.latte.wechat.LatteWeChat;

/**
 * Created by bojiejiang on 2/18/18.
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getWeChatSignInCallBack().onSignInSuccess(userInfo);
    }
}
