package erick.android.mvp.domain.interactor;

import java.util.List;

import erick.android.mvp.data.model.User;

/**
 * Created by erick on 8/8/17.
 */

public interface GetUsersInteractor {
    void execute(Callback callback);

    interface Callback {
        void onGetUsersSuccess(List<User> genres);

        void onGetUsersError(String error);
    }
}