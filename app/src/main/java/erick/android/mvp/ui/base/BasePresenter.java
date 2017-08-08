package erick.android.mvp.ui.base;

/**
 * Created by erick on 8/8/17.
 */

public interface BasePresenter<T> {
    void onCreate(T view);

    void onDestroy();
}
