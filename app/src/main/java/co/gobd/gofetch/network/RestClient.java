package co.gobd.gofetch.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public class RestClient {

    //TODO Read stuff on Generics, assholes!
    public static <T> T getApi(String baseUrl, final Class<T> apiClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        T api = retrofit.create(apiClass);

        return api;

    }
}
