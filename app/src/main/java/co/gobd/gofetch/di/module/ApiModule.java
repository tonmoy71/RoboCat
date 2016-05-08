package co.gobd.gofetch.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import co.gobd.gofetch.config.ApiEndpoint;
import co.gobd.gofetch.network.AccountApi;
import co.gobd.gofetch.network.OrderApi;
import co.gobd.gofetch.utility.Constant;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tonmoy on 07-Apr-16.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient() {
        // Enables to see retrofit request logs in the android monitor
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        return httpClient.build();

    }

    @Provides
    @Singleton
    public GsonConverterFactory providesGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public OrderApi providesOrderAPi(@Named(Constant.BackendName.TASK_CAT) Retrofit retrofit) {
        return retrofit.create(OrderApi.class);
    }

    @Provides
    @Singleton
    public AccountApi providesAccountApi(@Named(Constant.BackendName.TASK_CAT) Retrofit retrofit) {
        return retrofit.create(AccountApi.class);
    }


    @Provides
    @Singleton
    @Named(Constant.BackendName.TASK_CAT)
    public Retrofit providesRetrofitForTaskCat(OkHttpClient okHttpClient,
                                               GsonConverterFactory factory) {
        return new Retrofit.Builder()
                .baseUrl(ApiEndpoint.TaskCat.BASE)
                .client(okHttpClient)
                .addConverterFactory(factory)
                .build();
    }


}
