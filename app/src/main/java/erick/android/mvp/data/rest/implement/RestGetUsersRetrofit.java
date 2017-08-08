package erick.android.mvp.data.rest.implement;

import java.util.List;

import erick.android.mvp.data.exception.GetUsersException;
import erick.android.mvp.data.model.BaseResponse;
import erick.android.mvp.data.model.User;
import erick.android.mvp.data.rest.RestGetUsers;
import erick.android.mvp.data.retrofit.ApiClientRetrofit;
import retrofit2.Response;

/**
 * Created by erick on 8/8/17.
 */

public class RestGetUsersRetrofit implements RestGetUsers {
    @Override
    public List<User> getUsers() throws GetUsersException {
        try {
            Response<BaseResponse<List<User>>> response = ApiClientRetrofit.getApiClient().getUsers().execute();
            if (response.isSuccessful()) {
                return response.body().getResults();
            } else {
                throw new GetUsersException(response.errorBody().string());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new GetUsersException(e.getMessage());
        }
    }
}

