package us.bojie.latte.util.timer;

import java.util.TimerTask;

/**
 * Created by bojiejiang on 2/11/18.
 */

public class BaseTimeTask extends TimerTask {

    private ITimerListener mITimerListener = null;

    public BaseTimeTask(ITimerListener timerListener) {
        mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}
