package us.bojie.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;
import us.bojie.latte.delegates.LatteDelegate;
import us.bojie.latte.ec.R;
import us.bojie.latte.ec.R2;
import us.bojie.latte.ui.launcher.ScrollLauncherTag;
import us.bojie.latte.util.storage.LattePreference;
import us.bojie.latte.util.timer.BaseTimeTask;
import us.bojie.latte.util.timer.ITimerListener;

/**
 * Created by bojiejiang on 2/11/18.
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    private Timer mTimer = null;
    private int mCount = 5;

    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
        finishTimer();
    }

    private void finishTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkIsShowScroll();
        }
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimeTask timeTask = new BaseTimeTask(this);
        mTimer.schedule(timeTask, 0, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    private void checkIsShowScroll() {
        if (!LattePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name())) {
            start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
            // TODO check if user has login
        }
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("Skip\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        finishTimer();
                    }
                }
            }
        });
    }
}
