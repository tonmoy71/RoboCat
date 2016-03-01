package co.gobd.gofetch.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.gobd.gofetch.model.order.BaseOrder;
import co.gobd.gofetch.model.order.RideOrder;
import co.gobd.gofetch.utility.RuntimeTypeAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tonmoy on 01-Feb-16.
 */
public class RestClient {

    public static <T> T getApi(String baseUrl, final Class<T> apiClass) {

        final RuntimeTypeAdapterFactory<BaseOrder> typeFactory = RuntimeTypeAdapterFactory
                .of(BaseOrder.class, "BaseOrder")
                .registerSubtype(RideOrder.class, "RideOrder");

        final Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(typeFactory)
                .create();

        // To check request log
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
        T api = retrofit.create(apiClass);

        return api;

    }
}
