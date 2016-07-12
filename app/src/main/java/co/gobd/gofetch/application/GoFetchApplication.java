package co.gobd.gofetch.application;

import android.app.Application;

import co.gobd.gofetch.di.component.AppComponent;
import co.gobd.gofetch.di.component.DaggerAppComponent;
import co.gobd.gofetch.di.module.ApiModule;
import co.gobd.gofetch.di.module.AppModule;
import co.gobd.gofetch.di.module.ServiceModule;

/**
 * Created by tonmoy on 19-Apr-16.
 */
public class GoFetchApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .serviceModule(new ServiceModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
