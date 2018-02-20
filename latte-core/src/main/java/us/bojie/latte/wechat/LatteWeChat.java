package us.bojie.latte.wechat;

import android.app.Activity;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import us.bojie.latte.app.ConfigKeys;
import us.bojie.latte.app.Latte;
import us.bojie.latte.wechat.callbacks.IWeChatSignInCallBack;

/**
 * Created by bojiejiang on 2/18/18.
 */

public class LatteWeChat {
    static final String APP_ID = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_ID);
    static final String APP_SECRET = Latte.getConfiguration(ConfigKeys.WE_CHAT_APP_SECRET);
    private final IWXAPI mWXAPI;
    private IWeChatSignInCallBack mWeChatSignInCallBack;

    private static final class Holder {
        private static final LatteWeChat INSTANCE = new LatteWeChat();
    }

    public static LatteWeChat getInstance() {
        return Holder.INSTANCE;
    }

    private LatteWeChat() {
        final Activity activity = Latte.getConfiguration(ConfigKeys.ACTVITY);
        mWXAPI = WXAPIFactory.createWXAPI(activity, APP_ID, true);
        mWXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI() {
        return mWXAPI;
    }

    public LatteWeChat onSignSuccess(IWeChatSignInCallBack callBack) {
        mWeChatSignInCallBack = callBack;
        return this;
    }

    public IWeChatSignInCallBack getWeChatSignInCallBack() {
        return mWeChatSignInCallBack;
    }

    public final void signIn() {
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        mWXAPI.sendReq(req);
    }
}
