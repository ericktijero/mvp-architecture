package erick.android.mvp.domain.interactor.implement;

import java.util.List;

import erick.android.mvp.data.exception.GetUsersException;
import erick.android.mvp.data.model.User;
import erick.android.mvp.data.rest.RestGetUsers;
import erick.android.mvp.data.rest.implement.RestGetUsersRetrofit;
import erick.android.mvp.domain.executor.InteractorExecutor;
import erick.android.mvp.domain.executor.MainThreadExecutor;
import erick.android.mvp.domain.interactor.AbstractInteractor;
import erick.android.mvp.domain.interactor.GetUsersInteractor;

/**
 * Created by erick on 8/8/17.
 */

public class GetUsersInteractorImplement extends AbstractInteractor implements GetUsersInteractor {
    private Callback callback;
    private RestGetUsers restGetUsers;

    public GetUsersInteractorImplement(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor) {
        super(interactorExecutor, mainThreadExecutor);
        restGetUsers = new RestGetUsersRetrofit();
    }

    @Override
    public void execute(Callback callback) {
        this.callback = callback;
        getInteractorExecutor().run(this);
    }

    @Override
    public void run() {
        try {
            final List<User> users = restGetUsers.getUsers();
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onGetUsersSuccess(users);
                }
            });
        } catch (final GetUsersException e) {
            e.printStackTrace();
            getMainThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    callback.onGetUsersError(e.getMessage());
                }
            });
        }
    }
}
