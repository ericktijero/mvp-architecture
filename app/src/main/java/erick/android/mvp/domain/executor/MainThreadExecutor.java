package erick.android.mvp.domain.executor;

/**
 * Created by erick on 8/8/17.
 */

public interface MainThreadExecutor {
    void execute(Runnable runnable);
}