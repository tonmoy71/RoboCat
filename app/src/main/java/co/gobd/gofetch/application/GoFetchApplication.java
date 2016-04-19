package co.gobd.gofetch.application;

import android.app.Application;

import co.gobd.gofetch.di.component.AppComponent;
import co.gobd.gofetch.di.component.DaggerAppComponent;
import co.gobd.gofetch.di.module.ApiModule;

/**
 * Created by tonmoy on 19-Apr-16.
 */
public class GoFetchApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
