package erick.android.mvp.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by erick on 8/8/17.
 */

public interface BaseView {
    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);
}