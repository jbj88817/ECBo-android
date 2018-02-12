package us.bojie.latte.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import us.bojie.latte.delegates.LatteDelegate;
import us.bojie.latte.ec.R;
import us.bojie.latte.ec.R2;

/**
 * Created by bojiejiang on 2/11/18.
 */

public class SignInDelegate extends LatteDelegate {
    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword;

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn() {
        if (checkForm()) {
            // TODO
        }
    }

    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWeChat() {

    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink() {
        start(new SignUpDelegate());
    }

    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();
        boolean isPass = true;


        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("Email address is wrong!");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("Password at least 6 digits");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
