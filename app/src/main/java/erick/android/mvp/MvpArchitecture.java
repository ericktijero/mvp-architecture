package erick.android.mvp;

import android.app.Application;
import android.location.Location;

import erick.android.mvp.domain.executor.MainThreadExecutor;
import erick.android.mvp.domain.executor.MainThreadExecutorImp;
import erick.android.mvp.domain.executor.ThreadExecutor;

/**
 * Created by erick on 8/8/17.
 */

public class MvpArchitecture extends Application {
    public static Location USER_LOCATION = null;
    public static ThreadExecutor threadExecutor;
    public static MainThreadExecutor mainThreadExecutor;

    @Override
    public void onCreate() {
        super.onCreate();
        threadExecutor = new ThreadExecutor();
        mainThreadExecutor = new MainThreadExecutorImp();
    }
}
