package erick.android.mvp.data.rest;

import java.util.List;

import erick.android.mvp.data.exception.GetUsersException;
import erick.android.mvp.data.model.User;

/**
 * Created by erick on 8/8/17.
 */

public interface RestGetUsers {
    List<User> getUsers() throws GetUsersException;
}

