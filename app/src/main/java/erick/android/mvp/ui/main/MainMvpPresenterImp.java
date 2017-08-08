package erick.android.mvp.ui.main;

import java.util.List;

import erick.android.mvp.MvpArchitecture;
import erick.android.mvp.data.model.User;
import erick.android.mvp.domain.interactor.GetUsersInteractor;
import erick.android.mvp.domain.interactor.implement.GetUsersInteractorImplement;

/**
 * Created by erick on 8/8/17.
 */

public class MainMvpPresenterImp implements MainMvpPresenter {
    private MainMvpView view;
    private GetUsersInteractor interactor;

    @Override
    public void onCreate(MainMvpView view) {
        this.view = view;
        interactor = new GetUsersInteractorImplement(MvpArchitecture.threadExecutor, MvpArchitecture.mainThreadExecutor);
    }

    @Override
    public void onDestroy() {
        this.view = null;
    }

    @Override
    public void getUsers() {
        view.showLoading();
        interactor.execute(new GetUsersInteractor.Callback() {
            @Override
            public void onGetUsersSuccess(List<User> users) {
                view.hideLoading();
                view.updateUserList(users);
            }

            @Override
            public void onGetUsersError(String error) {
                view.hideLoading();
                view.onError(error);
            }
        });
    }
}
