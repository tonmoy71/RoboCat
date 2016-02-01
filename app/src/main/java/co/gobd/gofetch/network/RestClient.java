package co.gobd.gofetch.network;

import co.gobd.gofetch.config.Url;
import retrofit.RestAdapter;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public class RestClient {

    SupportedOrderApi supportedOrderApi;

    public RestClient() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(Url.BASE_URL)
                .build();
        supportedOrderApi = restAdapter.create(SupportedOrderApi.class);
    }

    public SupportedOrderApi getSupportedOrderApi() {
        return supportedOrderApi;
    }
}
