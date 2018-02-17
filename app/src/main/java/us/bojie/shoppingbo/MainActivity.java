package us.bojie.shoppingbo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import us.bojie.latte.actvities.ProxyActivity;
import us.bojie.latte.delegates.LatteDelegate;
import us.bojie.latte.ec.sign.ISignListener;
import us.bojie.latte.ec.sign.SignUpDelegate;

public class MainActivity extends ProxyActivity implements ISignListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new SignUpDelegate();
    }

    @Override
    public void onSignInSuccess() {

    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "sign up success", Toast.LENGTH_SHORT).show();
    }
}
