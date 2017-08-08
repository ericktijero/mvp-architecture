package erick.android.mvp.ui.main;

import java.util.List;

import erick.android.mvp.data.model.User;
import erick.android.mvp.ui.base.BaseView;

/**
 * Created by erick on 8/8/17.
 */

public interface MainMvpView extends BaseView {
    void getUserList();
    void updateUserList(List<User> userList);
}


