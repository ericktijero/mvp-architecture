package erick.android.mvp.domain.executor;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by erick on 8/8/17.
 */

public class MainThreadExecutorImp implements MainThreadExecutor {
    private Handler handler;

    public MainThreadExecutorImp() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}
