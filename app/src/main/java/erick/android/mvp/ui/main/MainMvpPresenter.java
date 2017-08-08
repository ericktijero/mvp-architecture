package erick.android.mvp.ui.main;

import erick.android.mvp.ui.base.BasePresenter;

/**
 * Created by erick on 8/8/17.
 */

public interface MainMvpPresenter extends BasePresenter<MainMvpView> {
    void getUsers();
}

