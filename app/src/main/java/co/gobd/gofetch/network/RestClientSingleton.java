package co.gobd.gofetch.network;

import co.gobd.gofetch.config.Url;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public class RestClientSingleton {

    ISupportedOrderApi supportedOrderApi;

    public RestClientSingleton() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Url.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        supportedOrderApi = retrofit.create(ISupportedOrderApi.class);
    }

    public ISupportedOrderApi getSupportedOrderApi() {
        return supportedOrderApi;
    }
}
