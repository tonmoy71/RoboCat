package co.gobd.gofetch.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import co.gobd.gofetch.config.ApiEndpoint;
import co.gobd.gofetch.model.JobModel;
import co.gobd.gofetch.network.Api;
import co.gobd.gofetch.utility.Constant;
import co.gobd.gofetch.utility.deserializer.JobModelDeserializer;
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
    public Gson providesGson()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(JobModel.class, new JobModelDeserializer());
        return gsonBuilder.create();
    }


    @Provides
    @Singleton
    public GsonConverterFactory providesGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    public Api providesOrderAPi(@Named(Constant.BackendName.TASK_CAT) Retrofit retrofit) {
        return retrofit.create(Api.class);
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
