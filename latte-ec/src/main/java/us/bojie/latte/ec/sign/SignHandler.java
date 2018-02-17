package us.bojie.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import us.bojie.latte.app.AccountManger;
import us.bojie.latte.ec.database.DatabaseManager;
import us.bojie.latte.ec.database.UserProfile;

/**
 * Created by bojiejiang on 2/15/18.
 */

public class SignHandler {

    public static void onSignUp(String response, ISignListener signListener) {
        final JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        final long userId = profileJson.getLong("userId");
        final String name = profileJson.getString("name");
        final String avatar = profileJson.getString("avatar");
        final String gender = profileJson.getString("gender");
        final String address = profileJson.getString("address");

        final UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getUserProfileDao().insert(profile);

        // Save signUp state
        AccountManger.setSignState(true);
        signListener.onSignUpSuccess();
    }
}
