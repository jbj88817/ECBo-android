package us.bojie.latte.app;

import us.bojie.latte.util.storage.LattePreference;

/**
 * Created by bojiejiang on 2/16/18.
 */

public class AccountManger {

    private enum SignTag {
        SIGN_TAG
    }

    public static void setSignState(boolean state) {
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(), state);
    }

    private static boolean isSignIn() {
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker) {
        if (isSignIn()) {
            checker.onSignIn();
        } else {
            checker.onNotSignIn();
        }
    }
}
