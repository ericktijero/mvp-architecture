package erick.android.mvp.data.retrofit;

import java.util.List;

import erick.android.mvp.data.model.BaseResponse;
import erick.android.mvp.data.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by erick on 8/8/17.
 */

public interface RetrofitServiceInterface {
    @GET("api/?results=10")
    Call<BaseResponse<List<User>>> getUsers();
}
