package erick.android.mvp.data.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by erick on 8/8/17.
 */

public class ApiClientRetrofit {
    private static RetrofitServiceInterface servicesApiInterface;
    public static String BASE_SERVICE_URL = "https://randomuser.me/";
    public static RetrofitServiceInterface getApiClient() {
        if (servicesApiInterface == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.connectTimeout(60, TimeUnit.SECONDS);
            httpClient.readTimeout(60, TimeUnit.SECONDS);
            httpClient.writeTimeout(60, TimeUnit.SECONDS);
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request request = null;
                    request = original.newBuilder()
                            .header("language", "es")
                            .method(original.method(), original.body()).build();
                    return chain.proceed(request);
                }
            });
            Gson gson = new GsonBuilder()
                    .disableHtmlEscaping()
                    .create();

            Retrofit restAdapter = new Retrofit.Builder()
                    .baseUrl(BASE_SERVICE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();
            servicesApiInterface = restAdapter.create(RetrofitServiceInterface.class);
        }
        return servicesApiInterface;
    }
}
